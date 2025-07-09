package com.shanuka.ecom.customer;



public record CustomerResponseDto(
        String id,
        String firstname,
        String lastname,
        String email,
        Address address
) {

}
