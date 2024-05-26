package com.example.project.service;

import com.example.project.model.Entity_Pickup_point;
import com.example.project.repository.Pickup_pointRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Pickup_pointService {
    private Pickup_pointRepository repository;
    public void savePickup_product(Entity_Pickup_point pickup_point) {
        repository.save(pickup_point);
    }
}
