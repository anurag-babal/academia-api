package com.example.academia.course.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "specialisation")
@Data
public class SpecialisationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "specialisation_id")
    private int id;

    @NotNull
    @Column(name = "code", length = 2, nullable = false, unique = true)
    private String code;

    @NotNull
    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Column(name = "description", length = 100)
    private String description;

    @NotNull
    @Column(name = "year", length = 4, nullable = false)
    private String year;

    @NotNull
    @Column(name = "credits_required", nullable = false)
    private int creditsRequired;

    @OneToMany(mappedBy = "specialisationEntity")
    private List<SpecialisationCourseEntity> specialisationCourseEntities;
}
