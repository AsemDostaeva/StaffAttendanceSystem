package com.java;

import java.sql.*;

public class EmployeeDAO {

    public static void addEmployee(String firstName, String lastName) {
        Connection connection = DBConnection.getConnection();
        String query = "INSERT INTO employees (first_name, last_name) VALUES (?, ?)";

        try {
            PreparedStatement stmt = connection.prepareStatement(query, Statement.RETURN_GENERATED_KEYS);
            stmt.setString(1, firstName);
            stmt.setString(2, lastName);
            stmt.executeUpdate();

            ResultSet generatedKeys = stmt.getGeneratedKeys();
            if (generatedKeys.next()) {
                int employeeId = generatedKeys.getInt(1);
                System.out.println("Employee added successfully with ID: " + employeeId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(connection);
        }
    }

    public static void searchEmployeeById(int employeeId) {
        Connection connection = DBConnection.getConnection();
        String query = "SELECT * FROM employees WHERE id = ?";

        try {
            PreparedStatement stmt = connection.prepareStatement(query);
            stmt.setInt(1, employeeId);
            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                String firstName = rs.getString("first_name");
                String lastName = rs.getString("last_name");
                System.out.println("Employee ID: " + employeeId + ", Name: " + firstName + " " + lastName);
            } else {
                System.out.println("No employee found with ID: " + employeeId);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DBConnection.closeConnection(connection);
        }
    }
}
