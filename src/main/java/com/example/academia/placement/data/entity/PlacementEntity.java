package com.example.academia.placement.data.entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

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
