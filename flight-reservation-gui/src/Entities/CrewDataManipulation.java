package Entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class CrewDataManipulation {
	
    private String jdbcUrl = CreateDatabase.database;
    private String username  = CreateDatabase.username;
    private String password = CreateDatabase.password;

	public void InsertCrew(String firstName, String lastName) {
        String insertData = "INSERT INTO Crew (FName, LName) VALUES ('" 
        					   + firstName + "', '" + lastName + "')";

        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            
        	PreparedStatement preparedStatement = connection.prepareStatement(insertData)) {

            preparedStatement.executeUpdate();

        } 
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Something Has Gone Wrong", "Error", JOptionPane.INFORMATION_MESSAGE);
        }
    }
	
	public void UpdateCrew(int crewID, String firstName, String lastName) {
	    
	    String updateData = "UPDATE Crew SET FName=?, LName=? WHERE ID=?";

		try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
	           
			   PreparedStatement preparedStatement = connection.prepareStatement(updateData)) {

	           preparedStatement.setString(1, firstName);
	           preparedStatement.setString(2, lastName);
	           preparedStatement.setInt(3, crewID);

	           preparedStatement.executeUpdate();

	       } 
			catch (SQLException e) {
	           e.printStackTrace();
               JOptionPane.showMessageDialog(null, "Something Has Gone Wrong", "Error", JOptionPane.INFORMATION_MESSAGE);

	       }
	   }
	
	public void DeleteCrew(int crewID) {

		String deleteData = "DELETE FROM Crew WHERE ID = ?";
	    try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
	            PreparedStatement preparedStatement = connection.prepareStatement(deleteData)) {

	           preparedStatement.setInt(1, crewID);
	           
	           preparedStatement.executeUpdate();
	           

	       } catch (SQLException e) {
	           e.printStackTrace();
	           JOptionPane.showMessageDialog(null, "Something Has Gone Wrong", "Error", JOptionPane.INFORMATION_MESSAGE);
	           
	       }
	}

	
}
