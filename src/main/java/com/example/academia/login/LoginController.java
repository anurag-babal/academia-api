package com.example.academia.login;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.academia.core.ResponseBuilder;
import com.example.academia.core.ResponseDto;
import com.example.academia.login.domain.LoginService;
import com.example.academia.login.domain.User;
import com.example.academia.login.dto.LoginRequestDto;
import com.example.academia.login.dto.LoginResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
@CrossOrigin(originPatterns = "*localhost*")
public class LoginController {
  private final LoginService loginService;

  @PostMapping("/v1/login")
  public ResponseDto getUserByUsernamePassword(@RequestBody LoginRequestDto loginDto) {
    User user = loginService.getUserWithUsernamePassword(loginDto.getUsername(),
    loginDto.getPassword());
    return ResponseBuilder.createResponse(LoginResponseDto.builder()
        .username(user.getUsername())
        .role(user.getRole().toString())
        .employeeId(user.getEmployeeId())
        .build());
  }
}
