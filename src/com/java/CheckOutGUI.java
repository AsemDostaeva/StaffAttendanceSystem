package com.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckOutGUI extends JFrame {

    private JTextField txtEmployeeId;

    public CheckOutGUI() {
        setTitle("Check Out Employee");

        // Create components
        JLabel lblEmployeeId = new JLabel("Enter Employee ID:");
        txtEmployeeId = new JTextField(20);
        JButton btnCheckOut = new JButton("Check Out");

        // Layout setup
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(lblEmployeeId);
        add(txtEmployeeId);
        add(btnCheckOut);

        // Action Listener for "Check Out" button
        btnCheckOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String employeeIdText = txtEmployeeId.getText();

                    if (employeeIdText.isEmpty()) {
                        JOptionPane.showMessageDialog(null, "Please enter an Employee ID.");
                        return;  // Exit the method if the ID is empty
                    }

                    // Try to parse the employee ID
                    int employeeId = Integer.parseInt(employeeIdText);

                    // Call the DAO to check out the employee
                    boolean success = AttendanceDAO.checkOutEmployee(employeeId);

                    // Provide feedback based on whether check-out was successful
                    if (success) {
                        JOptionPane.showMessageDialog(null, "Employee Checked Out Successfully!");
                    } else {
                        JOptionPane.showMessageDialog(null, "Failed to Check Out Employee. Please try again.");
                    }

                    // Optionally, you can dispose of the window or reset the form
                    dispose();  // Close the window after the action (if you want to close it)

                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid Employee ID. Please enter a valid number.");
                }
            }
        });

        // Window settings
        setSize(300, 200);
        setLocationRelativeTo(null);  // Center the window
        setVisible(true);  // Show the window
    }
}
