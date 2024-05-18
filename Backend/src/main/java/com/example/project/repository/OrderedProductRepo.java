package com.example.project.repository;

import com.example.project.entity.OrderedProduct;
import com.example.project.entity.pk.IDOrderedProduct;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderedProductRepo extends JpaRepository<OrderedProduct, IDOrderedProduct> {
}
