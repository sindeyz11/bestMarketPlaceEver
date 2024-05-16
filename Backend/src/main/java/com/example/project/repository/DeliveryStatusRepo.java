package com.example.project.repository;


import com.example.project.entity.DeliveryStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryStatusRepo extends JpaRepository<DeliveryStatus, Integer> {
}
