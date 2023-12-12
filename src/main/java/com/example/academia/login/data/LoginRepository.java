package com.example.academia.login.data;

import org.springframework.stereotype.Component;

import com.example.academia.login.domain.User;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Component
@RequiredArgsConstructor
public class LoginRepository {
    private final LoginDao loginDao;

    public User getUserByUsername(String username) {
        return mapToDomainUser(getLoginEntityByUsername(username));
    }

    private LoginEntity getLoginEntityByUsername(String username) {
        return loginDao.findByUsername(username)
                .orElseThrow(() -> new EntityNotFoundException("User not found."));
    }

    public User getUserByUsernamePassword(String username, String password) {
      return mapToDomainUser(getLoginEntityByUsernameAndPassword(username, password));
    }

    private LoginEntity getLoginEntityByUsernameAndPassword(String username, String password) {
        return loginDao.findByUsernameAndPassword(username, password)
                .orElseThrow(() -> new EntityNotFoundException("User not found."));
    }

    private User mapToDomainUser(LoginEntity entity) {
        return User.builder()
                .username(entity.getUsername())
                .password(entity.getPassword())
                .role(entity.getRole())
                .employeeId(entity.getEmployeeId())
                .build();
    }
}
