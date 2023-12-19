package com.example.academia.login.data;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleEntityDao extends JpaRepository<RoleEntity, Integer> {
  Optional<RoleEntity> findByName(String name);
}
