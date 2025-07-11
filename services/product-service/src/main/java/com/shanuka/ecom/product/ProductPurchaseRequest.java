package com.shanuka.ecom.product;

import jakarta.validation.constraints.NotNull;

public record ProductPurchaseRequest(
        @NotNull(message = "Prouduct id required")
        Integer productId,
        @NotNull(message = "Quantity is required")
        double quantity
) {
}
