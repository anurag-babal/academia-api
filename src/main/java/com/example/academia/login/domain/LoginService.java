package com.example.academia.login.domain;

import org.springframework.stereotype.Service;

import com.example.academia.login.data.UserRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LoginService {
  private final UserRepository userRepository;

  public User getUserByUsername(String username) {
    return userRepository.getUserByUsername(username);
  }
}
