package com.hotelbeds.springbootlab.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbeds.springbootlab.model.Customer;
import com.hotelbeds.springbootlab.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RequestMapping("/customer")
@RestController
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping(value = "/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") String customerId) {
        return customerService.getCustomer(customerId);
    }

    @GetMapping
    public List<Customer> getAllCustomers() {
        return customerService.getCustomersList();
    }

    @PostMapping
    public String createCustomer(@RequestBody Customer customer) {
        Customer persistedCustomer = customerService.saveCustomer(customer);
        return persistedCustomer.getId();
    }

}
