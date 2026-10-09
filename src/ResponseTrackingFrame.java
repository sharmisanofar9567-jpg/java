import javax.swing.*;
import java.awt.*;

public class ResponseTrackingFrame {

    public static void main(String[] args) {

        JFrame frame = new JFrame("RESQ - Response Tracking");

        frame.setSize(700, 650);
        frame.setLayout(new BorderLayout());
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Title

        JLabel title = new JLabel("RESPONSE TRACKING");
        

        JPanel titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.add(title);

        frame.add(titlePanel, BorderLayout.NORTH);


        // Main Panel

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));


        // Emergency ID

        JPanel searchPanel =
                new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel idLabel = new JLabel("Emergency ID:");
        JTextField idField = new JTextField(15);
        JButton trackButton = new JButton("Track");

        searchPanel.add(idLabel);
        searchPanel.add(idField);
        searchPanel.add(trackButton);

        mainPanel.add(searchPanel);


        // Emergency Information

        JPanel emergencyPanel = new JPanel();

        emergencyPanel.setLayout(new GridLayout(4, 2));

        emergencyPanel.setBorder(
                BorderFactory.createTitledBorder("Emergency Information")
        );

        JLabel typeLabel = new JLabel("Emergency Type:");
        JLabel typeValue = new JLabel("Medical");

        JLabel locationLabel = new JLabel("Location:");
        JLabel locationValue = new JLabel("Kollam");

        JLabel priorityLabel = new JLabel("Priority:");
        JLabel priorityValue = new JLabel("HIGH");

        JLabel timeLabel = new JLabel("Reported Time:");
        JLabel timeValue = new JLabel("10:30 AM");

        emergencyPanel.add(typeLabel);
        emergencyPanel.add(typeValue);

        emergencyPanel.add(locationLabel);
        emergencyPanel.add(locationValue);

        emergencyPanel.add(priorityLabel);
        emergencyPanel.add(priorityValue);

        emergencyPanel.add(timeLabel);
        emergencyPanel.add(timeValue);

        mainPanel.add(emergencyPanel);


        // Assigned Resource

        JPanel resourcePanel = new JPanel();

        resourcePanel.setLayout(new GridLayout(2, 2));

        resourcePanel.setBorder(
                BorderFactory.createTitledBorder("Assigned Resource")
        );

        JLabel resourceLabel = new JLabel("Resource:");
        JLabel resourceValue = new JLabel("Ambulance AMB-102");

        JLabel teamLabel = new JLabel("Team:");
        JLabel teamValue = new JLabel("Medical Team");

        resourcePanel.add(resourceLabel);
        resourcePanel.add(resourceValue);

        resourcePanel.add(teamLabel);
        resourcePanel.add(teamValue);

        mainPanel.add(resourcePanel);


        // Current Status

        JPanel statusPanel =
                new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel statusLabel = new JLabel("Current Status:");
        JLabel statusValue = new JLabel("Dispatched");

        statusPanel.add(statusLabel);
        statusPanel.add(statusValue);

        mainPanel.add(statusPanel);


        // Response Details

        JPanel detailsPanel =
                new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel detailsLabel = new JLabel("Response Details:");

        JTextArea detailsArea = new JTextArea(3, 35);

        detailsArea.setText(
                "Medical team has been dispatched to the location."
        );

        detailsArea.setEditable(false);
        detailsArea.setLineWrap(true);
        detailsArea.setWrapStyleWord(true);

        detailsPanel.add(detailsLabel);
        detailsPanel.add(detailsArea);

        mainPanel.add(detailsPanel);


        frame.add(mainPanel, BorderLayout.CENTER);


        // Buttons

        JPanel buttonPanel =
                new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton refreshButton = new JButton("Refresh");
        JButton backButton = new JButton("Back");

        buttonPanel.add(refreshButton);
        buttonPanel.add(backButton);

        frame.add(buttonPanel, BorderLayout.SOUTH);


        frame.setVisible(true);
    }
}