package com.hotelmanagement.controller;

import com.hotelmanagement.model.Product;
import com.hotelmanagement.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

	/*
    @Autowired
    private ProductService productService;

    public ProductController() {
        // Constructor
    }

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("products", productService.getAllProducts());
        return "customer"; // Assuming there's a view named "listProducts" to display the list of products
    }
    */

}