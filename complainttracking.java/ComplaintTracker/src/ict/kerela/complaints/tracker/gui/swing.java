package ict.kerela.complaints.tracker.gui;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

class Complaint {
    int id;
    String description;
    String status;

    Complaint(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = "Open";
    }
}

public class swing {
    private JFrame frame;
    private JPanel mainPanel;
    private ArrayList<Complaint> complaints = new ArrayList<>();
    private int nextId = 1;

    public swing() {
        frame = new JFrame("Complaint Tracking System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        showMainMenu();

        frame.setVisible(true);
    }

    private void showMainMenu() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(5, 1, 10, 10));

        JButton submitBtn = new JButton("Submit Complaint");
        JButton viewStatusBtn = new JButton("View Complaint Status");
        JButton adminBtn = new JButton("Admin Dashboard");
        JButton filterBtn = new JButton("Filter Complaints by Status");
        JButton exitBtn = new JButton("Exit");

        submitBtn.addActionListener(e -> submitComplaint());
        viewStatusBtn.addActionListener(e -> viewComplaintStatus());
        adminBtn.addActionListener(e -> showAdminDashboard());
        filterBtn.addActionListener(e -> filterComplaints());
        exitBtn.addActionListener(e -> frame.dispose());

        mainPanel.add(submitBtn);
        mainPanel.add(viewStatusBtn);
        mainPanel.add(adminBtn);
        mainPanel.add(filterBtn);
        mainPanel.add(exitBtn);

        frame.setContentPane(mainPanel);
        frame.revalidate();
    }

    private void showAdminDashboard() {
        JPanel adminPanel = new JPanel();
        adminPanel.setLayout(new GridLayout(3, 1, 10, 10));

        JButton viewAllBtn = new JButton("View All Complaints");
        JButton updateStatusBtn = new JButton("Update Complaint Status");
        JButton backBtn = new JButton("Back to Main Menu");

        viewAllBtn.addActionListener(e -> viewAllComplaints());
        updateStatusBtn.addActionListener(e -> updateComplaintStatus());
        backBtn.addActionListener(e -> showMainMenu());

        adminPanel.add(viewAllBtn);
        adminPanel.add(updateStatusBtn);
        adminPanel.add(backBtn);

        frame.setContentPane(adminPanel);
        frame.revalidate();
    }

    private void submitComplaint() {
        String desc = JOptionPane.showInputDialog(frame, "Enter complaint description:");
        if (desc != null && !desc.trim().isEmpty()) {
            complaints.add(new Complaint(nextId++, desc));
            JOptionPane.showMessageDialog(frame, "Complaint submitted successfully!");
        }
    }

    private void viewComplaintStatus() {
        String idStr = JOptionPane.showInputDialog(frame, "Enter complaint ID:");
        try {
            int id = Integer.parseInt(idStr);
            for (Complaint c : complaints) {
                if (c.id == id) {
                    JOptionPane.showMessageDialog(frame, "Status: " + c.status);
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "Complaint not found!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid ID!");
        }
    }

    private void filterComplaints() {
        String status = JOptionPane.showInputDialog(frame, "Enter status to filter (Open/In Progress/Closed):");
        StringBuilder sb = new StringBuilder("Filtered Complaints:\n");
        for (Complaint c : complaints) {
            if (c.status.equalsIgnoreCase(status)) {
                sb.append("ID: ").append(c.id).append(", Desc: ").append(c.description)
                        .append(", Status: ").append(c.status).append("\n");
            }
        }
        JOptionPane.showMessageDialog(frame, sb.toString());
    }

    private void viewAllComplaints() {
        StringBuilder sb = new StringBuilder("All Complaints:\n");
        for (Complaint c : complaints) {
            sb.append("ID: ").append(c.id).append(", Desc: ").append(c.description)
                    .append(", Status: ").append(c.status).append("\n");
        }
        JOptionPane.showMessageDialog(frame, sb.toString());
    }

    private void updateComplaintStatus() {
        String idStr = JOptionPane.showInputDialog(frame, "Enter complaint ID to update:");
        try {
            int id = Integer.parseInt(idStr);
            for (Complaint c : complaints) {
                if (c.id == id) {
                    String newStatus = JOptionPane.showInputDialog(frame, "Enter new status:");
                    if (newStatus != null && !newStatus.trim().isEmpty()) {
                        c.status = newStatus;
                        JOptionPane.showMessageDialog(frame, "Status updated!");
                    }
                    return;
                }
            }
            JOptionPane.showMessageDialog(frame, "Complaint not found!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Invalid ID!");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(swing::new);
    }


	}


