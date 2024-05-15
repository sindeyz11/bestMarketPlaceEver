package com.example.project.repository;

import com.example.project.model.Entity_Category;
import com.example.project.model.ID_Category_product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Entity_Category, Integer> {
}
