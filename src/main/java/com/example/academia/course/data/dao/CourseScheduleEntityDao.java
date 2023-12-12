package com.example.academia.course.data.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.academia.course.data.entity.CourseScheduleEntity;

@Repository
public interface CourseScheduleEntityDao extends JpaRepository<CourseScheduleEntity, Integer> {
    List<CourseScheduleEntity> findAllByCourseEntityCourseId(int courseId);
}
