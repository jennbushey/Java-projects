package Entities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FetchAircrafts {
    
	    
	    public List<String> fetchAircraftsFromDatabase() {
	        List<String> aircrafts = new ArrayList<>();

	        try {
	        	Connection connection = DriverManager.getConnection(CreateDatabase.database, CreateDatabase.username, CreateDatabase.password);
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery("SELECT * FROM Aircraft");

	            while (resultSet.next()) {
	                int aircraftID = resultSet.getInt("ID");
	                String model = resultSet.getString("Model");


	                String aircraftsInfo = String.format("%d, %s",
	                		aircraftID, model);
	                aircrafts.add(aircraftsInfo);
	            }

	            resultSet.close();
	            statement.close();
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return aircrafts;
	    }
	}
