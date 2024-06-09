package com.example.project.dto.response;

import com.example.project.dto.serializer.PickupPointDTOSerializer;
import com.example.project.entity.Order;
import com.example.project.entity.User;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@JsonSerialize(using = PickupPointDTOSerializer.class)
@Data
@AllArgsConstructor
public class PickupPointDTO {
    private int id;
    private String address;
    private String managerName;
    private Double income;
}