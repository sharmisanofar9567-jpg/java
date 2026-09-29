package src;
import javax.swing.*;

public class EmergencyDetailsFrame {

    public static void main(String[] args) {

        // Create Frame
        JFrame frame = new JFrame("RESQ - Emergency Details");

        frame.setSize(500, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);


        // Title
        JLabel titleLabel = new JLabel("Emergency Details");
        titleLabel.setBounds(170, 30, 200, 30);
        frame.add(titleLabel);


        // Emergency ID
        JLabel idLabel = new JLabel("Emergency ID: ER001");
        idLabel.setBounds(40, 90, 300, 25);
        frame.add(idLabel);


        // Emergency Type
        JLabel typeLabel = new JLabel("Emergency Type: Medical Emergency");
        typeLabel.setBounds(40, 135, 350, 25);
        frame.add(typeLabel);


        // Severity / Priority
        JLabel priorityLabel = new JLabel("Severity / Priority: Critical");
        priorityLabel.setBounds(40, 180, 350, 25);
        frame.add(priorityLabel);


        // People Affected
        JLabel peopleLabel = new JLabel("People Affected: 3");
        peopleLabel.setBounds(40, 225, 300, 25);
        frame.add(peopleLabel);


        // Photo / Evidence
        JLabel photoLabel = new JLabel("Photo / Evidence: Attached");
        photoLabel.setBounds(40, 270, 350, 25);
        frame.add(photoLabel);


        // Emergency Service
        JLabel serviceLabel = new JLabel("Emergency Service: Ambulance");
        serviceLabel.setBounds(40, 315, 350, 25);
        frame.add(serviceLabel);


        // Show Frame
        frame.setVisible(true);
    }
}