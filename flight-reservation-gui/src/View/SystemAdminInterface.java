package View;
import Controller.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Interface for System Admin
 */
public class SystemAdminInterface {
	private Controller controller = Controller.getInstance();

	public void run() {
		
		//New Frame for System Admin User
        JFrame frame = new JFrame("System Administrator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 330);
        frame.setLocationRelativeTo(null);
        
        //Building Interface
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        //Building Components for System Administrator User
        JLabel welcomeLabel = new JLabel("Hello System Administrator!");   
        
        JButton browseFlightButton = new JButton("Browse Flight");
        JButton browseCrewButton = new JButton("Browse Crew");
        JButton browseAircraftButton = new JButton("Browse Aircraft");
        
        JButton manageCrewButton = new JButton("Manage Crew");
        JButton manageAircraftButton = new JButton("Manage Aircraft");
        JButton manageFlightsButton = new JButton("Manage Flights");
        
        JButton printRegisteredUsersButton = new JButton("Display Registered Users");
        JButton managePromosButton = new JButton("Manage Promos");
        JButton backButton = new JButton("Back");

        //Set Locations of components
        welcomeLabel.setBounds(65, 0, 200, 25);
        browseFlightButton.setBounds(70, 30, 150, 25);
        browseCrewButton.setBounds(70, 60, 150, 25);
        browseAircraftButton.setBounds(70, 90, 150, 25);
        manageCrewButton.setBounds(70, 120, 150, 25);
        manageAircraftButton.setBounds(70, 150, 150, 25);
        manageFlightsButton.setBounds(70, 180, 150, 25);
        printRegisteredUsersButton.setBounds(45, 210, 200, 25);
        managePromosButton.setBounds(70, 240, 150, 25);
        backButton.setBounds(70, 270, 150, 25);
        
        //Add all components to the panel
        panel.add(welcomeLabel);
        panel.add(browseFlightButton);
        panel.add(browseCrewButton);
        panel.add(browseAircraftButton);
        panel.add(manageCrewButton);
        panel.add(manageAircraftButton);
        panel.add(manageFlightsButton);
        panel.add(printRegisteredUsersButton);
        panel.add(managePromosButton);
        panel.add(backButton);

        
        //Buttons do something when clicked
        browseFlightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	controller.setState("BrowseSystemAdminFlights");
            }
        });  
        
        
        browseCrewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	controller.setState("BrowseCrews");
            }
        });  
        
        browseAircraftButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	controller.setState("BrowseAircrafts");
            }
        });  
        
        manageCrewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	controller.setState("QuerySelectionCrews");
            }
        });  

        manageAircraftButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	controller.setState("QuerySelectionAircrafts");
            }
        });  
        
        manageFlightsButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	controller.setState("QuerySelectionFlights");
            }
        });  
        
        printRegisteredUsersButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	controller.setState("BrowseRegisteredUsers");
            }
        });
        
        managePromosButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	controller.setState("ManagePromos");
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
