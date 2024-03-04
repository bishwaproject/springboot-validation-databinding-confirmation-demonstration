# Springboot data validation, data binding and confirmation demonstration

This project demonstrates Spring boot's data validation, data binding and confirmation exposing user registration API built with Spring Boot, showcasing Spring Boot validation, data binding, email confirmation, and audit logging.

## Table of Contents

1. [Introduction](#introduction)
2. [Capabilities](#capabilities)
3. [Prerequisites](#prerequisites)
4. [Installation](#installation)
5. [Usage](#usage)
6. [Testing](#testing)
7. [Dependencies](#dependencies)
8. [Contributing](#contributing)

   

## Introduction

This project provides a simple RESTful API for user registration. It utilizes Spring Boot's powerful features for validation, data binding, and additional functionality such as sending confirmation emails to registered users and logging user registration events for auditing purposes.

## Capabilities

### Spring Validation

The `@Valid` and `BindingResult` annotations are used to validate the `User` object submitted in the request body. This leverages the powerful validation framework in Spring that makes it easy to enforce constraints and business rules on endpoint input.

### Spring Data Binding

The `BindingResult` is also used to check for any data binding issues between the JSON request body and the `User` object. Spring's data binding provides seamless mapping between JSON and domain models.

### Spring Logging

`org.slf4j.Logger` is used to log events like user registrations. This allows tracing the workflow and having an audit trail.

### Spring Dependency Injection

The `UserService` bean is injected via constructor injection to keep the controller lightweight. This is Spring's recommended approach for wiring dependencies.

### Email Confirmation

Upon successful user registration, a confirmation email is sent to the user's email address using `JavaMail`. This feature ensures that users receive a confirmation of their registration, enhancing the user experience and providing a mechanism for verifying the provided email address.

### Testing

Unit tests for the `UserController` class are implemented in the `UserControllerTest.java` file. These tests validate the behavior of the user registration endpoint under different scenarios, including successful registration, validation errors, and unexpected errors. The tests use Mockito for mocking dependencies and Spring's `MockMvc` framework for simulating HTTP requests and verifying the controller's response.

## Prerequisites

Before running this project, ensure you have the following installed:

- Java 17 or higher
- Maven
- Git (optional, for cloning the project repository)

## Installation

To install and run this project locally, follow these steps:

1. Clone the project repository:

    ```bash
    git clone https://github.com/bishwaproject/springboot-validation-databinding-confirmation-demonstration.git
    ```

2. Navigate to the project directory:

    ```bash
    cd springboot-validation-databinding-confirmation-demonstration
    ```
3. **Gmail Configuration (Important!)**

Before running the application, ensure that you update the Gmail configuration properties in the `application.properties` file with your own Gmail account details. This is necessary for sending confirmation emails to users upon successful registration.

```properties
# Gmail Configuration
spring.mail.host=smtp.gmail.com
spring.mail.port=587
spring.mail.username=youremail@gmail.com #update here
spring.mail.password=yourgmailapppassword #update user app password not regular email password
spring.mail.properties.mail.smtp.auth=true
spring.mail.properties.mail.smtp.starttls.enable=true
```

Please note the following:

- Replace `youremail@gmail.com` with your Gmail email address.
- Generate an from your Google account settings and replace `yourgmailapppassword` with this password. This is required (Please follow google steps to create your `gmail-app password`.

After updating `application.properties` file continue steps:

4. Build the project using Maven:

    ```bash
    mvn clean install
    ```

## Usage

To run the application, use the following command:

```bash
mvn spring-boot:run
```

The application will start on port 8080., you can access the API endpoints using a tool like Postman or curl.
curl example:
```bash
curl -X POST -H "Content-Type: application/json" -d '{"firstName":"John","lastName":"Doe","email":"john.doe@example.com"}' http://localhost:8080/api/users/register
```

## Testing

To run the unit tests for this project, use the following command:

```bash
mvn test
```
## Dependencies
**H2 Database:** Provides a fast in-memory database that supports JDBC API and R2DBC access, with a small (2mb) footprint. Supports embedded and server modes as well as a browser based console application.

**Java Mail Sender**: Send email using Java Mail and Spring Framework's JavaMailSender.

**Spring Boot DevTools**: Provides fast application restarts, LiveReload, and configurations for enhanced development experience.

**Spring Data JPA**: Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.

**Spring Web**: Build web, including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.

**Validation** Bean Validation with Hibernate validator.

## Contributing


Contributions and feedback are welcome!




