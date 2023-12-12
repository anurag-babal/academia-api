package com.example.academia.product.dto;

import lombok.Data;

@Data
public class ProductResponseDto {
    private int id;
    private float price;
    private String title;
    private String image;
    private String description;
}
