package com.example.project.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;


@Data
@Entity
@Table(name = "Role")
public class Role {
    @Id
    private Integer role_id;
    private String title;

}
