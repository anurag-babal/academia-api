package com.example.academia.employee.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.academia.core.ResponseDto;
import com.example.academia.employee.domain.EmployeeService;
import com.example.academia.employee.domain.model.Employee;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping("/v1/employees/{id}")
    public ResponseDto getFacultyById(@PathVariable(name = "id") int id) {
        Employee employee = employeeService.getEmployeeById(id);
        return ResponseDto.builder()
                .status(200)
                .count(1)
                .data(employee)
                .message("OK")
                .build();
    }
}
