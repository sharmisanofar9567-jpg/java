package src;

import javax.swing.*;
import java.awt.*;

public class UserDashboard extends JFrame {

    Color blue = new Color(5, 61, 101);
    Color background = new Color(242, 246, 249);

    public UserDashboard() {
        setTitle("RESQ - User Dashboard");
        setSize(750, 550);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBackground(background);
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));

        JPanel header = new JPanel(new BorderLayout());
        header.setBackground(blue);
        header.setBorder(BorderFactory.createEmptyBorder(10, 15, 10, 15));

        JLabel title = new JLabel("RESQ - Emergency Response System", SwingConstants.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        title.setForeground(Color.WHITE);
        header.add(title, BorderLayout.CENTER);

        JPanel content = new JPanel();
        content.setBackground(blue);
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        JLabel welcome = new JLabel("Welcome, User!", SwingConstants.CENTER);
        welcome.setFont(new Font("Arial", Font.BOLD, 20));
        welcome.setForeground(Color.WHITE);
        welcome.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel description = new JLabel("Your emergency assistance dashboard", SwingConstants.CENTER);
        description.setFont(new Font("Arial", Font.PLAIN, 14));
        description.setForeground(Color.WHITE);
        description.setAlignmentX(Component.CENTER_ALIGNMENT);

        content.add(welcome);
        content.add(Box.createVerticalStrut(8));
        content.add(description);
        content.add(Box.createVerticalStrut(20));

        JButton reportButton = new JButton("Report an Emergency");
        JButton reportsButton = new JButton("My Reports");
        JButton trackingButton = new JButton("Response Tracking");

        styleButton(reportButton);
        styleButton(reportsButton);
        styleButton(trackingButton);

        Dimension largeSize = new Dimension(500, 80);
        reportButton.setPreferredSize(largeSize);
        reportsButton.setPreferredSize(largeSize);
        trackingButton.setPreferredSize(largeSize);

        reportButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        reportsButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        trackingButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        content.add(reportButton);
        content.add(Box.createVerticalStrut(15));
        content.add(reportsButton);
        content.add(Box.createVerticalStrut(15));
        content.add(trackingButton);
        content.add(Box.createVerticalStrut(20));

        JLabel footer = new JLabel("Sample dashboard design - not connected to live service.", SwingConstants.CENTER);
        footer.setFont(new Font("Arial", Font.PLAIN, 11));
        footer.setForeground(Color.WHITE);
        footer.setAlignmentX(Component.CENTER_ALIGNMENT);
        content.add(footer);

        reportButton.addActionListener(e -> showMessage("Report an Emergency"));
        reportsButton.addActionListener(e -> showMessage("My Reports"));
        trackingButton.addActionListener(e -> showMessage("Response Tracking"));

        mainPanel.add(header, BorderLayout.NORTH);
        mainPanel.add(content, BorderLayout.CENTER);

        setContentPane(mainPanel);
    }

    private void styleButton(JButton button) {
        button.setFont(new Font("Arial", Font.PLAIN, 16));
        button.setForeground(blue);
        button.setBackground(Color.WHITE);
        button.setFocusPainted(false);
        button.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(new Color(220, 225, 230)),
                BorderFactory.createEmptyBorder(12, 20, 12, 20)
        ));
        button.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    private void showMessage(String buttonName) {
        JOptionPane.showMessageDialog(this,
                buttonName + " button clicked.",
                "RESQ",
                JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new UserDashboard().setVisible(true));
    }
}
