package com.example.project.service;

import com.example.project.common.Constants;
import com.example.project.dto.mapper.PickupPointDTOMapper;
import com.example.project.dto.request.PickupPointRequest;
import com.example.project.dto.response.PickupPointDTO;
import com.example.project.entity.PickupPoint;
import com.example.project.entity.User;
import com.example.project.exception.UserNotExistException;
import com.example.project.repository.PickupPointRepo;
import com.example.project.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PickupPointService {
    private PickupPointRepo pickupPointRepo;
    private UserRepo userRepository;
    private PickupPointDTOMapper dtoMapper;

    public List<PickupPointDTO> getAll() {
        return pickupPointRepo.findAllWithManager()
                .stream()
                .map(dtoMapper)
                .collect(Collectors.toList());
    }

    public PickupPointDTO createPoint(PickupPointRequest request) throws UserNotExistException {
        User manager = userRepository.findById(request.getManagerId())
                .orElseThrow(() -> new UserNotExistException(Constants.NOT_FOUND_MANAGER));
        PickupPoint pickupPoint = PickupPoint.builder()
                .address(request.getAddress())
                .income(0)
                .manager(manager)
                .build();
        pickupPointRepo.save(pickupPoint);
        return dtoMapper.apply(pickupPoint);
    }
}
