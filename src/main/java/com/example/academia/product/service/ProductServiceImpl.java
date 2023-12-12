package com.example.academia.product.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.academia.product.domain.model.Product;
import com.example.academia.product.domain.repository.ProductRepository;
import com.example.academia.product.domain.service.ProductService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    @Override
    public List<Product> getAllProducts() {
        return productRepository.getAllProducts();
    }

    @Override
    public Product getProductById(int id) {
        return productRepository.getProductById(id);
    }
}
