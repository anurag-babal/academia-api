package com.example.academia.placement.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.academia.placement.data.entity.PlacementFilterEntity;

@Repository
public interface PlacementFilterEntityDao extends JpaRepository<PlacementFilterEntity, Integer> {
  public List<PlacementFilterEntity> findAllByDomainEntityId(int id);
}
