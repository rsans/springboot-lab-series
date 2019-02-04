package com.hotelbeds.springbootlab.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hotelbeds.springbootlab.model.Customer;
import com.hotelbeds.springbootlab.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerRepository customerRepository;


    @Override
    public Customer getCustomer(String customerId) {
        return customerRepository.findOne(customerId);
    }

    @Override
    public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getCustomersList() {
        return customerRepository.findAll();
    }

}
