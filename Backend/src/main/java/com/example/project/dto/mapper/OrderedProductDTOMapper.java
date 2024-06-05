package com.example.project.dto.mapper;

import com.example.project.dto.response.OrderedProductDTO;
import com.example.project.dto.response.ProductDTO;
import com.example.project.entity.OrderedProduct;
import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class OrderedProductDTOMapper implements Function<OrderedProduct, OrderedProductDTO> {
    @Override
    public OrderedProductDTO apply(OrderedProduct orderedProduct) {
        ProductDTO productDTO = new ProductDTO(orderedProduct.getProduct());

        return new OrderedProductDTO(
                productDTO,
                orderedProduct.getCount(),
                orderedProduct.getDiscountPrice(),
                orderedProduct.getDeliveryDays(),
                orderedProduct.getDeliveryStatus().getTitle(),
                orderedProduct.getCompletionDate()
        );
    }

}
