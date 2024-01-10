package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import Controller.Controller;

public class UpdateCrew implements Page {
	private Controller controller = Controller.getInstance();

	public void run() {
		
		//New Frame for Query Selection
        JFrame frame = new JFrame("Update for Crew");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 340);
        frame.setLocationRelativeTo(null);
        
        //Building Interface
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        //Building Components for Query Selection
        JLabel welcomeLabel = new JLabel("Please Update Crew Information"); 
        JLabel condition = new JLabel("Please Select by CrewID to Update");
        JLabel crewID = new JLabel("CrewID");
        JLabel next = new JLabel("Add Updated Information");
        JLabel firstName = new JLabel("First Name");
        JLabel lastName = new JLabel("Last Name");
        JTextField crewIDText = new JTextField();
        JTextField firstNameField = new JTextField();
        JTextField lastNameField = new JTextField();
        JButton updateButton = new JButton("Update");
        JButton browseCrews = new JButton("Browse Crews");
        JButton backButton = new JButton("Back");
        

        //Set Locations of components
        welcomeLabel.setBounds(20, 0, 200, 25);
        condition.setBounds(20,30, 300, 25);
        crewID.setBounds(20, 60, 80, 25);
        next.setBounds(20, 90, 300, 25);
        firstName.setBounds(20, 120, 80, 25);
        lastName.setBounds(20, 150, 80, 25);
        crewIDText.setBounds(100, 60, 150, 25);
        firstNameField.setBounds(100, 120, 150, 25);
        lastNameField.setBounds(100, 150, 150, 25);
        updateButton.setBounds(70, 180, 150, 25);
        browseCrews.setBounds(70,210, 150, 25);
        backButton.setBounds(70, 240, 150, 25);
        
        
        panel.add(welcomeLabel);
        panel.add(condition);
        panel.add(crewID);
        panel.add(next);
        panel.add(firstName);
        panel.add(lastName);
        panel.add(crewIDText);
        panel.add(firstNameField);
        panel.add(lastNameField);
        panel.add(updateButton);
        panel.add(browseCrews);
        panel.add(backButton);
        
        updateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int crewID = Integer.parseInt(crewIDText.getText());
            	String firstName = firstNameField.getText();
            	String lastName = lastNameField.getText();
            	
            	controller.updateCrew(crewID, firstName, lastName);
                JOptionPane.showMessageDialog(null, "Crew Information Updated", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
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
