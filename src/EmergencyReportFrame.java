package src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EmergencyReportFrame {

    public EmergencyReportFrame() {

        JFrame frame = new JFrame("RESQ - Emergency Reporting");
        frame.setSize(600, 500);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        // Title
        JLabel title = new JLabel("Emergency Reporting");
        title.setFont(new Font("Arial", Font.BOLD, 20));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(title, gbc);

        // Emergency Type
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(new JLabel("Emergency Type:"), gbc);

        String[] types = {
            "Medical Emergency", "Fire Incident", "Road Accident",
            "Natural Disaster", "Crime", "Other"
        };

        JComboBox<String> typeBox = new JComboBox<>(types);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        frame.add(typeBox, gbc);

        // Priority
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        frame.add(new JLabel("Severity / Priority:"), gbc);

        String[] priorities = {"Critical", "High", "Medium", "Low"};
        JComboBox<String> priorityBox = new JComboBox<>(priorities);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        frame.add(priorityBox, gbc);

        // Location
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        frame.add(new JLabel("Location:"), gbc);

        JTextField locationField = new JTextField(20);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        frame.add(locationField, gbc);

        // People Affected
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        frame.add(new JLabel("People Affected:"), gbc);

        JTextField peopleField = new JTextField(20);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        frame.add(peopleField, gbc);

        // Emergency Service
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.NONE;
        frame.add(new JLabel("Emergency Service:"), gbc);

        String[] services = {
            "Ambulance", "Fire Force", "Police",
            "Rescue Team", "Disaster Management"
        };

        JComboBox<String> serviceBox = new JComboBox<>(services);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        frame.add(serviceBox, gbc);

        // Emergency Type Event
        typeBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {

                String type = (String) typeBox.getSelectedItem();

                if ("Medical Emergency".equals(type)) {
                    serviceBox.setSelectedItem("Ambulance");
                } else if ("Fire Incident".equals(type)) {
                    serviceBox.setSelectedItem("Fire Force");
                }
            }
        });

        // Submit Button
        JButton submitButton =
                new JButton("Submit Emergency Report");

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(submitButton, gbc);

        // Back Button
        JButton backButton = new JButton("Back to Dashboard");

        gbc.gridy = 7;
        frame.add(backButton, gbc);

        // Submit Event
        submitButton.addActionListener(e -> {

            String location = locationField.getText().trim();
            String peopleText = peopleField.getText().trim();

            if (location.isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                        "Please enter the location.");
                return;
            }

            if (peopleText.isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                        "Please enter people affected.");
                return;
            }

            try {
                int people = Integer.parseInt(peopleText);

                if (people <= 0) {
                    JOptionPane.showMessageDialog(frame,
                            "People affected must be greater than zero.");
                    return;
                }

                // Generate Emergency ID
                String id = Sharedata.generateID();

                // Create Emergency Object
                Emergency emergency = new Emergency(
                        id,
                        (String) typeBox.getSelectedItem(),
                        (String) priorityBox.getSelectedItem(),
                        location,
                        people,
                        (String) serviceBox.getSelectedItem(),
                        "user"
                );

                // Save Report
                Sharedata.addEmergency(emergency);

                // Open Emergency Details
                frame.dispose();
                new EmergencyDetailsFrame(emergency);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame,
                        "Please enter a valid number of people.");
            }
        });

        // Back Event
     // Back Event
        backButton.addActionListener(e -> {
            frame.dispose();
            new UserDashboard().setVisible(true);
        });

        // Exit Confirmation
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {

                int choice = JOptionPane.showConfirmDialog(
                        frame,
                        "Are you sure you want to exit?",
                        "Confirm Exit",
                        JOptionPane.YES_NO_OPTION
                );

                if (choice == JOptionPane.YES_OPTION) {
                    frame.dispose();
                }
            }
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new EmergencyReportFrame();
    }
}
