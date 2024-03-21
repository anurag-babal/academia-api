package com.example.academia.course.data.dao;

import com.example.academia.course.data.entity.CourseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseEntityDao extends JpaRepository<CourseEntity, Integer> {
    Page<CourseEntity> findAllByEmployeeEntityEmployeeId(int employeeEntityEmployeeId, Pageable pageable);
}
