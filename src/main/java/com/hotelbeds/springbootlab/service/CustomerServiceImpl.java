package com.hotelbeds.springbootlab.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.hotelbeds.springbootlab.model.Customer;
import com.hotelbeds.springbootlab.repository.CustomerRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements CustomerService {

    private final CustomerRepository customerRepository;


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
