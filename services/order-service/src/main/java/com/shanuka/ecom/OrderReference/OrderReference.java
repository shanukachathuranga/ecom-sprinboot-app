package com.shanuka.ecom.OrderReference;

import com.shanuka.ecom.order.Order;
import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class OrderReference {

    @Id
    private Integer id;
    private double quantity;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private Order order;
    private Integer productId;


}
