package RESQ;  // ✅ Matches folder name RESQ

import javax.swing.*;
import java.awt.*;

public class ResourceManagement extends JFrame {

    // Labels
    JLabel titleLabel, resourceTypeLabel, totalResourceLabel, availableResourceLabel, detailsLabel;
    // ComboBox
    JComboBox<String> resourceTypeBox;
    // TextFields
    JTextField totalResourceField, availableResourceField;
    // Button
    JButton updateResourceButton;
    // Panel for resource details
    JPanel detailsPanel;

    public ResourceManagement() {
        // Frame setup
        setTitle("RESQ - Resource Management");
        setSize(600, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(25, 30, 25, 30));

        // Title at the top
        titleLabel = new JLabel("RESOURCE MANAGEMENT", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Center panel with BorderLayout
        JPanel centerPanel = new JPanel(new BorderLayout(10, 15));

        // Button panel with FlowLayout
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        updateResourceButton = new JButton("Update Resource");
        buttonPanel.add(updateResourceButton);
        centerPanel.add(buttonPanel, BorderLayout.NORTH);

        // Form panel with GridLayout
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 15));
        resourceTypeLabel = new JLabel("Resource Type:");
        resourceTypeBox = new JComboBox<>(new String[]{"Police", "Fire Force", "Ambulance", "Medical Kit"});

        totalResourceLabel = new JLabel("Total Resources:");
        totalResourceField = new JTextField("5");

        availableResourceLabel = new JLabel("Currently Available Resources:");
        availableResourceField = new JTextField("3");

        formPanel.add(resourceTypeLabel); formPanel.add(resourceTypeBox);
        formPanel.add(totalResourceLabel); formPanel.add(totalResourceField);
        formPanel.add(availableResourceLabel); formPanel.add(availableResourceField);

        centerPanel.add(formPanel, BorderLayout.CENTER);

        // Bottom panel with BorderLayout
        JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));
        detailsLabel = new JLabel("CURRENTLY AVAILABLE RESOURCE DETAILS");
        detailsLabel.setFont(new Font("Arial", Font.BOLD, 17));
        bottomPanel.add(detailsLabel, BorderLayout.NORTH);

        // Table-like details panel with GridLayout
        detailsPanel = new JPanel(new GridLayout(5, 3, 5, 5));
        detailsPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // Table headings
        detailsPanel.add(new JLabel("Resource Type"));
        detailsPanel.add(new JLabel("Total Resources"));
        detailsPanel.add(new JLabel("Currently Available"));

        // Resource rows
        detailsPanel.add(new JLabel("Police")); detailsPanel.add(new JLabel("5")); detailsPanel.add(new JLabel("3"));
        detailsPanel.add(new JLabel("Fire Force")); detailsPanel.add(new JLabel("2")); detailsPanel.add(new JLabel("1"));
        detailsPanel.add(new JLabel("Ambulance")); detailsPanel.add(new JLabel("3")); detailsPanel.add(new JLabel("2"));
        detailsPanel.add(new JLabel("Medical Kit")); detailsPanel.add(new JLabel("20")); detailsPanel.add(new JLabel("15"));

        bottomPanel.add(detailsPanel, BorderLayout.CENTER);
        centerPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Add center panel to main panel
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Add everything to frame
        add(mainPanel);
    }

    public static void main(String[] args) {
        ResourceManagement frame = new ResourceManagement();
        frame.setVisible(true);
    }
}
