package com.shanuka.ecom.OrderReference;

import com.shanuka.ecom.order.Order;
import org.springframework.stereotype.Service;

@Service
public class OrderReferenceMapper {


    public OrderReference toOrderReference(OrderReferenceRequestDto requestDto) {

        return OrderReference.builder()
                .id(requestDto.id())
                .quantity(requestDto.quantity())
                .order(
                        Order.builder()
                                .id(requestDto.orderId())
                                .build()
                )
                .productId(requestDto.productId())
                .quantity(requestDto.quantity())
                .build();

    }
}
