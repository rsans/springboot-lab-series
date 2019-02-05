# Creating a repository layer
 
A repository is a mechanism for encapsulating storage, retrieval, and search behavior which emulates a collection of objects.

We are going to use Spring Data JPA to store and retrieve data in a relational in-memory database such as H2.

@Repository is a Spring annotation that indicates that the decorated class is a repository. It is a specialization of the @Component annotation allowing for implementation classes to be autodetected through classpath scanning. By default, Spring Boot will enable JPA repository support and look in the package (and its subpackages) where @SpringBootApplication is located.


## Define a simple entity model

In this example, you store Customer objects, annotated as a JPA entity.


It is not the goal of this lab to go into detail in the use of JPA. At the end of this document in the references section you can get more information.

In subsequent labs, practices will be carried out to better understand the use of JPA. For now we are going to create the entity as the following example:

We are going to create the entity model in the package com.hotelbeds.springbootlab.model and we will give it the name of Customer

```
package com.hotelbeds.springbootlab.model;

import java.io.Serializable;
import java.time.LocalDate;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "customer")
@Data
@NoArgsConstructor
public class Customer implements Serializable {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid2")
    private String id;
    private String firstName;
    private String lastName;
    private String nif;
    private String email;
    private String phone;

}
```

Do not worry now if you do not know some annotations used.


## Create the repository interface

As a first step you define a domain class-specific repository interface. The interface must extend Repository and be typed to the domain class and an ID type

We are going to create the interface for the repository component in the package com.hotelbeds.springbootlab.repository and we will give it the name of CustomerRepository

```
package com.hotelbeds.springbootlab.repository;


public interface CustomerRepository {

}

```

Instead of extend Repository, we will extend technology-specific abstractions, such as JpaRepository. This interface extend CrudRepository and expose the capabilities of the underlying persistence technology in addition to the rather generic persistence technology-agnostic interfaces such as CrudRepository.
On top of the CrudRepository, there is a PagingAndSortingRepository abstraction that adds additional methods to ease paginated access to entities.

```
package com.hotelbeds.springbootlab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hotelbeds.springbootlab.model.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

}

```

That's all. When extending the JpaRepository interface, we have at our disposal the necessary methods to persist the entity.
            

## Update the service layer to use the new repository

Let's now modify the service layer, to make use of the repository to save a client and recover it.


```
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

}


```

## Update the controller layer to add new endpoints to work with customer model

Now we just need to modify the controller layer and add an endpoint for each operation. Create client and retrieve client.

```
package com.hotelbeds.springbootlab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.hotelbeds.springbootlab.model.Customer;
import com.hotelbeds.springbootlab.service.CustomerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;


    @GetMapping(value = "/{customerId}")
    public Customer getCustomer(@PathVariable("customerId") String customerId) {
        return customerService.getCustomer(customerId);
    }

    @PostMapping
    public String createCustomer(@RequestBody Customer customer) {
        Customer persistedCustomer = customerService.saveCustomer(customer);
        return persistedCustomer.getId();
    }

}
```

New annotations used here are:

* @PostMapping has the same behaviour that GetMapping, but works catching POST Requests

* @PathVariable is used to extract values from the request URI.


## Check your application

Now is time to check our new endpoints. Compile and start your application.


First you need to save a Customer before try to retrieve it.

```
curl -X POST -H "Content-Type:application/json" http://localhost:8080/customer -d '{ 	"firstName": "optimus", 	"lastName": "prime", 	"nif": "00000000T", 	"email": "optimus-primer@bot.com", 	"phone": "010020030" }'
```

This request should return an UUID, that is the customer id. Use it to retrieve customer data:

```
curl -X GET http://localhost:8080/customer/872aca3a-af47-48ae-83c4-c903343c182f
```



## References

[Spring Data](https://spring.io/projects/spring-data-jpa)

[Spring Data Reference](https://docs.spring.io/spring-data/data-commons/docs/1.5.x/reference/html/)

[Accesing Data With JPA](https://spring.io/guides/gs/accessing-data-jpa/)

[JPA](https://en.wikipedia.org/wiki/Java_Persistence_API)
