package com.example.project.controller;

import com.example.project.dto.request.ChangeCardUserRequest;
import com.example.project.dto.request.ChangeInfoUserRequest;
import com.example.project.dto.request.ChangePasswordRequest;
import com.example.project.exception.*;
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
        try {
            Userservice.changePassword(request, connectedUser);
            return new ResponseEntity<>("passord change",HttpStatus.OK);
        } catch (UserIncorrectPasswordException | UserMismatchPasswordException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/satistics")
    public ResponseEntity<?> getSatistics(Principal connectedUser) {
        try {
            return new ResponseEntity<>(Userservice.getUserStatistics(connectedUser), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/card")
    public ResponseEntity<?> getCard(Principal connectedUser) {
        try {
            return new ResponseEntity<>(Userservice.getUserCard(connectedUser), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/change/card")
    public ResponseEntity<?> ChangeUserCard(
            @RequestBody ChangeCardUserRequest request,
            Principal connectedUser
    ) {
        Userservice.changeUserCard(request, connectedUser);
        return new ResponseEntity<>("User's card save", HttpStatus.OK);
    }

    @GetMapping("/info")
    public ResponseEntity<?> getInfoUser(Principal connectedUser) {
        try {
            return new ResponseEntity<>(Userservice.getInfoUser(connectedUser), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PatchMapping("/change/info")
    public ResponseEntity<?> ChangeUserInfo(
            @RequestBody ChangeInfoUserRequest request,
            Principal connectedUser
    ) {try
    {
        return new ResponseEntity<>(Userservice.changeUserInfo(request, connectedUser), HttpStatus.OK);
    }catch(UniqueEmailException | UniquePhoneException e)
    {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}

    @GetMapping("/admin/all_users")
    public ResponseEntity<?> getUserAll() {
        return new ResponseEntity<>(Userservice.getAllUsers(), HttpStatus.OK);
    }
}

