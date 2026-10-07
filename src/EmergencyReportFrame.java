package src;
import javax.swing.*;

public class EmergencyReportFrame {

    public static void main(String[] args) {

        // Create Frame
        JFrame frame = new JFrame("RESQ - Emergency Reporting");

        frame.setSize(500, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);


        // Title
        JLabel titleLabel = new JLabel("Emergency Reporting");
        titleLabel.setBounds(170, 30, 200, 30);
        frame.add(titleLabel);


        // Emergency Type
        JLabel typeLabel = new JLabel("Emergency Type:");
        typeLabel.setBounds(40, 80, 120, 25);
        frame.add(typeLabel);

        JRadioButton medicalButton = new JRadioButton("Medical Emergency");
        medicalButton.setBounds(160, 75, 150, 25);
        frame.add(medicalButton);

        JRadioButton fireButton = new JRadioButton("Fire Incident");
        fireButton.setBounds(310, 75, 120, 25);
        frame.add(fireButton);

        JRadioButton accidentButton = new JRadioButton("Road Accident");
        accidentButton.setBounds(160, 110, 130, 25);
        frame.add(accidentButton);

        JRadioButton disasterButton = new JRadioButton("Natural Disaster");
        disasterButton.setBounds(290, 110, 140, 25);
        frame.add(disasterButton);

        JRadioButton crimeButton = new JRadioButton("Crime");
        crimeButton.setBounds(160, 145, 80, 25);
        frame.add(crimeButton);

        JRadioButton otherButton = new JRadioButton("Other");
        otherButton.setBounds(240, 145, 80, 25);
        frame.add(otherButton);


        // Severity / Priority
        JLabel priorityLabel = new JLabel("Severity / Priority:");
        priorityLabel.setBounds(40, 195, 120, 25);
        frame.add(priorityLabel);

        JRadioButton criticalButton = new JRadioButton("Critical");
        criticalButton.setBounds(160, 190, 80, 25);
        frame.add(criticalButton);

        JRadioButton highButton = new JRadioButton("High");
        highButton.setBounds(240, 190, 70, 25);
        frame.add(highButton);

        JRadioButton mediumButton = new JRadioButton("Medium");
        mediumButton.setBounds(310, 190, 90, 25);
        frame.add(mediumButton);

        JRadioButton lowButton = new JRadioButton("Low");
        lowButton.setBounds(160, 225, 70, 25);
        frame.add(lowButton);


        // People Affected
        JLabel peopleLabel = new JLabel("People Affected:");
        peopleLabel.setBounds(40, 275, 120, 25);
        frame.add(peopleLabel);

        JTextField peopleField = new JTextField();
        peopleField.setBounds(160, 275, 250, 25);
        frame.add(peopleField);


        // Photo / Evidence
        JLabel photoLabel = new JLabel("Photo / Evidence:");
        photoLabel.setBounds(40, 325, 120, 25);
        frame.add(photoLabel);

        JButton photoButton = new JButton("Choose File");
        photoButton.setBounds(160, 325, 120, 25);
        frame.add(photoButton);

        JLabel optionalLabel = new JLabel("(Optional)");
        optionalLabel.setBounds(290, 325, 80, 25);
        frame.add(optionalLabel);


        // Emergency Service
        JLabel serviceLabel = new JLabel("Emergency Service:");
        serviceLabel.setBounds(40, 375, 120, 25);
        frame.add(serviceLabel);

        JTextField serviceField = new JTextField();
        serviceField.setBounds(160, 375, 250, 25);
        frame.add(serviceField);


        // Submit Button
        JButton submitButton = new JButton("Submit Emergency Report");
        submitButton.setBounds(130, 440, 240, 35);
        frame.add(submitButton);


        // Show Frame
        frame.setVisible(true);
    }
}
		