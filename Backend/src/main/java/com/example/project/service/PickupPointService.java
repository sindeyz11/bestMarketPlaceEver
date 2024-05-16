package com.example.project.service;

import com.example.project.entity.PickupPoint;
import com.example.project.repository.PickupPointRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class PickupPointService {
    private PickupPointRepo repository;
    public void savePickup_product(PickupPoint pickup_point) {
        repository.save(pickup_point);
    }
}
