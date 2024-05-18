package com.example.project.controller;

import com.example.project.entity.User;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {
    @GetMapping("/welcome")
    public String welcome(){
        return "Добро пожаловать ";
    }
    @GetMapping("/user")
    @PreAuthorize("hasAnyAuthority('costumer')")
    public String User(){
        return "User";
    }
    @GetMapping("/m")
    @PreAuthorize("hasAnyAuthority('manager')")
    public String Manager(){
        return "Manager";
    }
    @GetMapping("/admin")
    @PreAuthorize("hasAnyAuthority('administrator')")
    public String Admin(){
        return "Admin";
    }
}
