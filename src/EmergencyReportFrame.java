package src;
import java.awt.*;
import javax.swing.*;

public class EmergencyReportFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("RESQ - Emergency Reporting");

        frame.setSize(650, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        // Title
        JPanel titlePanel = new JPanel();

        JLabel title = new JLabel("Emergency Reporting");

        titlePanel.add(title);

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;

        frame.add(titlePanel, gbc);

        // Emergency Type
        JLabel typeLabel =
                new JLabel("Emergency Type:");

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        frame.add(typeLabel, gbc);

        String[] types = {
            "Medical Emergency",
            "Fire Incident",
            "Road Accident",
            "Natural Disaster",
            "Crime",
            "Other"
        };

        JComboBox<String> typeBox =
                new JComboBox<>(types);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        frame.add(typeBox, gbc);

        // Severity / Priority
        JLabel priorityLabel =
                new JLabel("Severity / Priority:");

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;

        frame.add(priorityLabel, gbc);

        String[] priorities = {
            "Critical",
            "High",
            "Medium",
            "Low"
        };

        JComboBox<String> priorityBox =
                new JComboBox<>(priorities);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        frame.add(priorityBox, gbc);

        // People Affected
        JLabel peopleLabel =
                new JLabel("People Affected:");

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;

        frame.add(peopleLabel, gbc);

        JTextField peopleField =
                new JTextField();

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        frame.add(peopleField, gbc);

        // Photo / Evidence
        JLabel photoLabel =
                new JLabel("Photo / Evidence:");

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;

        frame.add(photoLabel, gbc);

        JButton photoButton =
                new JButton("Choose File");

        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.WEST;

        frame.add(photoButton, gbc);

        // Emergency Service
        JLabel serviceLabel =
                new JLabel("Emergency Service:");

        gbc.gridx = 0;
        gbc.gridy = 5;

        frame.add(serviceLabel, gbc);

        String[] services = {
            "Ambulance",
            "Fire Force",
            "Police",
            "Rescue Team",
            "Disaster Management"
        };

        JComboBox<String> serviceBox =
                new JComboBox<>(services);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        frame.add(serviceBox, gbc);

        // Submit Button
        JButton submitButton =
                new JButton("Submit Emergency Report");

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        frame.add(submitButton, gbc);

        // Show Frame
        frame.setVisible(true);
    }
}