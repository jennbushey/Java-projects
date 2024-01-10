package View;
import Controller.*;


import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class visaInterface extends Payment implements Page{

	private Controller controller = Controller.getInstance();
	private JTextField cardNumberField;
    private JTextField cardNameField;
    private JTextField cvvField;
    private JTextField emailField;
    public JFrame frame = new JFrame("Visa Credit Card Information");
    
    public void run() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        paymentStyle = new CreditCard();

        JPanel panel = new JPanel(new GridLayout(5, 2));

        // Labels
        JLabel cardNumberLabel = new JLabel("Card Number:");
        JLabel cardNameLabel = new JLabel("Name on Card:");
        JLabel cvvLabel = new JLabel("CVV:");
        JLabel email = new JLabel("email:");

        // Text Fields
        cardNumberField = new JTextField();
        cardNameField = new JTextField();
        cvvField = new JTextField();
        emailField = new JTextField();

        // Add components to the panel
        panel.add(cardNumberLabel);
        panel.add(cardNumberField);
        panel.add(cardNameLabel);
        panel.add(cardNameField);
        panel.add(cvvLabel);
        panel.add(cvvField);
        panel.add(email);
        panel.add(emailField);

        // Button to submit the credit card information
        JButton submitButton = new JButton("Submit");
        JButton backButton = new JButton("Back");
        submitButton.addActionListener(new SubmitButtonListener());
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	frame.dispose();
            	controller.setState("SelectPayment");
            }
        });
        panel.add(submitButton);
        panel.add(backButton);

        // Add the panel to the frame content pane
        frame.getContentPane().add(panel);

        frame.setSize(400, 300);
        frame.setVisible(true);
    }


    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            // Get credit card information from text fields
        	
        	
            String cardNumber = cardNumberField.getText();
            String cardName = cardNameField.getText();
            String cvv = cvvField.getText();
            String email = emailField.getText();
            
            if(cardNumber.length() != 16 || cvv.length() != 3) {
            	JOptionPane.showMessageDialog(null, "Invalid Size for Credit Card or CVV", "Error", JOptionPane.INFORMATION_MESSAGE);
            	cardNumberField.setText("");
            	cardNameField.setText("");
            	cvvField.setText("");
            	emailField.setText("");
            	frame.dispose();
            	controller.setState("Mastercard");
            }
            else {
	            // For now, just print the entered information
	            System.out.println("Card Number: " + cardNumber);
	            System.out.println("Name on Card: " + cardName);
	            System.out.println("CVV: " + cvv);
	            System.out.println("email: " + email);
	            controller.creditCardName = cardName;
	            controller.creditCardNumber = cardNumber;
	            controller.creditCardCVV = cvv;
	            controller.email = email;
	            
	            if (controller.userID == 0) {
	            	frame.dispose();
	            	controller.setState("GuestUserInputInfo");        	
	            }
	            else {
	            	frame.dispose();
	            	controller.setState("Confirmation");
	                }
	            }
        }
    }
}


	


