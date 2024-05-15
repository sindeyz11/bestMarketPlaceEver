package com.example.project.service;

import com.example.project.model.Entity_Ordered_product;
import com.example.project.repository.Ordered_productRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Ordered_productService {
    private Ordered_productRepository repository;
    public void saveOrdered_product(Entity_Ordered_product ordered_product) {
        repository.save(ordered_product);
    }
}
