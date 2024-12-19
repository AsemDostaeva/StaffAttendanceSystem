package com.java;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Staff Attendance System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. Search Employee by ID");
            System.out.println("3. Check In Employee");
            System.out.println("4. Check Out Employee");
            System.out.println("5. View Employee Attendance");
            System.out.println("6. Generate Attendance Report");
            System.out.println("7. Track Absentees");
            System.out.println("8. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter first name: ");
                    String firstName = scanner.nextLine();
                    System.out.print("Enter last name: ");
                    String lastName = scanner.nextLine();
                    EmployeeDAO.addEmployee(firstName, lastName);
                    break;

                case 2:
                    System.out.print("Enter employee ID: ");
                    int employeeId = scanner.nextInt();
                    EmployeeDAO.searchEmployeeById(employeeId);
                    break;

                case 3:
                    System.out.print("Enter employee ID to check in: ");
                    int checkInId = scanner.nextInt();
                    AttendanceDAO.checkInEmployee(checkInId);
                    break;

                case 4:
                    System.out.print("Enter employee ID to check out: ");
                    int checkOutId = scanner.nextInt();
                    AttendanceDAO.checkOutEmployee(checkOutId);
                    break;

                case 5:
                    System.out.print("Enter employee ID to view attendance: ");
                    int viewAttendanceId = scanner.nextInt();
                    // View attendance logic
                    break;

                case 6:
                    System.out.print("Enter start date (YYYY-MM-DD): ");
                    String startDate = scanner.nextLine();
                    System.out.print("Enter end date (YYYY-MM-DD): ");
                    String endDate = scanner.nextLine();
                    AttendanceDAO.generateAttendanceReport(startDate, endDate);
                    break;

                case 7:
                    // Absentee logic
                    break;

                case 8:
                    System.out.println("Exiting... Goodbye!");
                    scanner.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }
}
