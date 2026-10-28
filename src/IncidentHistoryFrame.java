package src;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import java.awt.*;

public class IncidentHistoryFrame extends JFrame {

    JTextField searchField;
    JLabel idLabel, typeLabel, locationLabel, resourceLabel;
    JComboBox<String> statusBox;
    JButton updateButton;
    Emergency selectedEmergency;

    Color blue = new Color(25, 100, 190);
    Color lightGrey = new Color(245, 247, 250);
    Color darkText = new Color(45, 55, 70);

    public IncidentHistoryFrame() {

        setTitle("RESCUE - Incident History");
        setSize(750, 680);
        setMinimumSize(new Dimension(600, 600));
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel
        JPanel main = new JPanel(new BorderLayout(15, 18));
        main.setBackground(Color.WHITE);
        main.setBorder(new EmptyBorder(20, 22, 20, 22));

        // Heading
        JPanel heading = new JPanel();
        heading.setLayout(new BoxLayout(heading, BoxLayout.Y_AXIS));
        heading.setBackground(Color.WHITE);

        JLabel title = new JLabel("Incident History & Status Management");
        title.setFont(new Font("Arial", Font.BOLD, 23));
        title.setForeground(darkText);

        JLabel subtitle = new JLabel("Admin View");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 14));
        subtitle.setForeground(Color.GRAY);

        heading.add(title);
        heading.add(Box.createVerticalStrut(8));
        heading.add(subtitle);

        // Search section
        JPanel searchSection = new JPanel(new BorderLayout(8, 8));
        searchSection.setBackground(Color.WHITE);

        JLabel searchTitle = new JLabel("Search by Incident ID");
        searchTitle.setFont(new Font("Arial", Font.PLAIN, 15));

        searchField = new JTextField();
        searchField.setFont(new Font("Arial", Font.PLAIN, 16));
        searchField.setPreferredSize(new Dimension(100, 42));

        JButton searchButton = new JButton("Search");
        searchButton.setPreferredSize(new Dimension(100, 42));
        searchButton.addActionListener(e -> searchIncident());

        JPanel searchRow = new JPanel(new BorderLayout(10, 0));
        searchRow.setBackground(Color.WHITE);
        searchRow.add(searchField, BorderLayout.CENTER);
        searchRow.add(searchButton, BorderLayout.EAST);

        searchSection.add(searchTitle, BorderLayout.NORTH);
        searchSection.add(searchRow, BorderLayout.CENTER);

        // Incident details
        JPanel details = new JPanel(new GridLayout(4, 2, 10, 18));
        details.setBackground(lightGrey);
        details.setBorder(new EmptyBorder(20, 18, 20, 18));

        idLabel = new JLabel("-");
        typeLabel = new JLabel("-");
        locationLabel = new JLabel("-");
        resourceLabel = new JLabel("-");

        details.add(createDetailTitle("Incident ID"));
        details.add(idLabel);

        details.add(createDetailTitle("Incident Type"));
        details.add(typeLabel);

        details.add(createDetailTitle("Location"));
        details.add(locationLabel);

        details.add(createDetailTitle("Assigned Resource"));
        details.add(resourceLabel);

        // Status section
        JPanel statusPanel = new JPanel();
        statusPanel.setLayout(new BoxLayout(statusPanel, BoxLayout.Y_AXIS));
        statusPanel.setBackground(lightGrey);
        statusPanel.setBorder(new EmptyBorder(15, 18, 18, 18));

        JLabel statusTitle = new JLabel("Update Status");
        statusTitle.setForeground(Color.GRAY);

        String[] statuses = {
            "Reported",
            "Pending",
            "Resources Allocated",
            "Active",
            "Resolved"
        };

        statusBox = new JComboBox<String>(statuses);
        statusBox.setFont(new Font("Arial", Font.PLAIN, 15));
        statusBox.setSelectedIndex(0);
        statusBox.setEditable(false);
        statusBox.setMaximumRowCount(5);
        statusBox.setBackground(Color.WHITE);
        statusBox.setForeground(Color.BLACK);
        statusBox.setPreferredSize(new Dimension(400, 42));
        statusBox.setMaximumSize(new Dimension(400, 42));
        statusBox.setAlignmentX(Component.LEFT_ALIGNMENT);
        statusBox.setEnabled(false);

        // Dropdown values display
        statusBox.setRenderer(new DefaultListCellRenderer() {
            @Override
            public Component getListCellRendererComponent(
                    JList<?> list, Object value, int index,
                    boolean isSelected, boolean cellHasFocus) {

                JLabel label = (JLabel) super.getListCellRendererComponent(
                        list, value, index, isSelected, cellHasFocus);

                label.setOpaque(true);
                label.setBackground(
                        isSelected ? blue : Color.WHITE);
                label.setForeground(
                        isSelected ? Color.WHITE : Color.BLACK);
                label.setBorder(
                        BorderFactory.createEmptyBorder(5, 8, 5, 8));

                return label;
            }
        });

        updateButton = new JButton("Update Status");
        updateButton.setBackground(blue);
        updateButton.setForeground(Color.WHITE);
        updateButton.setFocusPainted(false);
        updateButton.setMaximumSize(new Dimension(400, 42));
        updateButton.setPreferredSize(new Dimension(400, 42));
        updateButton.setAlignmentX(Component.LEFT_ALIGNMENT);
        updateButton.setEnabled(false);
        updateButton.addActionListener(e -> updateStatus());

        statusPanel.add(statusTitle);
        statusPanel.add(Box.createVerticalStrut(10));
        statusPanel.add(statusBox);
        statusPanel.add(Box.createVerticalStrut(12));
        statusPanel.add(updateButton);

        // Details card
        JPanel detailsCard = new JPanel(new BorderLayout());
        detailsCard.setBackground(lightGrey);
        detailsCard.setBorder(
                new LineBorder(new Color(225, 228, 233), 1, true));

        detailsCard.add(details, BorderLayout.NORTH);
        detailsCard.add(statusPanel, BorderLayout.CENTER);

        // Main content
        JPanel content = new JPanel(new BorderLayout(0, 18));
        content.setBackground(Color.WHITE);
        content.add(searchSection, BorderLayout.NORTH);
        content.add(detailsCard, BorderLayout.CENTER);

        main.add(heading, BorderLayout.NORTH);
        main.add(content, BorderLayout.CENTER);

        setContentPane(main);
    }

    // Create detail title labels
    JLabel createDetailTitle(String text) {

        JLabel label = new JLabel(text);
        label.setFont(new Font("Arial", Font.PLAIN, 15));
        label.setForeground(darkText);

        return label;
    }

    // Search incident by ID
    void searchIncident() {

        String id = searchField.getText();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(
                    this, "Please enter Incident ID.");
            return;
        }

        selectedEmergency = Sharedata.findEmergency(id);

        if (selectedEmergency == null) {

            idLabel.setText("-");
            typeLabel.setText("-");
            locationLabel.setText("-");
            resourceLabel.setText("-");

            statusBox.setSelectedIndex(0);
            statusBox.setEnabled(false);
            updateButton.setEnabled(false);

            JOptionPane.showMessageDialog(
                    this,
                    "Emergency not found. Please check the ID.");

            return;
        }

        // Emergency details
        idLabel.setText(selectedEmergency.emergencyID);
        typeLabel.setText(selectedEmergency.emergencyType);
        locationLabel.setText(selectedEmergency.location);

        // Assigned resource
        String[] resource =
                Resourcedata.findResource(selectedEmergency.emergencyID);

        if (resource != null) {
            resourceLabel.setText(
                    resource[1] + " (Quantity: " + resource[2] + ")");
        } else {
            resourceLabel.setText("Not allocated");
        }

        // Set current status in dropdown
        String currentStatus = selectedEmergency.status;

        if ("In Progress".equalsIgnoreCase(currentStatus)
                || "Dispatched".equalsIgnoreCase(currentStatus)
                || "Active".equalsIgnoreCase(currentStatus)) {

            statusBox.setSelectedItem("Active");

        } else if ("Resolved".equalsIgnoreCase(currentStatus)) {

            statusBox.setSelectedItem("Resolved");

        } else if ("Resources Allocated".equalsIgnoreCase(currentStatus)) {

            statusBox.setSelectedItem("Resources Allocated");

        } else if ("Reported".equalsIgnoreCase(currentStatus)) {

            statusBox.setSelectedItem("Reported");

        } else {

            statusBox.setSelectedItem("Pending");
        }

        statusBox.setEnabled(true);
        updateButton.setEnabled(true);
    }

    // Update incident status
    void updateStatus() {

        if (selectedEmergency == null) {
            JOptionPane.showMessageDialog(
                    this, "Please search for an incident first.");
            return;
        }

        String newStatus = (String) statusBox.getSelectedItem();

        if (newStatus == null) {
            return;
        }

        selectedEmergency.status = newStatus;

        JOptionPane.showMessageDialog(
                this, "Incident status updated successfully!");
    }

    public static void main(String[] args) {
        new IncidentHistoryFrame().setVisible(true);
    }
