package com.shanuka.ecom.payment;

import com.shanuka.ecom.customer.CustomerResponse;
import com.shanuka.ecom.order.PaymentMethod;

import java.math.BigDecimal;

public record PaymentRequest(
        BigDecimal amount,
        PaymentMethod paymentMethod,
        Integer orderId,
        String orderReference,
        CustomerResponse customer
) {
}
