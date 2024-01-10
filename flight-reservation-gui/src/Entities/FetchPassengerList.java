package Entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

public class FetchPassengerList {

    public List<String> fetchPassengerList(int flightID) {

        List<String> manifest = new ArrayList<>();

        try {
            Connection connection = DriverManager.getConnection(CreateDatabase.database, CreateDatabase.username, CreateDatabase.password);
            String query = "SELECT U.ID, U.FName, U.LName, B.Seat FROM USER U JOIN BOOKINGS B ON U.ID = B.UserID WHERE FLIGHTID = ?";
            
            try (PreparedStatement preparedStatement = connection.prepareStatement(query)) {
                preparedStatement.setInt(1, flightID);
                ResultSet resultSet = preparedStatement.executeQuery();

                while (resultSet.next()) {
                    int userID = resultSet.getInt("ID");
                    String fName = resultSet.getString("FName");
                    String lName = resultSet.getString("LName");
                    String seat = resultSet.getString("Seat");

                    String passengerInfo = String.format("%d, %s, %s, %s", userID, fName, lName, seat);
                    manifest.add(passengerInfo);
                }
            }

            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Something Has Gone Wrong", "Error", JOptionPane.INFORMATION_MESSAGE);

        }

        return manifest;
    }
}