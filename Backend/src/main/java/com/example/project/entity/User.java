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
    private String username;
    private String password;
    private String phone;
    private String email;
    private Integer user_discount;
    private Integer amount_spent;
    private Integer CVC;
    private String card_number;
    private LocalDate datetime;

    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "RoleUser",
            joinColumns = {
                    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
            },
            inverseJoinColumns = {
                    @JoinColumn(name = "role_id")
            }
    )
    private Set<Role> roles;

    @OneToOne(mappedBy = "manager", optional = true)
    private PickupPoint user_pickup_points;

    @OneToMany(mappedBy = "order_user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Order> user_orders;
}
