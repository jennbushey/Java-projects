package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.Controller;

public class DeleteFlight implements Page {
	private Controller controller = Controller.getInstance();

	public void run() {
		
		//New Frame for Query Selection
        JFrame frame = new JFrame("Deletion for Flight");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        
        //Building Interface
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        //Building Components for Query Selection
        JLabel welcomeLabel = new JLabel("Please Delete by Flight ID");   
        JLabel flightID = new JLabel("FlightID");
        JTextField flightIDText = new JTextField();
        JButton deleteButton = new JButton("Delete");
        JButton browseCrews = new JButton("Browse Flights");
        JButton backButton = new JButton("Back");
        

        //Set Locations of components
        welcomeLabel.setBounds(20, 0, 200, 25);
        flightID.setBounds(20, 30, 80, 25);
        flightIDText.setBounds(100, 30, 150, 25);
        deleteButton.setBounds(70, 60, 150, 25);
        browseCrews.setBounds(70,90, 150, 25);
        backButton.setBounds(70, 120, 150, 25);
        
        
        panel.add(welcomeLabel);
        panel.add(flightID);
        panel.add(flightIDText);
        panel.add(browseCrews);
        panel.add(deleteButton);
        panel.add(backButton);
        
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int flightID = Integer.parseInt(flightIDText.getText());
            	controller.deleteFlight(flightID);
                JOptionPane.showMessageDialog(null, "Flight Information Deleted", "Success", JOptionPane.INFORMATION_MESSAGE);

            }
        });  
        
        browseCrews.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	controller.setState("BrowseSystemAdminFlights");
            }
        });  
        
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	controller.setState("QuerySelectionCrews");
            }
        });  
        
        //Add panel to frame and set visible
        frame.getContentPane().add(panel); 
        frame.setVisible(true);
	}
}
