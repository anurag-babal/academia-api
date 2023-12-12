package com.example.academia.placement.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Placement {
    private int id;
    private String profile;
    private String description;
    private int intake;
    private double minimumGrade;
}
