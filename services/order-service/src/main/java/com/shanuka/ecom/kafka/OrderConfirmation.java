package com.shanuka.ecom.kafka;

import com.shanuka.ecom.customer.CustomerResponse;
import com.shanuka.ecom.order.PaymentMethod;
import com.shanuka.ecom.product.PurchaseResponse;

import java.math.BigDecimal;
import java.util.List;

public record OrderConfirmation(
        String orderReference,
        BigDecimal totalAmount,
        PaymentMethod paymentMethod,
        CustomerResponse customer,
        List<PurchaseResponse> products
) {
}
