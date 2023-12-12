package com.example.academia.product.domain.service;

import java.util.List;

import com.example.academia.product.domain.model.Product;

public interface ProductService {
    public List<Product> getAllProducts();
    public Product getProductById(int id);
}
