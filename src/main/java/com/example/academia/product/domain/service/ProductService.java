package com.example.academia.product.domain.service;

import com.example.academia.product.domain.model.Product;

import java.util.List;

public interface ProductService {
    List<Product> getAllProducts();

    Product getProductById(int id);
}
