package com.example.academia.placement.data.entity;

import com.example.academia.placement.domain.AcceptanceEnum;
import com.example.academia.student.data.StudentEntity;
import jakarta.persistence.*;
import lombok.Getter;

import java.time.LocalDate;

@Entity
@Table(name = "placement_student")
@Getter
public class PlacementStudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "cv_application", length = 50)
    private String cvApplication;

    @Column(name = "about", length = 100)
    private String about;

    @Enumerated(EnumType.STRING)
    @Column(name = "acceptance")
    private AcceptanceEnum acceptance = AcceptanceEnum.PENDING;

    @Column(name = "comments", length = 100)
    private String comments;

    @Column(name = "date")
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "placement_id")
    private PlacementEntity placementEntity;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private StudentEntity studentEntity;
}
