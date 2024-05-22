package com.example.project.service;

import com.example.project.model.Entity_Category;
import com.example.project.repository.CategoryRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CategoryService {
    private CategoryRepository repository;
    public void saveCategory(Entity_Category category) {
        repository.save(category);
    }
}
