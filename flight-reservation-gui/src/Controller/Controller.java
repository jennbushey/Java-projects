package Controller;

import View.*;
import Entities.*;

import java.sql.Timestamp;
import java.util.List;

/*
 * Controller employs a singleton pattern that all views can connect to and change the String "State"
 * and thus change views
 */
public class Controller {
	
	private static Controller instance;
	private static String state;
	private static String prev_state;
	public static int userType;
	public static int userID;
	public static String password;
	public static double flightCost;
	public static double seatCost;
	public static double insuranceCost;
	public static double totalCost;
	public static String flightChosen;
	public static String seatChosen;
	public static boolean insuranceChosen;
	public static String creditCardName;
	public static String creditCardNumber;
	public static String creditCardCVV;
	public static String email;
	
	// Basic Views
	private static MainMenu mainMenu = new MainMenu();
	private static LoginApp loginApp = new LoginApp();
	private static GuestUserInterface guestUserInterface = new GuestUserInterface();
	private static RegisteredUserInterface registeredUserInterface = new RegisteredUserInterface();
	private static SystemAdminInterface systemAdminInterface = new SystemAdminInterface();
	private static FlightAgentsInterface flightAgenInterface = new FlightAgentsInterface();
	private static CancelFlightInterface cancelFlightInterface = new CancelFlightInterface();
	private static SelectFlightInterface selectFlightInterface = new SelectFlightInterface();
	private static PaymentInterface paymentInterface = new PaymentInterface();
	private static RegisterInterface registerInterface = new RegisterInterface();
	private static SelectSeatInterface selectSeatInterface = new SelectSeatInterface();
	private static InsuranceSelectionInterface selectInsuranceInterface = new InsuranceSelectionInterface();
	private static visaInterface visa = new visaInterface();
	private static mastercardInterface mastercard = new mastercardInterface();
	private static ConfirmationInterface confirmation = new ConfirmationInterface();
	private static guestUserInfoInterface guestUserInfo = new guestUserInfoInterface();
	private static SelectFlightForManifest selectFlightForManifest = new SelectFlightForManifest();
	private static ManagePromos managePromos = new ManagePromos();
	
	// Views for Query/Insertion/Update/Deletion of Information
	private static QuerySelectionCrews querySelectionCrews = new QuerySelectionCrews();
	private static QuerySelectionFlights querySelectionFlights = new QuerySelectionFlights();
	private static QuerySelectionAircrafts querySelectionAircrafts = new QuerySelectionAircrafts();
	private static InsertCrew insertCrew =  new InsertCrew();
	private static UpdateCrew updateCrew = new UpdateCrew();
	private static DeleteCrew deleteCrew = new DeleteCrew();
	private static InsertAircraft insertAircraft = new InsertAircraft();
	private static UpdateAircraft updateAircraft = new UpdateAircraft();
	private static DeleteAircraft deleteAircraft = new DeleteAircraft();
	private static InsertFlight insertFlight = new InsertFlight();
	private static UpdateFlight updateFlight = new UpdateFlight();
	private static DeleteFlight deleteFlight = new DeleteFlight();
	
	
	//Entites to manipulate database
	private static CrewDataManipulation crewData = new CrewDataManipulation();
	private static AircraftDataManipulation aircraftData = new AircraftDataManipulation();
	private static FlightDataManipulation flightData = new FlightDataManipulation();
	
	// Views to display database information
	private static DisplayFlights displayFlights  = new DisplayFlights();
	private static DisplayCrews displayCrews = new DisplayCrews();
	private static DisplayAircrafts displayAircrafts = new DisplayAircrafts();
	private static DisplayRegisteredUsers displayRegisteredUsers = new DisplayRegisteredUsers();
	private static DisplaySystemAdminFlight displaySystemAdminUsers = new DisplaySystemAdminFlight();
	private static DisplayManifest displayManifest = new DisplayManifest();
	
	// Entities connected to database and used to retrieve/insert information
	public static FetchFlights fetchFlights = new FetchFlights();
	private static FetchCrews fetchCrews = new FetchCrews();
	private static FetchAircrafts fetchAircrafts = new FetchAircrafts();
	public static FetchRegisteredUsers fetchRegisteredUsers = new FetchRegisteredUsers();
	private static FetchPassengerList fetchPassengerList = new FetchPassengerList();

	private Controller() {
	}
	
	public static Controller getInstance() {
		if(instance == null) {
			instance = new Controller();
		}
		return instance;
	}
	
	public void setState(String newState) {
		prev_state = state;
		state = newState;
		changeView();
	}
	
	public void setUser(int userType) {
		this.userType = userType;
	}
	
	public String getPrevState() {
		return prev_state;
	}
	
	
	private static void changeView() {
		
		if(state.equals("MainMenu")) {
			mainMenu.run();
		}
		else if(state.equals("LoginApp")) {
			loginApp.run();
		}
		
		else if (state.equals("GuestUserInterface")) {
			guestUserInterface.run();
		}
		
		else if(state.equals("RegisteredUserInterface")) {
			registeredUserInterface.run();
		}
		
		else if(state.equals("SystemAdminInterface")) {
			systemAdminInterface.run();
		}
		else if (state.equals("FlightAgentInterface")) {
			flightAgenInterface.run();
		}
		else if (state.equals("BrowseFlights")) {
			//List<String> Flights = fetchFlights.fetchFlightsFromDatabase();
			//displayFlights.displayFlights(Flights);
			displayFlights.run();
		}
		else if(state.equals("BrowseCrews")){
			List<String> Crews = fetchCrews.fetchCrewsFromDatabase();
			displayCrews.displayCrews(Crews);
		}
		else if(state.equals("BrowseAircrafts")) {
			List<String> Aircrafts = fetchAircrafts.fetchAircraftsFromDatabase();
			displayAircrafts.displayAircrafts(Aircrafts);
		}
		else if(state.equals("BrowseRegisteredUsers")) {
			List<String> registeredUsers = fetchRegisteredUsers.fetchRegisteredUsersFromDatabase();
			displayRegisteredUsers.displayRegisteredUsers(registeredUsers);
		}
		else if(state.equals("BrowseSystemAdminFlights")) {
			List<String> systemAdminFlights = fetchFlights.fetchSystemAdminBrowseFlights();
			displaySystemAdminUsers.displaySystemAdminFlight(systemAdminFlights);		
		}
		
		else if(state.equals("SelectFlightForManifest")) {
			selectFlightForManifest.run();
		}
		else if(state.equals("")) {
		}
		
		else if(state.equals("CancelFlight")) {
			cancelFlightInterface.run();
		}
		else if(state.equals("SelectFlight")) {
			selectFlightInterface.run();
		}

		else if(state.equals("SelectPayment")) {
			paymentInterface.run();
		}
		else if(state.equals("Register")) {
			registerInterface.run();
		}
		else if(state.equals("SelectSeat")) {
			selectSeatInterface.run();
		}
		else if(state.equals("SelectInsurance")) {
			selectInsuranceInterface.run();
		}
		else if(state.equals("Visa")) {
			visa.run();
		}
		else if(state.equals("Mastercard")) {
			mastercard.run();
		}
		else if(state.equals("Confirmation")) {
			confirmation.run();
		}
		else if(state.equals("GuestUserInputInfo")) {
			guestUserInfo.run();
		}
		
		else if(state.equals("QuerySelectionCrews")) {
			querySelectionCrews.run();
		}
		else if(state.equals("QuerySelectionAircrafts")) {
			querySelectionAircrafts.run();
		}
		else if(state.equals("QuerySelectionFlights")) {
			querySelectionFlights.run();
		}
		else if(state.equals("InsertCrew")) {
			insertCrew.run();
		}
		else if(state.equals("UpdateCrew")) {
			updateCrew.run();
		}
		else if(state.equals("DeleteCrew")) {
			deleteCrew.run();
		}
		else if(state.equals("InsertAircraft")) {
			insertAircraft.run();
		}
		else if(state.equals("UpdateAircraft")) {
			updateAircraft.run();
		}
		else if(state.equals("DeleteAircraft")){
			deleteAircraft.run();
		}
		else if(state.equals("InsertFlight")) {
			insertFlight.run();
		}
		else if(state.equals("UpdateFlight")) {
			updateFlight.run();
		}
		else if(state.equals("DeleteFlight")){
			deleteFlight.run();
		}
		else if(state.equals("ManagePromos")){
			managePromos.run();
		}
		
		
		else {
			System.out.println("This state is not defined in the controller.");
		}
		
	}
	
    public void insertCrew(String firstName, String lastName) {
    	crewData.InsertCrew(firstName, lastName);
    }
    
    public void updateCrew(int crewID, String firstName, String lastName) {
    	crewData.UpdateCrew(crewID, firstName, lastName);
    }
    
    public void deleteCrew(int crewID) {
    	crewData.DeleteCrew(crewID);
    }
    
   
    public void insertAircraft(String Model) {
    	aircraftData.InsertAircraft(Model);
    }
    
    public void updateAircraft(int aircraftID, String Model) {
    	aircraftData.UpdateAircraft(aircraftID, Model);
    }
    
    public void deleteAircraft(int aircraftID) {
    	aircraftData.DeleteAircraft(aircraftID);
    }
    
   
    public void insertFlight(String departureLocation, String arrivalLocation, Timestamp departureTime,
			 				 Timestamp arrivalTime, int aircraftID, int crew1ID, int crew2ID, int crew3ID) {
    	flightData.InsertFlight(departureLocation, arrivalLocation, departureTime, arrivalTime, aircraftID,
    							crew1ID, crew2ID, crew3ID);
    }
    
    public void updateFlight(int flightID, String departureLocation, String arrivalLocation, Timestamp departureTime,
			 Timestamp arrivalTime, int aircraftID, int crew1ID, int crew2ID, int crew3ID) {
    	flightData.UpdateFlight(flightID, departureLocation, arrivalLocation, departureTime, arrivalTime, aircraftID,
				crew1ID, crew2ID, crew3ID);
    }
    
    public void deleteFlight(int flightID) {
    	flightData.DeleteFlight(flightID);
    }
    
    public void getManifest(int flightID) {
    	List<String> manifest = fetchPassengerList.fetchPassengerList(flightID);
    	displayManifest.displayManifest(manifest);
    }
        
    
	
	public static void main(String[] args) {
		
		//THIS CREATES THE DATABSE
		CreateDatabase.createDatabase();
		
		instance = getInstance();
		mainMenu.run();
		
		}	
}


