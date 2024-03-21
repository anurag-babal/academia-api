package com.example.academia.employee.domain;

import com.example.academia.employee.domain.model.Employee;

import java.util.List;

public interface EmployeeService {
    Employee getEmployeeById(int id);

    List<Employee> getAllEmployees();
}
