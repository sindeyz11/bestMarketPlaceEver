package com.example.project.dto.request;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class OrderedProductRequest {
    @JsonProperty("product_id")
    private Integer productId;

    @JsonProperty("count")
    private Integer countProduct;
}
