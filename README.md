# Smart Campus Resource Management System

## 1. Project Overview

The Smart Campus Resource Management System is a Java-based command-line application used to manage shared resources in a college campus.

The system allows students and faculty members to check resources and request bookings. Administrators can manage users, resources, bookings and maintenance requests.

The project is developed as part of **CSE2006 – Programming in Java**.

## 2. Problem Statement

Colleges have many shared resources such as classrooms, computer labs, seminar halls and projectors. Managing these resources manually can cause problems such as double booking, difficulty checking availability and poor record keeping.

This project provides a simple centralized system for managing campus resources and their bookings.

## 3. Objectives

* Manage campus resources in one system.
* Allow students and faculty to request bookings.
* Prevent overlapping bookings.
* Allow administrators to manage resources and users.
* Record maintenance problems.
* Generate basic reports.
* Apply Java programming concepts in a practical application.

## 4. Main Features

### User Management

* User registration
* User login
* Role-based access
* User management by admin

### Resource Management

* Add resources
* View resources
* Search resources
* Update resources
* Check availability

### Booking Management

* Create booking requests
* Check booking conflicts
* View bookings
* Cancel bookings
* Approve or reject bookings

### Maintenance Management

* Report resource problems
* View maintenance requests
* Update maintenance status

### Reports

* User reports
* Resource reports
* Booking reports
* Maintenance reports
* Export reports to text files

## 5. User Roles

The system has three types of users:

**Student:** Can view resources and request bookings.

**Faculty:** Can view resources and request bookings.

**Admin:** Can manage users, resources, bookings and maintenance requests.

## 6. Technologies Used

* Java 17
* Maven
* SQLite
* JDBC
* JPA / Hibernate
* JUnit 5
* Git and GitHub

## 7. Java Concepts Used

The project demonstrates the following concepts from CSE2006:

* Classes and objects
* Constructors
* Encapsulation
* Inheritance
* Polymorphism
* Method overloading and overriding
* Abstract classes
* Interfaces
* Exception handling
* Multithreading
* Synchronization
* Collections
* ArrayList
* File I/O
* JDBC
* JPA
* Enums

## 8. Project Structure

```text
smart-campus-resource-management/
│
├── README.md
├── statement.md
├── pom.xml
├── schema.sql
├── .gitignore
│
├── docs/
│   ├── architecture.md
│   ├── diagrams.md
│   └── testing.md
│
└── src/
    ├── main/
    │   ├── java/
    │   │   └── com/campus/management/
    │   │       ├── Main.java
    │   │       ├── model/
    │   │       ├── service/
    │   │       ├── repository/
    │   │       ├── controller/
    │   │       ├── exception/
    │   │       └── util/
    │   │
    │   └── resources/
    │
    └── test/
        └── java/
```

## 9. Requirements

Before running the project, install:

* JDK 17 or later
* Apache Maven
* Git

The application runs completely through the command line and does not require a GUI.

## 10. Installation

Clone the repository:

```bash
git clone https://github.com/YOUR_USERNAME/smart-campus-resource-management.git
```

Open the project directory:

```bash
cd smart-campus-resource-management
```

Check Java:

```bash
java -version
```

Check Maven:

```bash
mvn -version
```

## 11. Build the Project

Run:

```bash
mvn clean install
```

Maven will download the required dependencies and compile the project.

## 12. Run the Project

Run:

```bash
mvn exec:java
```

The application will start in the terminal and display the main menu.

## 13. Run Tests

To run the available tests:

```bash
mvn test
```

The tests cover important operations such as booking, conflict checking, resource management and exception handling.

## 14. Basic Workflow

```text
Login
  ↓
View Resources
  ↓
Check Availability
  ↓
Request Booking
  ↓
Check Booking Conflict
  ↓
Create Booking
  ↓
Admin Approval
  ↓
Booking Confirmed
```

## 15. Booking Conflict

The system checks existing bookings before creating a new booking.

For example:

```text
Existing booking: 10:00 - 12:00
New request:      11:00 - 13:00

Result: Booking Conflict
```

A conflicting booking is not accepted.

## 16. Database

SQLite is used for storing application data.

The main tables are:

* `users`
* `resources`
* `bookings`
* `maintenance_requests`

JDBC is used for database operations and JPA/Hibernate is used for ORM-based persistence.

## 17. Exception Handling

The application handles invalid input and other expected errors using exception handling.

Some custom exceptions include:

```text
BookingConflictException
ResourceNotFoundException
InvalidInputException
DatabaseException
UnauthorizedOperationException
```

## 18. Multithreading

Multithreading is used to demonstrate concurrent booking requests.

Synchronization is used while processing bookings so that two users cannot create conflicting bookings for the same resource at the same time.

## 19. File Handling

Reports can be exported as text files using Java I/O streams.

Example:

```text
reports/
├── booking_report.txt
├── resource_report.txt
└── maintenance_report.txt
```

## 20. Future Improvements

Some possible improvements are:

* Web interface
* Mobile application
* Email notifications
* Calendar integration
* QR-code based resource access
* Cloud database
* Advanced analytics

## 21. Academic Relevance

This project was created using concepts covered in **CSE2006 Programming in Java**. It combines object-oriented programming, exception handling, multithreading, collections, file I/O, JDBC and JPA in one application.

## 22. Author

**Name:**Eshita Parihar
**Course:** CSE2006 – Programming in Java
**Project:** Smart Campus Resource Management System

