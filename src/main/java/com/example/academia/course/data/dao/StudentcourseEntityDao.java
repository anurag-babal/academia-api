package com.example.academia.course.data.dao;

import com.example.academia.course.data.entity.StudentCourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentcourseEntityDao extends JpaRepository<StudentCourseEntity, Integer> {

}
