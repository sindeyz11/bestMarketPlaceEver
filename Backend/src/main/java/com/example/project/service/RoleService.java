package com.example.project.service;

import com.example.project.entity.Role;
import com.example.project.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {
    private RoleRepository repository;
    public void save(Role role) {
        repository.save(role);
    }
}
