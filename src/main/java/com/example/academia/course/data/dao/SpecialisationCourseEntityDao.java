package com.example.academia.course.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.academia.course.data.entity.SpecialisationCourseEntity;

@Repository
public interface SpecialisationCourseEntityDao extends JpaRepository<SpecialisationCourseEntity, Integer> {
    public List<SpecialisationCourseEntity> findAllByCourseEntityCourseId(int courseId);   
}
