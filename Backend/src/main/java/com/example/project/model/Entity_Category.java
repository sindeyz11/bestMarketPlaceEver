package com.example.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Category")
public class Entity_Category {
    @Id
    private Integer category_id;
    private String title;

    @OneToMany(mappedBy = "category")
    private List<Entity_Category_product> category_products;
}
