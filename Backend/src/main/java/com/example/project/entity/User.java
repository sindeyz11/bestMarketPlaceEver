package com.example.project.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Data
@Entity
@Table(name = "Users")
public class User {
    @Id
    private Integer user_id;
    private String first_name;
    private String password;
    private String phone;
    private String email;
    private Integer user_discount;
    private Integer amount_spent;
    private Integer CVC;
    private String card_number;
    private LocalDate datetime;

    @OneToMany(mappedBy = "user_role")
    private Set<RoleUser> roles;

    @OneToOne(mappedBy = "manager", optional = true)
    private PickupPoint user_pickup_points;

    @OneToMany(mappedBy = "order_user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> user_orders;
}
