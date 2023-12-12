package com.example.academia.login.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserEntityDao extends JpaRepository<UserEntity, Integer> {
  public Optional<UserEntity> findByUsername(String username);
}
