package com.example.project.controller;

import com.example.project.dto.request.PickupPointRequest;
import com.example.project.dto.response.PickupPointDTO;
import com.example.project.exception.CannotUseUserException;
import com.example.project.exception.NoSuchElementFoundException;
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
            return ResponseEntity.ok(pickupPointService.findAll());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping
    public ResponseEntity<?> createPoint(@RequestBody PickupPointRequest request) {
        try {
            PickupPointDTO pickupPointDTO = pickupPointService.create(request);
            return ResponseEntity.ok(pickupPointDTO);
        } catch (NoSuchElementFoundException | CannotUseUserException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updatePoint(@PathVariable Integer id, @RequestBody PickupPointRequest request) {
        try {
            PickupPointDTO pickupPointDTO = pickupPointService.update(id, request);
            return ResponseEntity.ok(pickupPointDTO);
        } catch (NoSuchElementFoundException | CannotUseUserException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
