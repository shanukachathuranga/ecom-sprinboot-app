package com.shanuka.ecom.order;

import java.math.BigDecimal;

public record OrderResponseDto(
        Integer id,
        String reference,
        BigDecimal amount,
        String customerId,
        PaymentMethod paymentMethod
) {
}
