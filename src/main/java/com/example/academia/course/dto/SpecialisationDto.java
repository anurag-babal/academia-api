package com.example.academia.course.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class SpecialisationDto {
    private int id;
    private String code;
    private String name;
    private String description;
    private String year;
    private int creditsRequired;
}
