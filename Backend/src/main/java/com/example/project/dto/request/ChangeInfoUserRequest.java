package com.example.project.dto.request;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class ChangeInfoUserRequest {
    private Integer user_id;
    private String username;
    private String email;
    private String phone;
}
