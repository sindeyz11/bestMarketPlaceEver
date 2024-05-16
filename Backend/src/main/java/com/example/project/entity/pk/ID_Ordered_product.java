package com.example.project.entity.pk;

import lombok.Data;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class ID_Ordered_product implements Serializable {
    private Integer order_product;
    private Integer ordered_product;
}
