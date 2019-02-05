# Creating a simple REST controller with Spring MVC

The @RestController annotation was introduced in Spring 4.0 to simplify the creation of RESTful web services. It’s a convenience annotation that combines @Controller and @ResponseBody – which eliminates the need to annotate every request handling method of the controller class with the @ResponseBody annotation.


Every request handling method of the controller class automatically serializes return objects into HttpResponse.

## Create the controller class

We are going to create the class for the controller in the package com.hotelbeds.springbootlab.controller and we will give it the name of CustomerController

```
package com.hotelbeds.springbootlab.controller;

public class CustomerController {

}
```

Now that we have the created class we are going to add the necessary springboot annotations to act as REST Controller

For this we will add the annotation @RestController and @RequestMapping ("/ customer") leaving the class as follows:

```
package com.hotelbeds.springbootlab.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

}
```

We already have a REST controller but we need to implement methods to meet the different REST requests that may be received.

For this we will start with a simple method that will respond to all GET requests from the endpoint /customer by returning a message.
In following labs we will evolve this controller expanding the functionality.

We are going to implement a public method that returns a String and we will annotate it with @GetMapping

```
package com.hotelbeds.springbootlab.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/customer")
public class CustomerController {

     @GetMapping
     public String greeting() {
         return "Response from my first REST Controller in springboot";
     }

}

```

## Checking the controller class

Now that we have our first controller created, let's check that it works correctly. To do this we will start the application and make a request to http://localhost:8080/customer

To start the application we will use the maven plugin spring-boot-maven-plugin

```
mvn spring-boot:run
```

After executing the maven command, check the output of the execution. The following line should appear at the end:

```
main] c.h.s.SpringbootLabApplication           : Started SpringbootLabApplication in 6.839 seconds (JVM running for 8.326)
```

The application is running and ready to receive requests. We are going to make a GET request through curl to the created endpoint.

```
curl -X GET http://localhost:8080/customer
```

And we should get in response the message that we have implemented in the method annotated with @GetMapping


## References

[RestController and RequestMapping annotations](https://docs.spring.io/spring-boot/docs/current/reference/html/getting-started-first-application.html#getting-started-first-application-annotations)

[GetMapping annotation](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-developing-web-applications.html#boot-features-spring-mvc-pathmatch)

[Springboot Web Applications](https://docs.spring.io/spring-boot/docs/current/reference/html/boot-features-developing-web-applications.html#boot-features-developing-web-applications)


# Next lab

[Creating a Service layer](05_adding_service_layer.md)
