package com.example.academia.login;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.academia.login.data.UserRepository;
import com.example.academia.login.domain.User;
import com.example.academia.login.domain.UserService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
  private final UserRepository userRepository;
  // private final PasswordEncoder encoder;

  @Override
  public User getUserByUsername(String username) {
    return userRepository.getUserByUsername(username);
  }

  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    return getUserByUsername(username);
  }

  @Override
  public User addUser(User user) {
    // user.setPassword(encoder.encode(user.getPassword()));
    // return userRepository.saveUser(user);
    return null;
  }
}
