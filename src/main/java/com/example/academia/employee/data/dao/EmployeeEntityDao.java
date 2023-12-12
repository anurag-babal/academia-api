package com.example.academia.employee.data.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.academia.employee.data.entity.EmployeeEntity;

@Repository
public interface EmployeeEntityDao extends JpaRepository<EmployeeEntity, Integer>{
    
}
