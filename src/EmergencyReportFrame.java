package src;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EmergencyReportFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("RESQ - Emergency Reporting");
        frame.setSize(650, 500);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE); // prevent auto-close
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(8, 8, 8, 8);
        gbc.anchor = GridBagConstraints.WEST;

        // Title
        JPanel titlePanel = new JPanel();
        JLabel title = new JLabel("Emergency Reporting");
        title.setFont(new Font("Arial", Font.BOLD, 20));
        titlePanel.add(title);

        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(titlePanel, gbc);

        // Emergency Type
        JLabel typeLabel = new JLabel("Emergency Type:");
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        frame.add(typeLabel, gbc);

        String[] types = {"Medical Emergency","Fire Incident","Road Accident","Natural Disaster","Crime","Other"};
        JComboBox<String> typeBox = new JComboBox<>(types);
        gbc.gridx = 1; gbc.gridy = 1; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1;
        frame.add(typeBox, gbc);

        // Severity / Priority
        JLabel priorityLabel = new JLabel("Severity / Priority:");
        gbc.gridx = 0; gbc.gridy = 2;
        frame.add(priorityLabel, gbc);

        String[] priorities = {"Critical","High","Medium","Low"};
        JComboBox<String> priorityBox = new JComboBox<>(priorities);
        gbc.gridx = 1; gbc.gridy = 2; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1;
        frame.add(priorityBox, gbc);

        // People Affected
        JLabel peopleLabel = new JLabel("People Affected:");
        gbc.gridx = 0; gbc.gridy = 3;
        frame.add(peopleLabel, gbc);

        JTextField peopleField = new JTextField();
        gbc.gridx = 1; gbc.gridy = 3; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1;
        frame.add(peopleField, gbc);

        // Emergency Service
        JLabel serviceLabel = new JLabel("Emergency Service:");
        gbc.gridx = 0; gbc.gridy = 4;
        frame.add(serviceLabel, gbc);

        String[] services = {"Ambulance","Fire Force","Police","Rescue Team","Disaster Management"};
        JComboBox<String> serviceBox = new JComboBox<>(services);
        gbc.gridx = 1; gbc.gridy = 4; gbc.fill = GridBagConstraints.HORIZONTAL; gbc.weightx = 1;
        frame.add(serviceBox, gbc);

        // Submit Button
        JButton submitButton = new JButton("Submit Emergency Report");
        gbc.gridx = 0; gbc.gridy = 5; gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(submitButton, gbc);

        // ================= EVENT HANDLING =================

        // Exit confirmation
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int choice = JOptionPane.showConfirmDialog(
                        frame,
                        "Are you sure you want to exit?",
                        "Confirm Exit",
                        JOptionPane.YES_NO_OPTION,
                        JOptionPane.QUESTION_MESSAGE
                );
                if (choice == JOptionPane.YES_OPTION) {
                    frame.dispose();
                }
            }
        });

        // ItemListener for Emergency Type
        typeBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedType = (String) typeBox.getSelectedItem();
                if ("Medical Emergency".equals(selectedType)) {
                    serviceBox.setSelectedItem("Ambulance");
                } else if ("Fire Incident".equals(selectedType)) {
                    serviceBox.setSelectedItem("Fire Force");
                }
            }
        });

        // ItemListener for Priority
        priorityBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedPriority = (String) priorityBox.getSelectedItem();
                if ("Critical".equals(selectedPriority)) {
                    JOptionPane.showMessageDialog(frame,
                            "⚠ Critical Priority! Immediate action required.",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                }
            }
        });

        // ServiceBox listener (optional handling)
        serviceBox.addItemListener(e -> {
            if (e.getStateChange() == ItemEvent.SELECTED) {
                String selectedService = (String) serviceBox.getSelectedItem();
                JOptionPane.showMessageDialog(frame,
                        "Service selected: " + selectedService,
                        "Info",
                        JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Submit button validation + report
        submitButton.addActionListener(e -> {
            String type = (String) typeBox.getSelectedItem();
            String priority = (String) priorityBox.getSelectedItem();
            String service = (String) serviceBox.getSelectedItem();
            String peopleText = peopleField.getText().trim();

            // Validation
            if (peopleText.isEmpty()) {
                JOptionPane.showMessageDialog(frame,
                        "Please enter number of people affected.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return;
            }
            try {
                int people = Integer.parseInt(peopleText);
                if (people < 0) throw new NumberFormatException();

                // Success message
                JOptionPane.showMessageDialog(frame,
                        "Report Submitted Successfully!\n\n" +
                        "Type: " + type + "\n" +
                        "Priority: " + priority + "\n" +
                        "People Affected: " + people + "\n" +
                        "Service: " + service,
                        "Success",
                        JOptionPane.INFORMATION_MESSAGE);

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(frame,
                        "Invalid number for People Affected.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
            }
        });

        // Show Frame
        frame.setVisible(true);
    }
}

