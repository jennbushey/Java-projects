package Entities;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import Controller.Controller;
import Controller.LoginController;

 
/**
 * Gets user information from database. Validates user input login credentials. 
 * Gets user type so controller can change view for each user type.
 */
public class LoginCredentialCheck {
	private Controller controller = Controller.getInstance();

	public static List<List<String>> fetchUserFromDatabase() {
		List<List<String>> users = new ArrayList<>();

		try {
			Connection connection = DriverManager.getConnection(CreateDatabase.database, CreateDatabase.username,
					CreateDatabase.password);
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("select * from user;");

			while (resultSet.next()) {
				List<String> user = new ArrayList<>();

				String userID = resultSet.getString("ID"); // 0
				String fName = resultSet.getString("FName"); // 1
				String lName = resultSet.getString("LName"); // 2
				String email = resultSet.getString("email"); // 3
				String password = resultSet.getString("password"); // 4
				String userType = resultSet.getString("User_Type"); // 5
				String voucher = resultSet.getString("Companion_Voucher"); // 6

				user.add(userID);
				user.add(fName);
				user.add(lName);
				user.add(email);
				user.add(password);
				user.add(userType);
				user.add(voucher);

				users.add(user);
			}

			resultSet.close();
			statement.close();
			connection.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return users;
	}
	// Check to see if email and password matches in the user table
	public boolean validate(String email, String password) {
		System.out.printf("Validating email: %s and password: %s\n", email, password);
		List<List<String>> users = fetchUserFromDatabase();
		
		for (int i = 0; i < users.size(); i++) {
			if (users.get(i).get(3).equals(email)) {
				if (users.get(i).get(4).equals(password)) {
					System.out.println("Success");
					LoginController.user = users.get(i);
					controller.userID = Integer.parseInt(users.get(i).get(0));
					return true;
				}
			}
		}
		System.out.println("Email and password are not found in database.");
		return false;  
	}
	
	
	// Check if you belong to any type of users and if you don't return 0
	public int getUserType(List<String> user) {
		if(user.get(5).equals("1")) {
			// Registered User
			return 1;
		} else if (user.get(5).equals("2")) {
			// System Admin
			return 2;
		} else if (user.get(5).equals("3")) {
			// Agent
			return 3;
		} else
		return 0;
	}
}

