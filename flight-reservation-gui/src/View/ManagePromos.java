package View;

import Controller.*;
import Entities.CreateDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ManagePromos implements Page {

	private Controller controller = Controller.getInstance();

	JTextField promoField = new JTextField();
	int bookingID;
	JFrame frame = new JFrame("Manage Promos");
	public List<String> promoUsers;

	public void run() {

		// New frame
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(350, 225);
		frame.setLocationRelativeTo(null);
		
		promoUsers = (controller.fetchRegisteredUsers).fetchPromoUsersFromDatabase();

		// Building Interface
		JPanel panel = new JPanel();
		panel.setLayout(null);

		// Building Components
		JLabel welcomeLabel = new JLabel("Manage Promos");
		JLabel promoLabel = new JLabel("Promo Text:");

		JButton promoButton = new JButton("Send Promo");
		JButton backButton = new JButton("Back");

		promoButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				if(promoField.getText().length() != 0) {
					for (int i=0; i<(promoUsers).size(); i++) {
						sendPromoEmail(promoUsers.get(i));
					}
					
					frame.dispose();
					controller.setState("SystemAdminInterface");
				}
				else {
					JOptionPane.showMessageDialog(null, "No Text Entered", "Error", JOptionPane.INFORMATION_MESSAGE);
	            	frame.dispose();
	            	controller.setState("SystemAdminInterface");

	            }

			}
		});

		backButton.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				frame.dispose();
				controller.setState("SystemAdminInterface");
			}
		});

		// Set component locations
		welcomeLabel.setBounds(20, 0, 300, 25);
		promoLabel.setBounds(20, 30, 150, 25);
		promoField.setBounds(160, 30, 100, 25);
		promoButton.setBounds(60, 100, 150, 25);
		backButton.setBounds(60, 130, 150, 25);

		// Add components to panel
		panel.add(welcomeLabel);
		panel.add(promoLabel);
		panel.add(promoField);
		panel.add(promoButton);
		panel.add(backButton);

		// Add panel to window and set visible
		frame.getContentPane().add(panel);
		frame.setVisible(true);

	}


	public void sendPromoEmail(String recipientEmail) {
		// Sender's email configuration
		String senderEmail = "group19ENSF614@gmail.com";
		String senderPassword = "ensf614ensf";

		// Recipient's email
		String toEmail = recipientEmail;

		// SMTP server configuration (for Gmail)
		String host = "smtp.gmail.com";
		String port = "587";

		// Set the system properties
		Properties properties = System.getProperties();
		properties.setProperty("mail.smtp.host", host);
		properties.setProperty("mail.smtp.port", port);
		properties.setProperty("mail.smtp.auth", "true");
		properties.setProperty("mail.smtp.starttls.enable", "true");
		properties.setProperty("mail.smtp.user", senderEmail);
		properties.setProperty("mail.smtp.password", "ktee tfdj earw fhyc");

		// Set the TLS protocols
		properties.setProperty("mail.smtp.ssl.protocols", "TLSv1.2");

		// Get the default Session object.
		Session session = Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {
				return new PasswordAuthentication(senderEmail, "ktee tfdj earw fhyc");
			}
		});

		try {
			// Create a default MimeMessage object.
			MimeMessage message = new MimeMessage(session);

			// Set From: header field of the header.
			message.setFrom(new InternetAddress(senderEmail));

			// Set To: header field of the header.
			message.addRecipient(Message.RecipientType.TO, new InternetAddress(toEmail));

			// Set Subject: header field
			message.setSubject("ENSF 614 Group 19 Promo Email");

			// Now set the actual message
			message.setText(
					"Promo from Group 19: " + promoField.getText());

			// Send message
			Transport.send(message);

			System.out.println("Email sent successfully.");

		} catch (MessagingException mex) {
			mex.printStackTrace();
		}
	}

}
