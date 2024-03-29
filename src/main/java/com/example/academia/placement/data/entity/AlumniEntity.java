package com.example.academia.placement.data.entity;

import com.example.academia.student.data.StudentEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

@Entity
@Table(name = "alumni")
@Getter
public class AlumniEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull
    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    @NotNull
    @Column(name = "contact_number", length = 15, nullable = false, unique = true)
    private String contactNumber;

    @OneToOne
    @JoinColumn(name = "student_id")
    private StudentEntity studentEntity;
}
