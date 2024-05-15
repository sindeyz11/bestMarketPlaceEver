package com.example.project.model;

import jakarta.persistence.Embeddable;
import lombok.Data;

@Data
@Embeddable
public class ID_Image_product {
    private Integer image_id;
    private Integer product_id;
}
