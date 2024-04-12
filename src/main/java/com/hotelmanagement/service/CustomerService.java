// Provides services related to customer operations such as retrieving, adding, updating, and deleting customers.
package com.hotelmanagement.service;

import com.hotelmanagement.model.Customer;
import com.hotelmanagement.repository.CustomerRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CustomerService {

    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

 // Retrieves all customers from the database.
    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

 // Retrieves a customer by their ID.
    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

 // Adds a new customer to the database.
    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

 // Updates an existing customer in the database.
    public void updateCustomer(Customer customer) {
        // Perform validation or additional logic if needed
        customerRepository.save(customer);
    }

 // Deletes a customer by their ID.
    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
