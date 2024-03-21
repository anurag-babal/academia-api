package com.example.academia.placement.data.dao;

import com.example.academia.placement.data.entity.AlumniOrganisationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlumniOrganisationEntityDao extends JpaRepository<AlumniOrganisationEntity, Integer> {
    List<AlumniOrganisationEntity> findAllByOrganisationEntityId(int organisationEntityId);
}
