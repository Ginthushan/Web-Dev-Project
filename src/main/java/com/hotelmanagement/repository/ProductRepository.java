package com.hotelmanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hotelmanagement.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
