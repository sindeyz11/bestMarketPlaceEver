package com.example.project.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ID_Ordered_product {
    private Integer order_product;
    private Integer ordered_product;
}
