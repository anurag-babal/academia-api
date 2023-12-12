package com.example.academia.placement.dto;

import java.util.List;

import com.example.academia.placement.domain.model.Alumni;
import com.example.academia.placement.domain.model.Placement;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlacementAlumniDto {
    List<Placement> placements;
    List<Alumni> alumnis;
}
