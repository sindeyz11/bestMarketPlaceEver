package com.example.project.entity;

import com.example.project.entity.pk.ID_Category_product;

import jakarta.persistence.*;

import lombok.Data;

@Data
@Entity
@Table(name = "Category_product")
@IdClass(ID_Category_product.class)
public class CategoryProduct {
    @Id
    @MapsId("category_id")
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "category_id")
    private Category category;

    @Id
    @MapsId("product_id")
    @OneToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product_category;
}
