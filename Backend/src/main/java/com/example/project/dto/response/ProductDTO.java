package com.example.project.dto.response;

import com.example.project.entity.CategoryProduct;
import com.example.project.entity.Product;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
public class ProductDTO {
    @JsonProperty("product_id")
    private int productId;

    @JsonProperty("title")
    private String title;

    @JsonProperty("image")
    private ImageDTO image;

    @JsonProperty("description")
    private String description;

    @JsonProperty("price")
    private BigDecimal price;

    @JsonProperty("discount_price")
    private BigDecimal discountPrice;

    @JsonProperty("quantity_available")
    private Integer quantityAvailable;

    @JsonProperty("unit")
    private String unit;

    @JsonProperty("delivery_days")
    private Integer deliveryDays;

    @JsonProperty("category")
    private CategoryProduct category;

    public ProductDTO(Product product) {
        productId = product.getProductId();
        title = product.getTitle();
        image = new ImageDTO(
                product.getImageRecord().getImageId(),
                product.getImageRecord().getImage(),
                product.getImageRecord().getAlt()
        );
        description = product.getDescription();
        price = product.getPrice();
        discountPrice = product.getDiscountPrice();
        quantityAvailable = product.getQuantityOfAvailable();
        unit = product.getUnit();
        deliveryDays = product.getDeliveryDays();
    }
}
