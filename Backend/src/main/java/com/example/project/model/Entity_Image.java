package com.example.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Image")
public class Entity_Image {
    @Id
    private Integer image_id;
    private String image;
    private String alt;

    @OneToOne(mappedBy = "product_image", optional = true)
    private Entity_Product image_product;
}
