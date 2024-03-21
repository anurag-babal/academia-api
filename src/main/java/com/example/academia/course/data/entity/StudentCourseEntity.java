package com.example.academia.course.data.entity;

import com.example.academia.student.data.StudentEntity;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "student_course")
@Data
public class StudentCourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity studentEntity;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntity courseEntity;

    // @ManyToOne
    // @JoinColumn(name = "grade_id")
    // private int gradeId;

    @Column(name = "comments", length = 30)
    private String comments;
}
