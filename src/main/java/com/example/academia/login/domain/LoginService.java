package com.example.academia.login.domain;

import com.example.academia.login.data.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LoginService {
    private final UserRepository userRepository;

    public User getUserByUsername(String username) {
        return userRepository.getUserByUsername(username);
    }
}
