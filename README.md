# 🔐 Spring Boot Security + JWT Authentication Demo

- This project demonstrates a basic implementation of **user authentication** using **Spring Boot 3** and **JWT (JSON Web Tokens)**. It provides secure login and registration endpoints, and protects routes using stateless JWT-based security. Additionally, it includes multiple REST endpoints for serving static content, products, and image-uploaded goods.
---

## ✅ Features

- 🛡️ Secure login and JWT-based authentication
- 📝 User registration with hashed passwords (BCrypt)
- 🔐 Secure protected API endpoints
- 🧾 Stateless authentication using JWT tokens in headers
- 🧰 Simple product management with RESTful routes
- 🖼 Image upload and fetch
- 🔍 Search functionality
- 🗂 CSRF token support for secure frontend integration
- 🌍 CORS enabled

---

## 🧰 Tech Stack

- Java 21
- Spring Boot 3.4.3
- Spring Security
- JWT (via `jjwt`)
- Spring Data JPA
- PostgreSQL (dev/prod)
- Maven

---

## ▶️ Running the App

```bash
./mvnw spring-boot:run
```
---

## 📁 Project Structure

```txt
spring-security-jwt/
├── src/
│ ├── main/java/com/neonid0/springboottraining
│ │ ├── config/ # Security configuration
│ │ ├── controller/ # REST controllers
│ │ ├── model/ # User, Product, etc.
│ │ ├── repository/ # Spring Data repositories
│ │ ├── filter/ # JWT filters
│ │ └── service/ # Business logic and JWT management
│ └── resources/
│ └── application.properties
└── pom.xml
```

---

## 🔧 API Endpoints

### 🏠 `HomeController`

| Method | Endpoint       | Description                                  |
|--------|----------------|----------------------------------------------|
| GET    | `/`            | Greet the user and show session ID           |
| GET    | `/about`       | Static about text with session ID            |

---

### 📦 `ProductController` (Basic Product Management)

| Method | Endpoint               | Description                     |
|--------|------------------------|---------------------------------|
| GET    | `/products`            | Get all products                |
| GET    | `/products/{itemId}`   | Get product by ID               |
| POST   | `/products`            | Add a new product               |
| PUT    | `/products`            | Update an existing product      |
| DELETE | `/products/{itemId}`   | Delete product by ID            |

---

### 🏪 `StoreController` (Products with Image Support)

| Method | Endpoint                            | Description                                 |
|--------|-------------------------------------|---------------------------------------------|
| GET    | `/api/store`                        | Get list of all goods                       |
| GET    | `/api/store/{productId}`            | Get a single good by ID                     |
| GET    | `/api/store/{productId}/image`      | Fetch image of the good by ID               |
| GET    | `/api/store/search?keyword=shoes`   | Search goods by keyword                     |
| POST   | `/api/store`                        | Add a good with image (`multipart/form`)    |
| PUT    | `/api/store/{productId}`            | Update a good with image                    |
| DELETE | `/api/store/{productId}`            | Delete a good by ID                         |

---

### 🛡 `Security Support`

| Method | Endpoint               | Description                           |
|--------|------------------------|---------------------------------------|
| GET   | `/users`      | Get all users    |
| GET   | `/users/{id}`   | Get user by ID                 |
| POST   | `/login`      | Authenticate user and return JWT      |
| POST   | `/register`   | Register a new user                   |

---

## 🔧 Configuration

### `application.properties`

```properties
server:
  port: 8080

spring:
  datasource:
    url: jdbc:h2:mem:testdb
    driver-class-name: org.h2.Driver
    username: sa
    password:
  h2:
    console:
      enabled: true
  jpa:
    hibernate:
      ddl-auto: update
    show-sql: true
    database-platform: org.hibernate.dialect.H2Dialect
```
---

## 🧑‍💻 Author
Yunus Melih Bozcan [@neonid0](https://github.com/neonid0)

---

## 📄 License

This project is licensed under the [MIT License](./LICENSE).

