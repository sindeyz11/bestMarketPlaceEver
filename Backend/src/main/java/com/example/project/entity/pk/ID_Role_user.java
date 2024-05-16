package com.example.project.entity.pk;

import jakarta.persistence.Embeddable;
import lombok.Data;

import java.io.Serializable;

@Data
@Embeddable
public class ID_Role_user implements Serializable {
    private int user_role;
    private int role;

}
