package Entities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FetchRegisteredUsers {
	    
	    public List<String> fetchRegisteredUsersFromDatabase() {
	        List<String> registeredUsers = new ArrayList<>();

	        try {
	        	Connection connection = DriverManager.getConnection(CreateDatabase.database, CreateDatabase.username, CreateDatabase.password);
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery("SELECT * FROM User");

	            while (resultSet.next()) {
	            	
	            	int registeredID = resultSet.getInt("ID");
	                String FName = resultSet.getString("FName"); 
	                String Fname = resultSet.getString("Fname");
	                String Email = resultSet.getString("Email");
	            	int userID = resultSet.getInt("User_Type");
	            	Boolean voucher = resultSet.getBoolean("Companion_Voucher");
	            	
	            	if(userID == 1) { 		
	            		String registeredUsersInfo = String.format("%d, %s, %s, %s, %b",registeredID, FName, Fname,
	            									Email, voucher);
	            		registeredUsers.add(registeredUsersInfo);
	            	}
	               
	            }

	            resultSet.close();
	            statement.close();
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return registeredUsers;
	    }
	    
	    public List<String> fetchPromoUsersFromDatabase() {
	        List<String> promoUsers = new ArrayList<>();

	        try {
	        	Connection connection = DriverManager.getConnection(CreateDatabase.database, CreateDatabase.username, CreateDatabase.password);
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery("SELECT Email FROM User WHERE User_Type = 1");

	            while (resultSet.next()) {

	                String Email = resultSet.getString("Email");
	                promoUsers.add(Email);
	            	
	            }

	            resultSet.close();
	            statement.close();
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return promoUsers;
	    }
}
