package com.example.academia.login;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.academia.core.ResponseBuilder;
import com.example.academia.core.ResponseDto;
import com.example.academia.core.config.JwtService;
import com.example.academia.login.domain.User;
import com.example.academia.login.domain.UserService;
import com.example.academia.login.dto.LoginRequestDto;
import com.example.academia.login.dto.LoginResponseDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class LoginController {
  private final UserService userService;
  private final JwtService jwtService;
  private final AuthenticationManager authenticationManager;

  @PostMapping("/v1/login")
  public ResponseDto getUserByUsernamePassword(@RequestBody LoginRequestDto loginDto) {
    User user = userService.getUserByUsername(loginDto.getUsername());
    return ResponseBuilder.createResponse(LoginResponseDto.builder()
        .username(user.getUsername())
        .roles(user.getRoles().stream().map(role -> role.toString()).toList())
        .employeeId(user.getEmployeeId())
        .build());
  }

  @PostMapping("/login")
  public ResponseDto authenticateUser(@RequestBody LoginRequestDto loginDto) {
    Authentication authentication = authenticationManager.authenticate(
      new UsernamePasswordAuthenticationToken(loginDto.getUsername(), loginDto.getPassword())
    );
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String token = jwtService.createToken(authentication);
    // User user = (User) authentication.getPrincipal();
    return ResponseBuilder.createResponse(token);
  }
}
