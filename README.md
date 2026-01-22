# Enterprise User Management System

Spring Boot REST API for managing users in an enterprise system.

## Features
- Create, update, delete users
- Pagination & filtering
- DTO validation
- Global exception handling
- Swagger API documentation
- JPA + Hibernate integration
- Docker support

## Tech Stack
- Java 17
- Spring Boot
- Spring Data JPA
- Hibernate
- PostgreSQL / MySQL
- Maven
- Docker

## API Examples
POST /api/users  
GET /api/users  
PUT /api/users/{id}  
DELETE /api/users/{id}

## Run Locally
```bash
mvn clean install
mvn spring-boot:run
