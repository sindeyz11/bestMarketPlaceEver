package com.example.project.entity;

import com.example.project.entity.pk.ID_Ordered_product;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "Ordered_product")
@IdClass(ID_Ordered_product.class)
public class OrderedProduct {
    @Id
    @MapsId("order_id")
    @ManyToOne
    @JoinColumn(name = "order_id", referencedColumnName = "order_id")
    private Order order_product;

    @Id
    @MapsId("product_id")
    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product ordered_product;
    private Integer count_product;
    private Integer discount_price;
    private Integer delivery_days;

    @ManyToOne
    @JoinColumn(name = "status_id", referencedColumnName = "status_id")
    private DeliveryStatus ordered_product_status;

    private LocalDate completion_date;
}
