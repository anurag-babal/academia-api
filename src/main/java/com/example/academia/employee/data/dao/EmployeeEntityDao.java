package com.example.academia.employee.data.dao;

import com.example.academia.employee.data.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeEntityDao extends JpaRepository<EmployeeEntity, Integer> {

}
