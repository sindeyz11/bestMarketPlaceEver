package com.example.project.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Ordered_product")
@IdClass(ID_Ordered_product.class)
public class Entity_Ordered_product {
    @Id
    @MapsId("order_id")
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private Entity_Order order_product;

    @Id
    @MapsId("product_id")
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Entity_Product ordered_product;
    private Integer count_product;
    private Integer discount_price;
    private Integer delivery_days;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    private Entity_Delivery_status ordered_product_status;

    private LocalDate completion_date;
}
