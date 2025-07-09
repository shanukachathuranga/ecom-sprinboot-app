package com.shanuka.ecom.customer;

import org.springframework.stereotype.Service;

@Service
public class CustomerMapper {

    public Customer toCustomer(CustomerRequestDto requestDto) {
        if(requestDto == null){
            return null;
        }
        return Customer.builder()
                .id(requestDto.id())
                .firstname(requestDto.firstname())
                .lastname(requestDto.lastname())
                .email(requestDto.email())
                .address(requestDto.address())
                .build();
    }

    public CustomerResponseDto fromCustomer(Customer customer) {
        return new CustomerResponseDto(
                customer.getId(),
                customer.getFirstname(),
                customer.getLastname(),
                customer.getEmail(),
                customer.getAddress()
        );
    }
}
