package com.example.academia.placement.dto;

import com.example.academia.placement.domain.model.Organisation;
import com.example.academia.placement.domain.model.Placement;
import com.example.academia.placement.domain.model.PlacementStudent;
import com.example.academia.student.domain.Student;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class PlacementStudentDto {
    Student student;
    Placement placement;
    Organisation organisation;
    PlacementStudent details;
}
