import javax.swing.*;

public class ResponseTrackingFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("RESQ - Response Tracking");
        frame.setSize(700, 650);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Title
        JLabel title = new JLabel("RESPONSE TRACKING");
        title.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 22));
        title.setBounds(200, 20, 500, 45);
        frame.add(title);

        // Emergency ID
        JLabel idLabel = new JLabel("Emergency ID:");
        idLabel.setBounds(50, 80, 120, 30);
        frame.add(idLabel);

        JTextField idField = new JTextField();
        idField.setBounds(170, 80, 200, 30);
        frame.add(idField);

        JButton trackButton = new JButton("Track");
        trackButton.setBounds(390, 80, 100, 30);
        frame.add(trackButton);

        // Emergency Information
        JPanel emergencyPanel = new JPanel();
        emergencyPanel.setLayout(null);
        emergencyPanel.setBorder(
            BorderFactory.createTitledBorder("Emergency Information")
        );
        emergencyPanel.setBounds(50, 130, 580, 180);
        frame.add(emergencyPanel);

        JLabel typeLabel = new JLabel("Emergency Type:");
        typeLabel.setBounds(20, 35, 130, 25);
        emergencyPanel.add(typeLabel);

        JLabel typeValue = new JLabel("Medical");
        typeValue.setBounds(160, 35, 200, 25);
        emergencyPanel.add(typeValue);

        JLabel locationLabel = new JLabel("Location:");
        locationLabel.setBounds(20, 70, 130, 25);
        emergencyPanel.add(locationLabel);

        JLabel locationValue = new JLabel("Kollam");
        locationValue.setBounds(160, 70, 200, 25);
        emergencyPanel.add(locationValue);

        JLabel priorityLabel = new JLabel("Priority:");
        priorityLabel.setBounds(20, 105, 130, 25);
        emergencyPanel.add(priorityLabel);

        JLabel priorityValue = new JLabel("HIGH");
        priorityValue.setBounds(160, 105, 200, 25);
        emergencyPanel.add(priorityValue);

        JLabel timeLabel = new JLabel("Reported Time:");
        timeLabel.setBounds(20, 140, 130, 25);
        emergencyPanel.add(timeLabel);

        JLabel timeValue = new JLabel("10:30 AM");
        timeValue.setBounds(160, 140, 200, 25);
        emergencyPanel.add(timeValue);

        // Assigned Resource
        JPanel resourcePanel = new JPanel();
        resourcePanel.setLayout(null);
        resourcePanel.setBorder(
            BorderFactory.createTitledBorder("Assigned Resource")
        );
        resourcePanel.setBounds(50, 325, 580, 120);
        frame.add(resourcePanel);

        JLabel resourceLabel = new JLabel("Resource:");
        resourceLabel.setBounds(20, 30, 120, 25);
        resourcePanel.add(resourceLabel);

        JLabel resourceValue = new JLabel("Ambulance AMB-102");
        resourceValue.setBounds(150, 30, 250, 25);
        resourcePanel.add(resourceValue);

        JLabel teamLabel = new JLabel("Team:");
        teamLabel.setBounds(20, 65, 120, 25);
        resourcePanel.add(teamLabel);

        JLabel teamValue = new JLabel("Medical Team");
        teamValue.setBounds(150, 65, 250, 25);
        resourcePanel.add(teamValue);

        // Current Status
        JLabel statusLabel = new JLabel("Current Status:");
        statusLabel.setBounds(50, 465, 120, 30);
        frame.add(statusLabel);

        JLabel statusValue = new JLabel("Dispatched");
        statusValue.setBounds(170, 465, 180, 30);
        frame.add(statusValue);

        // Response Details
        JLabel detailsLabel = new JLabel("Response Details:");
        detailsLabel.setBounds(50, 510, 130, 25);
        frame.add(detailsLabel);

        JTextArea detailsArea = new JTextArea();
        detailsArea.setText(
            "Medical team has been dispatched to the location."
        );
        detailsArea.setEditable(false);
        detailsArea.setLineWrap(true);
        detailsArea.setWrapStyleWord(true);
        detailsArea.setBounds(180, 500, 400, 60);
        frame.add(detailsArea);

        // Buttons
        JButton refreshButton = new JButton("Refresh");
        refreshButton.setBounds(200, 575, 100, 30);
        frame.add(refreshButton);

        JButton backButton = new JButton("Back");
        backButton.setBounds(320, 575, 100, 30);
        frame.add(backButton);

        frame.setVisible(true);
    }
}