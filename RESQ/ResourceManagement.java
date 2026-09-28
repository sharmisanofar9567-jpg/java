package RESQ;  // ✅ Added package declaration

import javax.swing.*;
import java.awt.*;

public class ResourceManagement extends JFrame {

    JLabel titleLabel;
    JLabel resourceTypeLabel;
    JLabel totalResourceLabel;
    JLabel availableResourceLabel;
    JLabel detailsLabel;

    JComboBox<String> resourceTypeBox;

    JTextField totalResourceField;
    JTextField availableResourceField;

    JButton updateResourceButton;

    JPanel detailsPanel;

    public ResourceManagement() {

        // Frame
        setTitle("RESQ - Resource Management");
        setSize(600, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main Panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(15, 15));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(25, 30, 25, 30));

        // Heading
        titleLabel = new JLabel("RESOURCE MANAGEMENT", SwingConstants.CENTER);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 24));
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Center Panel
        JPanel centerPanel = new JPanel();
        centerPanel.setLayout(new BorderLayout(10, 15));

        // Update Resource Button
        JPanel buttonPanel = new JPanel();
        updateResourceButton = new JButton("Update Resource");
        buttonPanel.add(updateResourceButton);
        centerPanel.add(buttonPanel, BorderLayout.NORTH);

        // Resource Details Form
        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(3, 2, 10, 15));

        resourceTypeLabel = new JLabel("Resource Type:");
        String[] resources = {"Police", "Fire Force", "Ambulance", "Medical Kit"};
        resourceTypeBox = new JComboBox<>(resources);

        totalResourceLabel = new JLabel("Total Resources:");
        totalResourceField = new JTextField("5");

        availableResourceLabel = new JLabel("Currently Available Resources:");
        availableResourceField = new JTextField("3");

        formPanel.add(resourceTypeLabel); formPanel.add(resourceTypeBox);
        formPanel.add(totalResourceLabel); formPanel.add(totalResourceField);
        formPanel.add(availableResourceLabel); formPanel.add(availableResourceField);

        centerPanel.add(formPanel, BorderLayout.CENTER);

        // Bottom Panel
        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout(10, 10));

        detailsLabel = new JLabel("CURRENTLY AVAILABLE RESOURCE DETAILS");
        detailsLabel.setFont(new Font("Arial", Font.BOLD, 17));
        bottomPanel.add(detailsLabel, BorderLayout.NORTH);

        // Table-like Details Panel
        detailsPanel = new JPanel();
        detailsPanel.setLayout(new GridLayout(5, 3, 5, 5));
        detailsPanel.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // Table Headings
        detailsPanel.add(new JLabel("Resource Type"));
        detailsPanel.add(new JLabel("Total Resources"));
        detailsPanel.add(new JLabel("Currently Available"));

        // Police
        detailsPanel.add(new JLabel("Police"));
        detailsPanel.add(new JLabel("5"));
        detailsPanel.add(new JLabel("3"));

        // Fire Force
        detailsPanel.add(new JLabel("Fire Force"));
        detailsPanel.add(new JLabel("2"));
        detailsPanel.add(new JLabel("1"));

        // Ambulance
        detailsPanel.add(new JLabel("Ambulance"));
        detailsPanel.add(new JLabel("3"));
        detailsPanel.add(new JLabel("2"));

        // Medical Kit
        detailsPanel.add(new JLabel("Medical Kit"));
        detailsPanel.add(new JLabel("20"));
        detailsPanel.add(new JLabel("15"));

        bottomPanel.add(detailsPanel, BorderLayout.CENTER);
        centerPanel.add(bottomPanel, BorderLayout.SOUTH);

        mainPanel.add(centerPanel, BorderLayout.CENTER);
        add(mainPanel);
    }

    public static void main(String[] args) {
        ResourceManagement frame = new ResourceManagement();
        frame.setVisible(true);
    }
}
