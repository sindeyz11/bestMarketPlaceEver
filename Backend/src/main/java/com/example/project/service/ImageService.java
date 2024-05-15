package com.example.project.service;

import com.example.project.model.Entity_Image;
import com.example.project.repository.ImageRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class ImageService {
    private ImageRepository repository;

    public void saveImage(Entity_Image image) {
        repository.save(image);
    }
}
