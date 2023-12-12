package com.example.academia.login.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleEntityDao extends JpaRepository<RoleEntity, Integer> {
  
}
