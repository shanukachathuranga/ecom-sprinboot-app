package com.shanuka.ecom.customer;

import com.shanuka.ecom.exception.CustomerNotFoundException;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.apache.commons.lang.StringUtils;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.lang.String.format;

@Service
@RequiredArgsConstructor
public class CustomerService {
    private final CustomerRepository repository;
    private final CustomerMapper mapper;

    public String createCustomer(CustomerRequestDto requestDto) {
        var customer = repository.save(mapper.toCustomer(requestDto));
        return customer.getId();
    }

    public void updateCustomer(@Valid CustomerRequestDto requestDto) {
        var customer = repository.findById(requestDto.id())
                .orElseThrow(() -> new com.shanuka.ecom.exception.CustomerNotFoundException(
                    format("Cannot update customer:: No customer found for id:: %s", requestDto.id())
                ));

        // use to merge customer with the request so that we don't replace existing data with null values
        mergeCustomer(customer, requestDto);
        repository.save(customer);

    }

    private void mergeCustomer(Customer customer, CustomerRequestDto requestDto) {

        if(StringUtils.isNotBlank(requestDto.firstname())){
            customer.setFirstname(requestDto.firstname());
        }

        if(StringUtils.isNotBlank(requestDto.lastname())){
            customer.setFirstname(requestDto.lastname());
        }

        if(StringUtils.isNotBlank(requestDto.email())){
            customer.setFirstname(requestDto.email());
        }

        if(requestDto.address() != null){
            customer.setAddress(requestDto.address());
        }
    }

    public List<CustomerResponseDto> findAllCustomers() {
        return repository.findAll()
                .stream()
                .map(mapper::fromCustomer)
                .collect(Collectors.toList());
    }

    public Boolean existsById(String customerId) {
        return repository.findById(customerId).isPresent();
    }

    public CustomerResponseDto getCustomerById(String customerId) {
        return repository.findById(customerId)
                .map(mapper::fromCustomer)
                .orElseThrow(() -> new CustomerNotFoundException(format("Customer not found for the id:: %s", customerId)));
    }

    public void deleteCustomer(String customerId) {
        repository.deleteById(customerId);
    }
}
