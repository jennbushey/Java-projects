package View;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import Controller.Controller;
import Controller.LoginController;
import Entities.AddUsers;
import Entities.LoginCredentialCheck;

public class guestUserInfoInterface implements Page {

	private Controller controller = Controller.getInstance();
	private LoginController loginController = LoginController.getInstance();

	public void run() {

		// New frame for Registering
		JFrame frame = new JFrame("Guest Info");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350, 280);
		frame.setLocationRelativeTo(null);

		// Building Interface
		JPanel panel = new JPanel();
		panel.setLayout(null);

		// Building Components for Registered user Interface
		JLabel welcomeLabel = new JLabel("Please enter the following information for your flight");
		JLabel fNameLabel = new JLabel("First Name");
		JLabel lNameLabel = new JLabel("Last Name");
		JLabel emailLabel = new JLabel("Email");
		JTextField fNameField = new JTextField();
		JTextField lNameField = new JTextField();
		JTextField emailField = new JTextField();
		JButton selectButton = new JButton("Enter");
		JButton backButton = new JButton("Back");
		JLabel messageLabel = new JLabel("");

		// Add all components to the panel
		panel.add(welcomeLabel);
		panel.add(fNameLabel);
		panel.add(lNameLabel);
		panel.add(emailLabel);

		panel.add(fNameField);
		panel.add(lNameField);
		panel.add(emailField);
		panel.add(selectButton);
		panel.add(backButton);
		panel.add(messageLabel);

		// Add panel to the frame
		frame.getContentPane().add(panel);

		// Set Locations of components
		welcomeLabel.setBounds(20, 0, 350, 25);
		fNameLabel.setBounds(20, 30, 80, 25);
		lNameLabel.setBounds(20, 60, 80, 25);
		emailLabel.setBounds(20, 90, 80, 25);
		messageLabel.setBounds(20, 210, 350, 25);

		fNameField.setBounds(100, 30, 200, 25);
		lNameField.setBounds(100, 60, 200, 25);
		emailField.setBounds(100, 90, 200, 25);

		selectButton.setBounds(100, 150, 150, 25);
		backButton.setBounds(100, 180, 150, 25);

		selectButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				clearError(messageLabel);

				if (!validateEmail(emailField.getText())) {
					// if email is bad
					showError(messageLabel, "Invalid email format.");

				} else {
					// email and password are both valid
					clearError(messageLabel);

					// get data from text fields
					List<String> user = new ArrayList<String>();
					user.add(fNameField.getText());
					user.add(lNameField.getText());
					user.add(emailField.getText());
					user.add("1111");
					user.add("0"); // registered user is type 0
					user.add("0"); // add companion voucher

					LoginController.user = user;
					LoginController.email = emailField.getText();
					LoginController.password = "1111";
					loginController.addUserToDatabase();
					loginController.getLoginCredentialCheck();
					
					frame.dispose();
	            	controller.setState("Confirmation");

				}
			}
		});

		backButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				controller.setState("SelectPayment");
			}
		});

		frame.setVisible(true);
	}

	/**
	 * Checks if email address contains @ symbol
	 */
	private boolean validateEmail(String email) {
		if (email.contains("@"))
			return true;
		else
			return false;
	}

	/**
	 * Checks if password is 4 characters or longer
	 */
	private boolean validatePassword(String password) {
		if (password.length() >= 4)
			return true;
		else
			return false;
	}

	/**
	 * Helper method changes error message
	 */
	private void showError(JLabel errorLabel, String errorMessage) {
		errorLabel.setText(errorMessage);
		errorLabel.setForeground(Color.RED); // Optional: Set text color to red for emphasis
	}

	/**
	 * Helper method clears error message
	 */
	private void clearError(JLabel errorLabel) {
		errorLabel.setText(null); // Set text to null or an empty string to clear the error message
	}

}



