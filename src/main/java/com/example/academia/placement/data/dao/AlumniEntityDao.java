package com.example.academia.placement.data.dao;

import com.example.academia.placement.data.entity.AlumniEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlumniEntityDao extends JpaRepository<AlumniEntity, Integer> {

}
