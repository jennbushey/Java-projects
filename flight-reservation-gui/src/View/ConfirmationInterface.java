package View;
import Controller.*;
import Entities.CreateDatabase;

import javax.swing.*;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.mail.*;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import java.util.Properties;


public class ConfirmationInterface implements Page{

	private Controller controller = Controller.getInstance();
	JFrame frame = new JFrame("Flight Confirmation");
	public int bookingID;

    public void run() {

        
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        controller.totalCost = controller.flightCost + controller.seatCost + controller.insuranceCost;

        JPanel panel = new JPanel(new GridLayout(10, 2));

        // Labels
        JLabel flight = new JLabel("Flight Number: " + controller.flightChosen);
        JLabel seat = new JLabel("Seat Number: " + controller.seatChosen);
        JLabel insurance = new JLabel("Insurance Selected: " + controller.insuranceChosen);
        JLabel creditCardNumber = new JLabel("Credit Card Number: " + controller.creditCardNumber);
        JLabel creditCardName = new JLabel("Credit Card Name: " + controller.creditCardName);
        JLabel creditCardCVV = new JLabel("Credit Card CVV: " + controller.creditCardCVV);
        JLabel flightCost = new JLabel("Flight Cost: $" + controller.flightCost);
        JLabel seatCost = new JLabel("Seat Cost: $" + controller.seatCost);
        JLabel insuranceCost = new JLabel("Insurance Cost: $" + controller.insuranceCost);
        JLabel totalCost = new JLabel("Total Cost: $" + controller.totalCost);

        // Add components to the panel
        panel.add(flight);
        panel.add(seat);
        panel.add(insurance);
        panel.add(creditCardNumber);
        panel.add(creditCardName);
        panel.add(creditCardCVV);
        panel.add(flightCost);
        panel.add(seatCost);
        panel.add(insuranceCost);
        panel.add(totalCost);

        // Button to submit the credit card information
        JButton submitButton = new JButton("Confirm Flight?");
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

        frame.setSize(500, 200);
        frame.setVisible(true);
    }


    private class SubmitButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        	addBookingToDB();
            sendConfirmationEmail(controller.email);
            frame.dispose();
            controller.setState("MainMenu");

        }
    }
    
    public void addBookingToDB() {
    	// JDBC variables
        Connection connection = null;
        Statement statement = null;
        String insurance;
        if (controller.insuranceChosen) {
        	insurance = "1";
        }
        else {insurance = "0";}

        try {
            // Establish a connection to MySQL
            connection = DriverManager.getConnection(CreateDatabase.database, CreateDatabase.username, CreateDatabase.password);

            // Create a PreparedStatement object for sending SQL queries
            String query = "INSERT INTO Bookings (UserID, FlightID, Seat, Insurance) VALUES (?, ?, ?, ?)";
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, controller.userID); 
                preparedStatement.setInt(2, Integer.parseInt(controller.flightChosen));
                preparedStatement.setString(3, controller.seatChosen);
                preparedStatement.setString(4, insurance);

                // Execute the query
                preparedStatement.executeUpdate();
            }
            PreparedStatement preparedStatement = null;
            ResultSet resultSet = null;
            // SQL query
            String sql = "SELECT * FROM Bookings ORDER BY ID DESC LIMIT 1;";
            //String sql = "SELECT LAST(Student_name) FROM Bookings;";

            // Prepare the statement
            preparedStatement = connection.prepareStatement(sql);

            // Execute the query
            resultSet = preparedStatement.executeQuery();
            
            while (resultSet.next()) {
                bookingID = resultSet.getInt("ID");
            }

        } catch (SQLException exp) {
            exp.printStackTrace();
        } finally {
            // Close resources in a finally block to ensure they are always closed
            try {
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException exp) {
                exp.printStackTrace();
            }
        }
    }
    
    public void sendConfirmationEmail(String recipientEmail) {
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
            message.setSubject("ENSF 614 Group 19 Flight Confirmation");

            // Now set the actual message
            message.setText("Thank you for booking your flight. Your confirmation details: \n"
            		+ "BookingID: " + bookingID + "\n"
            		+ "Flight: " + controller.flightChosen + "\n"
            		+ "Seat: " + controller.seatChosen + "\n"
            		+ "Insurance: " + controller.insuranceChosen + "\n"
            		+ "Credit Card Number: " + controller.creditCardNumber + "\n"
            		+ "\n"
            		+ "Flight Cost: " + controller.flightCost + "\n"
            		+ "Seat Cost: " + controller.seatCost + "\n"
            		+ "Insurance Cost: " + controller.insuranceCost + "\n"
            		+ "Total Cost: " + controller.totalCost + "\n"
            		+ "\n"
            		+ "Thank you for your booking!");

            // Send message
            Transport.send(message);

            System.out.println("Email sent successfully.");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }
}
	


