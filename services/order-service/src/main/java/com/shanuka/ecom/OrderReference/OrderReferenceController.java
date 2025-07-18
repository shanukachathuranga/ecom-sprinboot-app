package com.shanuka.ecom.OrderReference;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order-reference")
@RequiredArgsConstructor
public class OrderReferenceController {

    private final OrderReferenceService service;

    @GetMapping("/order/{order-id}")
    public ResponseEntity<List<OrderReferenceResponseDto>> findByOrderId(
            @PathVariable("order-id") Integer orderId
    ){
        return ResponseEntity.ok(service.findAllByOrderId(orderId));
    }

}
