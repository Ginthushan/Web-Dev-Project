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

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Customer getCustomerById(Long id) {
        return customerRepository.findById(id).orElse(null);
    }

    public void addCustomer(Customer customer) {
        customerRepository.save(customer);
    }

    public void updateCustomer(Customer customer) {
        // Perform validation or additional logic if needed
        customerRepository.save(customer);
    }

    public void deleteCustomer(Long id) {
        customerRepository.deleteById(id);
    }
}
