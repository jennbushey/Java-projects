package View;
import Controller.*;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class PaymentInterface implements Page{

	private Controller controller = Controller.getInstance();

	public void run() {
		
		// New frame for Selecting a flight
		JFrame frame = new JFrame("Select a Payment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(200, 200);
        frame.setLocationRelativeTo(null);
        
        //Building Interface
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        //Building Components for Registered user  Interface
        JLabel welcomeLabel = new JLabel("Select a Payment Method");
        JButton visaButton = new JButton("Visa");
        JButton mastercardButton = new JButton("Mastercard");	
        JButton backButton = new JButton("Back");
        
        //Set Locations of components
        welcomeLabel.setBounds(30, 0, 200, 25);
        visaButton.setBounds(40, 30, 120, 25);
        mastercardButton.setBounds(40, 60, 120 , 25);
        backButton.setBounds(40, 90, 120 , 25);
        
        //Add all components to the panel
        panel.add(welcomeLabel);
        panel.add(visaButton);
        panel.add(mastercardButton);
        panel.add(backButton);
        
        visaButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	controller.setState("Visa");
            }
        }); 
        
        mastercardButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	controller.setState("Mastercard");
            }
        }); 
        
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	controller.setState("SelectInsurance");
            }
        });
        
        //Add panel to frame and set visible
        frame.getContentPane().add(panel); 
        frame.setVisible(true);
	}
	

}
