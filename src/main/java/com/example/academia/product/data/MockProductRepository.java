package com.example.academia.product.data;

import com.example.academia.product.domain.model.Product;
import com.example.academia.product.domain.repository.ProductRepository;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.List;

@Component
public class MockProductRepository implements ProductRepository {
    List<Product> products = new ArrayList<>();

    /*
     * [{"prodName":"Men's running shoes","prodPrice":"₹250","imagePath":"images/shoes1.jpeg","productId":"1"},
     * {"prodName":"Men'strainers","prodPrice":"₹1250","imagePath":"images/shoes2.jpeg","productId":"2"},
     * {"prodName":"Trendy shoes","prodPrice":"₹3150","imagePath":"images/shoes3.jpeg","productId":"3"},
     * {"prodName":"Awesome shoes","prodPrice":"₹1050","imagePath":"images/shoes1.jpeg","productId":"4"},
     * {"prodName":"Some shoes","prodPrice":"₹2050","imagePath":"images/shoes2.jpeg","productId":"5"},
     * {"prodName":"Some other shoes","prodPrice":"₹2500","imagePath":"images/shoes3.jpeg","productId":"6"}]
     */

    public MockProductRepository() {
        products.add(new Product(1, 99.99, "Men's running shoes", "http://www.example.com", "description"));
        products.add(new Product(2, 99.99, "T-Shirt", "http://www.example.com", "description"));
        products.add(new Product(3, 99.99, "T-Shirt", "http://www.example.com", "description"));
    }

    @Override
    public List<Product> getAllProducts() {
        return products;
    }

    @Override
    public Product getProductById(int id) {
        for (Product product : products) {
            if (ObjectUtils.nullSafeEquals(product.getId(), id)) {
                return product;
            }
        }
        return null;
    }
}
