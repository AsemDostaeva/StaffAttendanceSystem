package com.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddEmployeeGUI extends JFrame {

    private JTextField txtFirstName, txtLastName;

    public AddEmployeeGUI() {
        setTitle("Add Employee");

        // Create form components
        JLabel lblFirstName = new JLabel("First Name:");
        JLabel lblLastName = new JLabel("Last Name:");
        txtFirstName = new JTextField(20);
        txtLastName = new JTextField(20);

        JButton btnAdd = new JButton("Add");

        // Add components to the frame
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(lblFirstName);
        add(txtFirstName);
        add(lblLastName);
        add(txtLastName);
        add(btnAdd);

        // Add action listener to the "Add" button
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String firstName = txtFirstName.getText().trim();
                String lastName = txtLastName.getText().trim();

                if (!firstName.isEmpty() && !lastName.isEmpty()) {
                    try {
                        EmployeeDAO.addEmployee(firstName, lastName);  // Call the DAO method to add employee
                        JOptionPane.showMessageDialog(null, "Employee Added Successfully!");
                        txtFirstName.setText("");
                        txtLastName.setText("");  // Clear the fields
                        dispose();  // Close the form
                    } catch (Exception ex) {
                        JOptionPane.showMessageDialog(null, "Error adding employee: " + ex.getMessage());
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Please enter both first and last name.");
                }
            }
        });

        // Window settings
        setSize(300, 200);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Properly handle window close
        setVisible(true);
    }
}
