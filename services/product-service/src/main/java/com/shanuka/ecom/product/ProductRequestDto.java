package com.shanuka.ecom.product;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

import java.math.BigDecimal;

public record ProductRequestDto(

        Integer id,
        @NotNull(message = "Product name required")
        String name,
        @NotNull(message = "Product price is required")
        @Positive(message = "Price should be positive")
        BigDecimal price,
        @NotNull(message = "Product quantity is required")
        @Positive(message = "Price should be positive")
        Double availableQuantity,
        @NotNull(message = "Product description is required")
        String description,
        @NotNull(message = "Product category is required")
        Integer categoryId

) {
}
