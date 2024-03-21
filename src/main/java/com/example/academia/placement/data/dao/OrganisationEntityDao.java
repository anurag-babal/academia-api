package com.example.academia.placement.data.dao;

import com.example.academia.placement.data.entity.OrganisationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrganisationEntityDao extends JpaRepository<OrganisationEntity, Integer> {

}
