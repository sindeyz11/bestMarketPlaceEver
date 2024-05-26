package com.example.project.controller;

import com.example.project.dto.request.OrderRequest;
import com.example.project.exception.PickupPointNotExistException;
import com.example.project.exception.ProductNotExistException;
import com.example.project.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/ordered-products/{orderId}")
    public ResponseEntity<?> getOrderedProductsByOrderId(@PathVariable Integer orderId) {
        try {
            return new ResponseEntity<>(orderService.getAllByOrderId(orderId), HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("/order")
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest request) {
        try {
            orderService.createOrder(request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (PickupPointNotExistException | ProductNotExistException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
