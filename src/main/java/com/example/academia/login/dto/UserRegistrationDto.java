package com.example.academia.login.dto;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class UserRegistrationDto {
  @NotBlank
  String username;

  @NotBlank
  String password;
  
  @NotNull
  List<String> roles;
}
