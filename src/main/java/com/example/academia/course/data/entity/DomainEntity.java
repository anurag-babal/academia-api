package com.example.academia.course.data.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
@Table(name = "domain")
@Getter
public class DomainEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "domain_id")
    private int id;

    @NotNull
    @Column(name = "program", length = 10, nullable = false)
    private String program;

    @NotNull
    @Column(name = "batch", length = 4, nullable = false)
    private String batch;

    @NotNull
    @Column(name = "capacity", nullable = false)
    private int capacity;

    @Column(name = "qualification", length = 30)
    private String qualification;
}
