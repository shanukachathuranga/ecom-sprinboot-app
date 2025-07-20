package com.shanuka.ecom.payment;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import org.springframework.validation.annotation.Validated;

@Validated
public record Customer(
        String id,
        @NotNull(message = "firstname required")
        String firstname,
        @NotNull(message = "lastname required")
        String lastname,
        @NotNull(message = "email required")
        @Email(message = "email not valid")
        String email
) {
}
