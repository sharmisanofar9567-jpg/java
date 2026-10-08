import javax.swing.*;
import java.awt.*;

public class Admindashboard {

    public static void main(String[] args) {

        JFrame frame = new JFrame("RESQ - Admin Dashboard");
        frame.setSize(750, 650);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        // Title
        JLabel title = new JLabel("Admin Dashboard", JLabel.CENTER);
      
        frame.add(title, BorderLayout.NORTH);

        // Top Section
        JPanel topPanel = new JPanel(new FlowLayout());

        topPanel.add(new JLabel("Area:"));

        JComboBox<String> areaBox = new JComboBox<>(
            new String[]{"Kollam", "Kochi", "Trivandrum"}
        );
        topPanel.add(areaBox);

        topPanel.add(new JLabel("Date:"));

        JTextField dateField = new JTextField(15);
        topPanel.add(dateField);

        JButton viewButton = new JButton("View Overview");
        topPanel.add(viewButton);

        // Emergency Overview
        JPanel emergencyPanel = new JPanel(
            new GridLayout(1, 4, 10, 10)
        );

        emergencyPanel.setBorder(
            BorderFactory.createTitledBorder("Emergency Overview")
        );

        emergencyPanel.setPreferredSize(new Dimension(700, 70));

        emergencyPanel.add(
            new JLabel("Total Reported: 5", SwingConstants.CENTER)
        );
        emergencyPanel.add(
            new JLabel("Pending: 2", SwingConstants.CENTER)
        );
        emergencyPanel.add(
            new JLabel("In Progress: 1", SwingConstants.CENTER)
        );
        emergencyPanel.add(
            new JLabel("Resolved: 2", SwingConstants.CENTER)
        );

        // View Emergencies
        JPanel viewPanel = new JPanel(
            new FlowLayout(FlowLayout.LEFT, 10, 5)
        );

        viewPanel.add(new JLabel("View Emergencies:"));

        JComboBox<String> viewBox = new JComboBox<>(
            new String[]{
                "Current Emergencies",
                "Pending",
                "In Progress",
                "Resolved",
                "All Emergencies"
            }
        );

        viewPanel.add(viewBox);

        // Emergency Records
        String[] columns = {
            "ID",
            "Reported By",
            "Type",
            "Location",
            "Priority",
            "Status"
        };

        String[][] data = {
            {"E001", "Anu", "Medical", "Kollam", "High", "Pending"},
            {"E002", "Rahul", "Fire", "Kottarakkara", "High", "In Progress"},
            {"E003", "Amal", "Accident", "Karunagappally",
             "Medium", "Resolved"}
        };

        JTable table = new JTable(data, columns);
        table.setRowHeight(25);

        JPanel recordsPanel = new JPanel(new BorderLayout(5, 5));

        recordsPanel.setBorder(
            BorderFactory.createTitledBorder("Emergency Records")
        );

        JScrollPane tableScroll = new JScrollPane(table);
        tableScroll.setPreferredSize(new Dimension(700, 130));

        recordsPanel.add(tableScroll, BorderLayout.CENTER);

        // Resource Overview
        String[] resourceColumns = {
            "Resource",
            "Total",
            "Assigned",
            "Available"
        };

        String[][] resourceData = {
            {"Ambulance", "5", "2", "3"},
            {"Fire Rescue", "3", "1", "2"},
            {"Rescue Team", "4", "2", "2"},
            {"Medical Team", "3", "1", "2"}
        };

        JTable resourceTable =
            new JTable(resourceData, resourceColumns);

        resourceTable.setRowHeight(25);

        JPanel resourcePanel = new JPanel(new BorderLayout(5, 5));

        resourcePanel.setBorder(
            BorderFactory.createTitledBorder("Resource Overview")
        );

        JScrollPane resourceScroll =
            new JScrollPane(resourceTable);

        resourceScroll.setPreferredSize(
            new Dimension(700, 130)
        );

        resourcePanel.add(
            resourceScroll,
            BorderLayout.CENTER
        );

        // Center Section
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(
            new BoxLayout(centerPanel, BoxLayout.Y_AXIS)
        );

        centerPanel.setBorder(
            BorderFactory.createEmptyBorder(5, 10, 5, 10)
        );

        centerPanel.add(topPanel);
        centerPanel.add(Box.createVerticalStrut(8));

        centerPanel.add(emergencyPanel);
        centerPanel.add(Box.createVerticalStrut(5));

        centerPanel.add(viewPanel);
        centerPanel.add(Box.createVerticalStrut(5));

        centerPanel.add(recordsPanel);
        centerPanel.add(Box.createVerticalStrut(8));

        centerPanel.add(resourcePanel);

        frame.add(centerPanel, BorderLayout.CENTER);

        // Logout
        JPanel logoutPanel = new JPanel(
            new FlowLayout(FlowLayout.RIGHT)
        );

        logoutPanel.add(new JButton("Logout"));
        

        frame.add(logoutPanel, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
