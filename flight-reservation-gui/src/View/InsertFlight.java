package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Timestamp;

import javax.swing.*;

import Controller.Controller;

public class InsertFlight implements Page {
	private Controller controller = Controller.getInstance();

	public void run() {
		
		//New Frame for Query Selection
        JFrame frame = new JFrame("Insertion for Flight");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 460);
        frame.setLocationRelativeTo(null);
        
        //Building Interface
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        //Building Components for Query Selection
        JLabel welcomeLabel = new JLabel("Please Insert Flight Information");   
        
        JLabel depatureLocation = new JLabel("Departure Location");
        JLabel arrivalLoction = new JLabel("Arrival Location");
        JLabel departureTime = new JLabel("Depature Time");
        JLabel arrivalTime = new JLabel("Arrival TIme");
        JLabel aircraftID = new JLabel("Aircraft ID");
        JLabel crewID1 = new JLabel("Crew ID 1");
        JLabel crewID2 = new JLabel("Crew ID 2");
        JLabel crewID3 = new JLabel("Crew ID 3");
        
        JTextField depatureLocationField = new JTextField();
        JTextField arrivalLocationField = new JTextField();
        JTextField depatureTimeField = new JTextField();
        JTextField arrivalTimeField = new JTextField();
        JTextField aircraftIDField = new JTextField();
        JTextField crewID1Field = new JTextField();
        JTextField crewID2Field = new JTextField();
        JTextField crewID3Field = new JTextField();

        JButton insertButton = new JButton("Insert");
        JButton browseFlights = new JButton("Browse Flights");
        JButton backButton = new JButton("Back");
        

        //Set Locations of components
        welcomeLabel.setBounds(20, 0, 300, 25);
        depatureLocation.setBounds(20, 30, 150, 25);
        arrivalLoction.setBounds(20, 60, 150, 25);
        departureTime.setBounds(20, 90, 150, 25);
        arrivalTime.setBounds(20, 120, 150, 25);
        aircraftID.setBounds(20, 150, 150, 25);
        crewID1.setBounds(20, 180, 210, 25);
        crewID2.setBounds(20, 210, 240, 25);
        crewID3.setBounds(20, 240, 270, 25);
        
        depatureLocationField.setBounds(200, 30, 150, 25);
        arrivalLocationField.setBounds(200, 60, 150, 25);
        depatureTimeField.setBounds(200, 90, 150, 25);
        arrivalTimeField.setBounds(200, 120, 150, 25);
        aircraftIDField.setBounds(200, 150, 150, 25);
        crewID1Field.setBounds(200, 180, 150, 25);
        crewID2Field.setBounds(200,210, 150, 25);
        crewID3Field.setBounds(200, 240, 150, 25);
        
        insertButton.setBounds(125, 270, 150, 25);
        browseFlights.setBounds(125,300, 150, 25);
        backButton.setBounds(125, 330, 150 ,25);
        
           
        panel.add(welcomeLabel);
        panel.add(depatureLocation);
        panel.add(arrivalLoction);
        panel.add(departureTime);
        panel.add(arrivalTime);
        panel.add(aircraftID);
        panel.add(crewID1);
        panel.add(crewID2);
        panel.add(crewID3);
        
        panel.add(depatureLocationField);
        panel.add(arrivalLocationField);
        panel.add(depatureTimeField);
        panel.add(arrivalTimeField);
        panel.add(aircraftIDField);
        panel.add(crewID1Field);
        panel.add(crewID2Field);
        panel.add(crewID3Field);
        
        
        panel.add(insertButton);
        panel.add(browseFlights);
        panel.add(backButton);
        
        
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String departureLocation = depatureLocationField.getText();
            	String arrivalLocation = arrivalLocationField.getText();
            	
            	String departureString = depatureTimeField.getText();
            	Timestamp departureTime = Timestamp.valueOf(departureString);
            	
            	String arrivalString = arrivalTimeField.getText();
            	Timestamp arrivalTime = Timestamp.valueOf(arrivalString);
            	
            	int aircraftID = Integer.parseInt(aircraftIDField.getText());
            	int crew1ID = Integer.parseInt(crewID1Field.getText());
            	int crew2ID = Integer.parseInt(crewID2Field.getText());
            	int crew3ID = Integer.parseInt(crewID3Field.getText());
            	
            	controller.insertFlight(departureLocation, arrivalLocation, departureTime, arrivalTime, 
            							aircraftID, crew1ID, crew2ID, crew3ID);
                JOptionPane.showMessageDialog(null, "Flight Information Inserted", "Success", JOptionPane.INFORMATION_MESSAGE);
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
