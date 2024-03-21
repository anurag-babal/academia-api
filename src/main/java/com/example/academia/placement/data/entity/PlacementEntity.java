package com.example.academia.placement.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "placement")
@Getter
public class PlacementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "profile", length = 30, nullable = false)
    private String profile;

    @Column(name = "description", length = 50)
    private String description;

    @NotNull
    @Column(name = "intake", nullable = false)
    private int intake;

    @Column(name = "minimum_grade")
    private BigDecimal minimumGrade;

    @ManyToOne
    @JoinColumn(name = "organisation_id", nullable = false)
    private OrganisationEntity organisationEntity;

    @OneToMany(mappedBy = "placementEntity")
    private List<PlacementStudentEntity> placementStudentEntities;
}
