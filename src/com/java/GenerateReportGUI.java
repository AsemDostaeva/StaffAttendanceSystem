package com.java;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class GenerateReportGUI extends JFrame {

    private JTextField txtStartDate, txtEndDate;
    private JTextArea reportArea;

    public GenerateReportGUI() {
        setTitle("Generate Attendance Report");

        // Create form components
        JLabel lblStartDate = new JLabel("Start Date (YYYY-MM-DD):");
        txtStartDate = new JTextField(20);
        JLabel lblEndDate = new JLabel("End Date (YYYY-MM-DD):");
        txtEndDate = new JTextField(20);
        reportArea = new JTextArea(10, 30);
        reportArea.setEditable(false);

        JButton btnGenerateReport = new JButton("Generate Report");

        // Set layout and add components
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(lblStartDate);
        add(txtStartDate);
        add(lblEndDate);
        add(txtEndDate);
        add(btnGenerateReport);
        add(new JScrollPane(reportArea));

        // Add action listener to the "Generate Report" button
        btnGenerateReport.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String startDate = txtStartDate.getText();
                String endDate = txtEndDate.getText();

                // Validate input dates
                if (startDate.isEmpty() || endDate.isEmpty()) {
                    JOptionPane.showMessageDialog(null, "Please enter both start and end dates.");
                    return;
                }

                // Validate date format
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                sdf.setLenient(false);  // Strict date parsing
                try {
                    sdf.parse(startDate);
                    sdf.parse(endDate);
                } catch (ParseException ex) {
                    JOptionPane.showMessageDialog(null, "Invalid date format. Please use 'YYYY-MM-DD'.");
                    return;
                }

                try {
                    // Call the DAO method to generate the attendance report
                    List<Attendance> report = AttendanceDAO.generateAttendanceReport(startDate, endDate);

                    if (report.isEmpty()) {
                        reportArea.setText("No attendance records found between " + startDate + " and " + endDate);
                    } else {
                        StringBuilder sb = new StringBuilder();
                        sb.append("Attendance Report from ").append(startDate)
                                .append(" to ").append(endDate).append("\n\n");

                        // Loop through the report data and append to the text area
                        for (Attendance attendance : report) {
                            sb.append("Employee ID: ").append(attendance.getEmployeeId())
                                    .append(" | Date: ").append(attendance.getDate())
                                    .append(" | Status: ").append(attendance.getStatus()).append("\n");
                        }

                        reportArea.setText(sb.toString());  // Show report in the text area
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(null, "Error generating report. Please try again.");
                }
            }
        });

        // Window settings
        setSize(800, 600);  // Adjust window size based on typical report content
        setLocationRelativeTo(null);
        setVisible(true);
    }
}
