package com.example.academia.login.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LoginDao extends JpaRepository<LoginEntity, Integer>{
    Optional<LoginEntity> findByUsername(String username);

    Optional<LoginEntity> findByUsernameAndPassword(String username, String password);
}
