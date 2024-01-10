package View;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import Controller.Controller;
import Controller.LoginController;

/*
 * Create the login interface. Also implement logic for username and password checking with
 * database in this class? I dont think we need constructor
 */
public class LoginApp implements Page {

	private Controller controller = Controller.getInstance();

	public void run() {

		// New Frame
		JFrame frame = new JFrame("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 275);
		frame.setLocationRelativeTo(null);

		// Building Interface
		JPanel panel = new JPanel();
		panel.setLayout(null);
		JLabel welcomeLabel = new JLabel("Please enter login credentials");

		// Components of Interface
		JLabel usernameLabel = new JLabel("Email");
		JLabel passwordLabel = new JLabel("Password");

		JTextField usernameField = new JTextField();
		JPasswordField passwordField = new JPasswordField();

		JButton loginButton = new JButton("Login");
		JButton registerButton = new JButton("Register");
		JButton guestButton = new JButton("Guest User");
		JButton backButton = new JButton("Back");

		// Add all components to panel
		panel.add(welcomeLabel);
		panel.add(usernameLabel);
		panel.add(passwordLabel);
		panel.add(usernameField);
		panel.add(passwordField);
		panel.add(loginButton);
		panel.add(registerButton);
		panel.add(guestButton);
		panel.add(backButton);

		// Add panel to the frame
		frame.getContentPane().add(panel);

		// Set Locations for components
		welcomeLabel.setBounds(20, 0, 250, 25);
		usernameLabel.setBounds(20, 30, 80, 25);
		passwordLabel.setBounds(20, 60, 80, 25);
		usernameField.setBounds(100, 30, 250, 25);
		passwordField.setBounds(100, 60, 250, 25);
		loginButton.setBounds(100, 90, 80, 25);
		registerButton.setBounds(100, 120, 120, 25);
		guestButton.setBounds(100, 150, 120, 25);
		backButton.setBounds(100, 180, 80, 25);

		// Do something when buttons are pressed
		loginButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LoginController loginCheck = new LoginController();

				// Get username and password
				LoginController.email = usernameField.getText();
				LoginController.password = String.valueOf(passwordField.getPassword());
				
				/* 
				 * If email and password are in user table then assign user type 
				 * and select state base on user type
				*/
				if (loginCheck.getLoginCredentialCheck()) {
					int type = loginCheck.getUserType();
					controller.setUser(type);

					// Open Registered User Interface
					if (type == 1) {
						frame.dispose();
						controller.setState("RegisteredUserInterface");
					}

					// Open System Administrator Interface
					else if (type == 2) {
						frame.dispose();
						controller.setState("SystemAdminInterface");
					}

					// Open Flight Agents Interface
					else if (type == 3) {
						frame.dispose();
						controller.setState("FlightAgentInterface");
					}

					else {
						System.out.println("Something terribly wrong has happened. Exiting Program...");
						System.exit(0);
					}
					
				} else {
					// Error message if email and/or password are not in database
					JLabel messageLabel = new JLabel("Invalid Username or Password");
					messageLabel.setBounds(100, 200, 200, 25);
					panel.add(messageLabel);

					// Refresh Frame to display message
					frame.revalidate();
					frame.repaint();
				}
			}
		});

		guestButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				controller.setState("GuestUserInterface");
			}

		});

		backButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				controller.setState("MainMenu");
			}

		});

		registerButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				controller.setState("Register");
			}

		});

		frame.setVisible(true);

	}

}
