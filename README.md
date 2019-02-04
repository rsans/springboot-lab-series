# springboot-lab

##

The objective of this repository is to introduce the springboot features.


The content will be expanded as different labs are made.

It is important to review the requirements and perform the initial configuration of the IDE to correctly generate the project that will be used as a basis for the labs.


## Requirements:

* GitHub Account
* JDK 8
* Maven 3.5.4
* Unix Terminal or GitBash
* cURL
* Git
* IntelliJ IDEA
* IntelliJ Lombok Plugin

If you like to live to the limit you can use any other IDE. Other IDEs will not be supported during the lab, so make sure you have it properly configured before you start.

* The IDE must be configured before the lab. To configure IntelliJ IDEA you can consult [this section](doc/01_ide-configuration.md)
* Generate base project following [this guide](doc/02_generate-project.md)
* Dockerize base project with JIB following [this guide](doc/03_dockerize_with_jib.md)


## Series of labs

* [Create a RESTful simple service](doc/04_simple_spring_mvc_controller.md): In this lab we are going to use the generated base project to create a very simple RESTful service to introduce some basic annotations of springboot. We will check that the application starts correctly and the implemented endpoint answers GET requests.
* [Create a service layer](doc/05_adding_service_layer.md): In this lab we are going to create a service component, that is used to write business logic in a different layer. We will implement a simple business logic method that returns a String message, replacing our custom message in the controller with a call to this service method.
* [Create a repository layer](doc/06_adding_repository_layer.md): In this lab we are going to create a repository component, that is used to encapsulate storage, retrieval, search and other operations against a database. We will use an in-memory database as H2 and generate a model of entities to persist the data.
* **Load databse on application startup**: In this lab we are going to add dummy data to database on application startup using a spring bean.
* (WIP)

## About Spring

Spring provides plenty of getting started guides at https://spring.io/guides/ . If there is some specific problem that you would like to explore, pick a guide of your choice and follow the instructions there. In this series of labs, there are several references to different parts of the reference documentation, however if you miss some information you can find it online at http://docs.spring.io/spring-boot/docs/1.5.x/reference/htmlsingle/


## Springboot Actuator Endpoints

[Reference](https://docs.spring.io/spring-boot/docs/current/reference/html/production-ready-endpoints.html)

http://localhost:8080/actuator
