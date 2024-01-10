package View;
import Controller.*;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenu implements Page{

	private Controller controller = Controller.getInstance();
	
	public void run() {
        JFrame frame = new JFrame("Flight Booking App");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 250);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        JLabel welcomeLabel = new JLabel("Welcome to the Flight Booking App!");
        JButton loginButton = new JButton("Log In");
        JButton browseFlightsButton = new JButton("Browse Flights");
        JButton cancelFlightButton = new JButton("Cancel Flight");


        // Log In button action listener
        loginButton.addActionListener(e -> {
        	frame.dispose();
        	controller.setState("LoginApp");
        });

        // Browse Flights button action listener
        browseFlightsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	controller.setState("BrowseFlights");
            }
        });
        
        cancelFlightButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	controller.setState("CancelFlight");
            }
        });

        // Add components to the panel
        panel.add(welcomeLabel);
        panel.add(loginButton);
        panel.add(browseFlightsButton);
        panel.add(cancelFlightButton);

        // Add the panel to the frame
        frame.getContentPane().add(panel);

        // Set layout manager (null for absolute positioning)
        panel.setLayout(null);

        // Set component bounds (x, y, width, height)
        // center components(int x, int frame width)
        welcomeLabel.setBounds(centerComponent(frame.getContentPane().getWidth(), 80) , 20, 300, 30);
        loginButton.setBounds(centerComponent(frame.getContentPane().getWidth(), 150), 60, 150, 30);
        browseFlightsButton.setBounds(centerComponent(frame.getContentPane().getWidth(), 150), 100, 150, 30);
        cancelFlightButton.setBounds(centerComponent(frame.getContentPane().getWidth(), 150), 140, 150, 30);

        // Make the frame visible
        frame.setVisible(true);
	}
}
