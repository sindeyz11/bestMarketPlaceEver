package com.example.project.service;


import com.example.project.auth.AuthenticationResponse;
import com.example.project.config.JwtService;
import com.example.project.dto.request.ChangeCardUserRequest;
import com.example.project.dto.request.ChangeInfoUserRequest;
import com.example.project.dto.request.ChangePasswordRequest;
import com.example.project.dto.response.*;
import com.example.project.entity.User;
import com.example.project.dto.response.UserProductStatsDTO;
import com.example.project.repository.OrderedProductRepo;
import com.example.project.repository.UserRepo;
import lombok.AllArgsConstructor;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.security.Principal;
import java.util.List;


@Service
@AllArgsConstructor
public class UserService {

    private OrderedProductRepo orderedproductRepo;
    private UserRepo userRepo;
    private PasswordEncoder passwordEncoder;
    private final JwtService jwtService;

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepo.save(user);
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
        userRepo.save(user);
    }

    public UserStatisticsDTO getUserStatistics(Principal connectedUser){
        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        UserProductStatsDTO stats= orderedproductRepo.findUserProductStatsByUserId(user.getUser_id());
        Double percent;
        if (stats != null) {
            Long issuedCount = stats.getIssuedProducts();
            Long refusedCount = stats.getRefusedProducts();
            percent = (double) issuedCount / (issuedCount + refusedCount) * 100;
        } else {
            percent = null;
        }
        return UserStatisticsDTO.builder()
                .user_discount(user.getUser_discount())
                .amount_spent(user.getAmount_spent())
                .kol_order(user.getOrders().size())
                .percent_order(percent)
                .build();
    }

    public UserInfoDTO getInfoUser(Principal connectedUser){
        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        return UserInfoDTO.builder()
                .username(user.getName())
                .phone(user.getPhone())
                .email(user.getEmail())
                .build();
    }
    public UserCardDTO getUserCard(Principal connectedUser){
        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        return UserCardDTO.builder()
                .card_number(user.getCard_number())
                .CVC(user.getCVC())
                .datetime(user.getDatetime())
                .build();
    }

    public void changeUserCard(ChangeCardUserRequest request, Principal connectedUser){
        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        user.setCard_number(request.getCard_number());
        user.setCVC(request.getCVC());
        user.setDatetime(request.getDatetime());
        userRepo.save(user);
    }

    public AuthenticationResponse changeUserInfo(ChangeInfoUserRequest request, Principal connectedUser){
        var user = (User) ((UsernamePasswordAuthenticationToken) connectedUser).getPrincipal();
        user.setEmail(request.getEmail());
        user.setPhone(request.getPhone());
        user.setUsername(request.getUsername());
        userRepo.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthenticationResponse.builder()
                .Token(jwtToken)
                .role(user.getRole())
                .build();
    }

    public List<AllUsersDTO> getAllUsers() {
        List<AllUsersDTO> users = userRepo.findAll()
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

