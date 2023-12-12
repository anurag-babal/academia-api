package com.example.academia.placement.dto;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlacementStudentHistoryDto {
  private String rollNo;
  private String studentName;
  private String organisationName;
  private String year;
  private String domainName;
  private String status;
  private String email;
}
