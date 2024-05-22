package com.example.project.repository;

import com.example.project.model.Entity_Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository  extends JpaRepository<Entity_Product, Integer> {
}
