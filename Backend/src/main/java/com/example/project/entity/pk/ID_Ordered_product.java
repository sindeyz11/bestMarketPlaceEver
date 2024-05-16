package com.example.project.entity.pk;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class ID_Ordered_product implements Serializable {
    private Integer order_product;
    private Integer ordered_product;
}
