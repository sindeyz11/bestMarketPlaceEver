package com.example.project.service;

import com.example.project.entity.User;
import com.example.project.exception.UserAlreadyExistException;
import com.example.project.repository.UserRepo;
import lombok.AllArgsConstructor;
import lombok.NonNull;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class UserService {

    private UserRepo repository;
    private PasswordEncoder passwordEncoder;
    private final List<User> users;

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }
    /*public void addUser(User user) throws UserAlreadyExistException {
        if(repository.findByEmail(user.getEmail()) != null) {
            throw new UserAlreadyExistException("Пользователь с такой почтой уже есть");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        repository.save(user);
    }*/
    public User getUser(Integer user_id)
    {
        User user = repository.findById(user_id).orElse(null);
        return user;
    }

    public Optional<User> getByLogin(@NonNull String login) {
        return users.stream()
                .filter(user -> login.equals(user.getUsername()))
                .findFirst();
    }
}
