package com.example.academia.student.domain;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Student {
    private int id;
    private String rollNumber;
    private String firstName;
    private String lastName;
    private String email;
    private String photographPath;
    private double cgpa;
    private int totalCredits;
    private String graduationYear;
    private int domainId;
}
