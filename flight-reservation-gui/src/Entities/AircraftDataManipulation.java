package Entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class AircraftDataManipulation {
	
    private String jdbcUrl = CreateDatabase.database;
    private String username  = CreateDatabase.username;
    private String password = CreateDatabase.password;

	public void InsertAircraft(String model) {
		String insertData = "INSERT INTO Aircraft (Model) VALUES ('" + model + "')";


        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(insertData)) {

            preparedStatement.executeUpdate();

        } 
        catch (SQLException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Something Has Gone Wrong", "Error", JOptionPane.INFORMATION_MESSAGE);

        }
    }
	
	public void UpdateAircraft(int aircraftID, String model) {
	    
	    String updateData = "UPDATE Aircraft SET Model=? WHERE ID=?";

		try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
	           
			   PreparedStatement preparedStatement = connection.prepareStatement(updateData)) {

	           preparedStatement.setString(1, model);
	           preparedStatement.setInt(2, aircraftID);

	           preparedStatement.executeUpdate();

	       } 
			catch (SQLException e) {
	           e.printStackTrace();
	           JOptionPane.showMessageDialog(null, "Something Has Gone Wrong", "Error", JOptionPane.INFORMATION_MESSAGE);
	       }
	   }
	
	public void DeleteAircraft(int aircraftID) {

		String deleteData = "DELETE FROM Aircraft WHERE ID = ?";
	    try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password);
	            PreparedStatement preparedStatement = connection.prepareStatement(deleteData)) {

	           preparedStatement.setInt(1, aircraftID);
	           
	           preparedStatement.executeUpdate();
	           

	       } catch (SQLException e) {
	           e.printStackTrace();
	           JOptionPane.showMessageDialog(null, "Something Has Gone Wrong", "Error", JOptionPane.INFORMATION_MESSAGE);
	           
	       }
	}

	
	
}
