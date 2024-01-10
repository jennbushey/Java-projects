package View;

import Controller.*;
import Entities.CreateDatabase;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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

public class CancelFlightInterface implements Page {

    private Controller controller = Controller.getInstance();

    JTextField ticketField = new JTextField();
    JTextField emailField = new JTextField();
    int bookingID;
    JFrame frame = new JFrame("Cancel Flight");

    public void run() {

        // New frame

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(350, 225);
        frame.setLocationRelativeTo(null);

        // Building Interface
        JPanel panel = new JPanel();
        panel.setLayout(null);

        // Building Components
        JLabel welcomeLabel = new JLabel("Please Enter your Booking number and Email");
        JLabel bookingNumber = new JLabel("Booking Number:");
        JLabel emailLabel = new JLabel("Email");

        JButton cancelButton = new JButton("Cancel Flight");
        JButton backButton = new JButton("Back");

        cancelButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                boolean userEnteredInt = isNumeric(ticketField.getText());
                if (ticketField.getText().length() != 0 && userEnteredInt) {
                    boolean check = cancelFlight();
                    if (check) {
                        sendCancelConfirmationEmail(emailField.getText());
                    }
                    frame.dispose();
                    controller.setState("MainMenu");
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Size Booking ID", "Error",
                            JOptionPane.INFORMATION_MESSAGE);
                    emailField.setText("");
                    frame.dispose();
                    controller.setState("CancelFlight");
                    frame.dispose();
                    controller.setState("MainMenu");

                }

            }
        });

        backButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                frame.dispose();
                controller.setState("MainMenu");
            }
        });

        // Set component locations
        welcomeLabel.setBounds(20, 0, 300, 25);
        bookingNumber.setBounds(20, 30, 150, 25);
        emailLabel.setBounds(20, 60, 150, 25);
        ticketField.setBounds(160, 30, 100, 25);
        emailField.setBounds(160, 60, 100, 25);
        cancelButton.setBounds(60, 100, 150, 25);
        backButton.setBounds(60, 130, 150, 25);

        // Add components to panel
        panel.add(welcomeLabel);
        panel.add(bookingNumber);
        panel.add(emailLabel);
        panel.add(ticketField);
        panel.add(emailField);
        panel.add(cancelButton);
        panel.add(backButton);

        // Add panel to window and set visible
        frame.getContentPane().add(panel);
        frame.setVisible(true);

    }

    public boolean cancelFlight() {
        // JDBC variables
        Connection connection = null;
        PreparedStatement preparedStatement = null;

        try {
            bookingID = Integer.parseInt(ticketField.getText());
            try {
                // Establish a connection to MySQL
                connection = DriverManager.getConnection(CreateDatabase.database, CreateDatabase.username,
                        CreateDatabase.password);

                // SQL query for deletion based on the ID
                String sql = "DELETE FROM Bookings WHERE ID = ?";

                // Prepare the statement
                preparedStatement = connection.prepareStatement(sql);

                // Set the parameter (ID) in the prepared statement
                preparedStatement.setInt(1, bookingID);

                // Execute the query
                int rowsAffected = preparedStatement.executeUpdate();

                // Check the result
                if (rowsAffected > 0) {
                    System.out.println("Booking with ID " + bookingID + " deleted successfully.");
                    return true;
                } else {
                    System.out.println("No booking found with ID " + bookingID + ". No rows deleted.");
                    return false;
                }

            } catch (SQLException e) {
                e.printStackTrace();
            } finally {
                // Close resources in a finally block to ensure they are always closed
                try {
                    if (preparedStatement != null) {
                        preparedStatement.close();
                    }
                    if (connection != null) {
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        } catch (Exception e) {
            frame.dispose();
            controller.setState("MainMenu");
        }

        return true;
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public void sendCancelConfirmationEmail(String recipientEmail) {
        // Sender's email configuration
        String senderEmail = "";
        String senderPassword = "";

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
            message.setSubject("ENSF 614 Group 19 Flight Cancellation Confirmation");

            // Now set the actual message
            message.setText(
                    "Your booking : '" + bookingID + "' has been cancelled." + "\n" + "Please book again soon!");

            // Send message
            Transport.send(message);

            System.out.println("Email sent successfully.");

        } catch (MessagingException mex) {
            mex.printStackTrace();
        }
    }

}
