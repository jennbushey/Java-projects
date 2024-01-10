package Entities;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class FetchFlights {
   
	    
	    public List<String> fetchFlightsFromDatabase() {
	        List<String> flights = new ArrayList<>();

	        try {
	            Connection connection = DriverManager.getConnection(CreateDatabase.database, CreateDatabase.username, CreateDatabase.password);
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery("SELECT * FROM flight");

	            while (resultSet.next()) {
	                int flightID = resultSet.getInt("ID");
	                String departureAirport = resultSet.getString("Departure_Airport");
	                String arrivalAirport = resultSet.getString("Arrival_Airport");
	                Timestamp departureTime = resultSet.getTimestamp("Departure_Time");
	                Timestamp arrivalTime = resultSet.getTimestamp("Arrival_Time");

	                String flightInfo = String.format("%d, %s, %s, %s, %s",
	                        flightID, departureAirport, arrivalAirport, departureTime, arrivalTime);
	                flights.add(flightInfo);
	            }

	            resultSet.close();
	            statement.close();
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return flights;
	    }
	    
	    public List<String> fetchArrivalsFromDatabase(String arrival_airport) {
	        List<String> flights = new ArrayList<>();

	        try {
	            Connection connection = DriverManager.getConnection(CreateDatabase.database, CreateDatabase.username, CreateDatabase.password);
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery("SELECT * FROM flight WHERE Arrival_Airport = '" + arrival_airport +"'");
	            
	            System.out.println("Arrival airport: " + arrival_airport);
	            while (resultSet.next()) {
	                int flightID = resultSet.getInt("ID");
	                String departureAirport = resultSet.getString("Departure_Airport");
	                String arrivalAirport = resultSet.getString("Arrival_Airport");
	                Timestamp departureTime = resultSet.getTimestamp("Departure_Time");
	                Timestamp arrivalTime = resultSet.getTimestamp("Arrival_Time");

	                String flightInfo = String.format("%d, %s, %s, %s, %s",
	                        flightID, departureAirport, arrivalAirport, departureTime, arrivalTime);
	                flights.add(flightInfo);
	            }

	            resultSet.close();
	            statement.close();
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return flights;
	    }
	    
	    public List<String> fetchDeparturesFromDatabase(String departure_airport) {
	        List<String> flights = new ArrayList<>();

	        try {
	            Connection connection = DriverManager.getConnection(CreateDatabase.database, CreateDatabase.username, CreateDatabase.password);
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery("SELECT * FROM flight WHERE Departure_Airport = '" + departure_airport +"'");
	            
	            System.out.println("Arrival airport: " + departure_airport);
	            while (resultSet.next()) {
	                int flightID = resultSet.getInt("ID");
	                String departureAirport = resultSet.getString("Departure_Airport");
	                String arrivalAirport = resultSet.getString("Arrival_Airport");
	                Timestamp departureTime = resultSet.getTimestamp("Departure_Time");
	                Timestamp arrivalTime = resultSet.getTimestamp("Arrival_Time");

	                String flightInfo = String.format("%d, %s, %s, %s, %s",
	                        flightID, departureAirport, arrivalAirport, departureTime, arrivalTime);
	                flights.add(flightInfo);
	                
	            }

	            resultSet.close();
	            statement.close();
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return flights;
	    }
	    
	    public List<String> fetchSystemAdminBrowseFlights() {
	        List<String> flights = new ArrayList<>();

	        try {
	            Connection connection = DriverManager.getConnection(CreateDatabase.database, CreateDatabase.username, CreateDatabase.password);
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery("SELECT * FROM flight");

	            while (resultSet.next()) {
	                int flightID = resultSet.getInt("ID");
	                String departureAirport = resultSet.getString("Departure_Airport");
	                String arrivalAirport = resultSet.getString("Arrival_Airport");
	                Timestamp departureTime = resultSet.getTimestamp("Departure_Time");
	                Timestamp arrivalTime = resultSet.getTimestamp("Arrival_Time");
	                int aircraftID = resultSet.getInt("AircraftID");
	                int crew1ID = resultSet.getInt("Crew1ID");
	                int crew2ID = resultSet.getInt("Crew2ID");
	                int crew3ID = resultSet.getInt("Crew3ID");



	                String flightInfo = String.format("%d, %s, %s, %s, %s, %d, %d, %d, %d",
	                        flightID, departureAirport, arrivalAirport, departureTime, arrivalTime, aircraftID, crew1ID, crew2ID,
	                        crew3ID);
	                flights.add(flightInfo);
	            }

	            resultSet.close();
	            statement.close();
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	       return flights;


	    
	}
	    
	    public List<String> fetchFlightSeatsFromDatabase(int flightID) {
	        List<String> seatList = new ArrayList<>();

	        try {
	            Connection connection = DriverManager.getConnection(CreateDatabase.database, CreateDatabase.username, CreateDatabase.password);
	            Statement statement = connection.createStatement();
	            ResultSet resultSet = statement.executeQuery("SELECT * FROM Bookings WHERE FlightID = '" + flightID +"'");
	            
	            System.out.println("Checking Seats of: " + flightID);
	            while (resultSet.next()) {
	                String seat = resultSet.getString("Seat");

	                seatList.add(seat);
	            }

	            resultSet.close();
	            statement.close();
	            connection.close();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return seatList;
	    }
}

