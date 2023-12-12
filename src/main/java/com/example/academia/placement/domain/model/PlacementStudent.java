package com.example.academia.placement.domain.model;

import com.example.academia.placement.domain.AcceptanceEnum;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlacementStudent {
    private int id;
    private int studentId;
    private int placementId;
    private String cvApplication;
    private String about;
    private AcceptanceEnum acceptance;
    private String comments;
    private String date;
}
