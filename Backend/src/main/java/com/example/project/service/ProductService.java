package com.example.project.service;

import com.example.project.model.Entity_Product;
import com.example.project.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepository repository;

    public void saveProduct(Entity_Product product){
        repository.save(product);
    }
}
