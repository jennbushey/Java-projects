package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

import javax.swing.*;

import Controller.Controller;

public class UpdateFlight implements Page {
	private Controller controller = Controller.getInstance();

	public void run() {
		
		//New Frame for Query Selection
        JFrame frame = new JFrame("Update for Flight");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 500);
        frame.setLocationRelativeTo(null);
        
        //Building Interface
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        //Building Components for Query Selection
        JLabel welcomeLabel = new JLabel("Please Update Flight Information");   
        JLabel condition = new JLabel("Please Select by FlightID to Update");
        JLabel flightID = new JLabel("Flight ID");
        JLabel next = new JLabel("Add Updated Information");
        JLabel depatureLocation = new JLabel("Departure Location");
        JLabel arrivalLoction = new JLabel("Arrival Location");
        JLabel departureTime = new JLabel("Depature Time");
        JLabel arrivalTime = new JLabel("Arrival TIme");
        JLabel aircraftID = new JLabel("Aircraft ID");
        JLabel crewID1 = new JLabel("Crew ID 1");
        JLabel crewID2 = new JLabel("Crew ID 2");
        JLabel crewID3 = new JLabel("Crew ID 3");
        
        JTextField flightIDField = new JTextField();
        JTextField depatureLocationField = new JTextField();
        JTextField arrivalLocationField = new JTextField();
        JTextField depatureTimeField = new JTextField();
        JTextField arrivalTimeField = new JTextField();
        JTextField aircraftIDField = new JTextField();
        JTextField crewID1Field = new JTextField();
        JTextField crewID2Field = new JTextField();
        JTextField crewID3Field = new JTextField();

        JButton updateButton = new JButton("Update");
        JButton browseFlights = new JButton("Browse Flights");
        JButton backButton = new JButton("Back");
        

        //Set Locations of components
        welcomeLabel.setBounds(20, 0, 300, 25);
        condition.setBounds(20, 30, 300, 25);
        flightID.setBounds(20, 60, 150, 25);
        next.setBounds(20, 90, 300, 25);
        depatureLocation.setBounds(20, 120, 150, 25);
        arrivalLoction.setBounds(20, 150, 150, 25);
        departureTime.setBounds(20, 180, 150, 25);
        arrivalTime.setBounds(20, 210, 150, 25);
        aircraftID.setBounds(20, 240, 150, 25);
        crewID1.setBounds(20, 270, 150, 25);
        crewID2.setBounds(20,300, 150, 25);
        crewID3.setBounds(20, 330, 150, 25);
        
        flightIDField.setBounds(200, 60, 150, 25);
        depatureLocationField.setBounds(200, 120, 150, 25);
        arrivalLocationField.setBounds(200, 150, 150, 25);
        depatureTimeField.setBounds(200, 180, 150, 25);
        arrivalTimeField.setBounds(200, 210, 150, 25);
        aircraftIDField.setBounds(200, 240, 150, 25);
        crewID1Field.setBounds(200, 270, 150, 25);
        crewID2Field.setBounds(200,300, 150, 25);
        crewID3Field.setBounds(200, 330, 150, 25);
        
        updateButton.setBounds(125, 360, 150, 25);
        browseFlights.setBounds(125, 390, 150, 25);
        backButton.setBounds(125, 420, 150 ,25);
        
           
        panel.add(welcomeLabel);
        panel.add(condition);
        panel.add(flightID);
        panel.add(next);
        panel.add(depatureLocation);
        panel.add(arrivalLoction);
        panel.add(departureTime);
        panel.add(arrivalTime);
        panel.add(aircraftID);
        panel.add(crewID1);
        panel.add(crewID2);
        panel.add(crewID3);
        
        panel.add(flightIDField);
        panel.add(depatureLocationField);
        panel.add(arrivalLocationField);
        panel.add(depatureTimeField);
        panel.add(arrivalTimeField);
        panel.add(aircraftIDField);
        panel.add(crewID1Field);
        panel.add(crewID2Field);
        panel.add(crewID3Field);
        
        
        panel.add(updateButton);
        panel.add(browseFlights);
        panel.add(backButton);
        
        
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
            	int flightID = Integer.parseInt(flightIDField.getText());
            	String depatureLocation = depatureLocationField.getText();
            	String arrivalLocation = arrivalLocationField.getText();
            	
            	String departureTime = depatureTimeField.getText();
                Timestamp departureTimeStamp = Timestamp.valueOf(departureTime);
                
            	String arrivalTime = arrivalTimeField.getText();
                Timestamp arrivalTimeStamp = Timestamp.valueOf(arrivalTime);
                
            	int aircraftID = Integer.parseInt(aircraftIDField.getText());
            	int crew1ID = Integer.parseInt(crewID1Field.getText());
            	int crew2ID = Integer.parseInt(crewID2Field.getText());
            	int crew3ID = Integer.parseInt(crewID3Field.getText());
            	
            	controller.updateFlight(flightID, depatureLocation, arrivalLocation, departureTimeStamp, arrivalTimeStamp,
            							aircraftID, crew1ID, crew2ID, crew3ID); 
            	
            	JOptionPane.showMessageDialog(null, "Flight Information Updated", "Success", JOptionPane.INFORMATION_MESSAGE);

            }
        });  
        
        browseFlights.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	controller.setState("BrowseSystemAdminFlights");
            }
        });  
        
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	controller.setState("QuerySelectionFlights");
            }
        });  
        
        //Add panel to frame and set visible
        frame.getContentPane().add(panel); 
        frame.setVisible(true);
	}
}
