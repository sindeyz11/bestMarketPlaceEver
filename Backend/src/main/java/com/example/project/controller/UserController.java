package com.example.project.controller;

import com.example.project.entity.User;
import com.example.project.service.UserService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/user")
@AllArgsConstructor
public class UserController {
    private UserService service;

    @PostMapping("/new-user")
    public ResponseEntity addUser(@RequestBody User user) {
        try {
            service.addUser(user);
            return ResponseEntity.ok("Пользователь был успешно сохранен");
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Произошла ошибка");
        }
    }

}
