package Controller;
import java.util.List;

import Entities.*;

public class LoginController {
	
	private static LoginController instance;
	public static String email;
	public static String password;
	public static List<String> user;
	
	private static LoginCredentialCheck loginCheck = new LoginCredentialCheck(); 
	private static AddUsers addUser = new AddUsers(); 

	public boolean getLoginCredentialCheck() {
//		System.out.println(email + " " + password);
		return loginCheck.validate(email, password);
	}
	
	public int getUserType() {
		return loginCheck.getUserType(user);
	}
	
	public boolean addUserToDatabase() {
		return addUser.addUserToDatabase(user);
	}
	
	public static LoginController getInstance() {
		if(instance == null) {
			instance = new LoginController();
		}
		return instance;
	}
	
}
