package com.example.project.service;

import com.example.project.model.Entity_Category_product;
import com.example.project.repository.Category_productRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Category_productService {
    private Category_productRepository repository;
    public void saveCategory_product(Entity_Category_product category_product) {
        repository.save(category_product);
    }
}
