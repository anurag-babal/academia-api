package com.example.academia.placement.domain.model;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Organisation {
    private int id;
    private String name;
    private String address;
}
