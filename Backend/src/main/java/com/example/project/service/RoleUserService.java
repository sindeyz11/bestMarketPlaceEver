package com.example.project.service;

import com.example.project.entity.RoleUser;
import com.example.project.repository.RoleUserRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class RoleUserService {
    private RoleUserRepo repository;
    public void saveRole_user(RoleUser role_user)
    {
        repository.save(role_user);
    }
}
