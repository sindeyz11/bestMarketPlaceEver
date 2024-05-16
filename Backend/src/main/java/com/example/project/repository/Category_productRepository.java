package com.example.project.repository;

import com.example.project.model.Entity_Category_product;
import com.example.project.model.ID_Category_product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Category_productRepository extends JpaRepository<Entity_Category_product, ID_Category_product> {
}
