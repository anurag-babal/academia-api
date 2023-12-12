package com.example.academia.placement.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class WorkingAlumniDto {
  private String name;
  private String position;
  private String joiningDate;
  private String email;
}
