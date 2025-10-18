# RentApplication - Spring Boot Project

A comprehensive Spring Boot application for managing apartment rentals, rent payments, and electricity bills.

## 📋 Table of Contents
- [Project Overview](#project-overview)
- [Technology Stack](#technology-stack)
- [Project Structure](#project-structure)
- [Database Configuration](#database-configuration)
- [API Endpoints](#api-endpoints)
- [Getting Started](#getting-started)
- [File Index](#file-index)

## 🏠 Project Overview

This is a Spring Boot microservice application designed to manage apartment rental operations. The application handles three main entities:
- **Apartments**: Property management
- **Rent**: Payment tracking
- **Electricity Bills (EBill)**: Utility bill management

## 🛠 Technology Stack

- **Java 17**
- **Spring Boot 3.3.5**
- **Spring Data JPA** - Database operations
- **MySQL** - Database
- **Lombok** - Code generation
- **Spring Web** - REST API
- **Spring Validation** - Input validation
- **Spring Actuator** - Application monitoring

## 📁 Project Structure

```
RentApplication/
├── src/
│   └── main/
│       ├── java/org/rentapp/rentapplication/
│       │   ├── controllers/          # REST API Controllers
│       │   │   ├── ApartmentController.java
│       │   │   ├── RentController.java
│       │   │   └── EBillController.java
│       │   ├── entities/             # JPA Entities
│       │   │   ├── Apartment.java
│       │   │   ├── Rent.java
│       │   │   └── EBill.java
│       │   ├── repositories/         # Data Access Layer
│       │   │   ├── ApartmentRepository.java
│       │   │   ├── RentRepository.java
│       │   │   └── EBillRepository.java
│       │   ├── services/             # Business Logic Layer
│       │   │   ├── ApartmentService.java
│       │   │   ├── RentService.java
│       │   │   └── EBillService.java
│       │   ├── exception/            # Custom Exceptions
│       │   │   └── RentException.java
│       │   └── RentApplication.java  # Main Application Class
│       └── resources/
│           └── application.properties # Configuration
├── pom.xml                           # Maven Dependencies
├── mvnw                             # Maven Wrapper (Unix)
├── mvnw.cmd                         # Maven Wrapper (Windows)
└── README.md                        # This file
```

## 🗄 Database Configuration

The application is configured to use MySQL database with the following settings:
- **Database**: `Rentapp`
- **Port**: `3306`
- **Username**: `root`
- **Password**: `*@*@`
- **Server Port**: `8082`

## 🔌 API Endpoints

### Apartment Management (`/apartment`)
- `GET /apartment/getallapartments` - Get all apartments
- `GET /apartment/getapartmentById/{id}` - Get apartment by ID
- `POST /apartment/addapartment` - Create new apartment
- `DELETE /apartment/{id}` - Delete apartment

### Rent Management (`/rent`)
- `GET /rent/hello` - Health check endpoint
- `POST /rent/addRent` - Add new rent payment
- `GET /rent/getRentbyApartment/{apartmentId}` - Get rents by apartment
- `GET /rent/getAllRents` - Get all rent payments
- `GET /rent/getRentbyId/{id}` - Get rent by ID
- `DELETE /rent/deleteRentbyId/{id}` - Delete rent payment

### Electricity Bill Management (`/eb`)
- `POST /eb/addebill` - Add new electricity bill
- `GET /eb/getebill/{id}` - Get bill by ID
- `GET /eb/getAll` - Get all electricity bills
- `GET /eb/getByapartmentId/{id}` - Get bills by apartment
- `DELETE /eb/delete/{id}` - Delete electricity bill

## 🚀 Getting Started

### Prerequisites
- Java 17 or higher
- MySQL 8.0 or higher
- Maven 3.6 or higher

### Installation Steps

1. **Clone the repository**
   ```bash
   git clone <repository-url>
   cd RentApplication
   ```

2. **Database Setup**
   - Install MySQL
   - Create database: `Rentapp`
   - Update database credentials in `application.properties` if needed

3. **Run the application**
   ```bash
   # Using Maven wrapper
   ./mvnw spring-boot:run
   
   # Or using Maven
   mvn spring-boot:run
   ```

4. **Access the application**
   - Application runs on: `http://localhost:8082`
   - Actuator endpoints: `http://localhost:8082/actuator`

## 📄 File Index

### Core Application Files
- **`RentApplication.java`** - Main Spring Boot application class with `@SpringBootApplication` annotation
- **`application.properties`** - Configuration file containing database settings and server port

### Entity Classes (JPA Models)
- **`Apartment.java`** - Apartment entity with fields: id, name, address, rentAmount
- **`Rent.java`** - Rent payment entity with fields: id, amount, date, apartmentId
- **`EBill.java`** - Electricity bill entity with fields: id, apartmentId, amount, month, costPerUnit, units

### Controller Classes (REST API)
- **`ApartmentController.java`** - Handles apartment CRUD operations
- **`RentController.java`** - Manages rent payment operations
- **`EBillController.java`** - Handles electricity bill management

### Service Classes (Business Logic)
- **`ApartmentService.java`** - Apartment business logic and validation
- **`RentService.java`** - Rent payment processing logic
- **`EBillService.java`** - Electricity bill calculation and management

### Repository Classes (Data Access)
- **`ApartmentRepository.java`** - JPA repository for apartment data operations
- **`RentRepository.java`** - JPA repository for rent data operations
- **`EBillRepository.java`** - JPA repository for electricity bill data operations

### Exception Handling
- **`RentException.java`** - Custom runtime exception for application-specific errors

### Configuration Files
- **`pom.xml`** - Maven project configuration with Spring Boot dependencies
- **`mvnw`** - Maven wrapper script for Unix/Linux
- **`mvnw.cmd`** - Maven wrapper script for Windows

## 🔧 Key Features

1. **RESTful API Design** - Clean, RESTful endpoints for all operations
2. **Data Validation** - Input validation using Spring Validation
3. **Exception Handling** - Custom exception handling with proper HTTP status codes
4. **Database Integration** - JPA/Hibernate for database operations
5. **Actuator Monitoring** - Health checks and application metrics
6. **Lombok Integration** - Reduces boilerplate code with annotations

## 📝 Notes

- The application uses MySQL as the database
- All entities use JPA annotations for database mapping
- Lombok annotations are used for getters, setters, and constructors
- The application runs on port 8082
- Database schema is managed by Hibernate (DDL auto is set to 'none')

## 🤝 Contributing

1. Fork the repository
2. Create a feature branch
3. Make your changes
4. Test thoroughly
5. Submit a pull request
