package com.example.academia.placement.data.entity;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
@Table(name = "alumni_organisation")
@Getter
public class AlumniOrganisationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "position", length = 30)
    private String position;

    @NotNull
    @Column(name = "joining_date", nullable = false)
    private LocalDate joiningDate;

    @Column(name = "leaving_date")
    private LocalDate leavingDate;
    
    @ManyToOne
    @JoinColumn(name = "organisation_id")
    private OrganisationEntity organisationEntity;

    @ManyToOne
    @JoinColumn(name = "alumni_id")
    private AlumniEntity alumniEntity;
}
