package com.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchEmployeeGUI extends JFrame {

    private JTextField txtEmployeeId;

    public SearchEmployeeGUI() {
        setTitle("Search Employee by ID");

        // Create components
        JLabel lblEmployeeId = new JLabel("Enter Employee ID:");
        txtEmployeeId = new JTextField(20);
        JButton btnSearch = new JButton("Search");

        // Set up layout and add components
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(lblEmployeeId);
        add(txtEmployeeId);
        add(btnSearch);

        // Search button action
        btnSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String input = txtEmployeeId.getText();

                if (input.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter an Employee ID.");
                    return;
                }

                try {
                    int employeeId = Integer.parseInt(input);
                    // Attempt to search for the employee by ID
                    EmployeeDAO.searchEmployeeById(employeeId);
                    txtEmployeeId.setText("");  // Clear the input field after search
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid ID format. Please enter a valid number.");
                } catch (Exception ex) {
                    // Catch any other exceptions, like database connection errors
                    JOptionPane.showMessageDialog(null, "Error occurred while searching. Please try again.");
                    ex.printStackTrace();
                }
            }
        });

        // Window settings
        setSize(300, 200);
        setLocationRelativeTo(null);  // Center the window
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);  // Close this window only, not the app
        setVisible(true);
    }
}
