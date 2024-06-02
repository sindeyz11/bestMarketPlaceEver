package com.example.project.service;

import com.example.project.common.Constants;
import com.example.project.dto.mapper.OrderedProductDTOMapper;
import com.example.project.dto.request.OrderRequest;
import com.example.project.dto.request.OrderedProductRequest;
import com.example.project.dto.response.OrderDTO;
import com.example.project.dto.response.OrderedProductDTO;
import com.example.project.entity.*;
import com.example.project.exception.PickupPointNotExistException;
import com.example.project.exception.ProductNotExistException;
import com.example.project.repository.*;
import lombok.AllArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class OrderService {
    private OrderRepo repository;
    private ProductRepo productRepository;
    private PickupPointRepo pickupPointRepo;
    private OrderedProductRepo orderedProductRepo;
    private DeliveryStatusRepo deliveryStatusRepo;

    private OrderedProductDTOMapper dtoMapper;

    public OrderDTO findAllByOrderId(Integer orderId) throws NoSuchElementException {
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

    @Transactional(rollbackFor={Exception.class})
    public void create(OrderRequest orderRequest) throws ProductNotExistException, PickupPointNotExistException {
        User user = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal());
        Integer userDiscount = user.getUser_discount();
        PickupPoint pickupPoint = pickupPointRepo
                .findById(orderRequest.getPickupPointId())
                .orElseThrow(() -> new PickupPointNotExistException(Constants.NOT_FOUND_PICKUPPOINT));
        DeliveryStatus deliveryStatus = deliveryStatusRepo.findById(1).orElseThrow(); // id1 = В пути

        List<OrderedProductRequest> orderedProductsReq = orderRequest.getOrderedProducts();
        List<OrderedProduct> orderedProductsToCreate = new ArrayList<>();

        Order order = Order.builder()
                .user(user)
                .datetime(LocalDate.now())
                .pickupPoint(pickupPoint)
                .completed(false)
                .build();
        repository.save(order);

        var productsIds = orderedProductsReq
                .stream()
                .map(OrderedProductRequest::getProductId)
                .toList();
        List<Product> products = productRepository.findAllById(productsIds);

        for (OrderedProductRequest orderedProductReq : orderedProductsReq) {
            var id = orderedProductReq.getProductId();
            try {
                var product = products
                        .stream()
                        .filter(p -> p.getProduct_id() == id)
                        .toList()
                        .get(0);
                Integer discountPrice;
                Integer productDiscountPrice = product.getDiscount_price();

                if (userDiscount != null && userDiscount != 0) {
                    discountPrice = productDiscountPrice - productDiscountPrice * (userDiscount / 100);
                } else {
                    discountPrice = productDiscountPrice;
                }

                orderedProductsToCreate.add(OrderedProduct.builder()
                        .order(order)
                        .product(product)
                        .count(orderedProductReq.getCountProduct())
                        .discountPrice(discountPrice)
                        .deliveryDays(product.getDelivery_days())
                        .deliveryStatus(deliveryStatus)
                        .build()
                );

            } catch (Exception e) {
                throw new ProductNotExistException(Constants.NOT_FOUND_PRODUCT + id.toString());
            }
        }
        orderedProductRepo.saveAll(orderedProductsToCreate);
    }
}
