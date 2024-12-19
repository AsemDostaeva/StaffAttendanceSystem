package com.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ViewAttendanceGUI extends JFrame {

    private JTextField txtEmployeeId;
    private JTextArea attendanceArea;

    public ViewAttendanceGUI() {
        setTitle("View Employee Attendance");

        // Create form components
        JLabel lblEmployeeId = new JLabel("Enter Employee ID:");
        txtEmployeeId = new JTextField(20);
        attendanceArea = new JTextArea(10, 30);
        attendanceArea.setEditable(false);

        JButton btnViewAttendance = new JButton("View Attendance");

        // Set layout and add components
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(lblEmployeeId);
        add(txtEmployeeId);
        add(btnViewAttendance);
        add(new JScrollPane(attendanceArea));  // Add scroll pane for text area

        // Add action listener to the "View Attendance" button
        btnViewAttendance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String employeeIdText = txtEmployeeId.getText();

                    // Check if input is empty
                    if (employeeIdText.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter an Employee ID.");
                        return;
                    }

                    // Parse Employee ID to int
                    int employeeId = Integer.parseInt(employeeIdText);

                    // Call the DAO method to get attendance records
                    List<Attendance> attendanceList = AttendanceDAO.viewAttendance(employeeId);

                    if (attendanceList.isEmpty()) {
                        attendanceArea.setText("No attendance records found for Employee ID: " + employeeId);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Attendance for Employee ID: ").append(employeeId).append("\n\n");
                        for (Attendance attendance : attendanceList) {
                            sb.append("Date: ").append(attendance.getDate())
                                    .append(" | Status: ").append(attendance.getStatus()).append("\n");
                        }
                        attendanceArea.setText(sb.toString());
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Employee ID. Please enter a valid number.");
                }
            }
        });

        // Window settings
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Close this window only
        setVisible(true);
    }

    public static void main(String[] args) {
        new ViewAttendanceGUI();
    }
}
