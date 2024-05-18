package com.example.project.controller;

import com.example.project.dto.response.PickupPointDTO;
import com.example.project.service.PickupPointService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class PickupPointController {

    private final PickupPointService pickupPointService;

    @GetMapping("/pickup-points")
    public ResponseEntity<List<PickupPointDTO>> getAll() {
        return ResponseEntity.ok(pickupPointService.getAll());
    }
}
