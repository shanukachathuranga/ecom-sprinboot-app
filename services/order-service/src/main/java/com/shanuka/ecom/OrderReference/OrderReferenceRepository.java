package com.shanuka.ecom.OrderReference;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderReferenceRepository extends JpaRepository<OrderReference, Integer> {
    List<OrderReference> findAllByOrderId(Integer orderId);
}
