package View;
import Controller.*;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectFlightForManifest {
	private Controller controller = Controller.getInstance();
	
	public void run() {
				//New Frame for Flight Agent User
        JFrame frame = new JFrame("Flight Agent");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 170);
        frame.setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        JLabel welcomeLabel = new JLabel("Please Select a FlightID");   
        JLabel flightID = new JLabel("FlightID");
        JTextField flightIDField = new JTextField();
        JButton selectButton = new JButton("Select");
        JButton backButton = new JButton("Back");

        welcomeLabel.setBounds(20, 0, 200, 25);
        flightID.setBounds(20, 30, 80, 25);
        flightIDField.setBounds(100, 30, 150, 25);
        selectButton.setBounds(70, 60, 150, 25);
        backButton.setBounds(70, 90, 150, 25);
        
        panel.add(welcomeLabel);
        panel.add(flightID);
        panel.add(flightIDField);
        panel.add(selectButton);
        panel.add(backButton);
        
        //Buttons do something when clicked
        selectButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	int flightID = Integer.parseInt(flightIDField.getText());
            	controller.getManifest(flightID);
            }
        });  
         
        
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	controller.setState("FlightAgentInterface");
            }
        });  
        
        //Add panel to frame and set visible
        frame.getContentPane().add(panel); 
        frame.setVisible(true);
	}

}
