package com.example.academia.login.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class UserResponseDto {
    private String username;
    private List<String> roles;
}
