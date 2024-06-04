package com.example.project.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import java.util.List;


@Data
@AllArgsConstructor
public class OrderRequest {
    @JsonProperty("pickup_point_id")
    @NotNull(message = "ID пункта выдачи не может быть пустым")
    private Integer pickupPointId;

    @JsonProperty("products")
    @Valid
    @NotEmpty(message = "Список продуктов не может быть пустым")
    private List<OrderedProductRequest> orderedProducts;
}
