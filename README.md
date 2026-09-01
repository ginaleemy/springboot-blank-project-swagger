# Spring Boot Employee Management System - Swagger

Simple Spring Boot Employee Management System project with:

* Spring Boot
* Spring Security
* JWT Authentication
* Spring Data JPA
* MySQL / MariaDB
* Swagger / OpenAPI
* Role-Based Authorization

This project is a Swagger/OpenAPI version of my Employee Management System project.

---

## 1. Project Information

Project name:

```text
springboot-blank-project-swagger
```

Application context path:

```text
/ems-backend
```

Default server port:

```text
8080
```

Base URL:

```text
http://localhost:8080/ems-backend
```

---

## 2. Swagger Dependency

The project uses Springdoc OpenAPI:

```xml
<dependency>
    <groupId>org.springdoc</groupId>
    <artifactId>springdoc-openapi-starter-webmvc-ui</artifactId>
    <version>3.1.0</version>
</dependency>
```

---

## 3. Swagger URL

Start the Spring Boot application first.

Then open:

```text
http://localhost:8080/ems-backend/swagger-ui.html
```

Swagger UI allows me to:

* View REST APIs
* View request DTOs
* View response DTOs
* Test APIs
* Send JWT tokens
* View API error responses

OpenAPI JSON:

```text
http://localhost:8080/ems-backend/v3/api-docs
```

OpenAPI YAML:

```text
http://localhost:8080/ems-backend/v3/api-docs.yaml
```

---

## 4. Swagger Annotations Used

### Controller

Swagger annotations are mainly added to controllers.

```java
@Tag(
    name = "Employee Management",
    description = "Employee management APIs"
)
```

For individual APIs:

```java
@Operation(
    summary = "Get employee by ID",
    description = "Returns an employee using the employee ID"
)
```

API responses can be documented using:

```java
@ApiResponses({
    @ApiResponse(
        responseCode = "200",
        description = "Employee found"
    ),
    @ApiResponse(
        responseCode = "404",
        description = "Employee not found"
    )
})
```

---

## 5. DTO Swagger Documentation

Request and response DTOs use:

```java
@Schema
```

Example:

```java
@Schema(description = "Employee first name", example = "Daniel")
private String firstName;
```

Swagger annotations are useful on:

```text
EmployeeRequest
LoginRequest
RegisteRequest
EmployeeResponse
JwtAuthResponse
UserResponse
ErrorDetails
```

---

## 6. Classes That Do Not Need Swagger Annotations

Swagger is used for the API layer.

These classes normally do not need Swagger annotations:

```text
Entity
Mapper
Repository
Service
ServiceImpl
Security classes
Exception classes
```

Example:

```text
EmployeeController       -> Swagger annotations

EmployeeRequest          -> @Schema
EmployeeResponse         -> @Schema
ErrorDetails             -> @Schema

Employee                 -> No Swagger
EmployeeMapper           -> No Swagger
EmployeeRepository       -> No Swagger
AuthServiceImpl          -> No Swagger
CustomUserDetailsService -> No Swagger
```

---

## 7. JWT Authentication in Swagger

The project uses JWT Bearer authentication.

The OpenAPI security scheme is configured as:

```java
@SecurityScheme(
    name = "Bearer Authentication",
    type = SecuritySchemeType.HTTP,
    scheme = "bearer",
    bearerFormat = "JWT"
)
```

Secured controllers can use:

```java
@SecurityRequirement(name = "Bearer Authentication")
```

### How to test secured APIs

First call:

```text
POST /api/auth/login
```

Login example:

```json
{
  "usernameOrEmail": "admin@example.com",
  "password": "Password123!"
}
```

The response contains:

```json
{
  "accessToken": "JWT_TOKEN_HERE",
  "tokenType": "Bearer"
}
```

Copy only the JWT token.

Click:

```text
Authorize
```

in Swagger UI.

Enter the token.

Swagger will send:

```text
Authorization: Bearer JWT_TOKEN
```

with secured API requests.

---

## 8. Spring Security Swagger Access

Swagger endpoints must be allowed without authentication.

In `SpringSecurityConfig`:

```java
.requestMatchers(
    "/swagger-ui/**",
    "/swagger-ui.html",
    "/v3/api-docs/**"
).permitAll()
```

The `/ems-backend` context path does not need to be added inside these request matchers.

For example, the browser URL is:

```text
http://localhost:8080/ems-backend/swagger-ui.html
```

but the Spring Security matcher remains:

```text
/swagger-ui/**
```

---

## 9. Main Authentication APIs

Register:

```text
POST /ems-backend/api/auth/register
```

Login:

```text
POST /ems-backend/api/auth/login
```

Example complete login URL:

```text
http://localhost:8080/ems-backend/api/auth/login
```

---

## 10. Employee APIs

Base employee endpoint:

```text
/ems-backend/api/employees
```

Example:

```text
GET    /ems-backend/api/employees
GET    /ems-backend/api/employees/{id}
POST   /ems-backend/api/employees
PUT    /ems-backend/api/employees/{id}
DELETE /ems-backend/api/employees/{id}
```

Employee APIs are protected using Spring Security roles such as:

```java
@PreAuthorize("hasRole('ADMIN')")
```

Database role names should use:

```text
ROLE_USER
ROLE_MANAGER
ROLE_ADMIN
```

Example:

```java
hasRole("ADMIN")
```

checks for:

```text
ROLE_ADMIN
```

---

## 11. Project Flow

```text
Swagger UI / Client
        |
        v
Controller
        |
        v
Service
        |
        v
ServiceImpl
        |
        +--------> Mapper
        |
        v
Repository
        |
        v
MySQL / MariaDB
```

Authentication flow:

```text
Login Request
     |
     v
AuthController
     |
     v
AuthServiceImpl
     |
     v
AuthenticationManager
     |
     v
CustomUserDetailsService
     |
     v
UserRepository
     |
     v
Database
     |
     v
JWT Token Generated
```

---

## 12. Important Notes

### User and Role Relationship

A user can have multiple roles.

Example:

```json
{
  "roles": [
    "ROLE_USER",
    "ROLE_MANAGER"
  ]
}
```

The relationship is stored using:

```text
users
roles
users_roles
```

### Passwords

Passwords must be stored using BCrypt.

```java
passwordEncoder.encode(password)
```

Never return the user's password in an API response.

Never log the actual password.

---

## 13. Error Handling

The project uses:

```text
GlobalExceptionHandler
```

and:

```text
ErrorDetails
```

for standard error responses.

Examples:

```text
400 BAD_REQUEST
401 UNAUTHORIZED
404 NOT_FOUND
```

`ResourceNotFoundException` is used for missing resources.

Example:

```java
throw new ResourceNotFoundException(
    "Employee not found with id: " + id
);
```

---

## 14. Run the Project

Run from Eclipse:

```text
Run As
→ Spring Boot App
```

or Maven:

```bash
mvn spring-boot:run
```

After startup, open Swagger:

```text
http://localhost:8080/ems-backend/swagger-ui.html
```

---

## 15. GitHub

Repository:

```text
https://github.com/ginaleemy/springboot-blank-project-swagger
```

Basic Git commands:

```bash
git status
git add .
git commit -m "Describe my changes"
git push
```

---

## Quick Reminder

When I come back to this project later:

```text
1. Start MySQL / MariaDB
2. Start Spring Boot application
3. Open:
   http://localhost:8080/ems-backend/swagger-ui.html
4. Login using /api/auth/login
5. Copy JWT accessToken
6. Click Swagger Authorize
7. Test secured APIs
```
