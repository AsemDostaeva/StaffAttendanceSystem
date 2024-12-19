package com.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckInGUI extends JFrame {

    private JTextField txtEmployeeId;

    public CheckInGUI() {
        setTitle("Check In Employee");

        // Create form components
        JLabel lblEmployeeId = new JLabel("Enter Employee ID:");
        txtEmployeeId = new JTextField(20);
        JButton btnCheckIn = new JButton("Check In");

        // Layout setup
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(lblEmployeeId);
        add(txtEmployeeId);
        add(btnCheckIn);

        // Action Listener for the "Check In" button
        btnCheckIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    // Parse the employee ID entered by the user
                    int employeeId = Integer.parseInt(txtEmployeeId.getText());

                    // Call DAO method to check in the employee
                    boolean success = AttendanceDAO.checkInEmployee(employeeId);

                    // Provide feedback to the user based on the success of the check-in
                    if (success) {
                        JOptionPane.showMessageDialog(null, "Employee checked in successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Error checking in the employee. Please try again.");
                    }

                } catch (NumberFormatException ex) {
                    // Display an error if the input is not a valid integer
                    JOptionPane.showMessageDialog(null, "Invalid ID format. Please enter a number.");
                }
            }
        });

        // Window settings
        setSize(300, 200);
        setLocationRelativeTo(null);  // Center the window
        setVisible(true);  // Make the window visible
    }
}
