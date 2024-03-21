package com.example.academia.login.domain;

public interface UserService {
    User getUserByUsername(String username);

    User addUser(User user);

    String generateToken(User user);
}
