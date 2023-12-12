package com.example.academia.placement.data.entity;

import java.time.LocalDate;

import com.example.academia.placement.domain.AcceptanceEnum;
import com.example.academia.student.data.StudentEntity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.Getter;

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
