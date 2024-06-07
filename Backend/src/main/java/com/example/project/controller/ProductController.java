package com.example.project.controller;

import com.example.project.dto.response.ProductDTO;
import com.example.project.exception.ProductNotExistException;
import com.example.project.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/v1/product")
@RequiredArgsConstructor
public class ProductController {
    private ProductService productService;

    @GetMapping("/image/{imageId}")
    public ResponseEntity<byte[]> getImage(@PathVariable Integer imageId) {
        try {
            byte[] image = productService.getImage(imageId);
            return ResponseEntity.ok().contentType(MediaType.IMAGE_PNG).body(image);
        } catch (ProductNotExistException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @PostMapping("/image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file, @RequestParam("altText") String altText) {
        try {
            productService.uploadImage(file, altText);
            return ResponseEntity.status(HttpStatus.CREATED).body("Изображение успешно загружено");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Ошибка загрузки изображения");
        }
    }

    @GetMapping("/assortment")
    public ResponseEntity<List<ProductDTO>> getAssortment() {
        List<ProductDTO> products = productService.getAssortment();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/categories")
    public ResponseEntity<List<String>> getAvailableCategories() {
        List<String> categories = productService.getAvailableCategories();
        return ResponseEntity.ok(categories);
    }

    @GetMapping("/special")
    public ResponseEntity<List<ProductDTO>> getSpecialOffers() {
        List<ProductDTO> products = productService.getSpecialOffers();
        return ResponseEntity.ok(products);
    }
}
