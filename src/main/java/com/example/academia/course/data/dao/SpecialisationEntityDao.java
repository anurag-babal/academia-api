package com.example.academia.course.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.academia.course.data.entity.SpecialisationEntity;

@Repository
public interface SpecialisationEntityDao extends JpaRepository<SpecialisationEntity, Integer> {
    
}
