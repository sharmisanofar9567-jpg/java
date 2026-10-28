package src;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class AdmindashboardFrame extends JFrame {

    JLabel totalLabel = new JLabel("0");
    JLabel pendingLabel = new JLabel("0");
    JLabel activeLabel = new JLabel("0");
    JLabel resolvedLabel = new JLabel("0");

    JPanel reportsPanel = new JPanel();
    Timer refreshTimer;

    Color blue = new Color(25, 100, 190);
    Color lightBlue = new Color(235, 244, 255);

    public AdmindashboardFrame() {

        setTitle("RESCUE - Admin Dashboard");
        setSize(900, 800);
        setMinimumSize(new Dimension(700, 600));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(12, 12));
        mainPanel.setBackground(Color.WHITE);
        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(15, 18, 15, 18));

        // Header
        JPanel headerPanel = new JPanel(new GridLayout(2, 1));
        headerPanel.setBackground(blue);

        JLabel titleLabel = new JLabel("RESCUE");
        titleLabel.setForeground(Color.WHITE);
        titleLabel.setFont(new Font("Arial", Font.BOLD, 26));

        JLabel subtitleLabel = new JLabel("Admin Dashboard");
        subtitleLabel.setForeground(Color.WHITE);
        subtitleLabel.setFont(new Font("Arial", Font.PLAIN, 16));

        headerPanel.add(titleLabel);
        headerPanel.add(subtitleLabel);

        mainPanel.add(headerPanel, BorderLayout.NORTH);

        // Dashboard content
        JPanel contentPanel = new JPanel(new BorderLayout(10, 10));
        contentPanel.setBackground(Color.WHITE);

        // Count boxes
        JPanel countPanel = new JPanel(new GridLayout(1, 4, 10, 10));
        countPanel.setBackground(Color.WHITE);

        countPanel.add(countBox("Total Reports", totalLabel));
        countPanel.add(countBox("Pending", pendingLabel));
        countPanel.add(countBox("Active", activeLabel));
        countPanel.add(countBox("Resolved", resolvedLabel));

        contentPanel.add(countPanel, BorderLayout.NORTH);

        // Emergency reports section
        JPanel reportsSection = new JPanel(new BorderLayout(8, 8));
        reportsSection.setBackground(Color.WHITE);

        JPanel reportsHeader = new JPanel(new BorderLayout());
        reportsHeader.setBackground(Color.WHITE);

        JLabel reportsTitle = new JLabel("New Emergency Reports");
        reportsTitle.setFont(new Font("Arial", Font.BOLD, 19));

        JButton refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(e -> refreshDashboard());

        reportsHeader.add(reportsTitle, BorderLayout.WEST);
        reportsHeader.add(refreshButton, BorderLayout.EAST);

        reportsSection.add(reportsHeader, BorderLayout.NORTH);

        // Reports list
        reportsPanel.setLayout(
                new BoxLayout(reportsPanel, BoxLayout.Y_AXIS));
        reportsPanel.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(reportsPanel);
        scrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);

        reportsSection.add(scrollPane, BorderLayout.CENTER);
        contentPanel.add(reportsSection, BorderLayout.CENTER);

        // Quick Access buttons
        JPanel quickAccessPanel =
                new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 8));
        quickAccessPanel.setBackground(lightBlue);

        JButton resourceManagementButton =
                makeButton("Resource Management", () -> {
                    new ResourceManagement().setVisible(true);
                });

        JButton incidentHistoryButton =
                makeButton("Incident History", () -> {
                    new IncidentHistoryFrame().setVisible(true);
                });

        JButton logoutButton =
                makeButton("Logout", () -> logout());

        quickAccessPanel.add(resourceManagementButton);
        quickAccessPanel.add(incidentHistoryButton);
        quickAccessPanel.add(logoutButton);

        contentPanel.add(quickAccessPanel, BorderLayout.SOUTH);
        mainPanel.add(contentPanel, BorderLayout.CENTER);

        add(mainPanel);

        // Initial refresh
        refreshDashboard();

        // Automatic refresh every 3 seconds
        refreshTimer = new Timer(3000, e -> refreshDashboard());
        refreshTimer.start();

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                if (refreshTimer != null) {
                    refreshTimer.stop();
                }
            }
        });
    }

    // Count box
    JPanel countBox(String title, JLabel numberLabel) {

        JPanel panel = new JPanel(new GridLayout(2, 1, 5, 5));
        panel.setBackground(lightBlue);
        panel.setBorder(
                BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel titleLabel = new JLabel(title);
        titleLabel.setFont(new Font("Arial", Font.PLAIN, 14));

        numberLabel.setFont(new Font("Arial", Font.BOLD, 24));
        numberLabel.setForeground(blue);

        panel.add(titleLabel);
        panel.add(numberLabel);

        return panel;
    }

    // Common button method
    JButton makeButton(String text, Runnable action) {

        JButton button = new JButton(text);
        button.addActionListener(e -> action.run());

        return button;
    }

    // Update dashboard counts and reports
    void refreshDashboard() {

        int total = Sharedata.emergencyList.size();
        int pending = 0;
        int active = 0;
        int resolved = 0;

        for (Emergency emergency : Sharedata.emergencyList) {

            String status = emergency.status;

            if ("Pending".equalsIgnoreCase(status)
                    || "Reported".equalsIgnoreCase(status)) {

                pending++;

            } else if ("In Progress".equalsIgnoreCase(status)
                    || "Active".equalsIgnoreCase(status)
                    || "Dispatched".equalsIgnoreCase(status)
                    || "Resources Allocated".equalsIgnoreCase(status)) {

                active++;

            } else if ("Resolved".equalsIgnoreCase(status)) {

                resolved++;
            }
        }

        totalLabel.setText(String.valueOf(total));
        pendingLabel.setText(String.valueOf(pending));
        activeLabel.setText(String.valueOf(active));
        resolvedLabel.setText(String.valueOf(resolved));

        refreshReports();
    }

    // Display emergency reports
    void refreshReports() {

        reportsPanel.removeAll();

        if (Sharedata.emergencyList.isEmpty()) {

            JLabel emptyLabel =
                    new JLabel("No emergency reports received yet.");

            emptyLabel.setBorder(
                    BorderFactory.createEmptyBorder(20, 10, 20, 10));

            reportsPanel.add(emptyLabel);

        } else {

            for (int i = Sharedata.emergencyList.size() - 1;
                    i >= 0; i--) {

                Emergency emergency = Sharedata.emergencyList.get(i);

                JPanel card = new JPanel(new BorderLayout(10, 8));
                card.setBackground(Color.WHITE);

                card.setBorder(BorderFactory.createCompoundBorder(
                        BorderFactory.createLineBorder(lightBlue, 2),
                        BorderFactory.createEmptyBorder(12, 12, 12, 12)));

                // Emergency information
                JLabel info = new JLabel(
                        "<html>"
                        + "<b>Emergency ID:</b> " + emergency.emergencyID
                        + "<br><b>Type:</b> " + emergency.emergencyType
                        + "<br><b>Priority:</b> " + emergency.priority
                        + "<br><b>Location:</b> " + emergency.location
                        + "<br><b>People Affected:</b> "
                        + emergency.peopleAffected
                        + "<br><b>Required Service:</b> "
                        + emergency.emergencyService
                        + "<br><b>Status:</b> " + emergency.status
                        + "</html>");

                info.setFont(new Font("Arial", Font.PLAIN, 14));
                card.add(info, BorderLayout.CENTER);

                // Show Allocate button only for unresolved incidents
                if (!"Resolved".equalsIgnoreCase(emergency.status)) {

                    JButton allocateButton =
                            new JButton("Allocate Resource");

                    allocateButton.addActionListener(e -> {

                        // Check status again before opening allocation
                        if ("Resolved".equalsIgnoreCase(emergency.status)) {

                            JOptionPane.showMessageDialog(
                                    this,
                                    "Resolved incidents cannot be allocated resources.");

                            refreshDashboard();
                            return;
                        }

                        ResourceAllocation allocation =
                                new ResourceAllocation();

                        allocation.emergencyField.setText(
                                emergency.emergencyID);

                        allocation.locationField.setText(
                                emergency.location);

                        allocation.setVisible(true);
                    });

                    JPanel buttonPanel =
                            new JPanel(new FlowLayout(FlowLayout.RIGHT));
                    buttonPanel.setBackground(Color.WHITE);
                    buttonPanel.add(allocateButton);

                    card.add(buttonPanel, BorderLayout.SOUTH);
                }

                card.setAlignmentX(Component.LEFT_ALIGNMENT);
                card.setMaximumSize(
                        new Dimension(Integer.MAX_VALUE, 190));

                reportsPanel.add(card);
                reportsPanel.add(Box.createVerticalStrut(10));
            }
        }

        reportsPanel.revalidate();
        reportsPanel.repaint();
    }

    // Logout
    void logout() {

        int choice = JOptionPane.showConfirmDialog(
                this,
                "Are you sure you want to logout?",
                "Logout",
                JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_OPTION) {

            if (refreshTimer != null) {
                refreshTimer.stop();
            }

            dispose();
            LoginFrame.main(new String[0]);
        }
    }

    public static void main(String[] args) {
        new AdmindashboardFrame().setVisible(true);
    }
}
