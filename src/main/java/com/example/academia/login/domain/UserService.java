package com.example.academia.login.domain;

import org.springframework.security.core.userdetails.UserDetailsService;

public interface UserService extends UserDetailsService {
  public User getUserByUsername(String username);

  public User addUser(User user);
}
