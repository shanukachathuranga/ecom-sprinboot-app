package com.shanuka.ecom.OrderReference;

public record OrderReferenceRequestDto(
        Integer id,
        Integer orderId,
        Integer productId,
        double quantity
) {
}
