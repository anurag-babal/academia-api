package com.example.academia.product.domain.repository;

import java.util.List;

import com.example.academia.product.domain.model.Product;

public interface ProductRepository {
    public List<Product> getAllProducts();
    public Product getProductById(int id);
}
