package com.example.project.service;

import com.example.project.model.Entity_Order;
import com.example.project.repository.OrderRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {
    private OrderRepository repository;
    public void saveOrder(Entity_Order order) {
        repository.save(order);
    }
}
