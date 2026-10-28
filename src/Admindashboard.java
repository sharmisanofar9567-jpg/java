
package src;

import javax.swing.*;
import java.awt.*;

public class Admindashboard {

    JLabel totalLabel = new JLabel("0");
    JLabel pendingLabel = new JLabel("0");
    JLabel activeLabel = new JLabel("0");
    JLabel resolvedLabel = new JLabel("0");

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

        JLabel reportsTitle = new JLabel("New Emergency Reports");
        reportsTitle.setFont(new Font("Arial", Font.BOLD, 18));

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> refreshDashboard());

        JPanel reportsHeader = new JPanel(new BorderLayout());
        reportsHeader.setBackground(Color.WHITE);
        reportsHeader.add(reportsTitle, BorderLayout.WEST);
        reportsHeader.add(refreshButton, BorderLayout.EAST);

        reportsSection.add(reportsHeader, BorderLayout.NORTH);

        reportsPanel.setLayout(
            new BoxLayout(reportsPanel, BoxLayout.Y_AXIS)
        );
        reportsPanel.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(reportsPanel);
        scrollPane.setVerticalScrollBarPolicy(
            JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED
        );

        reportsSection.add(scrollPane, BorderLayout.CENTER);

        // Quick Access Buttons
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        buttonPanel.setBackground(Color.WHITE);

        JButton resourceButton = new JButton("Resource Management");
        resourceButton.addActionListener(e -> {
            new ResourceManagement().setVisible(true);
        });

        JButton historyButton = new JButton("Incident History");
        historyButton.addActionListener(e -> {
            new IncidentHistoryFrame().setVisible(true);
        });

        JButton logoutButton = new JButton("Logout");
        logoutButton.addActionListener(e -> logout(frame));

        buttonPanel.add(resourceButton);
        buttonPanel.add(historyButton);
        buttonPanel.add(logoutButton);

        JPanel centerPanel = new JPanel(new BorderLayout(10, 15));
        centerPanel.setBackground(Color.WHITE);
        centerPanel.add(countPanel, BorderLayout.NORTH);
        centerPanel.add(reportsSection, BorderLayout.CENTER);
        centerPanel.add(buttonPanel, BorderLayout.SOUTH);

        mainPanel.add(centerPanel, BorderLayout.CENTER);

        frame.add(mainPanel);
        frame.setVisible(true);

        refreshDashboard();
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

    void refreshDashboard() {

        int total = Sharedata.emergencyList.size();
        int pending = 0;
        int active = 0;
        int resolved = 0;

        for (Emergency emergency : Sharedata.emergencyList) {

            String status = emergency.status;

            if (status.equalsIgnoreCase("Pending")
                    || status.equalsIgnoreCase("Reported")) {
                pending++;
            } else if (status.equalsIgnoreCase("In Progress")
                    || status.equalsIgnoreCase("Active")
                    || status.equalsIgnoreCase("Dispatched")
                    || status.equalsIgnoreCase("Resources Allocated")) {
                active++;
            } else if (status.equalsIgnoreCase("Resolved")) {
                resolved++;
            }
        }

        totalLabel.setText(String.valueOf(total));
        pendingLabel.setText(String.valueOf(pending));
        activeLabel.setText(String.valueOf(active));
        resolvedLabel.setText(String.valueOf(resolved));

        refreshReports();
    }

    void refreshReports() {

        reportsPanel.removeAll();

        if (Sharedata.emergencyList.isEmpty()) {

            JLabel emptyLabel = new JLabel("No emergency reports available.");
            emptyLabel.setBorder(
                BorderFactory.createEmptyBorder(15, 10, 15, 10)
            );

            reportsPanel.add(emptyLabel);

        } else {

            for (int i = Sharedata.emergencyList.size() - 1; i >= 0; i--) {

                Emergency emergency = Sharedata.emergencyList.get(i);

                JPanel card = new JPanel();
                card.setLayout(
                    new BoxLayout(card, BoxLayout.Y_AXIS)
                );
                card.setBackground(lightBlue);
                card.setBorder(
                    BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(
                            new Color(210, 225, 240)
                        ),
                        BorderFactory.createEmptyBorder(10, 12, 10, 12)
                    )
                );

                JLabel idLabel = new JLabel(
                    "Emergency ID: " + emergency.emergencyID
                );

                JLabel typeLabel = new JLabel(
                    "Type: " + emergency.type
                );

                JLabel priorityLabel = new JLabel(
                    "Priority: " + emergency.priority
                );

                JLabel locationLabel = new JLabel(
                    "Location: " + emergency.location
                );

                JLabel peopleLabel = new JLabel(
                    "People Affected: " + emergency.peopleAffected
                );

                JLabel serviceLabel = new JLabel(
                    "Required Service: " + emergency.requiredService
                );

                JLabel statusLabel = new JLabel(
                    "Status: " + emergency.status
                );

                card.add(idLabel);
                card.add(Box.createVerticalStrut(4));
                card.add(typeLabel);
                card.add(priorityLabel);
                card.add(locationLabel);
                card.add(peopleLabel);
                card.add(serviceLabel);
                card.add(statusLabel);

                card.setAlignmentX(Component.LEFT_ALIGNMENT);
                card.setMaximumSize(
                    new Dimension(Integer.MAX_VALUE, 190)
                );

                reportsPanel.add(card);
                reportsPanel.add(Box.createVerticalStrut(10));
            }
        }

        reportsPanel.revalidate();
        reportsPanel.repaint();
    }

    void logout(JFrame frame) {

        int choice = JOptionPane.showConfirmDialog(
            frame,
            "Are you sure you want to logout?",
            "Logout",
            JOptionPane.YES_NO_OPTION
        );

        if (choice == JOptionPane.YES_OPTION) {
            frame.dispose();
            LoginFrame.main(new String[0]);
        }
    }

    public static void main(String[] args) {
        new Admindashboard();
    }
}

