package com.example.project.dto.mapper;

import com.example.project.dto.response.PickupPointDTO;
import com.example.project.entity.PickupPoint;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PickupPointDTOMapper implements Function<PickupPoint, PickupPointDTO> {

    @Override
    public PickupPointDTO apply(PickupPoint pickupPoint) {
        return new PickupPointDTO(
                pickupPoint.getId(),
                pickupPoint.getAddress(),
                pickupPoint.getManagerName(),
                pickupPoint.getIncome()
        );
    }
}
