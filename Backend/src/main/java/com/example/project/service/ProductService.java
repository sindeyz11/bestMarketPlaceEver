package com.example.project.service;

import com.example.project.dto.response.ProductDTO;
import com.example.project.entity.Image;
import com.example.project.entity.Product;
import com.example.project.exception.ProductNotExistException;
import com.example.project.repository.ImageRepo;
import com.example.project.repository.ProductRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class ProductService {
    private ProductRepo productRepo;
    private ImageRepo imageRepo;

    public void saveProduct(Product product){
        productRepo.save(product);
    }
    
    public List<ProductDTO> getAssortment() {
        return productRepo.findAll().
                stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    public byte[] getImage(Integer imageId) throws ProductNotExistException {
        Image image = imageRepo.findById(imageId).
                orElseThrow(() -> new ProductNotExistException("Image not found"));
        return image.getImage().getBytes();
    }

    public void uploadImage(MultipartFile file, String altText) throws IOException {
        Image image = new Image();
        image.setImage(new String(file.getBytes()));
        image.setAlt(altText);
        imageRepo.save(image);
    }

    public List<ProductDTO> getSpecialOffers() {
        return productRepo.findByDiscountPriceNotNull().
                stream().map(ProductDTO::new).collect(Collectors.toList());
    }

    public List<String> getAvailableCategories() {
        return productRepo.findDistinctCategories();
    }
}
