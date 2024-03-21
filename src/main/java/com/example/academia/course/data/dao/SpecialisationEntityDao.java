package com.example.academia.course.data.dao;

import com.example.academia.course.data.entity.SpecialisationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SpecialisationEntityDao extends JpaRepository<SpecialisationEntity, Integer> {

}
