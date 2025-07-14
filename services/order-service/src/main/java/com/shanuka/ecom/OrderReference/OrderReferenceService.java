package com.shanuka.ecom.OrderReference;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class OrderReferenceService {

    private final OrderReferenceRepository repository;
    private final OrderReferenceMapper mapper;

    public Integer saveOrderReference(OrderReferenceRequestDto requestDto) {
        var order = mapper.toOrderReference(requestDto);
        return repository.save(order).getId();
    }
}
