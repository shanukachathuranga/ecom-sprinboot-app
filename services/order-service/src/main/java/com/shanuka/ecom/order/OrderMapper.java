package com.shanuka.ecom.order;

import org.springframework.stereotype.Service;

@Service
public class OrderMapper {

    public Order toOrder(OrderRequestDto requestDto){
        return Order.builder()
                .id(requestDto.id())
                .customerId(requestDto.customerId())
                .reference(requestDto.reference())
                .totalAmount(requestDto.amount())
                .paymentMethod(requestDto.paymentMethod())
                .build();
    }

}
