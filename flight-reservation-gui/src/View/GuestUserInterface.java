package View;
import Controller.*;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Interface for guest user. I dont think we need Constructor
 */
public class GuestUserInterface implements Page{
	
	private Controller controller = Controller.getInstance();
	
	public void run() {
		
		//New Frame for Guest User
        JFrame frame = new JFrame("Guest User");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        
        //Building Interface
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        //Building Components for Guest Interface
        JLabel welcomeLabel = new JLabel("Hello Valued Guest!");   
        JButton bookFlightButton = new JButton("Book Flight");
        JButton browseFlightButton = new JButton("Browse Flights");
        JButton registerButton = new JButton("Register");
        JButton backButton = new JButton("Back");
        
        
        //Set Locations of components
        welcomeLabel.setBounds(centerComponent(frame.getContentPane().getWidth(), 280), 0, 200, 25);
        bookFlightButton.setBounds(centerComponent(frame.getContentPane().getWidth(), 250), 30, 150, 25);
        browseFlightButton.setBounds(centerComponent(frame.getContentPane().getWidth(), 250), 60, 150, 25);
        registerButton.setBounds(centerComponent(frame.getContentPane().getWidth(), 250), 90, 150, 25);
        backButton.setBounds(centerComponent(frame.getContentPane().getWidth(), 250), 120, 150 ,25);
        
        
        //Add all components to the panel
        panel.add(welcomeLabel);
        panel.add(bookFlightButton);
        panel.add(browseFlightButton);
        panel.add(registerButton);
        panel.add(backButton);
        
        //Do something when buttons are clicked
        bookFlightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	controller.setState("BrowseFlights");
            }
        });    
        
        browseFlightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	controller.setState("BrowseFlights");
            }
        });   
        
        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	controller.setState("Register");
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
