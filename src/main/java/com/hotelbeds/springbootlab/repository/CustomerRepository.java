package com.hotelbeds.springbootlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelbeds.springbootlab.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {



}
