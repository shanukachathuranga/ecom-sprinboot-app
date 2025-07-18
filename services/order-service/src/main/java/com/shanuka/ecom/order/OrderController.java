package com.shanuka.ecom.order;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/orders")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @PostMapping
    public ResponseEntity<Integer> createOrder(
            @RequestBody @Valid OrderRequestDto requestDto
    ){
        return ResponseEntity.ok(orderService.createOrder(requestDto));
    }

    @GetMapping
    public ResponseEntity<List<OrderResponseDto>> getAll(){
        return ResponseEntity.ok(orderService.findAll());
    }

    @GetMapping("/{order-id}")
    public ResponseEntity<OrderResponseDto> getOrderById(
            @PathVariable("order-id") Integer orderId
    ){
        return ResponseEntity.ok(orderService.findOrderById(orderId));
    }

}
