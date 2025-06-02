# 🧑‍💼 Job Microservices Backend

A scalable backend system for managing job postings, company data, and company reviews. Built with a microservices architecture using **Spring Boot**, integrated with a **Dockerized PostgreSQL** database for persistence.

## ⚙️ Project Overview

This system consists of three independent microservices:

- **Job Service** – Manages job listings and associates each job with a company.
- **Company Service** – Handles CRUD operations for company profiles.
- **Review Service** – Enables users to leave reviews for companies.

Each service is designed for independent deployment and maintenance, and communicates via REST APIs.

## 🛠️ Tech Stack

- **Java 17+**
- **Spring Boot**
- **Spring Web & Spring Data JPA**
- **PostgreSQL** (Dockerized)
- **Docker & Docker Compose**
- **pgAdmin 4**
- **RESTful APIs**

## 🧩 Microservices Details

### 🔹 Job Service
- Create, update, and retrieve job postings.
- Each job is linked to a company via `companyId`.

### 🔹 Company Service
- Create and manage company information.
- Serves as a central reference for both jobs and reviews.

### 🔹 Review Service
- Users can add and retrieve reviews for companies.
- Each review is linked to a company by `companyId`.

## 🐳 Database & Containerization

- The database is managed via **Docker Compose** for consistency and isolation.
- A **PostgreSQL** container is used for persistent storage.
- **pgAdmin** is included for easy database management and inspection.

## 🚀 Getting Started

## 🚀 How to Run

1. **Clone the repository**  
   ```bash
   git clone https://github.com/yourusername/job-microservices-backend.git

2. **Configure each microservice**  
   Update each microservice's `application.yml` or `application.properties` file with the correct database connection:

   - Host  
   - Port  
   - Username  
   - Password


3. **Run the services**  
   You can run each Spring Boot service using:

   ```bash
   ./mvnw spring-boot:run
Or directly from your IDE (e.g., IntelliJ or Eclipse).

## 📬 Sample API Endpoints

### 🔹 Job Service
- `POST http://localhost:8080/jobs` – Create a job  
- `GET http://localhost:8080/jobs` – Get all jobs  
- `GET http://localhost:8080/jobs/{id}` – Get job by ID  


### 🔹 Company Service
- `POST http://localhost:8080/companies` – Add a company  
- `GET http://localhost:8080/companies` – Get all companies  
- `GET http://localhost:8080/companies/{id}` – Get company by ID  
- `GET http://localhost:8080/companies/{companyId}/reviews/{reviewId}` – Get reviews for a company  


### 🔹 Review Service
- `POST http://localhost:8080/reviews` – Add a review  


## 🔐 Security (Optional)

This project is ready for integration with:

- ✅ **JWT-based authentication**
- ✅ **Role-based access control**


## 📦 Future Enhancements

- Service discovery with **Eureka**  
- Centralized config with **Spring Cloud Config**  
- API Gateway using **Spring Cloud Gateway**  
- Asynchronous communication using **Kafka**  


## 👨‍💻 Author

Developed by **Omar A.**  
Computer Science Student | Backend Developer | Microservices Enthusiast







