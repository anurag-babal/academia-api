package com.example.academia.placement.data.dao;

import com.example.academia.placement.data.entity.PlacementStudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlacementStudentEntityDao extends JpaRepository<PlacementStudentEntity, Integer> {
    List<PlacementStudentEntity> findAllByStudentEntityId(int id);
}
