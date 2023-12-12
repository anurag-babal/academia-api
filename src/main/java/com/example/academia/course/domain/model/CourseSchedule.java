package com.example.academia.course.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class CourseSchedule {
    private int id;
    private String time;
    private String day;
    private int room;
    private String building;
}
