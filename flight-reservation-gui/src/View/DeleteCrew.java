package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.Controller;

public class DeleteCrew implements Page {
	private Controller controller = Controller.getInstance();

	public void run() {
		
		//New Frame for Query Selection
        JFrame frame = new JFrame("Deletion for Crew");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLocationRelativeTo(null);
        
        //Building Interface
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        //Building Components for Query Selection
        JLabel welcomeLabel = new JLabel("Please Delete by Crew ID");   
        JLabel crewID = new JLabel("CrewID");
        JTextField crewIDText = new JTextField();
        JButton deleteButton = new JButton("Delete");
        JButton browseCrews = new JButton("Browse Crews");
        JButton backButton = new JButton("Back");
        

        //Set Locations of components
        welcomeLabel.setBounds(20, 0, 200, 25);
        crewID.setBounds(20, 30, 80, 25);
        crewIDText.setBounds(100, 30, 150, 25);
        deleteButton.setBounds(70, 60, 150, 25);
        browseCrews.setBounds(70,90, 150, 25);
        backButton.setBounds(70, 120, 150, 25);
        
        
        panel.add(welcomeLabel);
        panel.add(crewID);
        panel.add(crewIDText);
        panel.add(browseCrews);
        panel.add(deleteButton);
        panel.add(backButton);
        
        deleteButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int crewID = Integer.parseInt(crewIDText.getText());
            	controller.deleteCrew(crewID);
                JOptionPane.showMessageDialog(null, "Crew Information Deleted", "Success", JOptionPane.INFORMATION_MESSAGE);             }
        });  
        
        browseCrews.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	controller.setState("BrowseCrews");
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