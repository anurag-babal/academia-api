package com.example.academia.login.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleEntityDao extends JpaRepository<RoleEntity, Integer> {
    Optional<RoleEntity> findByName(String name);
}
