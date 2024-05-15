package com.example.project.repository;

import com.example.project.model.Entity_Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsersRepository extends JpaRepository<Entity_Users, Integer> {

}
