package com.example.project.dto.mapper;

import com.example.project.dto.response.PickupPointDTO;
import com.example.project.entity.PickupPoint;
import com.example.project.entity.User;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class PickupPointDTOMapper implements Function<PickupPoint, PickupPointDTO> {

    @Override
    public PickupPointDTO apply(PickupPoint pickupPoint) {
        User manager = pickupPoint.getManager();
        String managerName = null;
        if (manager != null) {
            managerName = manager.getName();
        }
        return new PickupPointDTO(
                pickupPoint.getId(),
                pickupPoint.getAddress(),
                managerName,
                pickupPoint.getIncome()
        );
    }
}
