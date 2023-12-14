package com.example.academia.login.dto;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class LoginResponseDto {
  private String username;
  private List<String> roles;
}
