package com.example.academia.student.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class StudentAdmissionCreateRequestDto {
    @NotBlank
    private String fname;
    private String lname;

    @Email
    private String email;

    private String photoPath;
    private int graduationYear;

    @NotNull
    private int domainId;
}
