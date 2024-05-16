package com.example.project.repository;

import com.example.project.entity.CategoryProduct;
import com.example.project.entity.pk.ID_Category_product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryProductRepo extends JpaRepository<CategoryProduct, ID_Category_product> {
}
