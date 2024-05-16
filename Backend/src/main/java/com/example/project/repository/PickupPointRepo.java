package com.example.project.repository;

import com.example.project.entity.PickupPoint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PickupPointRepo extends JpaRepository<PickupPoint, Integer> {
}
