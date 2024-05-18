package com.example.project.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.Formula;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "Orders")
public class Order {
    @Id
    @Column(name = "order_id")
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user;

    private LocalDate datetime;

    @ManyToOne
    @JoinColumn(name = "point_id", referencedColumnName = "point_id")
    private PickupPoint pickupPoint;

    private boolean completed;

    @OneToMany(mappedBy = "order", fetch = FetchType.EAGER)
    private List<OrderedProduct> products;
}
