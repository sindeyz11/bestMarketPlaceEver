package com.example.project.repository;

import com.example.project.entity.RoleUser;
import com.example.project.entity.pk.ID_Role_user;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleUserRepo extends JpaRepository<RoleUser, ID_Role_user> {
}
