
package src;

import javax.swing.*;
import java.awt.*;

public class Admindashboard {

    JLabel totalLabel = new JLabel("5");
    JLabel pendingLabel = new JLabel("2");
    JLabel activeLabel = new JLabel("1");
    JLabel resolvedLabel = new JLabel("2");

    JPanel reportsPanel = new JPanel();

    Color blue = new Color(25, 100, 190);
    Color lightBlue = new Color(235, 244, 255);

    public Admindashboard() {

        JFrame frame = new JFrame("RESCUE - Admin Dashboard");

        frame.setSize(900, 800);
        frame.setMinimumSize(new Dimension(700, 600));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        frame.setLayout(new BorderLayout());

        // Main Panel
        JPanel mainPanel = new JPanel(new BorderLayout(10, 15));
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(
            BorderFactory.createEmptyBorder(15, 18, 15, 18)
        );

        // Header
        JPanel header = new JPanel();
        header.setLayout(new BoxLayout(header, BoxLayout.Y_AXIS));
        header.setBackground(blue);
        header.setBorder(
            BorderFactory.createEmptyBorder(15, 20, 15, 20)
        );

        JLabel title = new JLabel("RESCUE");
        title.setFont(new Font("Arial", Font.BOLD, 26));
        title.setForeground(Color.WHITE);

        JLabel subtitle = new JLabel("Admin Dashboard");
        subtitle.setFont(new Font("Arial", Font.PLAIN, 16));
        subtitle.setForeground(Color.WHITE);

        header.add(title);
        header.add(Box.createVerticalStrut(5));
        header.add(subtitle);

        mainPanel.add(header, BorderLayout.NORTH);

        // Dashboard Content
        JPanel content = new JPanel(new BorderLayout(10, 15));
        content.setBackground(Color.WHITE);

        // Count Cards
        JPanel countPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        countPanel.setBackground(Color.WHITE);

        countPanel.add(countBox("Total Reports", totalLabel));
        countPanel.add(countBox("Pending", pendingLabel));
        countPanel.add(countBox("Active", activeLabel));
        countPanel.add(countBox("Resolved", resolvedLabel));

        // Reports Section
        JPanel reportsSection = new JPanel(new BorderLayout(5, 10));
        reportsSection.setBackground(Color.WHITE);

        JLabel reportsTitle = new JLabel("Emergency Reports");
        reportsTitle.setFont(new Font("Arial", Font.BOLD, 18));

        reportsSection.add(reportsTitle, BorderLayout.NORTH);

        reportsPanel.setLayout(
            new BoxLayout(reportsPanel, BoxLayout.Y_AXIS)
        );
        reportsPanel.setBackground(Color.WHITE);

        JLabel message = new JLabel("Emergency reports will appear here.");
        message.setBorder(
            BorderFactory.createEmptyBorder(15, 10, 15, 10)
        );
        reportsPanel.add(message);

        JScrollPane scrollPane = new JScrollPane(reportsPanel);
        scrollPane.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );

        reportsSection.add(scrollPane, BorderLayout.CENTER);

        // Quick Access Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(Color.WHITE);

        JButton resourceButton = new JButton("Resource Management");
        JButton historyButton = new JButton("Incident History");
        JButton logoutButton = new JButton("Logout");

        buttonPanel.add(resourceButton);
        buttonPanel.add(historyButton);
        buttonPanel.add(logoutButton);

        JPanel centerPanel = new JPanel(new BorderLayout(10, 15));
        centerPanel.setBackground(Color.WHITE);

        centerPanel.add(countPanel, BorderLayout.NORTH);
        centerPanel.add(reportsSection, BorderLayout.CENTER);
        centerPanel.add(buttonPanel, BorderLayout.SOUTH);

        content.add(centerPanel, BorderLayout.CENTER);

        mainPanel.add(content, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setVisible(true);
    }

    JPanel countBox(String title, JLabel numberLabel) {

        JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));
        panel.setBackground(lightBlue);
        panel.setBorder(
            BorderFactory.createEmptyBorder(12, 10, 12, 10)
        );

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        numberLabel.setFont(new Font("Arial", Font.BOLD, 24));
        numberLabel.setForeground(blue);

        panel.add(titleLabel);
        panel.add(numberLabel);

        return panel;
    }

    public static void main(String[] args) {
        new Admindashboard();
    }
}
