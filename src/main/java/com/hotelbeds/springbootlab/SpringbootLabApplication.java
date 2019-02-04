package com.hotelbeds.springbootlab;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.hotelbeds.springbootlab.model.Address;
import com.hotelbeds.springbootlab.model.Customer;
import com.hotelbeds.springbootlab.repository.CustomerRepository;

import lombok.extern.slf4j.Slf4j;

@SpringBootApplication
@Slf4j
public class SpringbootLabApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootLabApplication.class, args);
    }


    /**
     * Loads the database on startup
     */
    @Bean
    CommandLineRunner loadDatabase(CustomerRepository repository) {
        return args -> {
            log.debug("loading database...");
            Address address = new Address();
            address.setStreetName("customer street");
            address.setNumber("31");
            address.setDoor("1");
            address.setFloor("6");
            address.setCountry("Spain");
            address.setZipCode("07006");

            Customer customer = new Customer();
            customer.setFirstName("customer1");
            customer.setLastName("customer1ln");
            customer.setNif("11111111T");
            customer.setEmail("customer@customer.com");
            customer.setAddress(address);

            repository.save(customer);

            log.debug("database loaded");
        };

    }
}

