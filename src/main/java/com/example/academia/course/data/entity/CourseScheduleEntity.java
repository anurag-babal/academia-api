package com.example.academia.course.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Entity
@Table(name = "course_schedule")
@Data
public class CourseScheduleEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "time", length = 5, nullable = false)
    private String time;

    @NotNull
    @Column(name = "day", length = 10, nullable = false)
    private String day;

    @NotNull
    @Column(name = "room", nullable = false)
    private int room;

    @Column(name = "building", length = 30)
    private String building;

    @ManyToOne
    @JoinColumn(name = "course_id")
    private CourseEntity courseEntity;
}
