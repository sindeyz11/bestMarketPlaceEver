package com.example.project.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PickupPointRequest {
    @JsonProperty("manager_id")
    Integer managerId;
    String address;
}
