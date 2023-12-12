package com.example.academia.product.domain.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private int id;
    private double price;
    private String title;
    private String image;
    private String description;
}
