package com.example.project.entity;


import lombok.Data;

import jakarta.persistence.*;
import java.util.List;

@Data
@Entity
@Table(name = "Delivery_status")
public class DeliveryStatus {
    @Id
    private Integer status_id;
    private String title;

    @OneToMany(mappedBy = "ordered_product_status")
    private List<OrderedProduct> status_ordered_product;
}
