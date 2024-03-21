package com.example.academia.placement.data.dao;

import com.example.academia.placement.data.entity.PlacementEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlacementEntityDao extends JpaRepository<PlacementEntity, Integer> {
    List<PlacementEntity> findAllByOrganisationEntityId(int organisationEntityId);
}
