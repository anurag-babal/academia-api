package com.example.academia.placement.dto;

import java.util.List;

import com.example.academia.course.domain.model.Domain;
import com.example.academia.placement.domain.model.Organisation;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlacementDetailsDto {
  List<Organisation> organisations;
  List<String> years;
  List<Domain> domains;
}
