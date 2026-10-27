package RESQ;  // ✅ Matches folder name RESQ

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;

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

    // Store resource data dynamically
    HashMap<String, int[]> resourceData;

    public ResourceManagement() {
        // Frame setup
        setTitle("RESQ - Resource Management");
        setSize(600, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Initialize resource data (Total, Available)
        resourceData = new HashMap<>();
        resourceData.put("Police", new int[]{5, 3});
        resourceData.put("Fire Force", new int[]{2, 1});
        resourceData.put("Ambulance", new int[]{3, 2});
        resourceData.put("Medical Kit", new int[]{20, 15});

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

        // Fill initial resource data
        refreshDetailsPanel();

        bottomPanel.add(detailsPanel, BorderLayout.CENTER);
        centerPanel.add(bottomPanel, BorderLayout.SOUTH);

        // Add center panel to main panel
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Add everything to frame
        add(mainPanel);

        // ✅ Event Handling
        updateResourceButton.addActionListener(e -> {
            try {
                String resource = (String) resourceTypeBox.getSelectedItem();
                int total = Integer.parseInt(totalResourceField.getText());
                int available = Integer.parseInt(availableResourceField.getText());

                if (available > total) {
                    JOptionPane.showMessageDialog(this,
                            "Available resources cannot exceed total!",
                            "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Update resource data
                resourceData.put(resource, new int[]{total, available});

                // Refresh details panel
                refreshDetailsPanel();

                JOptionPane.showMessageDialog(this,
                        resource + " updated!\nTotal: " + total + "\nAvailable: " + available,
                        "Update Successful", JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this,
                        "Please enter valid numbers for resources.",
                        "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        });
    }

    // Method to refresh the details panel dynamically
    private void refreshDetailsPanel() {
        detailsPanel.removeAll();

        // Table headings
        detailsPanel.add(new JLabel("Resource Type"));
        detailsPanel.add(new JLabel("Total Resources"));
        detailsPanel.add(new JLabel("Currently Available"));

        // Add updated resource rows
        for (String key : resourceData.keySet()) {
            detailsPanel.add(new JLabel(key));
            detailsPanel.add(new JLabel(String.valueOf(resourceData.get(key)[0])));
            detailsPanel.add(new JLabel(String.valueOf(resourceData.get(key)[1])));
        }

        // Refresh UI
        detailsPanel.revalidate();
        detailsPanel.repaint();
    }

    public static void main(String[] args) {
        ResourceManagement frame = new ResourceManagement();
        frame.setVisible(true);
    }
}
