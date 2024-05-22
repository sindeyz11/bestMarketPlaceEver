package com.example.project.repository;

import com.example.project.model.Entity_Image;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImageRepository extends JpaRepository<Entity_Image, Integer> {
}
