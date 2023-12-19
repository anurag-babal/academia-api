package com.example.academia.login.domain;

public interface UserService {
  public User getUserByUsername(String username);

  public User addUser(User user);

  public String generateToken(User user);
}
