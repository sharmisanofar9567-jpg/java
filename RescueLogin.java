import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class RescueLogin {

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
        gbc.gridx = 0; gbc.gridy = 0; gbc.gridwidth = 2;
        frame.add(title, gbc);

        // Subtitle
        JLabel subtitle = new JLabel("Emergency Reporting System");
        gbc.gridx = 0; gbc.gridy = 1; gbc.gridwidth = 2;
        frame.add(subtitle, gbc);

        // Username
        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridx = 0; gbc.gridy = 2; gbc.gridwidth = 1;
        frame.add(usernameLabel, gbc);

        JTextField usernameField = new JTextField(18);
        gbc.gridx = 1; gbc.gridy = 2;
        frame.add(usernameField, gbc);

        // Password
        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0; gbc.gridy = 3;
        frame.add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField(18);
        gbc.gridx = 1; gbc.gridy = 3;
        frame.add(passwordField, gbc);

        // Buttons
        JButton loginButton = new JButton("Login");
        JButton clearButton = new JButton("Clear");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loginButton);
        buttonPanel.add(clearButton);

        gbc.gridx = 0; gbc.gridy = 4; gbc.gridwidth = 2;
        frame.add(buttonPanel, gbc);

        // EVENT HANDLING - Login Button
        loginButton.addActionListener(e -> {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (username.equals("admin") && password.equals("1234")) {
                JOptionPane.showMessageDialog(frame, "Login Successful!");

                // ✅ Link to ResourceManagement frame
                ResourceManagement rmFrame = new ResourceManagement();
                rmFrame.setVisible(true);

                // Close login frame
                frame.dispose();
            } else {
                JOptionPane.showMessageDialog(frame, "Invalid Username or Password!");
            }
        });

        // EVENT HANDLING - Clear Button
        clearButton.addActionListener(e -> {
            usernameField.setText("");
            passwordField.setText("");
            JOptionPane.showMessageDialog(frame, "Fields Cleared!");
        });

        // Show Frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
