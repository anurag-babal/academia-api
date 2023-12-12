package com.example.academia.employee.domain;

import java.util.List;

import com.example.academia.employee.domain.model.Employee;

public interface EmployeeService {
    public Employee getEmployeeById(int id);
    public List<Employee> getAllEmployees();
}
