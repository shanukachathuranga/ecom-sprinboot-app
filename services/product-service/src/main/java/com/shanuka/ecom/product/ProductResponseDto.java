package com.shanuka.ecom.product;

import java.math.BigDecimal;

public record ProductResponseDto(
        Integer id,
        String name,
        BigDecimal price,
        Double availableQuantity,
        String description,
        Integer categoryId,
        String categoryName,
        String categoryDescription
) {
}
