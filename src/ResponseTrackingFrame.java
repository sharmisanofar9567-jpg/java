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
        JLabel typeValue = new JLabel("-");

        JLabel locationLabel = new JLabel("Location:");
        JLabel locationValue = new JLabel("-");

        JLabel priorityLabel = new JLabel("Priority:");
        JLabel priorityValue = new JLabel("-");

        JLabel timeLabel = new JLabel("Reported Time:");
        JLabel timeValue = new JLabel("-");

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
        JLabel resourceValue = new JLabel("-");

        JLabel teamLabel = new JLabel("Team:");
        JLabel teamValue = new JLabel("-");

        resourcePanel.add(resourceLabel);
        resourcePanel.add(resourceValue);

        resourcePanel.add(teamLabel);
        resourcePanel.add(teamValue);
        
        
      
        
        
        
        mainPanel.add(resourcePanel);


        // Current Status

        JPanel statusPanel =
                new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel statusLabel = new JLabel("Current Status:");
        JLabel statusValue = new JLabel("-");

        statusPanel.add(statusLabel);
        statusPanel.add(statusValue);

        
        
        mainPanel.add(statusPanel);


        // Response Details

        JPanel detailsPanel =
                new JPanel(new FlowLayout(FlowLayout.LEFT));

        JLabel detailsLabel = new JLabel("Response Details:");

        JTextArea detailsArea = new JTextArea(3, 35);

        detailsArea.setText("");

        detailsArea.setEditable(false);
        detailsArea.setLineWrap(true);
        detailsArea.setWrapStyleWord(true);

        detailsPanel.add(detailsLabel);
        detailsPanel.add(detailsArea);

        
       
        mainPanel.add(detailsPanel);
       
        


        frame.add(mainPanel, BorderLayout.CENTER);

        trackButton.addActionListener(e -> {
    try {
        String id = idField.getText();

        if (id.isEmpty()) {
            JOptionPane.showMessageDialog(
                frame, "Please enter Emergency ID"
            );
            return;
        }
        else if (id.equals("E001")) {
            typeValue.setText("Medical");
            locationValue.setText("Kollam");
            priorityValue.setText("HIGH");
            timeValue.setText("10:30 AM");
            resourceValue.setText("Ambulance AMB-102");
            teamValue.setText("Medical Team");
            statusValue.setText("Dispatched");
            detailsArea.setText(
                "Medical team has been dispatched to the location."
            );
            emergencyPanel.setVisible(true);
            resourcePanel.setVisible(true);
            statusPanel.setVisible(true);
            detailsPanel.setVisible(true);
        }
        else {
            JOptionPane.showMessageDialog(
                frame, "Emergency ID not found"
            );
        }
    } catch (Exception ex) {
        JOptionPane.showMessageDialog(
            frame,
            "An error occurred while tracking the emergency.",
            "Error",
            JOptionPane.ERROR_MESSAGE
        );
    }
});
        // Buttons

        JPanel buttonPanel =
                new JPanel(new FlowLayout(FlowLayout.CENTER));

        JButton refreshButton = new JButton("Refresh");
        JButton backButton = new JButton("Back");

        buttonPanel.add(refreshButton);
        buttonPanel.add(backButton);
        refreshButton.addActionListener(e -> {
            idField.setText("");

            typeValue.setText("-");
            locationValue.setText("-");
            priorityValue.setText("-");
            timeValue.setText("-");

            resourceValue.setText("-");
            teamValue.setText("-");
            statusValue.setText("-");

            detailsArea.setText("");
        });

        frame.add(buttonPanel, BorderLayout.SOUTH);


        frame.setVisible(true);
    }
}
