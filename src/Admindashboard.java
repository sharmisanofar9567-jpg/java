import javax.swing.*;

public class Admindashboard {

    public static void main(String[] args) {

        JFrame frame = new JFrame("RESQ - Admin Dashboard");
        frame.setSize(750, 650);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Title

        JLabel title = new JLabel("Admin Dashboard");
        title.setBounds(270, 20, 250, 30);
        frame.add(title);


        // Area

        JLabel areaLabel = new JLabel("Area:");
        areaLabel.setBounds(50, 65, 50, 30);
        frame.add(areaLabel);

        JComboBox<String> areaBox = new JComboBox<String>();

        areaBox.addItem("Kollam");
        areaBox.addItem("Kochi");
        areaBox.addItem("Trivandrum");

        areaBox.setBounds(100, 65, 130, 30);
        frame.add(areaBox);


        // Date

        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setBounds(270, 65, 50, 30);
        frame.add(dateLabel);

        JTextField dateField = new JTextField();
        dateField.setBounds(320, 65, 130, 30);
        frame.add(dateField);


        // View Overview

        JButton viewButton = new JButton("View Overview");
        viewButton.setBounds(480, 65, 130, 30);
        frame.add(viewButton);


        // Emergency Overview

        JPanel emergencyPanel = new JPanel();
        emergencyPanel.setLayout(null);
        emergencyPanel.setBorder(
            BorderFactory.createTitledBorder("Emergency Overview")
        );
        emergencyPanel.setBounds(40, 115, 660, 100);
        frame.add(emergencyPanel);


        JLabel totalLabel = new JLabel("Total Reported: 5");
        totalLabel.setBounds(20, 35, 130, 30);
        emergencyPanel.add(totalLabel);

        JLabel pendingLabel = new JLabel("Pending: 2");
        pendingLabel.setBounds(170, 35, 110, 30);
        emergencyPanel.add(pendingLabel);

        JLabel progressLabel = new JLabel("In Progress: 1");
        progressLabel.setBounds(300, 35, 120, 30);
        emergencyPanel.add(progressLabel);

        JLabel resolvedLabel = new JLabel("Resolved: 2");
        resolvedLabel.setBounds(440, 35, 120, 30);
        emergencyPanel.add(resolvedLabel);


        // View Emergencies

        JLabel viewLabel = new JLabel("View Emergencies:");
        viewLabel.setBounds(40, 230, 130, 30);
        frame.add(viewLabel);

        JComboBox<String> viewBox = new JComboBox<String>();

        viewBox.addItem("Current Emergencies");
        viewBox.addItem("Pending");
        viewBox.addItem("In Progress");
        viewBox.addItem("Resolved");
        viewBox.addItem("All Emergencies");

        viewBox.setBounds(170, 230, 180, 30);
        frame.add(viewBox);


        // Emergency Records

        JLabel recordsLabel = new JLabel("Emergency Records");
        recordsLabel.setBounds(40, 270, 180, 30);
        frame.add(recordsLabel);


        String[] columns = {
            "ID",
            "Reported By",
            "Type",
            "Location",
            "Priority",
            "Status"
        };


        String[][] data = {
            {"E001", "Anu", "Medical", "Kollam",
             "High", "Pending"},

            {"E002", "Rahul", "Fire", "Kottarakkara",
             "High", "In Progress"},

            {"E003", "Amal", "Accident", "Karunagappally",
             "Medium", "Resolved"}
        };


        JTable table = new JTable(data, columns);

        JScrollPane tableScroll = new JScrollPane(table);
        tableScroll.setBounds(40, 305, 660, 90);

        frame.add(tableScroll);


        // Resource Overview

        JPanel resourcePanel = new JPanel();
        resourcePanel.setLayout(null);
        resourcePanel.setBorder(
            BorderFactory.createTitledBorder("Resource Overview")
        );
        resourcePanel.setBounds(40, 410, 660, 155);
        frame.add(resourcePanel);


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


        JScrollPane resourceScroll =
            new JScrollPane(resourceTable);

        resourceScroll.setBounds(20, 30, 600, 100);

        resourcePanel.add(resourceScroll);


        // Logout

        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(580, 580, 100, 30);
        frame.add(logoutButton);


        frame.setVisible(true);
    }
}