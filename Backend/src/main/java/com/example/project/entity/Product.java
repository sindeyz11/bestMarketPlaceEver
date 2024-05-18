package com.example.project.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Product")
public class Product {
    @Id
    private int product_id;
    private String title;

    @OneToOne
    @JoinColumn(name = "image_id", referencedColumnName = "image_id")
    private Image product_image;
    private String description;
    private Integer price;
    private Integer discount_price;
    private Integer quantity_of_available;
    private String unit;
    private Integer delivery_days;

    @OneToOne(mappedBy = "product_category")
    private CategoryProduct categories;

    @OneToMany(mappedBy = "product")
    private List<OrderedProduct> product_orderes;

}
