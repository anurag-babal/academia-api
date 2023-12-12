package com.example.academia.placement.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Alumni {
    private int id;
    private int studentId;
    private String email;
    private String contactNumber;
}
