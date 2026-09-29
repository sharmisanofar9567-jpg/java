import javax.swing.*;
import javax.swing.table.JTableHeader;

public class IncidentHistoryFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("RESQ - My Incident History");
        frame.setSize(700, 550);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel title = new JLabel(" Incident History");
        title.setBounds(200, 20, 300, 30);
        frame.add(title);

        JLabel searchLabel = new JLabel("Search By Date:");
        searchLabel.setBounds(50, 70, 120, 30);
        frame.add(searchLabel);

        JTextField dateField = new JTextField();
        dateField.setBounds(170, 70, 180, 30);
        frame.add(dateField);

        JButton searchButton = new JButton("Search");
        searchButton.setBounds(370, 70, 100, 30);
        frame.add(searchButton);

        JLabel historyLabel = new JLabel("Incident History");
        historyLabel.setBounds(50, 120, 150, 30);
        frame.add(historyLabel);

        String[] columns = {
            "Emergency ID",
            "Emergency Type",
            "Date",
            "Outcome",
            "Status"
        };

        String[][] data = {
            {"E001", "Medical", "28-09-2026",
             "Assistance Provided", "Resolved"},

            {"E002", "Accident", "25-09-2026",
             "First Aid Provided", "Pending"}
        };

        JTable table = new JTable(data, columns);

        JTableHeader header = table.getTableHeader();

        header.setBounds(50, 155, 580, 30);
        table.setBounds(50, 185, 580, 70);

        frame.add(header);
        frame.add(table);

        JLabel summaryLabel = new JLabel("Overall Incident Summary");
        summaryLabel.setBounds(50, 290, 200, 30);
        frame.add(summaryLabel);

        JLabel totalLabel = new JLabel("Total Incidents: 4");
        totalLabel.setBounds(50, 330, 150, 30);
        frame.add(totalLabel);

        JLabel resolvedLabel = new JLabel("Resolved: 2");
        resolvedLabel.setBounds(220, 330, 120, 30);
        frame.add(resolvedLabel);

        JLabel pendingLabel = new JLabel("Pending: 1");
        pendingLabel.setBounds(350, 330, 120, 30);
        frame.add(pendingLabel);

        JLabel unresolvedLabel = new JLabel("Unresolved: 1");
        unresolvedLabel.setBounds(480, 330, 120, 30);
        frame.add(unresolvedLabel);

        JButton backButton = new JButton("Back");
        backButton.setBounds(280, 400, 100, 30);
        frame.add(backButton);

        frame.setVisible(true);
    }
}