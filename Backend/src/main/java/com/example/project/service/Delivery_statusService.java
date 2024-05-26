package com.example.project.service;

import com.example.project.model.Entity_Delivery_status;
import com.example.project.repository.Delivery_statusRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Delivery_statusService {
    private Delivery_statusRepository repository;

    public void saveDelivery_status(Entity_Delivery_status delivery_status){
        repository.save(delivery_status);
    }
}
