package Entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Timestamp;

import javax.swing.JOptionPane;

public class FlightDataManipulation {
	
    private String jdbcUrl = CreateDatabase.database;
    private String username  = CreateDatabase.username;
    private String password = CreateDatabase.password;

    public void InsertFlight(String departureLocation, String arrivalLocation, Timestamp departureTime,
            				  Timestamp arrivalTime, int aircraftID, int crew1ID, int crew2ID, int crew3ID) {
		
    	String insertData = "INSERT INTO Flight (Departure_Airport, Arrival_Airport, Departure_Time, Arrival_Time, AircraftID, "
								+ "" + "Crew1ID, Crew2ID, Crew3ID) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
				
			try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
					
				PreparedStatement preparedStatement = connection.prepareStatement(insertData)) {
				
				preparedStatement.setString(1, departureLocation);
				preparedStatement.setString(2, arrivalLocation);
				preparedStatement.setTimestamp(3, departureTime);
				preparedStatement.setTimestamp(4, arrivalTime);
				preparedStatement.setInt(5, aircraftID);
				preparedStatement.setInt(6, crew1ID);
				preparedStatement.setInt(7, crew2ID);
				preparedStatement.setInt(8, crew3ID);
				
				preparedStatement.executeUpdate();
				
			} 
			
			catch (SQLException e) {
				e.printStackTrace();
	            JOptionPane.showMessageDialog(null, "Something Has Gone Wrong", "Error", JOptionPane.INFORMATION_MESSAGE);
			}
    	}
    
    public void UpdateFlight(int flightID, String departureLocation, String arrivalLocation, Timestamp departureTime,
			  Timestamp arrivalTime, int aircraftID, int crew1ID, int crew2ID, int crew3ID){
    	
    	
    	String updateData = "UPDATE Flight SET Departure_Airport=?, Arrival_Airport=?, Departure_Time=?, "
    						+ "Arrival_Time=?, AircraftID=?, Crew1ID=?, Crew2ID=?, Crew3ID=? WHERE ID=?";


		try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
	           
			   PreparedStatement preparedStatement = connection.prepareStatement(updateData)) {

		        preparedStatement.setString(1, departureLocation);
		        preparedStatement.setString(2, arrivalLocation);
		        preparedStatement.setTimestamp(3, departureTime);
		        preparedStatement.setTimestamp(4, arrivalTime);
		        preparedStatement.setInt(5, aircraftID);
		        preparedStatement.setInt(6, crew1ID);
		        preparedStatement.setInt(7, crew2ID);
		        preparedStatement.setInt(8, crew3ID);
		        preparedStatement.setInt(9, flightID);

	           preparedStatement.executeUpdate();

	       } 
			catch (SQLException e) {
	           e.printStackTrace();
	           JOptionPane.showMessageDialog(null, "Something Has Gone Wrong", "Error", JOptionPane.INFORMATION_MESSAGE);
	       }
        
    	
    }
    
	public void DeleteFlight(int flightID) {
	    
		String deleteData = "DELETE FROM Flight WHERE ID = ?";
	    try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
	            PreparedStatement preparedStatement = connection.prepareStatement(deleteData)) {

	           preparedStatement.setInt(1, flightID);
	           
	           preparedStatement.executeUpdate();
	           

	       } catch (SQLException e) {
	           e.printStackTrace();
	           JOptionPane.showMessageDialog(null, "Something Has Gone Wrong", "Error", JOptionPane.INFORMATION_MESSAGE);
	           
	       }
	    
	}
    
    
	
	
}
