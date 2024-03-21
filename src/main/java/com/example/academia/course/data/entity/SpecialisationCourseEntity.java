package com.example.academia.course.data.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "specialisation_course")
@Data
public class SpecialisationCourseEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "specialisation_id")
    private SpecialisationEntity specialisationEntity;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntity courseEntity;
}
