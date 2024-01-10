package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.Controller;

public class UpdateAircraft implements Page {
	private Controller controller = Controller.getInstance();

	public void run() {
		
		//New Frame for Query Selection
        JFrame frame = new JFrame("Update for Aircrafts");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 310);
        frame.setLocationRelativeTo(null);
        
        //Building Interface
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        //Building Components for Query Selection
        JLabel welcomeLabel = new JLabel("Please Update Aircraft Information");   
        JLabel condition = new JLabel("Please Select by AircraftID to Update");
        JLabel aircraftID = new JLabel("Aircraft ID");
        JLabel next = new JLabel("Add Updated Information");
        JLabel aircraftModel = new JLabel("Aircraft Model");
        JTextField aircraftIDText = new JTextField();
        JTextField aircraftModelText = new JTextField();
        JButton updateButton = new JButton("Update");
        JButton browseAircrafts = new JButton("Browse Aircrafts");
        JButton backButton = new JButton("Back");
        

        //Set Locations of components
        welcomeLabel.setBounds(30, 0, 200, 25);
        condition.setBounds(30, 30, 300, 25);
        aircraftID.setBounds(30, 60, 120, 25);
        next.setBounds(30, 90, 300, 25);
        aircraftModel.setBounds(30, 120, 120, 25);
        aircraftIDText.setBounds(140, 60, 150, 25);
        aircraftModelText.setBounds(140, 120, 150, 25);
        updateButton.setBounds(85, 150, 150, 25);
        browseAircrafts.setBounds(85, 180, 150, 25);
        backButton.setBounds(85, 210, 150, 25);
        
        
        panel.add(welcomeLabel);
        panel.add(condition);
        panel.add(aircraftID);
        panel.add(next);
        panel.add(aircraftModel);
        panel.add(aircraftIDText);
        panel.add(aircraftModelText);
        panel.add(updateButton);
        panel.add(browseAircrafts);
        panel.add(backButton);
        
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int aircraftID = Integer.parseInt(aircraftIDText.getText());
            	String model = aircraftModelText.getText();
            	
            	controller.updateAircraft(aircraftID, model);
                JOptionPane.showMessageDialog(null, "Aircraft Information Updated", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });  
        
        browseAircrafts.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	controller.setState("BrowseAircrafts");
            }
        });  
        
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	controller.setState("QuerySelectionAircrafts");
            }
        });  
        
        //Add panel to frame and set visible
        frame.getContentPane().add(panel); 
        frame.setVisible(true);
	}
}
