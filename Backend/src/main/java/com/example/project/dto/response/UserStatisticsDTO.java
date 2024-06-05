package com.example.project.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserStatisticsDTO {
    private Integer user_discount;
    private Integer amount_spent;
    private Integer kol_order;
    private Double percent_order;
}
