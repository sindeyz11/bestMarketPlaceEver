package com.example.project.service;

import com.example.project.entity.User;
import com.example.project.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UserService {

    private UserRepo repository;
    public void saveUser(User user) {
        repository.save(user);
    }
}
