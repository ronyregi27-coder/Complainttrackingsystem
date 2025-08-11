package ict.kerela.complaints.tracker;

import java.util.*;

// Represents a single complaint
class Complaint {
    int id;              // Unique complaint ID
    String description;  // Complaint details
    String status;       // Complaint status (e.g., Open, Closed, In Progress)

    // Constructor to initialize complaint details (default status is "Open")
    Complaint(int id, String description) {
        this.id = id;
        this.description = description;
        this.status = "Open";
    }

    // Displays complaint details
    public void display() {
        System.out.println("ID: " + id + " | Description: " + description + " | Status: " + status);
    }
}

// Manages all complaint operations
class ComplaintManager {
    List<Complaint> complaints = new ArrayList<>(); // Stores all complaints
    int complaintCounter = 1; // Tracks and generates unique IDs

    // Adds a new complaint
    public void addComplaint(String description) {
        Complaint c = new Complaint(complaintCounter++, description);
        complaints.add(c);
        System.out.println("Complaint registered with ID: " + c.id);
    }

    // Displays status of a complaint by ID
    public void showStatus(int id) {
        for (Complaint c : complaints) {
            if (c.id == id) {
                c.display();
                return;
            }
        }
        System.out.println("Complaint ID not found.");
    }

    // Displays all complaints
    public void showAllComplaints() {
        if (complaints.isEmpty()) {
            System.out.println("No complaints found.");
        } else {
            for (Complaint c : complaints) {
                c.display();
            }
        }
    }

    // Updates status of a complaint by ID
    public void updateStatus(int id, String newStatus) {
        for (Complaint c : complaints) {
            if (c.id == id) {
                c.status = newStatus;
                System.out.println("Status updated.");
                return;
            }
        }
        System.out.println("Complaint ID not found.");
    }

    // Displays complaints filtered by status
    public void filterComplaints(String status) {
        for (Complaint c : complaints) {
            if (c.status.equalsIgnoreCase(status)) {
                c.display();
            }
        }
    }
}

// Main application class
public class Complainttracking {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ComplaintManager manager = new ComplaintManager();
        int choice;

        // Main menu loop
        do {
            System.out.println("\n--- Complaint Tracking System ---");
            System.out.println("1. Submit Complaint");
            System.out.println("2. View Complaint Status");
            System.out.println("3. Admin Dashboard");
            System.out.println("4. Filter Complaints by Status");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // Clear input buffer

            switch (choice) {
                case 1:
                    // Add a new complaint
                    System.out.print("Enter complaint description: ");
                    String desc = sc.nextLine();
                    manager.addComplaint(desc);
                    break;

                case 2:
                    // View specific complaint status
                    System.out.print("Enter complaint ID: ");
                    int id = sc.nextInt();
                    manager.showStatus(id);
                    break;

                case 3:
                    //view Admin dashboard
                    int adminChoice;
                    do {
                        System.out.println("\n--- Admin Dashboard ---");
                        System.out.println("1. View All Complaints");
                        System.out.println("2. Update Complaint Status");
                        System.out.println("3. Back to Main Menu");
                        System.out.print("Enter choice: ");
                        adminChoice = sc.nextInt();
                        sc.nextLine(); 

                        switch (adminChoice) {
                            case 1:
                                // Display all complaints
                                manager.showAllComplaints();
                                break;

                            case 2:
                                // Update complaint status
                                System.out.print("Enter complaint ID: ");
                                int compId = sc.nextInt();
                                sc.nextLine();
                                System.out.print("Enter new status: ");
                                String newStatus = sc.nextLine();
                                manager.updateStatus(compId, newStatus);
                                break;

                            case 3:
                                // Return to main menu
                                break;

                            default:
                                System.out.println("Invalid choice.");
                        }

                    } while (adminChoice != 3);
                    break;

                case 4:
                    // Filter complaints by status
                    System.out.print("Enter status to filter (Open/Closed/In Progress): ");
                    String filterStatus = sc.nextLine();
                    manager.filterComplaints(filterStatus);
                    break;

                case 5:
                    // Exit program
                    System.out.println("Exiting system...");
                    break;

                default:
                    System.out.println("Invalid choice.");
            }

        } while (choice != 5);
    }
}
