package View;
import Controller.*;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class SelectFlightInterface implements Page{

	private Controller controller = Controller.getInstance();

	public void run() {
		
		// New frame for Selecting a flight
		JFrame frame = new JFrame("Select a flight");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 280);
        frame.setLocationRelativeTo(null);
        
        //Building Interface
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        //Building Components for Registered user  Interface
        JLabel welcomeLabel = new JLabel("Please Enter a Flight ID and Seat ID");
        JLabel flightIDLabel = new JLabel("Flight ID");
        JLabel seatIDLabel = new JLabel("Seat ID");
        JTextField flightIDText = new JTextField();
        JTextField seatIDText = new JTextField();
        JButton selectButton = new JButton("Select");
        JButton browseFlightButton = new JButton("Browse Flights");
        JButton browseSeatButton = new JButton ("Browse Seats");
        JButton backButton = new JButton("Back");
        
        //Set Locations of components
        welcomeLabel.setBounds(20, 0, 300, 25);
        flightIDLabel.setBounds(20, 30, 80, 25);
        seatIDLabel.setBounds(20, 60, 80, 25);
        flightIDText.setBounds(100, 30, 150, 25);
        seatIDText.setBounds(100, 60, 80, 25);
        selectButton.setBounds(70, 90, 150, 25);
        browseFlightButton.setBounds(70, 120, 150 , 25);
        browseSeatButton.setBounds(70, 150, 150, 25);
        backButton.setBounds(70, 180, 150, 25);
        
        //Add all components to the panel
        panel.add(welcomeLabel);
        panel.add(flightIDLabel);
        panel.add(seatIDLabel);
        panel.add(flightIDText);
        panel.add(seatIDText);
        panel.add(selectButton);
        panel.add(browseFlightButton);
        panel.add(browseSeatButton);
        panel.add(backButton);
        
        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	controller.setState("SelectPayment");
            }
        }); 
        
        browseFlightButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	controller.setState("BrowseFlights");
            }
        }); 
        
        browseSeatButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	// Do Something
            }
        }); 
        
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	String current = controller.getPrevState();
            	if(current == "GuestUserInterface") {
            		controller.setState("GuestUserInterface");
            	}
            	else {
            		controller.setState("RegisteredUserInterface");
            	}
            }
        }); 
        
        //Add panel to frame and set visible
        frame.getContentPane().add(panel); 
        frame.setVisible(true);
	}
	

}
