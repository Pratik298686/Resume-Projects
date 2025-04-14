Spring Boot User Authentication System

This is a simple Spring Boot application that provides User Registration, Login, and Authentication functionality using Spring Security, JPA, and Thymeleaf.

Features

- User Registration with full name, username, and password
- Password encryption using BCrypt
- User Login using Spring Security
- Session management with logout support
- MVC Architecture
- Thymeleaf templating engine
- MySQL (configurable) database integration

Technologies Used

- Java 17+
- Spring Boot
- Spring Security
- Spring Data JPA
- Thymeleaf
- Maven
- MySQL
- BCrypt Password Encoder

Project Structure

```bash
src
└── main
    └── java
        └── com.springprogramming.restapi.UserAuth
            ├── Configuration       # Spring Security configuration and custom user details service
            ├── Controller          # Handles user requests and routes
            ├── Entity              # JPA entity class for User
            ├── Repository          # Repository for database operations
            ├── Services            # Business logic and service layer
            └── dto                 # Data Transfer Object (DTO) for user input

Endpoints

| Method | URL           | Description              |
|--------|---------------|--------------------------|
| GET    | `/login`      | Login page               |
| POST   | `/login`      | Authenticate user        |
| GET    | `/register`   | Registration page        |
| POST   | `/register`   | Register new user        |
| GET    | `/home`       | Home page after login    |
| GET    | `/logout`     | Logs out the user        |

Database

- The default setup uses **H2 in-memory database**.
- To switch to MySQL or any other database, update the `application.properties`.

Setup Instructions

1. Clone the repository

git clone https://github.com/your-username/spring-user-auth.git
cd spring-user-auth

2. Build the project

mvn clean instal
```

3. Run the application

mvn spring-boot:run

4. Access in browser

- Registration: [http://localhost:8080/register]
- Login: [http://localhost:8080/login]

Notes

- Passwords are securely stored using BCrypt hashing.
- Default user role is `USER`.
- You can customize roles and permissions by updating `CustomUserDetailsService`.


