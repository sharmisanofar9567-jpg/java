package ui;

import javax.swing.*;
import java.awt.*;

public class EmergencyReportFrame extends JFrame {

    public EmergencyReportFrame() {

        // ---------------- FRAME ----------------

        setTitle("RESQ - Emergency Reporting");
        setSize(650, 720);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        // ---------------- HEADER ----------------

        JPanel headerPanel = new JPanel();
        headerPanel.setBackground(new Color(52, 73, 94));
        headerPanel.setPreferredSize(new Dimension(650, 80));
        headerPanel.setLayout(new BorderLayout());

        JLabel titleLabel = new JLabel("Emergency Reporting");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 25));
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel subtitleLabel = new JLabel(
                "Please provide the details of the emergency"
        );
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 13));
        subtitleLabel.setForeground(new Color(230, 230, 230));
        subtitleLabel.setHorizontalAlignment(SwingConstants.CENTER);

        headerPanel.add(titleLabel, BorderLayout.CENTER);
        headerPanel.add(subtitleLabel, BorderLayout.SOUTH);

        add(headerPanel, BorderLayout.NORTH);

        // ---------------- MAIN FORM ----------------

        JPanel formPanel = new JPanel(new GridBagLayout());
        formPanel.setBackground(new Color(248, 249, 250));
        formPanel.setBorder(
                BorderFactory.createEmptyBorder(15, 30, 15, 30)
        );

        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(6, 8, 6, 8);
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.anchor = GridBagConstraints.WEST;

        // ---------------- EMERGENCY TYPE ----------------

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 0;

        JLabel typeLabel = new JLabel("Emergency Type:");
        typeLabel.setFont(new Font("Arial", Font.BOLD, 14));

        formPanel.add(typeLabel, gbc);

        gbc.gridx = 1;
        gbc.weightx = 1;

        String[] emergencyTypes = {
                "Select Emergency Type",
                "Medical Emergency",
                "Fire Incident",
                "Road Accident",
                "Natural Disaster",
                "Crime",
                "Other"
        };

        JComboBox<String> emergencyTypeBox =
                new JComboBox<>(emergencyTypes);

        formPanel.add(emergencyTypeBox, gbc);

        // ---------------- LOCATION ----------------

        gbc.gridx = 0;
        gbc.gridy = 1;

        JLabel locationLabel =
                new JLabel("Location / Address:");

        locationLabel.setFont(new Font("Arial", Font.BOLD, 14));

        formPanel.add(locationLabel, gbc);

        gbc.gridx = 1;

        JTextField locationField = new JTextField();
        locationField.setPreferredSize(new Dimension(300, 30));

        formPanel.add(locationField, gbc);

        // ---------------- DATE ----------------

        gbc.gridx = 0;
        gbc.gridy = 2;

        JLabel dateLabel = new JLabel("Date:");
        dateLabel.setFont(new Font("Arial", Font.BOLD, 14));

        formPanel.add(dateLabel, gbc);

        gbc.gridx = 1;

        JTextField dateField =
                new JTextField("DD / MM / YYYY");

        formPanel.add(dateField, gbc);

        // ---------------- TIME ----------------

        gbc.gridx = 0;
        gbc.gridy = 3;

        JLabel timeLabel = new JLabel("Time:");
        timeLabel.setFont(new Font("Arial", Font.BOLD, 14));

        formPanel.add(timeLabel, gbc);

        gbc.gridx = 1;

        JTextField timeField =
                new JTextField("HH : MM");

        formPanel.add(timeField, gbc);

        // ---------------- PRIORITY ----------------

        gbc.gridx = 0;
        gbc.gridy = 4;

        JLabel priorityLabel =
                new JLabel("Severity / Priority:");

        priorityLabel.setFont(new Font("Arial", Font.BOLD, 14));

        formPanel.add(priorityLabel, gbc);

        gbc.gridx = 1;

        String[] priorityLevels = {
                "Select Priority",
                "Critical",
                "High",
                "Medium",
                "Low"
        };

        JComboBox<String> priorityBox =
                new JComboBox<>(priorityLevels);

        formPanel.add(priorityBox, gbc);

        // ---------------- PEOPLE AFFECTED ----------------

        gbc.gridx = 0;
        gbc.gridy = 5;

        JLabel peopleLabel =
                new JLabel("People Affected:");

        peopleLabel.setFont(new Font("Arial", Font.BOLD, 14));

        formPanel.add(peopleLabel, gbc);

        gbc.gridx = 1;

        JTextField peopleField = new JTextField();

        formPanel.add(peopleField, gbc);

        // ---------------- WHAT HAPPENED ----------------

        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.anchor = GridBagConstraints.NORTHWEST;

        JLabel descriptionLabel =
                new JLabel("What happened?");

        descriptionLabel.setFont(new Font("Arial", Font.BOLD, 14));

        formPanel.add(descriptionLabel, gbc);

        gbc.gridx = 1;
        gbc.fill = GridBagConstraints.BOTH;

        JTextArea descriptionArea =
                new JTextArea(4, 25);

        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        descriptionArea.setFont(
                new Font("Arial", Font.PLAIN, 13)
        );

        JScrollPane descriptionScrollPane =
                new JScrollPane(descriptionArea);

        formPanel.add(descriptionScrollPane, gbc);

        // Example text
        gbc.gridx = 1;
        gbc.gridy = 7;

        JLabel exampleLabel = new JLabel(
                "Example: Road accident near the bus stop..."
        );

        exampleLabel.setFont(
                new Font("Arial", Font.ITALIC, 11)
        );

        exampleLabel.setForeground(
                new Color(100, 100, 100)
        );

        formPanel.add(exampleLabel, gbc);

        // ---------------- PHOTO / EVIDENCE ----------------

        gbc.gridx = 0;
        gbc.gridy = 8;

        JLabel photoLabel =
                new JLabel("Photo / Evidence:");

        photoLabel.setFont(new Font("Arial", Font.BOLD, 14));

        formPanel.add(photoLabel, gbc);

        gbc.gridx = 1;

        JPanel photoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        photoPanel.setOpaque(false);

        JButton uploadButton =
                new JButton("Choose File");

        JLabel optionalLabel =
                new JLabel("  (Optional)");

        optionalLabel.setFont(
                new Font("Arial", Font.ITALIC, 12)
        );

        optionalLabel.setForeground(
                new Color(100, 100, 100)
        );

        photoPanel.add(uploadButton);
        photoPanel.add(optionalLabel);

        formPanel.add(photoPanel, gbc);

        // ---------------- REPORTER NAME ----------------

        gbc.gridx = 0;
        gbc.gridy = 9;

        JLabel nameLabel =
                new JLabel("Reporter Name:");

        nameLabel.setFont(new Font("Arial", Font.BOLD, 14));

        formPanel.add(nameLabel, gbc);

        gbc.gridx = 1;

        JTextField nameField = new JTextField();

        formPanel.add(nameField, gbc);

        // ---------------- CONTACT NUMBER ----------------

        gbc.gridx = 0;
        gbc.gridy = 10;

        JLabel contactLabel =
                new JLabel("Contact Number:");

        contactLabel.setFont(new Font("Arial", Font.BOLD, 14));

        formPanel.add(contactLabel, gbc);

        gbc.gridx = 1;

        JTextField contactField = new JTextField();

        formPanel.add(contactField, gbc);

        // ---------------- EMERGENCY SERVICE ----------------

        gbc.gridx = 0;
        gbc.gridy = 11;

        JLabel serviceLabel =
                new JLabel("Emergency Service:");

        serviceLabel.setFont(new Font("Arial", Font.BOLD, 14));

        formPanel.add(serviceLabel, gbc);

        gbc.gridx = 1;

        String[] services = {
                "Select Service",
                "Police",
                "Ambulance",
                "Fire & Rescue",
                "Disaster Management"
        };

        JComboBox<String> serviceBox =
                new JComboBox<>(services);

        formPanel.add(serviceBox, gbc);

        add(formPanel, BorderLayout.CENTER);

        // ---------------- BUTTON PANEL ----------------

        JPanel buttonPanel = new JPanel();
        buttonPanel.setBackground(new Color(248, 249, 250));
        buttonPanel.setBorder(
                BorderFactory.createEmptyBorder(5, 10, 15, 10)
        );

        JButton submitButton =
                new JButton("Submit Emergency Report");

        submitButton.setFont(
                new Font("Arial", Font.BOLD, 14)
        );

        submitButton.setForeground(Color.WHITE);
        submitButton.setBackground(
                new Color(39, 125, 161)
        );

        submitButton.setFocusPainted(false);

        buttonPanel.add(submitButton);

        add(buttonPanel, BorderLayout.SOUTH);
    }

    // ---------------- MAIN METHOD ----------------

    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {

            EmergencyReportFrame frame =
                    new EmergencyReportFrame();

            frame.setVisible(true);
        });
    }
}