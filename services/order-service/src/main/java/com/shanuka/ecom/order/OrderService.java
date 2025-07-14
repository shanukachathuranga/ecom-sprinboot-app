package com.shanuka.ecom.order;

import com.shanuka.ecom.OrderReference.OrderReferenceRequestDto;
import com.shanuka.ecom.OrderReference.OrderReferenceService;
import com.shanuka.ecom.customer.CustomerClient;
import com.shanuka.ecom.exception.BusinessException;
import com.shanuka.ecom.product.ProductClient;
import com.shanuka.ecom.product.PurchaseRequest;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderService {

    private final OrderRepository orderRepository;
    private final CustomerClient customerClient;
    private final ProductClient productClient;
    private final OrderMapper mapper;
    private final OrderReferenceService orderReferenceService;

    public Integer createOrder(@Valid OrderRequestDto requestDto) {
        // check the customer --> OpenFeign
        var customer = this.customerClient.findCustomerById(requestDto.customerId())
                .orElseThrow(() -> new BusinessException("order creation failed::customer not found"));
        //purchase the product --> product microservice using RestTemplate just like OpenFeign
        this.productClient.purchaseProducts(requestDto.products());
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
        // todo start payment process

        //send the order confirmation via notification microservice(kafka)

        return null;
    }
}
