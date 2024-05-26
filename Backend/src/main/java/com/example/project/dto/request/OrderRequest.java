package com.example.project.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;


@Data
@AllArgsConstructor
public class OrderRequest {
    @JsonProperty("pickup_point_id")
    private Integer pickupPointId;

    @JsonProperty("products")
    private List<OrderedProductRequest> orderedProducts;
}
