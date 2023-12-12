package com.example.academia.course.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Specialisation {
    private int id;
    private String code;
    private String name;
    private String description;
    private String year;
    private int creditsRequired;
}
