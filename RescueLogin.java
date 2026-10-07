import javax.swing.*;
import java.awt.*;

public class RescueLogin extends JFrame {

    private JTextField username;
    private JPasswordField password;
    private JButton login;
    private JButton clear;

    public RescueLogin() {
        setTitle("Rescue - Login");
        setSize(400, 220);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel with padding
        JPanel panel = new JPanel(new BorderLayout(10, 10));
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Heading
        JLabel title = new JLabel("RESCUE LOGIN", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 22));
        panel.add(title, BorderLayout.NORTH);

        // Form panel
        JPanel form = new JPanel(new GridLayout(2, 2, 10, 10));

        form.add(new JLabel("Username:"));
        username = new JTextField();
        form.add(username);

        form.add(new JLabel("Password:"));
        password = new JPasswordField();
        form.add(password);

        panel.add(form, BorderLayout.CENTER);

        // Buttons panel
        JPanel buttons = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        login = new JButton("Login");
        clear = new JButton("Clear");

        buttons.add(login);
        buttons.add(clear);
        panel.add(buttons, BorderLayout.SOUTH);

        // Button actions (do nothing)
        login.addActionListener(e -> {
            // intentionally left blank
        });

        clear.addActionListener(e -> {
            // intentionally left blank
        });

        add(panel);
        setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(RescueLogin::new);
    }
}