package com.example.academia.course.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseDto {
    private int courseId;
    private String courseCode;
    private String name;
    private String description;
    private String year;
    private int term;
    private int credits;
    private int capacity;
}
