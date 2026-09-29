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
        JLabel idLabel = new JLabel("Emergency ID:");
        idLabel.setBounds(40, 90, 120, 25);
        frame.add(idLabel);

        JTextField idField = new JTextField("ER001");
        idField.setBounds(170, 90, 250, 25);
        idField.setEditable(false);
        frame.add(idField);


        // Emergency Type
        JLabel typeLabel = new JLabel("Emergency Type:");
        typeLabel.setBounds(40, 135, 120, 25);
        frame.add(typeLabel);

        JTextField typeField = new JTextField("Medical Emergency");
        typeField.setBounds(170, 135, 250, 25);
        typeField.setEditable(false);
        frame.add(typeField);


        // Severity / Priority
        JLabel priorityLabel = new JLabel("Severity / Priority:");
        priorityLabel.setBounds(40, 180, 120, 25);
        frame.add(priorityLabel);

        JTextField priorityField = new JTextField("Critical");
        priorityField.setBounds(170, 180, 250, 25);
        priorityField.setEditable(false);
        frame.add(priorityField);


        // People Affected
        JLabel peopleLabel = new JLabel("People Affected:");
        peopleLabel.setBounds(40, 225, 120, 25);
        frame.add(peopleLabel);

        JTextField peopleField = new JTextField("3");
        peopleField.setBounds(170, 225, 250, 25);
        peopleField.setEditable(false);
        frame.add(peopleField);


        // Photo / Evidence
        JLabel photoLabel = new JLabel("Photo / Evidence:");
        photoLabel.setBounds(40, 270, 120, 25);
        frame.add(photoLabel);

        JTextField photoField = new JTextField("Attached");
        photoField.setBounds(170, 270, 250, 25);
        photoField.setEditable(false);
        frame.add(photoField);


        // Emergency Service
        JLabel serviceLabel = new JLabel("Emergency Service:");
        serviceLabel.setBounds(40, 315, 120, 25);
        frame.add(serviceLabel);

        JTextField serviceField = new JTextField("Ambulance");
        serviceField.setBounds(170, 315, 250, 25);
        serviceField.setEditable(false);
        frame.add(serviceField);


        // Show Frame
        frame.setVisible(true);
    }
}