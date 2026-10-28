package src;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("RESQ - Login");

        frame.setSize(500, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridBagLayout());

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);

        // Title
        JLabel title = new JLabel("RESQ");
        title.setFont(new Font("Arial", Font.BOLD, 28));

        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(title, gbc);

        // Subtitle
        JLabel subtitle = new JLabel("Emergency Reporting System");

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
        frame.add(subtitle, gbc);

        // Username
        JLabel usernameLabel = new JLabel("Username:");

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        frame.add(usernameLabel, gbc);

        JTextField usernameField = new JTextField(18);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        frame.add(usernameField, gbc);

        // Password
        JLabel passwordLabel = new JLabel("Password:");

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        frame.add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField(18);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        frame.add(passwordField, gbc);

        // Buttons
        JButton loginButton = new JButton("Login");
        JButton clearButton = new JButton("Clear");

        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loginButton);
        buttonPanel.add(clearButton);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        frame.add(buttonPanel, gbc);

        // Login Button Event Handling
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String username = usernameField.getText().trim();
                String password =
                        new String(passwordField.getPassword());

                if (username.equals("admin")
                        && password.equals("admin123")) {

                    AdmindashboardFrame admin =
                            new AdmindashboardFrame();

                    admin.setVisible(true);
                    frame.dispose();

                } else if (username.equals("user")
                        && password.equals("user123")) {

                    UserDashboard user =
                            new UserDashboard();

                    user.setVisible(true);
                    frame.dispose();

                } else {

                    JOptionPane.showMessageDialog(
                            frame,
                            "Invalid Username or Password"
                    );
                }
            }
        });

        // Clear Button Event Handling
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                usernameField.setText("");
                passwordField.setText("");
            }
        });

        // Show Login Frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
