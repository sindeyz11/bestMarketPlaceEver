package com.example.project.entity.pk;

import lombok.Data;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class ID_Image_product implements Serializable {
    private Integer image_id;
    private Integer product_id;
}
