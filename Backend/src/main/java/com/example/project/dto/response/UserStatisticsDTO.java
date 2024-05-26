package com.example.project.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserStatisticsDTO {
    private Integer id;
    private Integer user_discount;
    private Integer amount_spent;
}
