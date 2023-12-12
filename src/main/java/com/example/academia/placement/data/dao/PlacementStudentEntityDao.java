package com.example.academia.placement.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.academia.placement.data.entity.PlacementStudentEntity;

@Repository
public interface PlacementStudentEntityDao extends JpaRepository<PlacementStudentEntity, Integer> {
  public List<PlacementStudentEntity> findAllByStudentEntityId(int id);   
}
