package com.example.project.service;

import com.example.project.dto.mapper.OrderedProductDTOMapper;
import com.example.project.dto.response.OrderDTO;
import com.example.project.dto.response.OrderedProductDTO;
import com.example.project.entity.Order;
import com.example.project.entity.OrderedProduct;
import com.example.project.repository.OrderRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService {
    private OrderRepo repository;
    private OrderedProductDTOMapper dtoMapper;

    public OrderDTO getAllByOrderId(Integer orderId) throws NoSuchElementException {
        Order order = repository.findById(orderId).orElseThrow();
        List<OrderedProductDTO> products = order.getProducts()
                .stream()
                .map(dtoMapper)
                .collect(Collectors.toList());

        return new OrderDTO(
                order.getId(),
                products,
                order.getDatetime(),
                order.isCompleted()
        );
    }
}
