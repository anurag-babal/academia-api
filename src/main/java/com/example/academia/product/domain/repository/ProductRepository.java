package com.example.academia.product.domain.repository;

import com.example.academia.product.domain.model.Product;

import java.util.List;

public interface ProductRepository {
    List<Product> getAllProducts();

    Product getProductById(int id);
}
