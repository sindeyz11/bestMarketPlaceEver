package com.example.project.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ID_Category_product {
    private Integer category;
    private Integer product_category;
}
