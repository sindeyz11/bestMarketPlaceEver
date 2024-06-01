package com.example.project.repository;

import com.example.project.entity.OrderedProduct;
import com.example.project.entity.pk.IDOrderedProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderedProductRepo extends JpaRepository<OrderedProduct, IDOrderedProduct> {
    @Query(value = "SELECT op.* FROM ordered_product op " +
            "JOIN orders o ON op.order_id = o.order_id " +
            "WHERE op.status_id = ?1 AND (o.datetime + make_interval(days \\:= op.delivery_days)) < NOW();",
            nativeQuery = true)
    List<OrderedProduct> findAllProductsDueToArrive(Integer statusId);

}
