package com.example.project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "Pickup_point")
public class Entity_Pickup_point {
    @Id
    private int point_id;
    private String address;
    @OneToOne(optional = true)
    @JoinColumn(name = "manager_id", referencedColumnName = "user_id")
    private Entity_Users manager;
    private Integer income;

    @OneToMany(mappedBy = "order_pickup_point", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Entity_Order> pickup_point_orders;
}
