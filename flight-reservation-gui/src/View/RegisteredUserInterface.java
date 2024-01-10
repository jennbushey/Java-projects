package View;
import Controller.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Building interface for registered users
 */
public class RegisteredUserInterface {
	private Controller controller = Controller.getInstance();

	public void run() {
		
		//New Frame for Registered User
        JFrame frame = new JFrame("Registered User");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        
        //Building Interface
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        //Building Components for Registered user  Interface
        JLabel welcomeLabel = new JLabel("Hello Registered User");
        JButton browseFlightButton = new JButton("Browse Flights");
        JButton backButton = new JButton("Back");
        
        //Set Locations of components
        welcomeLabel.setBounds(80, 0, 200, 25);
        browseFlightButton.setBounds(70, 60, 150, 25);
        backButton.setBounds(70, 90, 150, 25);
        
        //Add all components to the panel
        panel.add(welcomeLabel);
        panel.add(browseFlightButton);
        panel.add(backButton);
        
        browseFlightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	controller.setState("BrowseFlights");
            }
        }); 
        
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	controller.setState("LoginApp");
            }
        });  
         
        
        //Add panel to frame and set visible
        frame.getContentPane().add(panel); 
        frame.setVisible(true);
	}
}
