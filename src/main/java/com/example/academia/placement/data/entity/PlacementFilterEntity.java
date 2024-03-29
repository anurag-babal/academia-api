package com.example.academia.placement.data.entity;

import com.example.academia.course.data.entity.DomainEntity;
import com.example.academia.course.data.entity.SpecialisationEntity;
import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Table(name = "placement_filter")
@Getter
public class PlacementFilterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "placement_id")
    private PlacementEntity placementEntity;

    @ManyToOne
    @JoinColumn(name = "specialisation_id")
    private SpecialisationEntity specialisationEntity;

    @ManyToOne
    @JoinColumn(name = "domain_id")
    private DomainEntity domainEntity;
}
