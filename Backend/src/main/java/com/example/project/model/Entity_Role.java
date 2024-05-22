package com.example.project.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name = "Role")
public class Entity_Role {
    @Id
    private Integer role_id;
    private String title;

    @OneToMany(mappedBy = "role")
    private Set<Entity_Role_user> roles_user;
}
