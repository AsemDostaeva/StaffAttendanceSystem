package com.java;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainGUI extends JFrame {

    public MainGUI() {
        setTitle("Staff Attendance System");

        // Set layout for the main window
        setLayout(new BorderLayout());

        // Create a panel to hold buttons with BoxLayout
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create buttons for each action
        JButton btnAddEmployee = new JButton("Add Employee");
        JButton btnSearchEmployee = new JButton("Search Employee by ID");
        JButton btnCheckIn = new JButton("Check In Employee");
        JButton btnCheckOut = new JButton("Check Out Employee");
        JButton btnViewAttendance = new JButton("View Attendance");
        JButton btnGenerateReport = new JButton("Generate Attendance Report");
        JButton btnExit = new JButton("Exit");

        // Set button alignment and add them to the panel
        btnAddEmployee.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnSearchEmployee.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCheckIn.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnCheckOut.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnViewAttendance.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnGenerateReport.setAlignmentX(Component.CENTER_ALIGNMENT);
        btnExit.setAlignmentX(Component.CENTER_ALIGNMENT);

        panel.add(btnAddEmployee);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnSearchEmployee);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnCheckIn);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnCheckOut);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnViewAttendance);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnGenerateReport);
        panel.add(Box.createRigidArea(new Dimension(0, 10)));
        panel.add(btnExit);

        add(panel, BorderLayout.CENTER);

        // Button actions
        btnAddEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AddEmployeeGUI();
            }
        });

        btnSearchEmployee.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new SearchEmployeeGUI();
            }
        });

        btnCheckIn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CheckInGUI();
            }
        });

        btnCheckOut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new CheckOutGUI();
            }
        });

        btnViewAttendance.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ViewAttendanceGUI();
            }
        });

        btnGenerateReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new GenerateReportGUI();
            }
        });

        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        // Window settings
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(400, 400);
        setLocationRelativeTo(null);  // Center the window on the screen
        setVisible(true);
    }

    public static void main(String[] args) {
        new MainGUI();
    }
}
