package com.example.project.service;

import com.example.project.model.Entity_Role;
import com.example.project.repository.RoleRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleService {
    private RoleRepository repository;
    public void save(Entity_Role role) {
        repository.save(role);
    }
}
