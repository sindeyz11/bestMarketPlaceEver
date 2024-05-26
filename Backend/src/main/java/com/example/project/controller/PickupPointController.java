package com.example.project.controller;

import com.example.project.dto.request.OrderRequest;
import com.example.project.dto.request.PickupPointRequest;
import com.example.project.dto.response.PickupPointDTO;
import com.example.project.exception.UserNotExistException;
import com.example.project.service.PickupPointService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/point")
@RequiredArgsConstructor
public class PickupPointController {

    private final PickupPointService pickupPointService;

    @GetMapping
    public ResponseEntity<List<PickupPointDTO>> getAll() {
        try {
            return ResponseEntity.ok(pickupPointService.getAll());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping
    public ResponseEntity<?> createPoint(@RequestBody PickupPointRequest request) {
        try {
            PickupPointDTO pickupPointDTO = pickupPointService.createPoint(request);
            return ResponseEntity.ok(pickupPointDTO);
        } catch (UserNotExistException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping
    public ResponseEntity<?> updatePoint(@RequestBody PickupPointRequest request) {
        return ResponseEntity.ok("todo" +
                "todo add manager_id v dto?");
    }
}
