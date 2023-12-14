package com.example.academia.login.domain;

import com.example.academia.login.dto.LoginRequestDto;

public interface UserService {
  public User getUserByUsername(String username);

  public User addUser(User user);

  public String generateToken(LoginRequestDto loginRequestDto);
}
