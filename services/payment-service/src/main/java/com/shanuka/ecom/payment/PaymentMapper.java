package com.shanuka.ecom.payment;

import org.springframework.stereotype.Service;

@Service
public class PaymentMapper {
    public Payment toPayment(PaymentRequestDto requestDto){
        return Payment.builder()
                .id(requestDto.id())
                .amount(requestDto.amount())
                .paymentMethod(requestDto.paymentMethod())
                .orderId(requestDto.orderId())
                .build();
    }
}
