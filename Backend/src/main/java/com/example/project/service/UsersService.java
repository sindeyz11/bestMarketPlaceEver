package com.example.project.service;

import com.example.project.model.Entity_Users;
import com.example.project.repository.UsersRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class UsersService {

    private UsersRepository repository;
    public void saveUser(Entity_Users user) {
        repository.save(user);
    }
}
