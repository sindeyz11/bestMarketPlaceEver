package com.example.project.repository;

import com.example.project.model.Entity_Role_user;
import com.example.project.model.ID_Role_user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Role_userRepository  extends JpaRepository<Entity_Role_user, ID_Role_user> {
}
