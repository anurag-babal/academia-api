package com.example.academia.course.data.entity;

import java.util.List;

import com.example.academia.employee.data.entity.EmployeeEntity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "course")
@Data
public class CourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int courseId;

    @NotNull
    @Column(name = "course_code", length = 5, nullable = false, unique = true)
    private String courseCode;

    @NotNull
    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Column(name = "description", length = 100)
    private String description;

    @NotNull
    @Column(name = "year", length = 4, nullable = false)
    private String year;

    @NotNull
    @Column(name = "term", nullable = false)
    private int term;

    @NotNull
    @Column(name = "credits", nullable = false)
    private int credits;

    @NotNull
    @Column(name = "capacity", nullable = false)
    private int capacity;

    @ManyToOne(optional = false, cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "faculty_id", referencedColumnName = "employee_id")
    private EmployeeEntity employeeEntity;

    @OneToMany(mappedBy = "courseEntity")
    private List<StudentCourseEntity> studentCoursesEntities;

    @OneToMany(mappedBy = "courseEntity")
    private List<SpecialisationCourseEntity> specialisationCourseEntities;
}
