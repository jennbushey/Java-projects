package Entities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FetchCrews {
	    
	    public List<String> fetchCrewsFromDatabase() {
	        List<String> crews = new ArrayList<>();

	        try {
	        	Connection connection = DriverManager.getConnection(CreateDatabase.database, CreateDatabase.username, CreateDatabase.password);
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery("SELECT * FROM crew");

	            while (resultSet.next()) {
	                int crewID = resultSet.getInt("ID");
	                String Fname = resultSet.getString("Fname");
	                String LName = resultSet.getString("LName");

	                String crewInfo = String.format("%d, %s, %s",
	                		crewID, Fname, LName);
	                crews.add(crewInfo);
	            }

	            resultSet.close();
	            statement.close();
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return crews;
	    }
}

