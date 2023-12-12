package com.example.academia.employee.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.academia.employee.domain.EmployeeRepository;
import com.example.academia.employee.domain.EmployeeService;
import com.example.academia.employee.domain.model.Employee;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeRepository employeeRepository;

    @Override
    public Employee getEmployeeById(int id) {
        return employeeRepository.getEmployeeById(id);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeRepository.getAllEmployees();
    }
}
