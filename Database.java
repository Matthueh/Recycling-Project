import java.sql.*;
import java.util.*;

public class Database {

	public String USERNAME;
	public String PASSWORD;
	public String DBURL;
	
	private Connection dbConnect;
	
	Database(String DBURL, String USERNAME, String PASSWORD){
		this.USERNAME = USERNAME;
		this.PASSWORD = PASSWORD;
		this.DBURL = DBURL;
	}
	
	public void initializeConnection() {
		try {
    		dbConnect = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}	
	}
	
	public ArrayList<Chair> getChairs(String type){
		
		ArrayList<Chair> chairs = new ArrayList<Chair>();
		
		try {
    		Statement state = dbConnect.createStatement();
    		ResultSet result = state.executeQuery("SELECT * FROM " + "chair");
    		
    		while(result.next()) {
    			if(result.getString("Type").equals(type)) {
    				//System.out.println("Into add chairs");
    				Chair temp = new Chair(result.getString("ID"),result.getString("Type"),result.getString("Legs").charAt(0),result.getString("Arms").charAt(0),result.getString("Seat").charAt(0),result.getString("Cushion").charAt(0),result.getInt("Price"),result.getString("ManuID"));
    				chairs.add(temp);
    			}
    		}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}

		return chairs;
	}
	
	public ArrayList<Desk> getDesks(String type){
		
		ArrayList<Desk> desks = new ArrayList<Desk>();
		
		try {
    		Statement state = dbConnect.createStatement();
    		ResultSet result = state.executeQuery("SELECT * FROM " + "desk");
    		
    		while(result.next()) {
    			if(result.getString("Type").equals(type)) {
    				Desk temp = new Desk(result.getString("ID"),result.getString("Type"),result.getString("Legs").charAt(0),result.getString("Top").charAt(0),result.getString("Drawer").charAt(0),result.getInt("Price"),result.getString("ManuID"));
    				desks.add(temp);
    				}
    			}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
		return desks;
	}
	
	public ArrayList<Filing> getFilings(String type){
		
		ArrayList<Filing> filings = new ArrayList<Filing>();
		
		try {
    		Statement state = dbConnect.createStatement();
    		ResultSet result = state.executeQuery("SELECT * FROM " + "filing");
    		
    		while(result.next()) {
    			if(result.getString("Type").equals(type)) {
    				Filing temp = new Filing(result.getString("ID"),result.getString("Type"),result.getString("Rails").charAt(0),result.getString("Drawers").charAt(0),result.getString("Cabinet").charAt(0),result.getInt("Price"),result.getString("ManuID"));
    				filings.add(temp);
    				}
    			}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
		return filings;
	}
	
	public ArrayList<Lamp> getLamps(String type){
		
		ArrayList<Lamp> lamps = new ArrayList<Lamp>();
		
		try {
    		Statement state = dbConnect.createStatement();
    		ResultSet result = state.executeQuery("SELECT * FROM " + "lamp");
    		
    		while(result.next()) {
    			if(result.getString("Type").equals(type)) {
    				Lamp temp = new Lamp(result.getString("ID"),result.getString("Type"),result.getString("Base").charAt(0),result.getString("Bulb").charAt(0),result.getInt("Price"),result.getString("ManuID"));
    				lamps.add(temp);
    				}
    			}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
		return lamps;
	}
	
	public ArrayList<Manufacturer> getManufacturers(){
		
		ArrayList<Manufacturer> manufacturers = new ArrayList<Manufacturer>();
		
		try {
    		Statement state = dbConnect.createStatement();
    		ResultSet result = state.executeQuery("SELECT * FROM " + "manufacturer");
    		
    		while(result.next()) {
    			
    		Manufacturer temp = new Manufacturer(result.getString("ManuID"),result.getString("Name"),result.getString("Phone"),result.getString("Province"));
    		manufacturers.add(temp);
    		}
    			
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
    	
		return manufacturers;
	}
	
	public void deleteChair(String id) {
		try {
    		String query = "DELETE FROM chair WHERE ID = ?";
    		PreparedStatement state = dbConnect.prepareStatement(query);
    		
    		state.setString(1,id);
    		
    		state.executeUpdate();
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
	}
	
	public void deleteDesk(String id) {
		try {
    		String query = "DELETE FROM desk WHERE ID = ?";
    		PreparedStatement state = dbConnect.prepareStatement(query);
    		
    		state.setString(1,id);
    		
    		state.executeUpdate();
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
	}
	
	public void deleteFiling(String id) {
		try {
    		String query = "DELETE FROM filing WHERE ID = ?";
    		PreparedStatement state = dbConnect.prepareStatement(query);
    		
    		state.setString(1,id);
    		
    		state.executeUpdate();
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
	}
	
	public void deleteLamp(String id) {
		try {
    		String query = "DELETE FROM lamp WHERE ID = ?";
    		PreparedStatement state = dbConnect.prepareStatement(query);
    		
    		state.setString(1,id);
    		
    		state.executeUpdate();
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}
	}
	
	public ArrayList<String> getChairManufacturers(){
		
		ArrayList<String> manuIDs = new ArrayList<String>();
		
		try {
    		Statement state = dbConnect.createStatement();
    		ResultSet result = state.executeQuery("SELECT * FROM " + "chair");
    		
    		while(result.next()) {
    			String manu = result.getString("ManuID");
    			if(manuIDs.contains(manu)==false) {
    				manuIDs.add(manu);
    			}
    			
    		}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}

		return manuIDs;
	}
	
	public ArrayList<String> getDeskManufacturers(){
		
		ArrayList<String> manuIDs = new ArrayList<String>();
		
		try {
    		Statement state = dbConnect.createStatement();
    		ResultSet result = state.executeQuery("SELECT * FROM " + "desk");
    		
    		while(result.next()) {
    			String manu = result.getString("ManuID");
    			if(manuIDs.contains(manu)==false) {
    				manuIDs.add(manu);
    			}
    			
    		}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}

		return manuIDs;
	}
	
	public ArrayList<String> getFilingManufacturers(){
		
		ArrayList<String> manuIDs = new ArrayList<String>();
		
		try {
    		Statement state = dbConnect.createStatement();
    		ResultSet result = state.executeQuery("SELECT * FROM " + "filing");
    		
    		while(result.next()) {
    			String manu = result.getString("ManuID");
    			if(manuIDs.contains(manu)==false) {
    				manuIDs.add(manu);
    			}
    			
    		}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}

		return manuIDs;
	}
	
	public ArrayList<String> getLampManufacturers(){
		
		ArrayList<String> manuIDs = new ArrayList<String>();
		
		try {
    		Statement state = dbConnect.createStatement();
    		ResultSet result = state.executeQuery("SELECT * FROM " + "lamp");
    		
    		while(result.next()) {
    			String manu = result.getString("ManuID");
    			if(manuIDs.contains(manu)==false) {
    				manuIDs.add(manu);
    			}
    			
    		}
    		state.close();
    	} catch(SQLException e) {
    		e.printStackTrace();
    	}

		return manuIDs;
	}

	
}
