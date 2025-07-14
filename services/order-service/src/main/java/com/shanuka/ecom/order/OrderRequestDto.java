package com.shanuka.ecom.order;

import com.shanuka.ecom.product.PurchaseRequest;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;
import java.util.List;

public record OrderRequestDto(
        Integer id,
        String reference,
        @Positive(message = "Order amount should be positive")
        BigDecimal amount,
        @NotNull(message = "Payment method required")
        PaymentMethod paymentMethod,
        @NotNull(message = "Customer required")
        @NotEmpty(message = "Customer required")
        @NotBlank(message = "Customer required")
        String customerId,
        @NotEmpty(message = "At least one product required")
        List<PurchaseRequest> products
) { }
