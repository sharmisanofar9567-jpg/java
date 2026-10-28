package src;

import javax.swing.*;
import java.awt.*;

public class UserDashboard extends JFrame {

    Color blue = new Color(40, 100, 160);
    Color background = new Color(245, 247, 250);

    public UserDashboard() {

        setTitle("RESQ - User Dashboard");
        setSize(650, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
        mainPanel.setBackground(background);

        mainPanel.setBorder(
                BorderFactory.createEmptyBorder(30, 30, 30, 30));

        JLabel title = new JLabel("RESQ - Emergency Response System");
        title.setFont(new Font("Arial", Font.BOLD, 23));
        title.setForeground(new Color(35, 55, 75));
        title.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel welcome = new JLabel("Welcome, User!");
        welcome.setFont(new Font("Arial", Font.BOLD, 20));
        welcome.setForeground(new Color(35, 55, 75));
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel description = new JLabel("Manage your emergency reports");
        description.setFont(new Font("Arial", Font.PLAIN, 14));
        description.setForeground(Color.DARK_GRAY);
        description.setAlignmentX(Component.CENTER_ALIGNMENT);

        JButton reportButton = new JButton("Report an Emergency");
        JButton reportsButton = new JButton("My Reports");
        JButton trackingButton = new JButton("Response Tracking");
        JButton backButton = new JButton("Back to Login");

        styleButton(reportButton);
        styleButton(reportsButton);
        styleButton(trackingButton);
        styleButton(backButton);

        mainPanel.add(title);
        mainPanel.add(Box.createVerticalStrut(35));

        mainPanel.add(welcome);
        mainPanel.add(Box.createVerticalStrut(8));

        mainPanel.add(description);
        mainPanel.add(Box.createVerticalStrut(30));

        mainPanel.add(reportButton);
        mainPanel.add(Box.createVerticalStrut(15));

        mainPanel.add(reportsButton);
        mainPanel.add(Box.createVerticalStrut(15));

        mainPanel.add(trackingButton);
        mainPanel.add(Box.createVerticalStrut(25));

        mainPanel.add(backButton);

        // Report an Emergency button
        reportButton.addActionListener(e -> {
            setVisible(false);
            new EmergencyReportFrame();
        });

        // My Reports button
        reportsButton.addActionListener(e -> {

            if (Sharedata.emergencyList.isEmpty()) {

                JOptionPane.showMessageDialog(
                        this, "No emergency reports found.");

            } else {

                int lastIndex = Sharedata.emergencyList.size() - 1;

                Emergency emergency =
                        Sharedata.emergencyList.get(lastIndex);

                setVisible(false);
                new EmergencyDetailsFrame(emergency);
            }
        });

        // Response Tracking button
        trackingButton.addActionListener(e -> {
            setVisible(false);
            ResponseTrackingFrame.main(new String[0]);
        });

        // Back to Login button
        backButton.addActionListener(e -> {
            new LoginFrame().main(new String[0]);
            dispose();
        });

        setContentPane(mainPanel);
    }

    private void styleButton(JButton button) {

        button.setFont(new Font("Arial", Font.PLAIN, 15));
        button.setForeground(Color.WHITE);
        button.setBackground(blue);
        button.setFocusPainted(false);

        button.setBorder(
                BorderFactory.createEmptyBorder(12, 20, 12, 20));

        button.setAlignmentX(Component.CENTER_ALIGNMENT);
        button.setMaximumSize(new Dimension(260, 48));
        button.setPreferredSize(new Dimension(260, 48));

        button.setCursor(
                Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    public static void main(String[] args) {
        new UserDashboard().setVisible(true);
    }
}
