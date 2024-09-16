package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "user_model")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String nome;
    private String login;
    private String password;
    private Role role = Role.ROLE_ADMIN;

    public enum Role {
        ROLE_ADMIN,
        ROLE_CLIENT
    }

}
