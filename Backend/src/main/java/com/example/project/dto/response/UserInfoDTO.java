package com.example.project.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserInfoDTO {
    private String username;
    private String email;
    private String phone;
    private String card_number;
    private Integer CVC;
    private LocalDate validity;
    private Integer user_discount;
    private Integer amount_spent;
    private Integer kol_order;
    private Double percent_order;
}
