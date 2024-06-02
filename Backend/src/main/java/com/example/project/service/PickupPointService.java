package com.example.project.service;

import com.example.project.common.Constants;
import com.example.project.dto.mapper.PickupPointDTOMapper;
import com.example.project.dto.request.PickupPointRequest;
import com.example.project.dto.response.PickupPointDTO;
import com.example.project.entity.PickupPoint;
import com.example.project.entity.User;
import com.example.project.exception.CannotUseUserException;
import com.example.project.exception.NoSuchElementFoundException;
import com.example.project.repository.PickupPointRepo;
import com.example.project.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class PickupPointService {
    private PickupPointRepo pickupPointRepo;
    private UserRepo userRepository;
    private PickupPointDTOMapper dtoMapper;

    public List<PickupPointDTO> findAll() {
        return pickupPointRepo.findAllWithManager()
                .stream()
                .map(dtoMapper)
                .collect(Collectors.toList());
    }

    public PickupPointDTO create(PickupPointRequest request) throws NoSuchElementFoundException, CannotUseUserException {
        User user = userRepository.findById(request.getManagerId())
                .orElseThrow(() -> new NoSuchElementFoundException(Constants.NOT_FOUND_MANAGER));

        //        if (!user.getRole().name().equals("ROLE_MANAGER")) {
//            throw new CannotUseUserExceptiion(Constants.);
//        }

        if (user.isLinkedToPickupPoint()) {
            throw new CannotUseUserException(Constants.CANNOT_USE_MANAGER);
        }

        PickupPoint pickupPoint = PickupPoint.builder()
                .address(request.getAddress())
                .income(0)
                .manager(user)
                .build();
        pickupPointRepo.save(pickupPoint);
        return dtoMapper.apply(pickupPoint);
    }

    public PickupPointDTO update(Integer id, PickupPointRequest request) throws NoSuchElementFoundException, CannotUseUserException {
        PickupPoint pickupPoint = pickupPointRepo.findById(id)
                .orElseThrow(() -> new NoSuchElementFoundException(Constants.NOT_FOUND_PICKUPPOINT));

        User user = userRepository.findById(request.getManagerId())
                .orElseThrow(() -> new NoSuchElementFoundException(Constants.NOT_FOUND_MANAGER));

//        if (!user.getRole().name().equals("ROLE_MANAGER")) {
//            throw new CannotUseUserExceptiion(Constants.);
//        }

        if (user.isLinkedToPickupPoint()) {
            throw new CannotUseUserException(Constants.CANNOT_USE_MANAGER);
        }

        pickupPoint.setAddress(request.getAddress());
        pickupPoint.setManager(user);

        pickupPointRepo.save(pickupPoint);
        return dtoMapper.apply(pickupPoint);
    }
}
