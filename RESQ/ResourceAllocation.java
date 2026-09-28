package RESQ;  // ✅ Added package declaration

import javax.swing.*;
import java.awt.*;

public class ResourceAllocation extends JFrame {

    JLabel emergencyLabel;
    JLabel resourceLabel;
    JLabel availableLabel;
    JLabel allocateLabel;
    JLabel priorityLabel;
    JLabel locationLabel;
    JLabel detailsLabel;

    JTextField emergencyField;
    JTextField availableField;
    JTextField allocateField;
    JTextField locationField;

    JComboBox<String> resourceBox;
    JComboBox<String> priorityBox;

    JTextArea detailsArea;

    JButton allocateButton;
    JButton clearButton;

    public ResourceAllocation() {

        setTitle("RESQ - Resource Allocation");
        setSize(600, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(9, 2, 10, 15));
        panel.setBorder(BorderFactory.createEmptyBorder(25, 30, 25, 30));

        // Emergency ID
        emergencyLabel = new JLabel("Emergency ID:");
        emergencyField = new JTextField("E001");

        // Resource Type
        resourceLabel = new JLabel("Resource Type:");
        String[] resources = {"Police", "Fire Force", "Ambulance", "Medical Kit"};
        resourceBox = new JComboBox<>(resources);

        // Available Quantity
        availableLabel = new JLabel("Available Quantity:");
        availableField = new JTextField("5");
        availableField.setEditable(false);

        // Allocate Quantity
        allocateLabel = new JLabel("Allocate Quantity:");
        allocateField = new JTextField("2");

        // Priority
        priorityLabel = new JLabel("Priority:");
        String[] priorities = {"Normal", "High", "Severe", "Extreme"};
        priorityBox = new JComboBox<>(priorities);

        // Location
        locationLabel = new JLabel("Location:");
        locationField = new JTextField("Kollam");

        // Buttons
        allocateButton = new JButton("Allocate");
        clearButton = new JButton("Clear");

        // Allocation Details
        detailsLabel = new JLabel("Allocation Details:");
        detailsArea = new JTextArea(
            "Emergency ID : E001\n" +
            "Resource     : Police\n" +
            "Quantity     : 2\n" +
            "Priority     : Severe\n" +
            "Location     : Kollam"
        );
        detailsArea.setEditable(false);

        // Add components
        panel.add(emergencyLabel); panel.add(emergencyField);
        panel.add(resourceLabel); panel.add(resourceBox);
        panel.add(availableLabel); panel.add(availableField);
        panel.add(allocateLabel); panel.add(allocateField);
        panel.add(priorityLabel); panel.add(priorityBox);
        panel.add(locationLabel); panel.add(locationField);
        panel.add(allocateButton); panel.add(clearButton);
        panel.add(detailsLabel); panel.add(detailsArea);

        add(panel);

        // No ActionListener is used.
        // Buttons are only GUI components.
    }

    public static void main(String[] args) {
        ResourceAllocation frame = new ResourceAllocation();
        frame.setVisible(true);
    }
}
