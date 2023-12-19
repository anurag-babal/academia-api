package com.example.academia.login;

import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.academia.core.ResponseBuilder;
import com.example.academia.core.ResponseDto;
import com.example.academia.login.domain.User;
import com.example.academia.login.domain.UserService;
import com.example.academia.login.dto.LoginRequestDto;
import com.example.academia.login.dto.LoginResponseDto;
import com.example.academia.login.dto.UserRegistrationDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoginController {
  private final UserMapper userMapper;
  private final UserService userService;

  @PostMapping("/v1/login")
  public ResponseDto getUserByUsernamePassword(@RequestBody LoginRequestDto loginDto) {
    User user = userService.getUserByUsername(loginDto.getUsername());
    return ResponseBuilder.createResponse(LoginResponseDto.builder()
        .username(user.getUsername())
        .roles(user.getRoles().stream().map(role -> role.toString()).toList())
        .build());
  }

  @PostMapping("/v1/authenticate")
  public ResponseDto authenticateUser(@RequestBody LoginRequestDto loginDto) {
    String token = userService.generateToken(userMapper.mapToDomainUser(loginDto));
    return ResponseBuilder.createResponse(token);
  }

  @GetMapping("/test")
  public ResponseDto test() {
    return ResponseBuilder.createResponse("Welcome!!");
  }

  @PostMapping("/v1/register")
  public ResponseDto registerUser(@Validated @RequestBody UserRegistrationDto dto) {
    User user = userService.addUser(userMapper.mapToDomainUser(dto));
    return ResponseBuilder.createResponse(userMapper.mapToDtoUser(user));
  }
}
