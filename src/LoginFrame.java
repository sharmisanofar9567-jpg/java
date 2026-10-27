import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

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
        gbc.gridx = 0; gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(title, gbc);

        // Subtitle
        JLabel subtitle = new JLabel("Emergency Reporting System");
        gbc.gridx = 0; gbc.gridy = 1;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        frame.add(subtitle, gbc);

        // Username
        JLabel usernameLabel = new JLabel("Username:");
        gbc.gridx = 0; gbc.gridy = 2;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        frame.add(usernameLabel, gbc);

        JTextField usernameField = new JTextField(18);
        gbc.gridx = 1; gbc.gridy = 2;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        frame.add(usernameField, gbc);

        // Password
        JLabel passwordLabel = new JLabel("Password:");
        gbc.gridx = 0; gbc.gridy = 3;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        frame.add(passwordLabel, gbc);

        JPasswordField passwordField = new JPasswordField(18);
        gbc.gridx = 1; gbc.gridy = 3;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        frame.add(passwordField, gbc);

        // Role Selection
        JLabel roleLabel = new JLabel("Login as:");
        gbc.gridx = 0; gbc.gridy = 4;
        gbc.fill = GridBagConstraints.NONE;
        gbc.weightx = 0;
        frame.add(roleLabel, gbc);

        String[] roles = {"Admin", "User"};
        JComboBox<String> roleBox = new JComboBox<>(roles);
        roleBox.setPreferredSize(new Dimension(180, 25)); // fixes overlap
        gbc.gridx = 1; gbc.gridy = 4;
        gbc.fill = GridBagConstraints.HORIZONTAL;
        gbc.weightx = 1;
        frame.add(roleBox, gbc);

        // Buttons
        JButton loginButton = new JButton("Login");
        JButton clearButton = new JButton("Clear");
        JPanel buttonPanel = new JPanel();
        buttonPanel.add(loginButton);
        buttonPanel.add(clearButton);

        gbc.gridx = 0; gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        gbc.fill = GridBagConstraints.NONE;
        frame.add(buttonPanel, gbc);

        // EVENT HANDLING - Login Button
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText().trim();
                String password = new String(passwordField.getPassword()).trim();
                String role = (String) roleBox.getSelectedItem();

                // No hardcoded credentials: just show success
                JOptionPane.showMessageDialog(frame,
                    role + " Login Successful!\nUsername: " + username);
            }
        });

        // EVENT HANDLING - Clear Button
        clearButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                usernameField.setText("");
                passwordField.setText("");
                roleBox.setSelectedIndex(0);
                JOptionPane.showMessageDialog(frame, "Fields Cleared!");
            }
        });

        // Show Frame
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }
}
