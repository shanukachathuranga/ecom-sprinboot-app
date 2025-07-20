package com.shanuka.ecom.order;

import com.shanuka.ecom.OrderReference.OrderReferenceRequestDto;
import com.shanuka.ecom.OrderReference.OrderReferenceService;
import com.shanuka.ecom.customer.CustomerClient;
import com.shanuka.ecom.exception.BusinessException;
import com.shanuka.ecom.kafka.OrderConfirmation;
import com.shanuka.ecom.kafka.OrderProducer;
import com.shanuka.ecom.payment.PaymentClient;
import com.shanuka.ecom.payment.PaymentRequest;
import com.shanuka.ecom.product.ProductClient;
import com.shanuka.ecom.product.PurchaseRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper mapper;
    private final OrderReferenceService orderReferenceService;
    private final OrderProducer orderProducer;
    private final PaymentClient paymentClient;

    public Integer createOrder(@Valid OrderRequestDto requestDto) {
        // check the customer --> OpenFeign
        var customer = this.customerClient.findCustomerById(requestDto.customerId())
                .orElseThrow(() -> new BusinessException("order creation failed::customer not found"));
        //purchase the product --> product microservice using RestTemplate just like OpenFeign
        var purchasedProducts = this.productClient.purchaseProducts(requestDto.products());
        //persist order
        var order = this.orderRepository.save(mapper.toOrder(requestDto));
        //persist order-references
        for(PurchaseRequest purchaseRequest: requestDto.products()){
            orderReferenceService.saveOrderReference(
                    new OrderReferenceRequestDto(
                            null,
                            order.getId(),
                            purchaseRequest.productId(),
                            purchaseRequest.quantity()
                    )
            );
        }

        //start payment process
        var paymentRequest = new PaymentRequest(
                requestDto.amount(),
                requestDto.paymentMethod(),
                order.getId(),
                requestDto.reference(),
                customer

        );
        paymentClient.requestOrderPayment(paymentRequest);

        //send the order confirmation via notification microservice(kafka)
        orderProducer.sendOrderConfirmation(
                new OrderConfirmation(
                        requestDto.reference(),
                        requestDto.amount(),
                        requestDto.paymentMethod(),
                        customer,
                        purchasedProducts
                )
        );

        return order.getId();
    }

    public List<OrderResponseDto> findAll() {
        return orderRepository.findAll()
                .stream()
                .map(mapper::toOrderResponse)
                .collect(Collectors.toList());
    }

    public OrderResponseDto findOrderById(Integer orderId) {
        return orderRepository.findById(orderId)
                .map(mapper::toOrderResponse)
                .orElseThrow(() -> new BusinessException(String.format("Order not found for the id: %d", orderId)));
    }

}
