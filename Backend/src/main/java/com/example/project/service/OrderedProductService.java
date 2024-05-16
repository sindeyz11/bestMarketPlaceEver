package com.example.project.service;

import com.example.project.entity.OrderedProduct;
import com.example.project.repository.OrderedProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderedProductService {
    private OrderedProductRepo repository;
    public void saveOrdered_product(OrderedProduct ordered_product) {
        repository.save(ordered_product);
    }
}
