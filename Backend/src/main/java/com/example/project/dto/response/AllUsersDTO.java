package com.example.project.dto.response;

import com.example.project.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class AllUsersDTO {
    private String username;
    private Role role;
    private Integer amount_spent;
    private Double user_discount;
}
