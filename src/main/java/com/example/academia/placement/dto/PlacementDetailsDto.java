package com.example.academia.placement.dto;

import com.example.academia.course.domain.model.Domain;
import com.example.academia.placement.domain.model.Organisation;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PlacementDetailsDto {
    List<Organisation> organisations;
    List<String> years;
    List<Domain> domains;
}
