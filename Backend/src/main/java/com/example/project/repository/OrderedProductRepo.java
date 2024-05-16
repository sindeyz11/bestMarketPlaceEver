package com.example.project.repository;

import com.example.project.entity.OrderedProduct;
import com.example.project.entity.pk.ID_Ordered_product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedProductRepo extends JpaRepository<OrderedProduct, ID_Ordered_product> {
}
