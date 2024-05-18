package com.example.project.service;

import com.example.project.dto.mapper.PickupPointDTOMapper;
import com.example.project.dto.response.PickupPointDTO;
import com.example.project.repository.PickupPointRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PickupPointService {
    private PickupPointRepo pickupPointRepo;
    private PickupPointDTOMapper dtoMapper;

    public List<PickupPointDTO> getAll() {
        return pickupPointRepo.findAll()
                .stream()
                .map(dtoMapper)
                .collect(Collectors.toList());
    }
}
