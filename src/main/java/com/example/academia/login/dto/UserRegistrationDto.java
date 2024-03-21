package com.example.academia.login.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Data
public class UserRegistrationDto {
    @NotBlank
    String username;

    @NotBlank
    String password;

    @NotNull
    List<String> roles;
}
