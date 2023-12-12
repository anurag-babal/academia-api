package com.example.academia.login.data;

import com.example.academia.login.domain.Role;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "login")
@Data
public class LoginEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "username", length = 30, nullable = false, unique = true)
    private String username = "admin";

    @NotNull
    @Column(name = "password", length = 100, nullable = false)
    private String password = "pass";

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "role", nullable = false)
    private Role role = Role.NONE;

    @NotNull
    @Column(name = "employee_id", nullable = false, unique = true)
    private int employeeId;
}
