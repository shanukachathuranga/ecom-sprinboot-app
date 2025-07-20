package com.shanuka.ecom.kafka.order;

public record Customer(
        String id,
        String firstname,
        String lastname,
        String email
) {
}
