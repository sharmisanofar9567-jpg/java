package src;

import java.awt.*;

import javax.swing.*;

public class LoginFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("RESQ - Login");

        frame.setSize(500, 350);
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

        JPasswordField passwordField =
                new JPasswordField(18);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;

        frame.add(passwordField, gbc);

        // Login Button
        JButton loginButton = new JButton("Login");

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        gbc.anchor = GridBagConstraints.CENTER;

        frame.add(loginButton, gbc);

        // Show Frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}