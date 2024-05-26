package com.example.project.service;

import com.example.project.dto.request.ChangeCardUserRequest;
import com.example.project.dto.request.ChangeInfoUserRequest;
import com.example.project.dto.request.ChangePasswordRequest;
import com.example.project.dto.response.AllUsersDTO;
import com.example.project.dto.response.OrderDTO;
import com.example.project.dto.response.OrderedProductDTO;
import com.example.project.dto.response.UserStatisticsDTO;
import com.example.project.entity.Order;
import com.example.project.entity.Role;
import com.example.project.entity.User;
import com.example.project.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;


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
    public void changePassword(ChangePasswordRequest request, Principal connectedUser) {

        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();

        if (!passwordEncoder.matches(request.getCurrentPassword(), user.getPassword())) {
            throw new IllegalStateException("Wrong password");
        }
        if (!request.getNewPassword().equals(request.getConfirmationPassword())) {
            throw new IllegalStateException("Password are not the same");
        }

        user.setPassword(passwordEncoder.encode(request.getNewPassword()));
        repository.save(user);
    }

    public UserStatisticsDTO getUserStatistics(Integer userId) throws NoSuchElementException{
        User user= repository.findById(userId).orElseThrow();
        return new UserStatisticsDTO(
                user.getUser_id(),
                user.getUser_discount(),
                user.getAmount_spent()
        );
    }
    public void changeUserCard(ChangeCardUserRequest request){
        User user = repository.findById(request.getUser_id()).orElseThrow();
        user.setCard_number(request.getCard_number());
        user.setCVC(request.getCVC());
        user.setDatetime(request.getDatetime());
        repository.save(user);
    }

    public void changeUserInfo(ChangeInfoUserRequest request){
        User user = repository.findById(request.getUser_id()).orElseThrow();
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setUsername(request.getUsername());
        repository.save(user);
    }

    public List<AllUsersDTO> getAllUsers() {
        List<AllUsersDTO> users = repository.findAll()
                .stream()
                .map(user -> {
                    AllUsersDTO usersDTO = new AllUsersDTO();
                    usersDTO.setUsername(user.getName());
                    usersDTO.setUser_discount(user.getUser_discount());
                    usersDTO.setRole(user.getRole());
                    usersDTO.setAmount_spent(user.getAmount_spent());
                    return usersDTO;
                })
                .toList();
        return users;
    }
}

