package com.example.academia.placement.data.dao;

import com.example.academia.placement.data.entity.PlacementFilterEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlacementFilterEntityDao extends JpaRepository<PlacementFilterEntity, Integer> {
    List<PlacementFilterEntity> findAllByDomainEntityId(int id);
}
