package src;
import java.awt.*;
import javax.swing.*;

public class EmergencyDetailsFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("RESQ - Emergency Details");

        frame.setSize(600, 450);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setLayout(new GridLayout(7, 2, 10, 10));

        // Title
        JLabel title = new JLabel("Emergency Details");

        frame.add(title);
        frame.add(new JLabel(""));

        // Emergency ID
        JLabel idLabel = new JLabel("Emergency ID:");
        JLabel idValue = new JLabel("ER001");

        frame.add(idLabel);
        frame.add(idValue);

        // Emergency Type
        JLabel typeLabel = new JLabel("Emergency Type:");
        JLabel typeValue = new JLabel("Fire Incident");

        frame.add(typeLabel);
        frame.add(typeValue);

        // Severity / Priority
        JLabel priorityLabel =
                new JLabel("Severity / Priority:");

        JLabel priorityValue =
                new JLabel("Critical");

        frame.add(priorityLabel);
        frame.add(priorityValue);

        // People Affected
        JLabel peopleLabel =
                new JLabel("People Affected:");

        JLabel peopleValue =
                new JLabel("5");

        frame.add(peopleLabel);
        frame.add(peopleValue);

        // Photo / Evidence
        JLabel photoLabel =
                new JLabel("Photo / Evidence:");

        JLabel photoValue =
                new JLabel("fire.jpg");

        frame.add(photoLabel);
        frame.add(photoValue);

        // Emergency Service
        JLabel serviceLabel =
                new JLabel("Emergency Service:");

        JLabel serviceValue =
                new JLabel("Fire Force");

        frame.add(serviceLabel);
        frame.add(serviceValue);

        // Show Frame
        frame.setVisible(true);
    }
}