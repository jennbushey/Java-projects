package View;
import Controller.*;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/*
 * Building interface for registered users
 */

public class FlightAgentsInterface {
	private Controller controller = Controller.getInstance();
	
	public void run() {
		
		//New Frame for Flight Agent User
        JFrame frame = new JFrame("Flight Agent");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 170);
        frame.setLocationRelativeTo(null);
        
        //Building Interface
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        //Building Components for Flight Agent User
        JLabel welcomeLabel = new JLabel("Hello Agent!");   
        JButton browseManifestListButton = new JButton("Passenger Mainfest");
        JButton bookFlightButton = new JButton("Book A Flight");
        JButton backButton = new JButton("Back");

        //Set Locations of components
        welcomeLabel.setBounds(110, 0, 200, 25);
        browseManifestListButton.setBounds(70, 30, 150, 25);
        bookFlightButton.setBounds(70, 60, 150, 25);
        backButton.setBounds(70, 90, 150, 25);
        
        //Add all components to the panel
        panel.add(welcomeLabel);
        panel.add(browseManifestListButton);
        panel.add(bookFlightButton);
        panel.add(backButton);
        
        //Buttons do something when clicked
        browseManifestListButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	controller.setState("SelectFlightForManifest");
            }
        });  
         
        
        bookFlightButton.addActionListener(new ActionListener() {
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
