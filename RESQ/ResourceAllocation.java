package RESQ;  // ✅ Must match folder name RESQ

import javax.swing.*;
import java.awt.*;

public class ResourceAllocation extends JFrame {

    // Labels
    JLabel emergencyLabel, resourceLabel, availableLabel, allocateLabel, priorityLabel, locationLabel;
    // Text fields
    JTextField emergencyField, availableField, allocateField, locationField;
    // Combo boxes
    JComboBox<String> resourceBox, priorityBox;
    // Buttons
    JButton allocateButton, clearButton;

    public ResourceAllocation() {
        // Window setup
        setTitle("RESQ - Resource Allocation");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        // Form panel with GridLayout (rows × columns)
        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));

        // Emergency ID
        emergencyLabel = new JLabel("Emergency ID:");
        emergencyField = new JTextField("E001");

        // Resource Type
        resourceLabel = new JLabel("Resource Type:");
        resourceBox = new JComboBox<>(new String[]{"Police", "Fire Force", "Ambulance", "Medical Kit"});

        // Available Quantity
        availableLabel = new JLabel("Available Quantity:");
        availableField = new JTextField("5");
        availableField.setEditable(false); // cannot edit

        // Allocate Quantity
        allocateLabel = new JLabel("Allocate Quantity:");
        allocateField = new JTextField("2");

        // Priority
        priorityLabel = new JLabel("Priority:");
        priorityBox = new JComboBox<>(new String[]{"Normal", "High", "Severe", "Extreme"});

        // Location
        locationLabel = new JLabel("Location:");
        locationField = new JTextField("Kollam");

        // Add all fields to form panel
        formPanel.add(emergencyLabel); formPanel.add(emergencyField);
        formPanel.add(resourceLabel); formPanel.add(resourceBox);
        formPanel.add(availableLabel); formPanel.add(availableField);
        formPanel.add(allocateLabel); formPanel.add(allocateField);
        formPanel.add(priorityLabel); formPanel.add(priorityBox);
        formPanel.add(locationLabel); formPanel.add(locationField);

        // Buttons panel with FlowLayout
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));
        allocateButton = new JButton("Allocate");
        clearButton = new JButton("Clear");
        buttonPanel.add(allocateButton);
        buttonPanel.add(clearButton);

        // Add panels to main layout
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add main panel to frame
        add(mainPanel);
    }

    public static void main(String[] args) {
        ResourceAllocation frame = new ResourceAllocation();
        frame.setVisible(true);
    }
}
