package com.example.project.controller;


import com.example.project.dto.request.ChangeCardUserRequest;
import com.example.project.dto.request.ChangeInfoUserRequest;
import com.example.project.dto.request.ChangePasswordRequest;
import com.example.project.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private UserService Userservice;

    @PatchMapping("/change/password")
    public ResponseEntity<?> changePassword(
            @RequestBody ChangePasswordRequest request,
            Principal connectedUser
    ) {
        Userservice.changePassword(request, connectedUser);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/satistics/{userId}")
    public ResponseEntity<?> getSatistics(@PathVariable Integer userId) {
        try {
            return new ResponseEntity<>(Userservice.getUserStatistics(userId), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/change/card")
    public ResponseEntity<?> ChangeUserCard(
            @RequestBody ChangeCardUserRequest request
    ) {
        Userservice.changeUserCard(request);
        return ResponseEntity.ok().build();
    }

    @PatchMapping("/change/info")
    public ResponseEntity<?> ChangeUserInfo(
            @RequestBody ChangeInfoUserRequest request
    ) {
        Userservice.changeUserInfo(request);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/admin/all_users")
    public ResponseEntity<?> getOrderedProductsByOrderId() {
        return new ResponseEntity<>(Userservice.getAllUsers(), HttpStatus.OK);
    }
}

