package com.example.project.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Category_product")
@IdClass(ID_Category_product.class)
public class Entity_Category_product {
    @Id
    @MapsId("category_id")
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Entity_Category category;

    @Id
    @MapsId("product_id")
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Entity_Product product_category;
}
