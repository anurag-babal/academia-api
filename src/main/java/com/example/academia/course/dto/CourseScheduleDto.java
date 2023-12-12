package com.example.academia.course.dto;

import java.util.List;

import com.example.academia.course.domain.model.Course;
import com.example.academia.course.domain.model.CourseSchedule;
import com.example.academia.course.domain.model.Specialisation;
import com.example.academia.employee.domain.model.Employee;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseScheduleDto {
    Employee faculty;
    Course course;
    List<Specialisation> specialisations;
    List<CourseSchedule> schedules;
}
