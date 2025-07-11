package com.shanuka.ecom.product;

import com.shanuka.ecom.category.Category;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class Product {

    @Id
    @GeneratedValue
    private Integer id;
    private String name;
    private BigDecimal price;
    private Double availableQuantity;
    private String description;
    @ManyToOne
    @JoinColumn(name = "category_id")
    private Category category;

}
