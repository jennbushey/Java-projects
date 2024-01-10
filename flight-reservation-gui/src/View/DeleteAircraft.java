package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.Controller;

public class DeleteAircraft implements Page {
	private Controller controller = Controller.getInstance();

	public void run() {
		
		//New Frame for Query Selection
        JFrame frame = new JFrame("Deletion for Aircrafts");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 200);
        frame.setLocationRelativeTo(null);
        
        //Building Interface
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        //Building Components for Query Selection
        JLabel welcomeLabel = new JLabel("Please Delete Aircraft By Aircraft ID");   
        JLabel aircraftID = new JLabel("Aircraft ID");
        JTextField aircraftIDText = new JTextField();
        JButton DeleteButton = new JButton("Delete");
        JButton browseAircrafts = new JButton("Browse Aircrafts");
        JButton backButton = new JButton("Back");
        

        //Set Locations of components
        welcomeLabel.setBounds(30, 0, 300, 25);
        aircraftID.setBounds(30, 30, 120, 25);
        aircraftIDText.setBounds(30, 60, 120, 25);
        aircraftIDText.setBounds(140, 30, 150, 25);
        DeleteButton.setBounds(85, 60, 150, 25);
        browseAircrafts.setBounds(85, 90, 150, 25);
        backButton.setBounds(85, 120, 150, 25);
        
        
        panel.add(welcomeLabel);
        panel.add(aircraftID);
        panel.add(aircraftIDText);
        panel.add(DeleteButton);
        panel.add(browseAircrafts);
        panel.add(backButton);
        
        DeleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int aircraftID = Integer.parseInt(aircraftIDText.getText());
            	controller.deleteAircraft(aircraftID);
                JOptionPane.showMessageDialog(null, "Aircraft Information Deleted", "Success", JOptionPane.INFORMATION_MESSAGE);            }
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
