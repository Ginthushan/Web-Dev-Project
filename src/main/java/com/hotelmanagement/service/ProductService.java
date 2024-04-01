package com.hotelmanagement.service;

import com.hotelmanagement.model.Product;
import com.hotelmanagement.repository.ProductRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public ProductService() {
        // Constructor
    }

    public void saveProduct(Product product) {
        productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
}
