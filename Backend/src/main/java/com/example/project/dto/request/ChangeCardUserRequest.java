package com.example.project.dto.request;

import jakarta.persistence.criteria.CriteriaBuilder;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class ChangeCardUserRequest {
    private String card_number;
    private Integer CVC;
    private LocalDate datetime;
}
