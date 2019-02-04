package com.hotelbeds.springbootlab.service;

import java.util.List;

import com.hotelbeds.springbootlab.model.Customer;

public interface CustomerService {

    Customer getCustomer(String customerId);

    Customer saveCustomer(Customer customer);

    List<Customer> getCustomersList();
}
