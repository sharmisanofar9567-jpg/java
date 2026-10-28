package src;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;

public class IncidentHistoryFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("RESQ - Incident History");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        // Heading
        JLabel heading = new JLabel("Incident History", JLabel.CENTER);
        mainPanel.add(heading, BorderLayout.NORTH);

        // Search Panel - Search By ID
        JPanel searchPanel = new JPanel(
                new FlowLayout(FlowLayout.CENTER, 5, 5));

        JTextField searchField = new JTextField(10);
        JButton searchButton = new JButton("Search");
        JButton showAllButton = new JButton("Show All");

        searchPanel.add(new JLabel("Search By ID:"));
        searchPanel.add(searchField);
        searchPanel.add(searchButton);
        searchPanel.add(showAllButton);

        mainPanel.add(searchPanel, BorderLayout.NORTH);

        // Table Data - Date Column Removed
        String[] columns = {
                "Emergency ID", "Emergency Type", "Outcome", "Status"
        };

        Object[][] data = {
                {"E001", "Medical", "Assistance Provided", "Resolved"},
                {"E002", "Accident", "First Aid Provided", "Pending"},
                {"E003", "Fire", "Rescue Operation", "Unresolved"},
                {"E004", "Flood", "Evacuation Done", "Resolved"}
        };

        DefaultTableModel model = new DefaultTableModel(data, columns);
        JTable table = new JTable(model);

        JScrollPane tableScroll = new JScrollPane(table);
        mainPanel.add(tableScroll, BorderLayout.CENTER);

        // Search by ID
        searchButton.addActionListener(e -> {

            String id = searchField.getText().trim();
            boolean found = false;

            model.setRowCount(0);

            for (Object[] incident : data) {
                if (incident[0].toString().equalsIgnoreCase(id)) {
                    model.addRow(incident);
                    found = true;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(
                        frame, "Incident ID Not Found!");
            }
        });

        // Show All Incidents
        showAllButton.addActionListener(e -> {
            model.setRowCount(0);

            for (Object[] incident : data) {
                model.addRow(incident);
            }
        });

        // Overall Incident Summary
        JPanel summaryPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        summaryPanel.add(new JLabel("Total Incidents: 4", JLabel.CENTER));
        summaryPanel.add(new JLabel("Resolved: 2", JLabel.CENTER));
        summaryPanel.add(new JLabel("Pending: 1", JLabel.CENTER));
        summaryPanel.add(new JLabel("Unresolved: 1", JLabel.CENTER));

        JPanel summaryContainer = new JPanel(new BorderLayout());
        summaryContainer.add(
                new JLabel("Overall Incident Summary", JLabel.CENTER),
                BorderLayout.NORTH);
        summaryContainer.add(summaryPanel, BorderLayout.CENTER);

        mainPanel.add(summaryContainer, BorderLayout.SOUTH);

        // Back Button
        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backPanel.add(new JButton("Back"));
        frame.add(backPanel, BorderLayout.SOUTH);

        frame.add(mainPanel, BorderLayout.CENTER);

        frame.setSize(700, 450);
        frame.setVisible(true);
    }
}
