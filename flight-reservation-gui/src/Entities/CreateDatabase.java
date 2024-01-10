package Entities;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;

public class CreateDatabase {
	// Database connection parameters
    public static String jdbcUrl = "jdbc:mysql://localhost:3306/";
    public static String username = getUsername();
    public static String password = getPassword();

    // Database name to be created
    public static String databaseName = "Group19FlightDB";
    public static String database = "jdbc:mysql://localhost:3306/Group19FlightDB";

	public static void createDatabase() {
		

        // JDBC variables
        Connection connection = null;
        Statement statement = null;

        try {
            // Establish a connection to MySQL
            connection = DriverManager.getConnection(jdbcUrl, username, password);
            
            ResultSet resultSet = null;

            // Create a Statement object for sending SQL queries
            statement = connection.createStatement();

            // Create the database
            //statement.executeUpdate("DROP DATABASE IF EXISTS " + databaseName);
            statement.executeUpdate("CREATE DATABASE IF NOT EXISTS " + databaseName);
            statement.executeUpdate("USE " + databaseName);
            
            // Create Aircraft table
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Aircraft (" +
                    "ID INT PRIMARY KEY AUTO_INCREMENT," +
                    "Model VARCHAR(255))");
            
            // Create Crew table
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Crew (" +
                    "ID INT PRIMARY KEY AUTO_INCREMENT," +
                    "FName VARCHAR(255)," +
                    "LName VARCHAR(255))");
            
            // Create User table
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS User (" +
            		"ID INT PRIMARY KEY AUTO_INCREMENT," +
            		"FName VARCHAR(255)," +
            		"LName VARCHAR(255)," +
            		"Email VARCHAR(255)," +
            		"Password VARCHAR(255)," +
            		"User_Type INT," +
            		"Companion_Voucher BOOLEAN)");

            // Create Flight table
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Flight (" +
                    "ID INT PRIMARY KEY AUTO_INCREMENT," +
                    "Departure_Airport VARCHAR(255)," +
                    "Arrival_Airport VARCHAR(255)," +
                    "Departure_Time DATETIME," +
                    "Arrival_Time DATETIME," +
                    "AircraftID INT," +
                    "Crew1ID INT," +
                    "Crew2ID INT," +
                    "Crew3ID INT," +
                    "FOREIGN KEY (AircraftID) REFERENCES Aircraft(ID) ON DELETE CASCADE," +
                    "FOREIGN KEY (Crew1ID) REFERENCES Crew(ID) ON DELETE CASCADE," +
                    "FOREIGN KEY (Crew2ID) REFERENCES Crew(ID) ON DELETE CASCADE," +
                    "FOREIGN KEY (Crew3ID) REFERENCES Crew(ID) ON DELETE CASCADE)");
            
            // Create Bookings table
            statement.executeUpdate("CREATE TABLE IF NOT EXISTS Bookings (" +
            		"ID INT PRIMARY KEY AUTO_INCREMENT," +
                    "UserID INT," +
                    "FlightID INT," +
                    "Seat VARCHAR(10)," +
                    "Insurance BOOLEAN," +
                    //"PRIMARY KEY (UserID, FlightID)," +
                    //"FOREIGN KEY (UserID) REFERENCES User(ID)," +
                    "FOREIGN KEY (FlightID) REFERENCES Flight(ID) ON DELETE CASCADE)");
            
            // Check if the user table is empty
            resultSet = statement.executeQuery("SELECT COUNT(*) FROM User");
            resultSet.next();
            int rowCount = resultSet.getInt(1);
            
         // If the table is empty, insert sample data
            if (rowCount == 0) {
            	statement.executeUpdate("INSERT INTO User (FName, LName, Email, Password, User_Type, Companion_Voucher) VALUES " +
                        "('John', 'Doe', 'john.doe@email.com', '1111', 1, 0),"
                        + "('Jane', 'Smith', 'jane.smith@email.com',  '1111', 1, 1),"
                        + "('Alice', 'Johnson', 'alice.johnson@email.com',  '1111',0, 0),"
                        + "('Bob', 'Anderson', 'bob.anderson@email.com',  '1111', 1, 0),"
                        + "('Emily', 'Taylor', 'emily.taylor@email.com',  '1111', 1, 1),"
                        + "('David', 'Williams', 'david.williams@email.com',  '1111', 1, 0),"
                        + "('Olivia', 'Brown', 'olivia.brown@email.com',  '1111', 1, 0),"
                        + "('Michael', 'Jones', 'michael.jones@email.com',  '1111', 1, 1),"
                        + "('Sophia', 'Miller', 'sophia.miller@email.com',  '1111', 1, 0),"
                        + "('Daniel', 'Davis', 'daniel.davis@email.com',  '1111', 2, 0),"
                        + "('Emma', 'Wilson', 'emma.wilson@email.com',  '1111', 2, 1),"
                        + "('James', 'Smith', 'james.smith@email.com', '1111', 2, 0),"
                        + "('Ava', 'Brown', 'ava.brown@email.com', '1111', 3, 0),"
                        + "('Ethan', 'Miller', 'ethan.miller@email.com', '1111', 3, 0),"
                        + "('Mia', 'Davis', 'mia.davis@email.com', '1111', 3, 1),"
                        + "('Liam', 'Johnson', 'liam.johnson@email.com',  '1111',3, 0),"
                        + "('Isabella', 'Anderson', 'isabella.anderson@email.com', '1111', 1, 0),"
                        + "('Noah', 'Taylor', 'noah.taylor@email.com',  '1111', 1, 1),"
                        + "('Sophie', 'Moore', 'sophie.moore@email.com',  '1111', 1, 0),"
                        + "('Jackson', 'Clark', 'jackson.clark@email.com',  '1111', 1, 0),"
                        + "('Grace', 'Harris', 'grace.harris@email.com',  '1111', 1, 0),"
                        + "('Logan', 'Anderson', 'logan.anderson@email.com',  '1111', 1, 0),"
                        + "('Chloe', 'Walker', 'chloe.walker@email.com',  '1111', 1, 0),"
                        + "('Lucas', 'Thomas', 'lucas.thomas@email.com', '1111', 1, 1),"
                        + "('Avery', 'White', 'avery.white@email.com', '1111', 1, 0),"
                        + "('Ella', 'Jones', 'ella.jones@email.com',  '1111', 1, 0),"
                        + "('Carter', 'Martin', 'carter.martin@email.com', '1111', 1, 0),"
                        + "('Lily', 'Robinson', 'lily.robinson@email.com', '1111', 1, 1),"
                        + "('Owen', 'Wright', 'owen.wright@email.com',  '1111', 1, 0),"
                        + "('Abigail', 'Baker', 'abigail.baker@email.com',  '1111', 1, 0);");
            } else {
                System.out.println("User table already contains data. Skipping sample data insertion.");
            }
            
            // Insert sample data into User table
            
            
            // Check if the Aircraft table is empty
            resultSet = statement.executeQuery("SELECT COUNT(*) FROM Aircraft");
            resultSet.next();
            rowCount = resultSet.getInt(1);

            // If the table is empty, insert sample data
            if (rowCount == 0) {
                statement.executeUpdate("INSERT INTO Aircraft (Model) VALUES " +
                        "('Boeing 747'),"
                        + "('Boeing 737'),"
                        + "('Boeing 777');");
                System.out.println("Sample data inserted into Aircraft table.");
            } else {
                System.out.println("Aircraft table already contains data. Skipping sample data insertion.");
            }   
            
            // Check if the Crew table is empty
            resultSet = statement.executeQuery("SELECT COUNT(*) FROM Crew");
            resultSet.next();
            rowCount = resultSet.getInt(1);

            // If the table is empty, insert sample data
            if (rowCount == 0) {
            	statement.executeUpdate("INSERT INTO Crew (FNAME, LName) VALUES " +
                        "('Sara', 'Johnson'),"
                        + "    ('Tom', 'Williams'),"
                        + "    ('Ava', 'Jones'),"
                        + "    ('Ethan', 'Moore'),"
                        + "    ('Mia', 'Davis'),"
                        + "    ('Liam', 'Wilson'),"
                        + "    ('Isabella', 'Brown'),"
                        + "    ('Noah', 'Miller'),"
                        + "    ('Sophie', 'Smith'),"
                        + "    ('Jackson', 'Anderson'),"
                        + "    ('Chloe', 'Thomas'),"
                        + "    ('Logan', 'Clark'),"
                        + "    ('Avery', 'Taylor'),"
                        + "    ('Grace', 'Martin'),"
                        + "    ('Ella', 'Wright'),"
                        + "    ('Lucas', 'Baker'),"
                        + "    ('Lily', 'Robinson'),"
                        + "    ('Owen', 'Harris'),"
                        + "    ('Abigail', 'White'),"
                        + "    ('Elijah', 'Walker');");
                System.out.println("Sample data inserted into Crew table.");
            } else {
                System.out.println("Crew table already contains data. Skipping sample data insertion.");
            }
            
            // Check if the Flight table is empty
            resultSet = statement.executeQuery("SELECT COUNT(*) FROM Flight");
            resultSet.next();
            rowCount = resultSet.getInt(1);

            // If the table is empty, insert sample data
            if (rowCount == 0) {
            	statement.executeUpdate("INSERT INTO Flight (Departure_Airport, Arrival_Airport, Departure_Time, Arrival_Time, AircraftID, Crew1ID, Crew2ID, Crew3ID) VALUES " +
                        "('YYC', 'YVR', '2023-12-01 08:00:00', '2023-12-01 10:00:00', 1, 2, 3, 4),"
                        + "    ('YEG', 'YYC', '2023-12-02 12:00:00', '2023-12-02 14:00:00', 2, 5, 6, 7),"
                        + "    ('YYC', 'YYZ', '2023-12-03 16:00:00', '2023-12-03 18:00:00', 3, 8, 9, 10),"
                        + "    ('YYC', 'YUL', '2023-12-04 10:00:00', '2023-12-04 12:00:00', 1, 11, 12, 13),"
                        + "    ('YOW', 'YYC', '2023-12-05 14:00:00', '2023-12-05 16:00:00', 2, 14, 15, 16),"
                        + "    ('YYC', 'YVR', '2023-12-06 08:00:00', '2023-12-06 10:00:00', 3, 17, 18, 19),"
                        + "    ('YEG', 'YYC', '2023-12-07 12:00:00', '2023-12-07 14:00:00', 1, 20, 1, 2),"
                        + "    ('YYC', 'YYZ', '2023-12-08 16:00:00', '2023-12-08 18:00:00', 2, 3, 4, 5),"
                        + "    ('YYC', 'YUL', '2023-12-09 10:00:00', '2023-12-09 12:00:00', 3, 6, 7, 8),"
                        + "    ('YOW', 'YYC', '2023-12-10 14:00:00', '2023-12-10 16:00:00', 1, 9, 10, 11),"
                        + "    ('YYC', 'YVR', '2023-12-11 08:00:00', '2023-12-11 10:00:00', 2, 12, 13, 14),"
                        + "    ('YEG', 'YYC', '2023-12-12 12:00:00', '2023-12-12 14:00:00', 3, 15, 16, 17),"
                        + "    ('YYC', 'YYZ', '2023-12-13 16:00:00', '2023-12-13 18:00:00', 1, 18, 19, 20),"
                        + "    ('YYC', 'YUL', '2023-12-14 10:00:00', '2023-12-14 12:00:00', 2, 1, 2, 3),"
                        + "    ('YOW', 'YYC', '2023-12-15 14:00:00', '2023-12-15 16:00:00', 3, 4, 5, 6),"
                        + "    ('YYC', 'YVR', '2023-12-16 08:00:00', '2023-12-16 10:00:00', 1, 7, 8, 9),"
                        + "    ('YEG', 'YYC', '2023-12-17 12:00:00', '2023-12-17 14:00:00', 2, 10, 11, 12),"
                        + "    ('YYC', 'YYZ', '2023-12-18 16:00:00', '2023-12-18 18:00:00', 3, 13, 14, 15),"
                        + "    ('YYC', 'YUL', '2023-12-19 10:00:00', '2023-12-19 12:00:00', 1, 16, 17, 18),"
                        + "    ('YOW', 'YYC', '2023-12-20 14:00:00', '2023-12-20 16:00:00', 2, 19, 20, 1);");
                System.out.println("Sample data inserted into Flight table.");
            } else {
                System.out.println("Flight table already contains data. Skipping sample data insertion.");
            }
            
         // Check if the Booking table is empty
            resultSet = statement.executeQuery("SELECT COUNT(*) FROM Bookings");
            resultSet.next();
            rowCount = resultSet.getInt(1);

            // If the table is empty, insert sample data
            if (rowCount == 0) {
            	statement.executeUpdate("INSERT INTO Bookings (UserID, FlightID, Seat, Insurance) VALUES " +
                        "(1, 1, '1A', true),"
                        + "    (5, 2, '4B', false),"
                        + "    (2, 2, '1B', false),"
                        + "    (6, 3, '3B', false),"
                        + "    (3, 3, '1C', true),"
                        + "    (2, 4, '1A', false),"
                        + "    (4, 4, '1D', false),"
                        + "    (5, 5, '1E', true),"
                        + "    (8, 5, '3B', false),"
                        + "    (6, 6, '1F', false),"
                        + "    (1, 6, '3B', true),"
                        + "    (7, 7, '2A', true),"
                        + "    (3, 7, '2B', true),"
                        + "    (8, 8, '2B', false),"
                        + "    (5, 8, '4C', false),"
                        + "    (9, 9, '2C', true),"
                        + "    (7, 9, '1A', true),"
                        + "    (10, 10, '2D', false),"
                        + "    (11, 11, '2E', true),"
                        + "    (12, 12, '2F', false),"
                        + "    (13, 13, '3A', true),"
                        + "    (14, 14, '3B', false),"
                        + "    (15, 15, '3C', true),"
                        + "    (16, 16, '3D', false),"
                        + "    (17, 17, '3E', true),"
                        + "    (18, 18, '3F', false),"
                        + "    (19, 19, '4A', true),"
                        + "    (20, 20, '4B', false),"
                        + "    (21, 1, '4C', true),"
                        + "    (22, 2, '4D', false),"
                        + "    (23, 3, '4E', true),"
                        + "    (24, 4, '4F', false),"
                        + "    (25, 5, '5A', true),"
                        + "    (26, 6, '5B', false),"
                        + "    (27, 7, '5C', true),"
                        + "    (28, 8, '5D', false),"
                        + "    (29, 9, '5E', true),"
                        + "    (30, 10, '5F', false);");
                System.out.println("Sample data inserted into Bookings table.");
            } else {
                System.out.println("Bookings table already contains data. Skipping sample data insertion.");
            }
            

            JOptionPane.showMessageDialog(null, "Database '" + databaseName + "' created successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // Close resources in a finally block to ensure they are always closed
            try {
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    private static String getUsername() {
        return JOptionPane.showInputDialog("Enter MySQL username:");
    }

    private static String getPassword() {
    	return JOptionPane.showInputDialog("Enter MySQL password:");

    }
}
