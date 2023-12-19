package com.example.academia.login;

import org.springframework.stereotype.Component;

import com.example.academia.login.domain.Role;
import com.example.academia.login.domain.User;
import com.example.academia.login.dto.LoginRequestDto;
import com.example.academia.login.dto.UserRegistrationDto;
import com.example.academia.login.dto.UserResponseDto;

@Component
public class UserMapper {
  public User mapToDomainUser(UserRegistrationDto dto) {
    return User.builder()
        .username(dto.getUsername())
        .password(dto.getPassword())
        .roles(dto.getRoles().stream().map(this::mapToDomainRole).toList())
        .build();
  }

  public Role mapToDomainRole(String role) {
    return Role.valueOf("ROLE_" + role.toUpperCase());
  }

  public User mapToDomainUser(LoginRequestDto dto) {
    return User.builder()
        .username(dto.getUsername())
        .password(dto.getPassword())
        .build();
  }

  public UserResponseDto mapToDtoUser(User user) {
    return UserResponseDto.builder()
        .username(user.getUsername())
        .roles(user.getRoles().stream().map(this::mapToDtoRole).toList())
        .build();
  }

  public String mapToDtoRole(Role role) {
    return role.toString().substring(5);
  }
}
