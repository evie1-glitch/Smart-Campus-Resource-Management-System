package main.java.com.campus.management;

import java.util.Scanner;

import main.java.com.campus.management.model.User;
import main.java.com.campus.management.model.Booking;
import main.java.com.campus.management.model.Resource;
import main.java.com.campus.management.model.MaintenanceRequest;

import main.java.com.campus.management.service.UserService;
import main.java.com.campus.management.service.ResourceService;
import main.java.com.campus.management.service.BookingService;
import main.java.com.campus.management.service.MaintenanceService;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        UserService userService = new UserService();
        ResourceService resourceService = new ResourceService();
        BookingService bookingService = new BookingService();
        MaintenanceService maintenanceService = new MaintenanceService();

        User currentUser = null;

        // Sample campus resources
        resourceService.addResource(
            new Resource(1, "Room 101", "Classroom", "Block A", true)
        );

        resourceService.addResource(
            new Resource(2, "Computer Lab 1", "Computer Laboratory", "Block B", true)
        );

        resourceService.addResource(
            new Resource(3, "Seminar Hall", "Seminar Hall", "Block C", true)
        );

        System.out.println("======================================");
        System.out.println("   SMART CAMPUS RESOURCE MANAGEMENT");
        System.out.println("======================================");

        boolean running = true;

        while (running) {

            System.out.println("\n----- MAIN MENU -----");
            System.out.println("1. Login");
            System.out.println("2. Register");
            System.out.println("3. View Resources");
            System.out.println("4. Book Resource");
            System.out.println("5. View Bookings");
            System.out.println("6. Cancel Booking");
            System.out.println("7. Report Maintenance Issue");
            System.out.println("8. View Maintenance Requests");
            System.out.println("9. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {

                // LOGIN
                case 1:

                    if (currentUser == null) {
                        System.out.println("Please register first.");
                        break;
                    }

                    scanner.nextLine();

                    System.out.print("Enter your email: ");
                    String loginEmail = scanner.nextLine();

                    System.out.print("Enter your password: ");
                    String loginPassword = scanner.nextLine();

                    if (userService.loginUser(
                            currentUser,
                            loginEmail,
                            loginPassword)) {

                        System.out.println("Login successful!");
                        System.out.println(
                            "Welcome back, " + currentUser.getName() + "!"
                        );

                    } else {
                        System.out.println("Invalid email or password.");
                    }

                    break;


                // REGISTER
                case 2:

                    System.out.print("Enter your name: ");
                    scanner.nextLine();
                    String name = scanner.nextLine();

                    System.out.print("Enter your email: ");
                    String email = scanner.nextLine();

                    System.out.print("Enter your password: ");
                    String password = scanner.nextLine();

                    User user = userService.registerUser(
                        1,
                        name,
                        email,
                        password
                    );

                    currentUser = user;

                    System.out.println("\nRegistration successful!");
                    System.out.println(
                        "Welcome, " + currentUser.getName() + "!"
                    );

                    break;


                // VIEW RESOURCES
                case 3:

                    System.out.println("\n----- CAMPUS RESOURCES -----");

                    if (resourceService.getAllResources().isEmpty()) {

                        System.out.println("No resources available.");

                    } else {

                        for (Resource resource :
                                resourceService.getAllResources()) {

                            System.out.println(
                                resource.getId() + ". " +
                                resource.getName() + " | " +
                                resource.getType() + " | " +
                                resource.getLocation()
                            );
                        }
                    }

                    break;


                // BOOK RESOURCE
                case 4:

                    System.out.println("\n----- BOOK RESOURCE -----");

                    System.out.print("Enter resource ID: ");
                    int resourceId = scanner.nextInt();

                    Resource selectedResource =
                        resourceService.findResource(resourceId);

                    if (selectedResource == null) {

                        System.out.println("Resource not found.");

                    } else {

                        System.out.println(
                            "Selected: " + selectedResource.getName()
                        );

                        System.out.print(
                            "Enter booking date (YYYY-MM-DD): "
                        );

                        scanner.nextLine();
                        String bookingDate = scanner.nextLine();

                        System.out.print(
                            "Enter start time (HH:MM): "
                        );

                        String startTime = scanner.nextLine();

                        System.out.print(
                            "Enter end time (HH:MM): "
                        );

                        String endTime = scanner.nextLine();

                        Booking booking = new Booking(
                            1,
                            currentUser != null
                                ? currentUser.getId()
                                : 1,
                            resourceId,
                            bookingDate,
                            startTime,
                            endTime,
                            "PENDING"
                        );

                        if (bookingService.addBooking(booking)) {

                            System.out.println(
                                "Booking request created successfully!"
                            );

                        } else {

                            System.out.println(
                                "Booking conflict! " +
                                "This resource is already booked " +
                                "for that time."
                            );
                        }
                    }

                    break;


                // VIEW BOOKINGS
                case 5:

                    System.out.println("\n----- MY BOOKINGS -----");

                    if (bookingService.getAllBookings().isEmpty()) {

                        System.out.println("No bookings found.");

                    } else {

                        boolean found = false;

                        for (Booking booking :
                                bookingService.getAllBookings()) {

                            if (currentUser != null &&
                                booking.getUserId() ==
                                currentUser.getId()) {

                                found = true;

                                System.out.println(
                                    "Booking ID: " + booking.getId()
                                    + " | Resource ID: "
                                    + booking.getResourceId()
                                    + " | Date: "
                                    + booking.getBookingDate()
                                    + " | Time: "
                                    + booking.getStartTime()
                                    + " - "
                                    + booking.getEndTime()
                                    + " | Status: "
                                    + booking.getStatus()
                                );
                            }
                        }

                        if (!found) {
                            System.out.println(
                                "You have no bookings."
                            );
                        }
                    }

                    break;


                // CANCEL BOOKING
                case 6:

                    System.out.println("\n----- CANCEL BOOKING -----");

                    if (currentUser == null) {

                        System.out.println(
                            "Please register or login first."
                        );

                        break;
                    }

                    System.out.print("Enter booking ID: ");
                    int bookingId = scanner.nextInt();

                    if (bookingService.cancelBooking(
                            bookingId,
                            currentUser.getId())) {

                        System.out.println(
                            "Booking cancelled successfully!"
                        );

                    } else {

                        System.out.println(
                            "Booking not found or cannot be cancelled."
                        );
                    }

                    break;


                // REPORT MAINTENANCE ISSUE
                case 7:

                    System.out.println(
                        "\n----- REPORT MAINTENANCE ISSUE -----"
                    );

                    if (currentUser == null) {

                        System.out.println(
                            "Please register first."
                        );

                        break;
                    }

                    System.out.print("Enter resource ID: ");
                    int maintenanceResourceId = scanner.nextInt();

                    scanner.nextLine();

                    System.out.print("Describe the problem: ");
                    String description = scanner.nextLine();

                    System.out.print(
                        "Enter priority (LOW/MEDIUM/HIGH/CRITICAL): "
                    );

                    String priority = scanner.nextLine().toUpperCase();

                    MaintenanceRequest request =
                        new MaintenanceRequest(
                            maintenanceService.getAllRequests().size() + 1,
                            currentUser.getId(),
                            maintenanceResourceId,
                            description,
                            priority,
                            "OPEN"
                        );

                    maintenanceService.addRequest(request);

                    System.out.println(
                        "Maintenance request submitted successfully!"
                    );

                    break;


                // VIEW MAINTENANCE REQUESTS
                case 8:

                    System.out.println(
                        "\n----- MAINTENANCE REQUESTS -----"
                    );

                    maintenanceService.showRequests();

                    break;


                // EXIT
                case 9:

                    System.out.println(
                        "Thank you for using the system."
                    );

                    running = false;

                    break;


                default:

                    System.out.println(
                        "Invalid choice. Please try again."
                    );
            }
        }

        scanner.close();
    }
}