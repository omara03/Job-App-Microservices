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

1. **Clone the repository**  
   ```bash
   git clone https://github.com/yourusername/job-microservices-backend.git
