package com.example.project.service;

import com.example.project.model.Entity_Role_user;
import com.example.project.repository.Role_userRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class Role_userService {
    private Role_userRepository repository;
    public void saveRole_user(Entity_Role_user role_user)
    {
        repository.save(role_user);
    }
}
