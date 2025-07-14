package com.shanuka.ecom.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record PurchaseRequest(
        @NotNull(message = "Product required")
        Integer productId,
        @Positive(message = "Quantity required")
        double quantity

) {
}
