package com.shanuka.ecom.OrderReference;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderReferenceService {

    private final OrderReferenceRepository repository;
    private final OrderReferenceMapper mapper;

    public Integer saveOrderReference(OrderReferenceRequestDto requestDto) {
        var order = mapper.toOrderReference(requestDto);
        return repository.save(order).getId();
    }

    public List<OrderReferenceResponseDto> findAllByOrderId(Integer orderId) {
        return repository.findAllByOrderId(orderId)
                .stream()
                .map(mapper::toOrderReferenceResponse)
                .collect(Collectors.toList());
    }
}
