package com.example.project.repository;

import com.example.project.entity.RoleUser;
import com.example.project.entity.pk.IDRoleUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleUserRepo extends JpaRepository<RoleUser, IDRoleUser> {
}
