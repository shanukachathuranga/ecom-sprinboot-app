package com.shanuka.ecom.product;

import com.shanuka.ecom.category.Category;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

@Service
public class ProductMapper {
    public Product toProduct(@Valid ProductRequestDto requestDto) {
        return Product.builder()
                .id(requestDto.id())
                .name(requestDto.name())
                .description(requestDto.description())
                .price(requestDto.price())
                .availableQuantity(requestDto.availableQuantity())
                .category(
                        Category.builder()
                                .id(requestDto.categoryId())
                                .build()
                )
                .build();
    }

    public ProductResponseDto toProductResponse(Product product) {
        return new ProductResponseDto(
                product.getId(),
                product.getName(),
                product.getPrice(),
                product.getAvailableQuantity(),
                product.getDescription(),
                product.getCategory().getId(),
                product.getCategory().getName(),
                product.getCategory().getDescription()
        );
    }

    public ProductPurchaseResponse toProductPurchaseResponse(Product product, double quantity) {
        return new ProductPurchaseResponse(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                quantity
        );
    }
}
