package com.hotelmanagement.controller;

import com.hotelmanagement.model.Customer;
import com.hotelmanagement.service.CustomerService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class CustomerController {

	@Autowired
	private CustomerService customerService;
	
	public CustomerController() {
		
	}

    @GetMapping("/customers")
    public String getAllCustomers(Model model) {
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customers";
    }
    
    @PostMapping("/customers/add")
    public String addCustomer(@RequestParam("name") String name,
                              @RequestParam("email") String email,
                              @RequestParam("phone") String phoneNumber) {
        Customer customer = new Customer();
        customer.setName(name);
        customer.setEmail(email);
        customer.setPhoneNumber(phoneNumber);

        // Save the new customer to the database
        customerService.addCustomer(customer);

        // Redirect to a page after adding the customer (e.g., customer list page)
        return "redirect:/customers";
    }
}
