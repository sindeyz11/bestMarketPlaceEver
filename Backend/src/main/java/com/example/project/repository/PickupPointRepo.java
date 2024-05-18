package com.example.project.repository;

import com.example.project.entity.PickupPoint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PickupPointRepo extends JpaRepository<PickupPoint, Integer> {
}
