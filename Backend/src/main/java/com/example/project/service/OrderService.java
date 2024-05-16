package com.example.project.service;

import com.example.project.entity.Order;
import com.example.project.repository.OrderRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {
    private OrderRepo repository;
    public void saveOrder(Order order) {
        repository.save(order);
    }
}
