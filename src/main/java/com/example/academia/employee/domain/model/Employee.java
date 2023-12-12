package com.example.academia.employee.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Employee {
    private int employeeId;
    private String firstName;
    private String lastName;
    private String email;
    private String title;
    private String photographPath;
}
