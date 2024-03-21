package com.example.academia.placement.data.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
@Table(name = "organisation")
@Getter
public class OrganisationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "name", length = 30, nullable = false)
    private String name;

    @Column(name = "address", length = 200)
    private String address;
}
