package com.example.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Delivery_status")
public class Entity_Delivery_status {
    @Id
    private Integer status_id;
    private String title;

    @OneToMany(mappedBy = "ordered_product_status")
    private List<Entity_Ordered_product> status_ordered_product;
}
