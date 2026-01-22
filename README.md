# Enterprise User Management API

Spring Boot REST API for user management with CRUD, pagination, filtering, validation, and OpenAPI/Swagger UI. Includes global exception handling and production-ready actuator endpoints.

## Tech Stack
- Java 17, Spring Boot 3
- Spring Web, Spring Data JPA
- H2 (default) + PostgreSQL (profile)
- Validation, OpenAPI/Swagger UI, Actuator

## Run locally
```bash
mvn spring-boot:run
```

Swagger UI: `http://localhost:8080/swagger-ui.html`

## Run with PostgreSQL (Docker)
```bash
docker compose up -d
SPRING_PROFILES_ACTIVE=postgres mvn spring-boot:run
```

## Key Endpoints
- `GET /api/v1/users` (pagination + optional filters)
- `POST /api/v1/users`
- `GET /api/v1/users/<built-in function id>`
- `PUT /api/v1/users/<built-in function id>`
- `PATCH /api/v1/users/<built-in function id>`
- `DELETE /api/v1/users/<built-in function id>`
