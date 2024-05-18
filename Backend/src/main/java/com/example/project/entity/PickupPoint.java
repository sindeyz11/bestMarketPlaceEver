package com.example.project.entity;

import jakarta.persistence.*;
import lombok.Data;
import java.util.List;

@Data
@Entity
@Table(name = "Pickup_point")
public class PickupPoint {
    @Id
    private int point_id;
    private String address;
    @OneToOne(optional = true)
    @JoinColumn(name = "manager_id", referencedColumnName = "user_id")
    private User manager;
    private Integer income;

    @OneToMany(mappedBy = "order_pickup_point", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> pickup_point_orders;
}
