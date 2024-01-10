package Entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class AddUsers {
	/**
	 * Returns true if user is successfully added to database.
	 */
	public boolean addUserToDatabase(List<String> user) {

		try {
			Connection connection = DriverManager.getConnection(CreateDatabase.database, CreateDatabase.username,
					CreateDatabase.password);
			
			String sql = "INSERT INTO USER"
					+ "(FName, LName, Email, Password, User_Type, Companion_Voucher) "
					+ "VALUES (?, ?, ?, ?, ?, ?)";
			
			try (PreparedStatement statement = connection.prepareStatement(sql)) {
				statement.setString(1, user.get(0)); // fName
				statement.setString(2, user.get(1)); // lName
				statement.setString(3, user.get(2)); // Email
				statement.setString(4, user.get(3)); // Password
				statement.setString(5, user.get(4)); // User_Type
				statement.setString(6, user.get(5)); // Companion_Voucher

				// Execute the update
				statement.executeUpdate();
			}

			connection.close();
			return true;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

}
