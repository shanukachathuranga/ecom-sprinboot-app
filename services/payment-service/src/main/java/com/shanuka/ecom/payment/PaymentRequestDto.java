package com.shanuka.ecom.payment;

import java.math.BigDecimal;

public record PaymentRequestDto(
        Integer id,
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        Customer customer
) {
}
