
import javax.swing.*;
import java.awt.*;

public class IncidentHistoryFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("RESQ - Incident History");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        // Main Panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));

        // Heading
        JLabel heading = new JLabel("Incident History", JLabel.CENTER);
       
        mainPanel.add(heading, BorderLayout.NORTH);

        // Search Panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        searchPanel.add(new JLabel("Search By Date:"));
        searchPanel.add(new JTextField(10));
        searchPanel.add(new JButton("Search"));
        mainPanel.add(searchPanel, BorderLayout.NORTH);

        // Table Data
        String[] columns = {"Emergency ID", "Emergency Type", "Date", "Outcome", "Status"};
        String[][] data = {
                {"E001", "Medical", "28-09-2026", "Assistance Provided", "Resolved"},
                {"E002", "Accident", "25-09-2026", "First Aid Provided", "Pending"},
                {"E003", "Fire", "20-09-2026", "Rescue Operation", "Unresolved"},
                {"E004", "Flood", "15-09-2026", "Evacuation Done", "Resolved"}
        };

        JTable table = new JTable(data, columns);


        JScrollPane tableScroll = new JScrollPane(table);
        mainPanel.add(tableScroll, BorderLayout.CENTER);

        // Overall Incident Summary
        JPanel summaryPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        summaryPanel.add(new JLabel("Total Incidents: 4", JLabel.CENTER));
        summaryPanel.add(new JLabel("Resolved: 2", JLabel.CENTER));
        summaryPanel.add(new JLabel("Pending: 1", JLabel.CENTER));
        summaryPanel.add(new JLabel("Unresolved: 1", JLabel.CENTER));

        JPanel summaryContainer = new JPanel(new BorderLayout());
        summaryContainer.add(new JLabel("Overall Incident Summary", JLabel.CENTER), BorderLayout.NORTH);
        summaryContainer.add(summaryPanel, BorderLayout.CENTER);

        mainPanel.add(summaryContainer, BorderLayout.SOUTH);

        // Back Button
        JPanel backPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        backPanel.add(new JButton("Back"));
        frame.add(backPanel, BorderLayout.SOUTH);

        // Add Main Panel
        frame.add(mainPanel, BorderLayout.CENTER);

        // Frame Size
        frame.setSize(700, 450);
       
        frame.setVisible(true);
    }
}