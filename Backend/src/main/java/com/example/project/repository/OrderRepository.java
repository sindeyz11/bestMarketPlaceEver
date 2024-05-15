package com.example.project.repository;

import com.example.project.model.Entity_Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository  extends JpaRepository<Entity_Order, Integer> {
}
