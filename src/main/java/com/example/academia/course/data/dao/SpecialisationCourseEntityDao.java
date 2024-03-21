package com.example.academia.course.data.dao;

import com.example.academia.course.data.entity.SpecialisationCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SpecialisationCourseEntityDao extends JpaRepository<SpecialisationCourseEntity, Integer> {
    List<SpecialisationCourseEntity> findAllByCourseEntityCourseId(int courseId);
}
