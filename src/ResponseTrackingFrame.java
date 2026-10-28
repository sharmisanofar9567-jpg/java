package src;

import javax.swing.*;
import java.awt.*;

public class ResponseTrackingFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("RESQ - Response Tracking");

        frame.setSize(700, 650);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        // Title
        JLabel title = new JLabel("RESPONSE TRACKING");

        JPanel titlePanel =
                new JPanel(new FlowLayout(FlowLayout.CENTER));

        titlePanel.add(title);
        frame.add(titlePanel, BorderLayout.NORTH);

        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(
                new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        // Emergency ID
        JPanel searchPanel =
                new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel idLabel = new JLabel("Emergency ID:");
        JTextField idField = new JTextField(15);
        JButton trackButton = new JButton("Track");

        searchPanel.add(idLabel);
        searchPanel.add(idField);
        searchPanel.add(trackButton);

        mainPanel.add(searchPanel);

        // Emergency Information
        JPanel emergencyPanel = new JPanel(new GridLayout(3, 2));

        emergencyPanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Emergency Information"));

        JLabel typeLabel = new JLabel("Emergency Type:");
        JLabel typeValue = new JLabel("-");

        JLabel locationLabel = new JLabel("Location:");
        JLabel locationValue = new JLabel("-");

        JLabel priorityLabel = new JLabel("Priority:");
        JLabel priorityValue = new JLabel("-");

        emergencyPanel.add(typeLabel);
        emergencyPanel.add(typeValue);
        emergencyPanel.add(locationLabel);
        emergencyPanel.add(locationValue);
        emergencyPanel.add(priorityLabel);
        emergencyPanel.add(priorityValue);

        mainPanel.add(emergencyPanel);

        // Assigned Resource
        JPanel resourcePanel = new JPanel(new GridLayout(2, 2));

        resourcePanel.setBorder(
                BorderFactory.createTitledBorder(
                        "Assigned Resource"));

        JLabel resourceLabel = new JLabel("Resource:");
        JLabel resourceValue = new JLabel("-");

        JLabel quantityLabel = new JLabel("Quantity:");
        JLabel quantityValue = new JLabel("-");

        resourcePanel.add(resourceLabel);
        resourcePanel.add(resourceValue);
        resourcePanel.add(quantityLabel);
        resourcePanel.add(quantityValue);

        mainPanel.add(resourcePanel);

        // Current Status
        JPanel statusPanel =
                new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel statusLabel = new JLabel("Current Status:");
        JLabel statusValue = new JLabel("-");

        statusPanel.add(statusLabel);
        statusPanel.add(statusValue);

        mainPanel.add(statusPanel);

        frame.add(mainPanel, BorderLayout.CENTER);

        // Track Button
        trackButton.addActionListener(e -> {

            try {
                String id = idField.getText();

                if (id.isEmpty()) {
                    JOptionPane.showMessageDialog(
                            frame,
                            "Please enter Emergency ID.");
                    return;
                }

                // Find emergency using Emergency ID
                Emergency emergency = Sharedata.findEmergency(id);

                if (emergency != null) {

                    // Display emergency details
                    typeValue.setText(emergency.emergencyType);
                    locationValue.setText(emergency.location);
                    priorityValue.setText(emergency.priority);

                    // Display current status
                    statusValue.setText(emergency.status);

                    // Find allocated resource for this Emergency ID
                    String[] resource =
                            Resourcedata.findResource(
                                    emergency.emergencyID);

                    if (resource != null) {

                        resourceValue.setText(resource[1]);
                        quantityValue.setText(resource[2]);

                    } else {

                        resourceValue.setText("Not allocated yet");
                        quantityValue.setText("-");
                    }

                } else {

                    typeValue.setText("-");
                    locationValue.setText("-");
                    priorityValue.setText("-");
                    resourceValue.setText("-");
                    quantityValue.setText("-");
                    statusValue.setText("-");

                    JOptionPane.showMessageDialog(
                            frame,
                            "Emergency ID not found!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }

            } catch (Exception ex) {

                JOptionPane.showMessageDialog(
                        frame,
                        "An error occurred while tracking the emergency.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        // Refresh and Back Buttons
        JPanel buttonPanel =
                new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton refreshButton = new JButton("Refresh");
        JButton backButton = new JButton("Back");

        buttonPanel.add(refreshButton);
        buttonPanel.add(backButton);

        refreshButton.addActionListener(e -> {

            idField.setText("");
            typeValue.setText("-");
            locationValue.setText("-");
            priorityValue.setText("-");
            resourceValue.setText("-");
            quantityValue.setText("-");
            statusValue.setText("-");
        });

        backButton.addActionListener(e -> {

            frame.dispose();
            new UserDashboard().setVisible(true);
        });

        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
