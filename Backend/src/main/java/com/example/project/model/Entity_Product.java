package com.example.project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Product")
public class Entity_Product {
    @Id
    private int product_id;
    private String title;
    @OneToOne
    @JoinColumn(name = "image_id", referencedColumnName = "image_id")
    private Entity_Image product_image;
    private String description;
    private Integer price;
    private Integer discount_price;
    private Integer quantity_of_available;
    private String unit;
    private Integer delivery_days;

    @OneToOne(mappedBy = "product_category")
    private Entity_Category_product categories;

    @OneToMany(mappedBy = "ordered_product")
    private List<Entity_Ordered_product> product_orderes;

}
