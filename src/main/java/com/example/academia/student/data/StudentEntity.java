package com.example.academia.student.data;

import java.math.BigDecimal;
import java.util.List;

import com.example.academia.course.data.entity.DomainEntity;
import com.example.academia.course.data.entity.StudentCourseEntity;
import com.example.academia.placement.data.entity.PlacementStudentEntity;

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
import lombok.Data;

@Entity
@Table(name = "student")
@Data
public class StudentEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "student_id")
    private int id;

    @NotNull
    @Column(name = "roll_number", length = 9, nullable = false, unique = true)
    private String rollNumber;

    @NotNull
    @Column(name = "first_name", length = 30, nullable = false)
    private String firstName;

    @Column(name = "last_name", length = 30)
    String lastName;

    @NotNull
    @Column(name = "email", length = 50, nullable = false, unique = true)
    private String email;

    @Column(name = "photograph_path", length = 50)    
    private String photographPath;

    @NotNull
    @Column(name = "cgpa", nullable = false, precision=3, scale=2)
    private BigDecimal cgpa = new BigDecimal(0.0);

    @NotNull
    @Column(name = "total_credits", nullable = false)
    private int totalCredits;

    @Column(name = "graduation_year", length = 4)
    private String graduationYear;
    
    @ManyToOne()
    @JoinColumn(name = "domain_id")
    private DomainEntity domainEntity;

    @OneToMany(mappedBy = "studentEntity")
    private List<StudentCourseEntity> studentCourseEntities;

    @OneToMany(mappedBy = "studentEntity")
    private List<PlacementStudentEntity> placementStudentEntities;
}
