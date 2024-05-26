package com.example.project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "Orders")
public class Entity_Order {
    @Id
    private Integer order_id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Entity_Users order_user;

    private LocalDate datetime;

    @ManyToOne
    @JoinColumn(name = "point_id", referencedColumnName = "point_id")
    private Entity_Pickup_point order_pickup_point;

    private boolean completed;

    @OneToMany(mappedBy = "order_product")
    private List<Entity_Ordered_product> order_products;
}
