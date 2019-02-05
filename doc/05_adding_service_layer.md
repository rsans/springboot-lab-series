# Creating a Service layer

Service Components are the class file which contains @Service annotation. These class files are used to write business logic in a different layer, separated from @RestController class file

## Create the service interface

We are going to create the interface for the service component in the package com.hotelbeds.springbootlab.service and we will give it the name of CustomerService

```
package com.hotelbeds.springbootlab.service;

public interface CustomerService {

}
```

Add to this interface a public method that returns a String

```
package com.hotelbeds.springbootlab.service;

public interface CustomerService {

    String message();

}
```

Now that we have the created interface we are going to create our first implementation and add the necessary springboot annotations to act as a Service spring component.

For this we will create an implementation class in the same package with the name CustomerServiceImpl. This class should be decorated with the @Service annotation and implement our interface :

```
package com.hotelbeds.springbootlab.service;

import org.springframework.stereotype.Service;


@Service
public class CustomerServiceImpl implements CustomerService {

    @Override
    public String message() {
        return "Response from my first REST Controller in springboot";
    }

}

```

That's all. We can already use our service from the controller. So we are going to modify the greeting() method of the controller to replace the String with a call to the method implemented in our service.


First we need to inject the service into the controller. Starting with Spring 2.5, the framework introduced a new style of Dependency Injection driven by @Autowired Annotations. This annotation allows Spring to resolve and inject collaborating beans into your bean.

You can read more about dependency injection in [docs.spring.io](https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-spring-beans-and-dependency-injection.html)

In the newest Spring release, it’s constructor does not need to be annotated with @Autowired annotation. With Lombok, it’s possible to generate a constructor for either all class’s fields (with @AllArgsConstructor) or all final class’s fields (with @RequiredArgsConstructor).

```
package com.hotelbeds.springbootlab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.RequiredArgsConstructor;

import com.hotelbeds.springbootlab.service.CustomerService;

@RestController
@RequestMapping("/customer")
@RequiredArgsConstructor
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping
    public String greeting() {
        return customerService.message();
    }

}

```

You can read more about lombok @RequiredArgsConstructor [here](https://projectlombok.org/features/constructor)


Now that we have implemented the service layer and use it from the controller, we will check that everything continues working correctly. For this you can follow the steps of the section "Checking the controller class" of the [previous lab](04_simple_spring_mvc_controller.md)


## References

[Spring Dependency Injection](https://docs.spring.io/spring-boot/docs/current/reference/html/using-boot-spring-beans-and-dependency-injection.html)

[Project Lombok](https://projectlombok.org)

[Lombok API](https://projectlombok.org/api/overview-summary.html)
