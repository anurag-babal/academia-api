package com.example.academia.login;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.academia.core.config.JwtService;
import com.example.academia.login.data.UserRepository;
import com.example.academia.login.domain.User;
import com.example.academia.login.domain.UserService;
import com.example.academia.login.dto.LoginRequestDto;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final JwtService jwtService;
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final AuthenticationManager authenticationManager;

  @Override
  public User getUserByUsername(String username) {
    return userRepository.getUserByUsername(username);
  }

  @Override
  public User addUser(User user) {
    user.setPassword(passwordEncoder.encode(user.getPassword()));
    return userRepository.saveUser(user);
  }

  @Override
  public String generateToken(LoginRequestDto loginRequestDto) {
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(
            loginRequestDto.getUsername(), 
            loginRequestDto.getPassword())
        );
    SecurityContextHolder.getContext().setAuthentication(authentication);
    return jwtService.generateToken(authentication);
  }
}
