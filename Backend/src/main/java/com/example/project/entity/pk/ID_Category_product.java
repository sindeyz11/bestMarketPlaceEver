package com.example.project.entity.pk;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Embeddable
@Data
public class ID_Category_product implements Serializable {
    private Integer category;
    private Integer product_category;
}
