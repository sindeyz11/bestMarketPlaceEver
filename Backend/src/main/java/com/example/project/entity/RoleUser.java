package com.example.project.entity;

import com.example.project.entity.pk.ID_Role_user;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Role_user")
@IdClass(ID_Role_user.class)
public class RoleUser {
    @Id
    @MapsId("user_id")
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User user_role;

    @Id
    @MapsId("role_id")
    @ManyToOne
    @JoinColumn(name = "role_id", referencedColumnName = "role_id")
    private Role role;
}
