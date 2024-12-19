package com.java;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AttendanceDAO {

    public static boolean checkInEmployee(int employeeId) {
        String sql = "INSERT INTO attendance (employee_id, date, status) VALUES (?, NOW(), 'Present')";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, employeeId);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean checkOutEmployee(int employeeId) {
        String sql = "UPDATE attendance SET status = 'Checked Out' WHERE employee_id = ? AND status = 'Present' ORDER BY date DESC LIMIT 1";
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, employeeId);
            int rowsAffected = pstmt.executeUpdate();
            return rowsAffected > 0;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<Attendance> generateAttendanceReport(String startDate, String endDate) {
        List<Attendance> report = new ArrayList<>();
        String sql = "SELECT * FROM attendance WHERE date BETWEEN ? AND ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setString(1, startDate);
            pstmt.setString(2, endDate);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int attendanceId = rs.getInt("attendance_id");
                int employeeId = rs.getInt("employee_id");
                String date = rs.getString("date");
                String status = rs.getString("status");
                Attendance attendance = new Attendance(attendanceId, employeeId, date, status);
                report.add(attendance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return report;
    }

    public static List<Attendance> viewAttendance(int employeeId) {
        List<Attendance> attendanceList = new ArrayList<>();
        String sql = "SELECT * FROM attendance WHERE employee_id = ?";

        try (Connection conn = DBConnection.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {

            pstmt.setInt(1, employeeId);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {
                int attendanceId = rs.getInt("attendance_id");
                String date = rs.getString("date");
                String status = rs.getString("status");
                Attendance attendance = new Attendance(attendanceId, employeeId, date, status);
                attendanceList.add(attendance);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return attendanceList;
    }
}
