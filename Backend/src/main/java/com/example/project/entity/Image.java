package com.example.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "Image")
public class Image {
    @Id
    private Integer image_id;
    private String image;
    private String alt;

    @OneToOne(mappedBy = "product_image", optional = true)
    private Product image_product;
}
