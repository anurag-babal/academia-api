package com.example.academia.placement.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.academia.placement.data.entity.PlacementEntity;

@Repository
public interface PlacementEntityDao extends JpaRepository<PlacementEntity, Integer> {
    List<PlacementEntity> findAllByOrganisationEntityId(int organisationEntityId);
}
