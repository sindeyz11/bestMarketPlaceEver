package com.example.project.repository;

import com.example.project.model.Entity_Ordered_product;
import com.example.project.model.ID_Ordered_product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Ordered_productRepository  extends JpaRepository<Entity_Ordered_product, ID_Ordered_product> {
}
