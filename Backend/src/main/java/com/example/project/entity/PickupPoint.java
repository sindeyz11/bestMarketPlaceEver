package com.example.project.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Formula;

import java.util.List;

@Data
@Entity
@Table(name = "Pickup_point")
public class PickupPoint {
    @Id
    @Column(name = "point_id")
    private int id;
    private String address;
    @OneToOne(optional = true)
    @JoinColumn(name = "manager_id", referencedColumnName = "user_id")
    private User manager;

    @Formula("(SELECT u.first_name FROM Users u WHERE u.user_id = manager_id)")
    private String managerName;

    private Integer income;

    @OneToMany(mappedBy = "pickupPoint", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> pickup_point_orders;
}
