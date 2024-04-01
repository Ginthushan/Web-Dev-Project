package com.hotelmanagement.controller;

import com.hotelmanagement.model.Customer;
import com.hotelmanagement.service.CustomerService;
import com.hotelmanagement.service.ProductService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	public CustomerController() {
		
	}

    @GetMapping("/customers")
    public String viewHomePage(Model model) {
        model.addAttribute("Customers", customerService.getAllCustomers());
        return "customers";
    }
    
    @GetMapping("/add")
    public String getAllCustomers(Model model) {
        List<Customer> customers = customerService.getAllCustomers();
        model.addAttribute("customers", customers);
        return "customer"; // Assuming the view name is "customer.html"
    }
}
