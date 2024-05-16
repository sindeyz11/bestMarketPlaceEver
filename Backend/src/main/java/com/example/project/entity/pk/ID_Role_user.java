package com.example.project.entity.pk;

import lombok.Data;

import jakarta.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Data
public class ID_Role_user implements Serializable {
    private int user_role;
    private int role;

}
