package com.example.academia.placement.domain.model;

import java.time.LocalDate;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class AlumniOrganisation {
    private int id;
    private int organisationId;
    private int alumniId;
    private String position;
    private LocalDate joiningDate;
    private LocalDate leavingDate;
}
