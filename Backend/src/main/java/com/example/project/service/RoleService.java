package com.example.project.service;

import com.example.project.entity.Role;
import com.example.project.repository.RoleRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {
    private RoleRepo repository;
    public void saveRole(Role role){
        repository.save(role);
    }
}
