package com.example.project.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PickupPointRequest {
    @JsonProperty("manager_id")
    @NotNull
    Integer managerId;

    @NotNull
    String address;
}
