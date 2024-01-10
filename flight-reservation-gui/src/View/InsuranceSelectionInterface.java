package View;
import Controller.*;


import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class InsuranceSelectionInterface implements Page{

	private Controller controller = Controller.getInstance();

	public void run() {
		
		// New frame for Selecting a flight
		JFrame frame = new JFrame("Select a Payment");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);
        
        //Building Interface
        JPanel panel = new JPanel();
        panel.setLayout(null);
        
        //Building Components for Registered user  Interface
        JLabel welcomeLabel = new JLabel("Would you like Flight Insurance?");
        JButton yesButton = new JButton("Yes");
        JButton noButton = new JButton("No");
        JButton backButton = new JButton("Back");
        
        //Set Locations of components
        welcomeLabel.setBounds(30, 0, 200, 25);
        yesButton.setBounds(40, 30, 120, 25);
        noButton.setBounds(40, 60, 120 , 25);
        backButton.setBounds(40, 90, 120, 25);
        
        //Add all components to the panel
        panel.add(welcomeLabel);
        panel.add(yesButton);
        panel.add(noButton);
        panel.add(backButton);
        
        yesButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	controller.insuranceChosen = true;
            	controller.insuranceCost = ((controller.seatCost) * 0.2);
            	frame.dispose();
            	controller.setState("SelectPayment");
            }
        }); 
        
        noButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	controller.insuranceChosen = false;
            	controller.insuranceCost = 0;
            	frame.dispose();
            	controller.setState("SelectPayment");
            }
        }); 
        
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	controller.setState("SelectSeat");
            }
        });
        
        //Add panel to frame and set visible
        frame.getContentPane().add(panel); 
        frame.setVisible(true);
	}
	

}
