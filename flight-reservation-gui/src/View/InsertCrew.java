package View;
import Controller.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class InsertCrew implements Page {
	private Controller controller = Controller.getInstance();

	public void run() {
		
		//New Frame for Query Selection
        JFrame frame = new JFrame("Insertion for Crew");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 230);
        frame.setLocationRelativeTo(null);
        
        //Building Interface
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        //Building Components for Query Selection
        JLabel welcomeLabel = new JLabel("Please Insert Crew Information");   
        JLabel firstName = new JLabel("First Name");
        JLabel lastName = new JLabel("Last Name");
        JTextField firstNameField = new JTextField();
        JTextField lastNameField = new JTextField();
        JButton insertButton = new JButton("Insert");
        JButton browseCrews = new JButton("Browse Crews");
        JButton backButton = new JButton("Back");
        

        //Set Locations of components
        welcomeLabel.setBounds(20, 0, 200, 25);
        firstName.setBounds(20, 30, 80, 25);
        lastName.setBounds(20, 60, 80, 25);
        firstNameField.setBounds(100, 30, 150, 25);
        lastNameField.setBounds(100, 60, 150, 25);
        insertButton.setBounds(70, 90, 150, 25);
        browseCrews.setBounds(70,120, 150, 25);
        backButton.setBounds(70, 150, 150, 25);
        
        
        panel.add(welcomeLabel);
        panel.add(firstName);
        panel.add(lastName);
        panel.add(firstNameField);
        panel.add(lastNameField);
        panel.add(insertButton);
        panel.add(browseCrews);
        panel.add(backButton);
        
        insertButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	String firstName = firstNameField.getText();
            	String lastName = lastNameField.getText();
            	
            	controller.insertCrew(firstName, lastName);
                JOptionPane.showMessageDialog(null, "Crew Information Inserted", "Success", JOptionPane.INFORMATION_MESSAGE);
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
