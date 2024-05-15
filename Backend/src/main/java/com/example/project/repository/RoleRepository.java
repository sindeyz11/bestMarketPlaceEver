package com.example.project.repository;

import com.example.project.model.Entity_Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository  extends JpaRepository<Entity_Role, Integer> {
}
