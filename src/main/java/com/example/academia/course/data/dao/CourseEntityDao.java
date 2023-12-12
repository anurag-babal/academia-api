package com.example.academia.course.data.dao;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.academia.course.data.entity.CourseEntity;

@Repository
public interface CourseEntityDao extends JpaRepository<CourseEntity, Integer>{
    Page<CourseEntity> findAllByEmployeeEntityEmployeeId(int employeeEntityEmployeeId, Pageable pageable);
}
