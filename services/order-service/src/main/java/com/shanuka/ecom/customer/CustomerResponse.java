package com.shanuka.ecom.customer;

public record CustomerResponse(
        String id,
        String firstname,
        String lastname,
        String email
) {
}
