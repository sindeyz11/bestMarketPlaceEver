package com.example.project.controller;

import com.example.project.dto.request.OrderRequest;
import com.example.project.exception.NoSuchElementFoundException;
import com.example.project.service.OrderService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class OrderController {

    private final OrderService orderService;

    @GetMapping("/ordered-products/{orderId}")
    public ResponseEntity<?> getOrderedProductsByOrderId(@PathVariable Integer orderId) {
        try {
            return new ResponseEntity<>(orderService.findAllByOrderId(orderId), HttpStatus.OK);
        } catch (NoSuchElementFoundException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/order/user")
    public ResponseEntity<?> getOrderedProductsByUserId() {
        // todo
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @PostMapping("/order")
    public ResponseEntity<?> createOrder(@RequestBody OrderRequest request) {
        try {
            orderService.create(request);
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (NoSuchElementFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/order/{id}")
    public ResponseEntity<?> confirmOrder(@PathVariable Integer id, @RequestBody OrderRequest request) {
        // todo
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
