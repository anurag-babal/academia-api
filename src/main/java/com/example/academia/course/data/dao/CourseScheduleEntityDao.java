package com.example.academia.course.data.dao;

import com.example.academia.course.data.entity.CourseScheduleEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseScheduleEntityDao extends JpaRepository<CourseScheduleEntity, Integer> {
    List<CourseScheduleEntity> findAllByCourseEntityCourseId(int courseId);
}
