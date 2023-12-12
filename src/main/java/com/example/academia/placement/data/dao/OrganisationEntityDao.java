package com.example.academia.placement.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.academia.placement.data.entity.OrganisationEntity;

@Repository
public interface OrganisationEntityDao extends JpaRepository<OrganisationEntity, Integer> {
    
}
