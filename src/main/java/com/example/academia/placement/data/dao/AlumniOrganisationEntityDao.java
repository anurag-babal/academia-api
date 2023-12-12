package com.example.academia.placement.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.academia.placement.data.entity.AlumniOrganisationEntity;

@Repository
public interface AlumniOrganisationEntityDao extends JpaRepository<AlumniOrganisationEntity, Integer> {
    public List<AlumniOrganisationEntity> findAllByOrganisationEntityId(int organisationEntityId);
}
