package src;

import javax.swing.*;
import java.awt.*;

public class ResourceAllocation extends JFrame {

    JLabel emergencyLabel, resourceLabel, availableLabel;
    JLabel allocateLabel, priorityLabel, locationLabel;

    JTextField emergencyField, availableField;
    JTextField allocateField, locationField;

    JComboBox<String> resourceBox, priorityBox;
    JButton allocateButton, clearButton;

    public ResourceAllocation() {

        setTitle("RESQ - Resource Allocation");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel formPanel = new JPanel(new GridLayout(6, 2, 10, 10));

        // Emergency ID
        emergencyLabel = new JLabel("Emergency ID:");
        emergencyField = new JTextField("E001");

        // Resource Type
        resourceLabel = new JLabel("Resource Type:");
        resourceBox = new JComboBox<>(new String[]{
            "Police", "Fire Force", "Ambulance", "Medical Kit"
        });

        // Available Quantity
        availableLabel = new JLabel("Available Quantity:");
        availableField = new JTextField();
        availableField.setEditable(false);

        // Allocate Quantity
        allocateLabel = new JLabel("Allocate Quantity:");
        allocateField = new JTextField("2");

        // Priority
        priorityLabel = new JLabel("Priority:");
        priorityBox = new JComboBox<>(new String[]{
            "Normal", "High", "Severe", "Extreme"
        });

        // Location
        locationLabel = new JLabel("Location:");
        locationField = new JTextField("Kollam");

        formPanel.add(emergencyLabel);
        formPanel.add(emergencyField);
        formPanel.add(resourceLabel);
        formPanel.add(resourceBox);
        formPanel.add(availableLabel);
        formPanel.add(availableField);
        formPanel.add(allocateLabel);
        formPanel.add(allocateField);
        formPanel.add(priorityLabel);
        formPanel.add(priorityBox);
        formPanel.add(locationLabel);
        formPanel.add(locationField);

        // Buttons
        JPanel buttonPanel =
                new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 10));

        allocateButton = new JButton("Allocate");
        clearButton = new JButton("Clear");

        buttonPanel.add(allocateButton);
        buttonPanel.add(clearButton);

        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);
        add(mainPanel);

        // Show available stock
        updateAvailableQuantity();

        resourceBox.addActionListener(e -> updateAvailableQuantity());

        // Allocate button
        allocateButton.addActionListener(e -> allocateResource());

        // Clear button
        clearButton.addActionListener(e -> {
            emergencyField.setText("");
            allocateField.setText("");
            locationField.setText("");
            resourceBox.setSelectedIndex(0);
            priorityBox.setSelectedIndex(0);
            updateAvailableQuantity();
        });
    }

    // Update available quantity
    private void updateAvailableQuantity() {
        String resource = resourceBox.getSelectedItem().toString();

        availableField.setText(
                String.valueOf(Resourcedata.getAvailable(resource)));
    }

    // Allocate resource
    private void allocateResource() {

        String id = emergencyField.getText();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this, "Please enter Emergency ID.");
            return;
        }

        Emergency emergency = Sharedata.findEmergency(id);

        if (emergency == null) {
            JOptionPane.showMessageDialog(
                    this,
                    "Emergency ID not found!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Do not allocate to resolved incidents
        if ("Resolved".equalsIgnoreCase(emergency.status)) {
            JOptionPane.showMessageDialog(
                    this,
                    "Resolved incidents cannot be allocated resources.",
                    "Allocation Not Allowed",
                    JOptionPane.WARNING_MESSAGE);
            dispose();
            return;
        }

        // Prevent duplicate allocation for the same incident
        if (Resourcedata.findResource(id) != null) {
            JOptionPane.showMessageDialog(
                    this,
                    "A resource is already allocated to this incident.",
                    "Allocation Not Allowed",
                    JOptionPane.WARNING_MESSAGE);
            return;
        }

        String resource = resourceBox.getSelectedItem().toString();

        int quantity;

        try {
            quantity = Integer.parseInt(allocateField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid number for allocation.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int available = Resourcedata.getAvailable(resource);

        if (quantity <= 0 || quantity > available) {
            JOptionPane.showMessageDialog(
                    this,
                    "Invalid quantity! Available quantity: " + available,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Deduct from shared stock
        boolean success = Resourcedata.allocateStock(resource, quantity);

        if (!success) {
            JOptionPane.showMessageDialog(
                    this,
                    "Resource is not available in sufficient quantity.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            updateAvailableQuantity();
            return;
        }

        // Save allocated resource
        Resourcedata.addResource(id, resource, quantity);

        // Update emergency status
        emergency.status = "Resources Allocated";

        updateAvailableQuantity();

        JOptionPane.showMessageDialog(
                this,
                "Resources allocated successfully!\n"
                + "Emergency ID: " + id
                + "\nResource: " + resource
                + "\nQuantity: " + quantity
                + "\nPriority: " + priorityBox.getSelectedItem()
                + "\nLocation: " + locationField.getText());

    }

    public static void main(String[] args) {
        ResourceAllocation frame = new ResourceAllocation();
        frame.setVisible(true);
    }
}
