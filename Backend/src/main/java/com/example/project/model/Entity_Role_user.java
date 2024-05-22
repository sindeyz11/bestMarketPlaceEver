package com.example.project.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Role_user")
@IdClass(ID_Role_user.class)
public class Entity_Role_user {
    @Id
    @MapsId("user_id")
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private Entity_Users user_role;

    @Id
    @MapsId("role_id")
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Entity_Role role;
}
