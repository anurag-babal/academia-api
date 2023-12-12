package com.example.academia.course.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Domain {
  private int id;
  private String program;
  private String batch;
  private int capacity;
  private String qualification;
}
