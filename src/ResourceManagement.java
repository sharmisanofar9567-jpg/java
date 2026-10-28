package src;

import javax.swing.*;
import java.awt.*;

public class ResourceManagement extends JFrame {

    JLabel titleLabel, resourceTypeLabel;
    JLabel totalResourceLabel, availableResourceLabel;
    JLabel detailsLabel;

    JComboBox<String> resourceTypeBox;
    JTextField totalResourceField, availableResourceField;

    JButton updateResourceButton, refreshButton;
    JPanel detailsPanel;

    String[] resources = {
        "Police", "Fire Force", "Ambulance", "Medical Kit"
    };

    public ResourceManagement() {

        setTitle("RESQ - Resource Management");
        setSize(600, 550);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(15, 15));
        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(25, 30, 25, 30));

        // Title
        titleLabel = new JLabel(
                "RESOURCE MANAGEMENT", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));

        mainPanel.add(titleLabel, BorderLayout.NORTH);

        JPanel centerPanel = new JPanel(new BorderLayout(10, 15));

        // Buttons
        JPanel buttonPanel =
                new JPanel(new FlowLayout(FlowLayout.CENTER));

        updateResourceButton = new JButton("Update Resource");
        refreshButton = new JButton("Refresh");

        buttonPanel.add(updateResourceButton);
        buttonPanel.add(refreshButton);

        centerPanel.add(buttonPanel, BorderLayout.NORTH);

        // Form
        JPanel formPanel = new JPanel(new GridLayout(3, 2, 10, 15));

        resourceTypeLabel = new JLabel("Resource Type:");
        resourceTypeBox = new JComboBox<>(resources);

        totalResourceLabel = new JLabel("Total Resources:");
        totalResourceField = new JTextField();

        availableResourceLabel =
                new JLabel("Currently Available Resources:");
        availableResourceField = new JTextField();
        availableResourceField.setEditable(false);

        formPanel.add(resourceTypeLabel);
        formPanel.add(resourceTypeBox);
        formPanel.add(totalResourceLabel);
        formPanel.add(totalResourceField);
        formPanel.add(availableResourceLabel);
        formPanel.add(availableResourceField);

        centerPanel.add(formPanel, BorderLayout.CENTER);

        // Details section
        JPanel bottomPanel = new JPanel(new BorderLayout(10, 10));

        detailsLabel = new JLabel(
                "CURRENTLY AVAILABLE RESOURCE DETAILS");
        detailsLabel.setFont(new Font("Arial", Font.BOLD, 17));

        bottomPanel.add(detailsLabel, BorderLayout.NORTH);

        detailsPanel = new JPanel(new GridLayout(5, 3, 5, 5));
        detailsPanel.setBorder(
                BorderFactory.createLineBorder(Color.GRAY));

        bottomPanel.add(detailsPanel, BorderLayout.CENTER);
        centerPanel.add(bottomPanel, BorderLayout.SOUTH);

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        add(mainPanel);

        // Show selected resource
        showSelectedResource();

        resourceTypeBox.addActionListener(e -> showSelectedResource());

        // Update total stock
        updateResourceButton.addActionListener(e -> updateResource());

        // Refresh stock details
        refreshButton.addActionListener(e -> {
            showSelectedResource();
            refreshDetailsPanel();
        });

        refreshDetailsPanel();
    }

    // Display selected resource quantities
    private void showSelectedResource() {

        String resource = resourceTypeBox.getSelectedItem().toString();
        int[] stock = Resourcedata.stockData.get(resource);

        if (stock != null) {
            totalResourceField.setText(String.valueOf(stock[0]));
            availableResourceField.setText(String.valueOf(stock[1]));
        }
    }

    // Update total resources
    private void updateResource() {

        String resource = resourceTypeBox.getSelectedItem().toString();

        int newTotal;

        try {
            newTotal = Integer.parseInt(totalResourceField.getText());
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(
                    this,
                    "Please enter a valid Total Resources number.",
                    "Input Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        int[] stock = Resourcedata.stockData.get(resource);

        if (stock == null) {
            JOptionPane.showMessageDialog(
                    this, "Resource not found.");
            return;
        }

        if (newTotal < 0) {
            JOptionPane.showMessageDialog(
                    this,
                    "Total Resources cannot be negative.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Calculate how many resources are already allocated
        int alreadyAllocated = stock[0] - stock[1];

        if (newTotal < alreadyAllocated) {
            JOptionPane.showMessageDialog(
                    this,
                    "Total cannot be less than already allocated quantity: "
                    + alreadyAllocated,
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Available = new total - already allocated
        int newAvailable = newTotal - alreadyAllocated;

        Resourcedata.updateStock(resource, newTotal, newAvailable);

        showSelectedResource();
        refreshDetailsPanel();

        JOptionPane.showMessageDialog(
                this,
                resource + " updated successfully!\n"
                + "Total Resources: " + newTotal
                + "\nCurrently Available: " + newAvailable);
    }

    // Display all resource stocks
    private void refreshDetailsPanel() {

        detailsPanel.removeAll();

        detailsPanel.add(new JLabel("Resource Type"));
        detailsPanel.add(new JLabel("Total Resources"));
        detailsPanel.add(new JLabel("Currently Available"));

        for (String resource : resources) {

            int[] stock = Resourcedata.stockData.get(resource);

            if (stock != null) {
                detailsPanel.add(new JLabel(resource));
                detailsPanel.add(new JLabel(String.valueOf(stock[0])));
                detailsPanel.add(new JLabel(String.valueOf(stock[1])));
            } else {
                detailsPanel.add(new JLabel(resource));
                detailsPanel.add(new JLabel("0"));
                detailsPanel.add(new JLabel("0"));
            }
        }

        detailsPanel.revalidate();
        detailsPanel.repaint();
    }

    public static void main(String[] args) {
        ResourceManagement frame = new ResourceManagement();
        frame.setVisible(true);
    }
}
