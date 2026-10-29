package src;

import java.awt.*;
import javax.swing.*;

public class EmergencyDetailsFrame {

    public EmergencyDetailsFrame(Emergency emergency) {

        JFrame frame = new JFrame("RESQ - Emergency Details");
        frame.setSize(550, 450);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(12, 15, 12, 15);
        gbc.anchor = GridBagConstraints.WEST;
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // Title
        JLabel title = new JLabel("Emergency Details");
        title.setFont(new Font("Arial", Font.BOLD, 22));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(title, gbc);

        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;

        // Emergency ID
        gbc.gridx = 0;
        gbc.gridy = 1;
        frame.add(new JLabel("Emergency ID:"), gbc);

        gbc.gridx = 1;
        frame.add(new JLabel(emergency.emergencyID), gbc);

        // Emergency Type
        gbc.gridx = 0;
        gbc.gridy = 2;
        frame.add(new JLabel("Emergency Type:"), gbc);

        gbc.gridx = 1;
        frame.add(new JLabel(emergency.emergencyType), gbc);

        // Priority
        gbc.gridx = 0;
        gbc.gridy = 3;
        frame.add(new JLabel("Severity / Priority:"), gbc);

        gbc.gridx = 1;
        frame.add(new JLabel(emergency.priority), gbc);

        // Location
        gbc.gridx = 0;
        gbc.gridy = 4;
        frame.add(new JLabel("Location:"), gbc);

        gbc.gridx = 1;
        frame.add(new JLabel(emergency.location), gbc);

        // People Affected
        gbc.gridx = 0;
        gbc.gridy = 5;
        frame.add(new JLabel("People Affected:"), gbc);

        gbc.gridx = 1;
        frame.add(new JLabel(
                String.valueOf(emergency.peopleAffected)), gbc);

        // Emergency Service
        gbc.gridx = 0;
        gbc.gridy = 6;
        frame.add(new JLabel("Emergency Service:"), gbc);

        gbc.gridx = 1;
        frame.add(new JLabel(emergency.emergencyService), gbc);

        // Status
        gbc.gridx = 0;
        gbc.gridy = 7;
        frame.add(new JLabel("Status:"), gbc);

        gbc.gridx = 1;
        frame.add(new JLabel(emergency.status), gbc);

        // Back Button
        JButton backButton = new JButton("Back");

        gbc.gridx = 0;
        gbc.gridy = 8;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        frame.add(backButton, gbc);

        backButton.addActionListener(e -> {
            frame.dispose();
            new UserDashboard().setVisible(true);
        });

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
