package com.java;

public class Attendance {
    private int attendanceId;
    private int employeeId;
    private String date;
    private String status;

    public Attendance(int attendanceId, int employeeId, String date, String status) {
        this.attendanceId = attendanceId;
        this.employeeId = employeeId;
        this.date = date;
        this.status = status;
    }

    public int getAttendanceId() {
        return attendanceId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getDate() {
        return date;
    }

    public String getStatus() {
        return status;
    }
}
