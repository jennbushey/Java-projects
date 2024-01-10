package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.Controller;

public class InsertAircraft implements Page {
	private Controller controller = Controller.getInstance();

	public void run() {
		
		//New Frame for Query Selection
        JFrame frame = new JFrame("Insertion for Aircrafts");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 200);
        frame.setLocationRelativeTo(null);
        
        //Building Interface
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        //Building Components for Query Selection
        JLabel welcomeLabel = new JLabel("Please Insert Aircraft Information");   
        JLabel aircraftModel = new JLabel("Aircraft Model");
        JTextField aircraftModelText = new JTextField();
        JButton insertButton = new JButton("Insert");
        JButton browseAircrafts = new JButton("Browse Aircrafts");
        JButton backButton = new JButton("Back");
        

        //Set Locations of components
        welcomeLabel.setBounds(30, 0, 200, 25);
        aircraftModel.setBounds(30, 30, 120, 25);
        aircraftModelText.setBounds(140, 30, 150, 25);
        insertButton.setBounds(85, 60, 150, 25);
        browseAircrafts.setBounds(85, 90, 150, 25);
        backButton.setBounds(85, 120, 150, 25);
        
        
        panel.add(welcomeLabel);
        panel.add(aircraftModel);
        panel.add(aircraftModelText);
        panel.add(insertButton);
        panel.add(browseAircrafts);
        panel.add(backButton);
        
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String aircraftModel = aircraftModelText.getText();
            	
            	controller.insertAircraft(aircraftModel);
                JOptionPane.showMessageDialog(null, "Aircraft Information Inserted", "Success", JOptionPane.INFORMATION_MESSAGE);
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

