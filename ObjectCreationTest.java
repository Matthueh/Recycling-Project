import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class ObjectCreationTest {
	
	//change this depending on the user.
	String DBURL = "jdbc:mysql://localhost/inventory"; 	//This can stay the same.
	String Username = "matthew";						//Change this depending on who uses it.
	String Password = "ensf409";						//Change this depending on who uses it.
	
	@Test
	//This will test getChairs
	public void testDataBaseConstructorGetChairs0Type() {
		Database data = new Database(DBURL, Username, Password); // We will have to get database from Alex.
		data.initializeConnection();
		
		//Here we are going to create an array of what expected chair Id's are going to be for the type Task
		String [] Task = {
				"C0914",
				"C1148",
				"C3405"
		};
		
		String [] Mesh = {
				"C0942",
				"C6748",
				"C8138",
				"C9890"
		};
		
		String [] Kneeling = {
				"C1320",
				"C3819"
		};
		
		String [] Executive = {
				"C2483",
				"C5784",
				"C7268"
		};
		
		String [] Ergonomic = {
				"C4839",
				"C5409",
				"C5789"
		};
		
		//Retrieve list of chairs of type task, convert it to an array.
		ArrayList<Chair> chair = data.getChairs("Task");
		String [] tmpArray = getArrayChairId(chair);
		
		//Checking that getChairs is actually working for type task
		assertTrue("Method getChairs(String type) doesn't handle getting type Task from the listed chairs.", Arrays.equals(Task, tmpArray));
		
		//Reassigning list of chairs of type mesh, convert it to an array.
		chair = data.getChairs("Mesh");
		tmpArray = getArrayChairId(chair);
		
		//Checking that getChairs is actually working for type mesh. 
		assertTrue("Method getChairs(String type) doesn't handle getting type Mesh from the listed chairs.", Arrays.equals(Mesh,  tmpArray));
		
		//Reassigning list of chairs of type Kneeling, convert it to an array.
		chair = data.getChairs("Kneeling");
		tmpArray = getArrayChairId(chair);
		
		//Checking that getChairs is actually working for type Kneeling.
		assertTrue("Method getChairs(String type) doesn't handle getting type Kneeling from the listed chairs.", Arrays.equals(Kneeling, tmpArray));
		
		//Retrieve list of chairs of type Executive 
		chair = data.getChairs("Executive");
		tmpArray = getArrayChairId(chair);
		
		//Checking that getChairs is actually working for type Executive.
		assertTrue("Method getChairs(String type) doesn't handle getting type Executive from the listed chairs.", Arrays.equals(Executive, tmpArray));
		
		//Retrieve list of chairs of type Ergonomic.
		chair = data.getChairs("Ergonomic");
		tmpArray = getArrayChairId(chair);
		
		//Checking that getChairs is actually working for type Executive.
		assertTrue("Method get Chairs(string type) doesn't handle getting type Ergonomic from the listed chairs.", Arrays.equals(Ergonomic, tmpArray));	
	}
	
	@Test
	//This will be getDesks.
	public void testDataBaseConstructorGetDesks0Type() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		//These are the expected outputs
		String [] Traditional = {
			"D0890",
			"D4231",
			"D8675",
			"D9352"
		};
		String [] Adjustable = {
				"D1030",
				"D2746",
				"D3682",
				"D4475",
				"D5437",
				"D7373"
		};
		String [] Standing = {
				"D1927",
				"D2341",
				"D3820",
				"D4438",
				"D9387"
		};
		
		//Retrieve list of desks of type Traditional
		ArrayList<Desk> desk = data.getDesks("Traditional");
		String [] tmpArray = getArrayDeskId(desk);
		
		//Checking whether getDesks method is actually working
		assertTrue("Method getDesks(String type) doesn't handle getting type Traditional from listed desks.", Arrays.equals(Traditional, tmpArray));
		
		//Retrieving list of desks of type Adjustable
		desk = data.getDesks("Adjustable");
		tmpArray = getArrayDeskId(desk);
		
		//Checking whether getDesks method is actually working
		assertTrue("Method getDesks(String type) doesn't handle getting type Adjustable from listed desks.", Arrays.equals(Adjustable, tmpArray));
		
		//Retrieving list of desks of type Standing
		desk = data.getDesks("Standing");
		tmpArray = getArrayDeskId(desk);
		
		//Checking whether getDesks method is actually working
		assertTrue("Method getDesks(String type) doesn't handle getting type Standing from listed desks.", Arrays.equals(Standing, tmpArray));
		
	}
	
	@Test
	
	public void testDataBaseConstructorGetFilings0Type() {
		
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		//These are the expected outputs
		String [] Small = {
				"F001",
				"F004",
				"F005",
				"F006",
				"F013"
		};
		
		String [] Medium = {
				"F002",
				"F007",
				"F008",
				"F009",
				"F014"
		};
		
		String [] Large = {
				"F003",
				"F010",
				"F011",
				"F012",
				"F015"
		};
		
		ArrayList<Filing> filing  = data.getFilings("Small");
		String [] tmpArray = getArrayFilingId(filing);
		
		assertTrue("Method getFiling(String type) doesn't handle getting type Small.", Arrays.equals(Small, tmpArray));
		
		filing = data.getFilings("Medium");
		tmpArray = getArrayFilingId(filing);
		
		assertTrue("Method getFilings(String type) doesn't handle getting type Medium", Arrays.equals(Medium, tmpArray));
		
		filing = data.getFilings("Large");
		tmpArray = getArrayFilingId(filing);
		
		assertTrue("Method getFilings(String type) doesn't handlge getting type Large", Arrays.equals(Large, tmpArray));
		
	}
	
	@Test
	
	public void testDataBaseConstructorGetLamps0Type() {
		
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		//These are expected outputs
		String [] Desk = {
			"L013",
			"L112",
			"L132",
			"L208",
			"L342",
			"L564",
			"L649"
		};
		String [] SwingArm = {
			"L053",
			"L096",
			"L487",
			"L879"
		};
		
		String [] Study = {
			"L223",
			"L928",
			"L980",
			"L982",
		};
		
		ArrayList<Lamp> Lamp  = data.getLamps("Desk");
		String [] tmpArray = getArrayLampId(Lamp);
		
		assertTrue("Method getLamps(String type) doesn't handle getting type Small.", Arrays.equals(Desk, tmpArray));
		
		Lamp = data.getLamps("Swing Arm");
		tmpArray = getArrayLampId(Lamp);
		
		assertTrue("Method getLamps(String type) doesn't handle getting type Medium", Arrays.equals(SwingArm, tmpArray));
		
		Lamp = data.getLamps("Study");
		tmpArray = getArrayLampId(Lamp);
		
		assertTrue("Method getLamps(String type) doesn't handle getting type Large", Arrays.equals(Study, tmpArray));
			
	}
	
	@Test
	
	public void testDataBaseConstructorGetManufacturers0Type() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		String [] ManuID = {
				"001",
				"002",
				"003",
				"004",
				"005"
		};
		
		ArrayList<Manufacturer> Manu = data.getManufacturers();
		String [] tmpArray = getArrayManuId(Manu);
		
		assertTrue("Method getManuID() doesn't handle getting the manufacturing Id's", Arrays.equals(ManuID, tmpArray));
		
	}
	
	@Test
	
	public void testDataBaseConstructorDeleteChair0Type() throws SQLException {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		data.deleteChair("C2483");
		
		//Expected chair outputs for executives is called.
		String [] ChairId = {
				"C5784",
				"C7268"
		};
		
		ArrayList<Chair> chair = data.getChairs("Executive");
		String [] tmpArray = getArrayChairId(chair);
		if(Arrays.equals(ChairId, tmpArray)) {
			insertNewChair("C2483", "Executive", "Y", "Y", "N", "N", 175, "002");
		}
		else {
			assertTrue("Method deleteChair(String type) doesn't  handle getting the manufacturing Id's", Arrays.equals(ChairId, tmpArray));
		}
		
	}
	
	@Test
	
	public void testDataBaseConstructorDeleteDesk0Type() throws SQLException {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		data.deleteDesk("D2746");
		
		//Expected desk outputs for executives is called.
		String [] DeskId = {
				"D1030",
				"D3682",
				"D4475",
				"D5437",
				"D7373"	
		};
		
		ArrayList<Desk> desk = data.getDesks("Adjustable");
		String [] tmpArray = getArrayDeskId(desk);
		if(Arrays.equals(DeskId, tmpArray)) {
			insertNewDesk("D2746", "Adjustable", "Y", "N", "Y", 250, "004");
		}
		else {
			assertTrue("Method deleteDesk(String type) doesn't handle getting the manufacturing Id's", Arrays.equals(DeskId, tmpArray));
		}
		
	}
	
	@Test
	
	public void testDataBaseConstructorDeleteFiling0Type() throws SQLException {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		data.deleteFiling("F008");
		
		//Expected desk outputs for executives is called.
		String [] filingId = {
				"F002",
				"F007",
				"F009",
				"F014",
		};
		
		ArrayList<Filing> filing = data.getFilings("Medium");
		String [] tmpArray = getArrayFilingId(filing);
		if(Arrays.equals(filingId, tmpArray)) {
			insertNewFiling("F008", "Medium", "Y", "N", "N", 50, "005");
		}
		else {
			assertTrue("Method deleteDesk(String type) doesn't handle getting the manufacturing Id's", Arrays.equals(filingId, tmpArray));
		}
	}
	
	@Test
	public void testDataBaseConstructorDeleteLamp0Type() throws SQLException {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		data.deleteLamp("L982");
		
		//Expected desk outputs for executives is called.
		String [] LampId = {
				"L223",
				"L928",
				"L980",
		};
		
		ArrayList<Lamp> lamps = data.getLamps("Study");
		String [] tmpArray = getArrayLampId(lamps);
		if(Arrays.equals(LampId, tmpArray)) {
			insertNewLamp("L982", "Study", "Y", "N", 8, "002");
		}
		else {
			assertTrue("Method deleteDesk(String type) doesn't handle getting the manufacturing Id's", Arrays.equals(LampId, tmpArray));
		}
	}
	
	
	

	//These are helper methods
	
	public String[] getArrayChairId(ArrayList<Chair> data) {
		ArrayList<String> tmp = new ArrayList<String>();
		if(data != null && data.isEmpty() == false) {
			for(int i = 0; i < data.size() ; i++ ) {
				tmp.add(data.get(i).getID());
			}
		}
		String [] tmpArray = tmp.toArray(new String[tmp.size()]);
		return tmpArray;
	}
	
	public String[] getArrayDeskId(ArrayList<Desk> data) {
		ArrayList<String> tmp = new ArrayList<String>();
		if(data != null && data.isEmpty() == false) {
			for(int i = 0; i < data.size() ; i++ ) {
				tmp.add(data.get(i).getID());
			}
		}
		String [] tmpArray = tmp.toArray(new String[tmp.size()]);
		return tmpArray;
	}
	
	public String[] getArrayFilingId(ArrayList<Filing> data) {
		ArrayList<String> tmp = new ArrayList<String>();
		if(data != null && data.isEmpty() == false) {
			for(int i = 0; i < data.size() ; i++ ) {
				tmp.add(data.get(i).getID());
			}
		}
		String [] tmpArray = tmp.toArray(new String[tmp.size()]);
		return tmpArray;
	}
	
	public String[] getArrayLampId(ArrayList<Lamp> data) {
		ArrayList<String> tmp = new ArrayList<String>();
		if(data != null && data.isEmpty() == false) {
			for(int i = 0; i < data.size() ; i++ ) {
				tmp.add(data.get(i).getID());
			}
		}
		String [] tmpArray = tmp.toArray(new String[tmp.size()]);
		return tmpArray;
	}
	
	private String[] getArrayManuId(ArrayList<Manufacturer> data) {
		ArrayList<String> tmp = new ArrayList<String>();
		if(data != null && data.isEmpty() == false) {
			for(int i = 0; i < data.size(); i++) {
				tmp.add(data.get(i).getManuID());
			}
		}
		String [] tmpArray = tmp.toArray(new String[tmp.size()]); 
		return tmpArray;
	}
	
	public void insertNewChair(String ID, String Type, String Legs, String Arms, String Seat, String Cushion, int Price, String ManuID) {
		try {
			Connection dbConnect = DriverManager.getConnection(DBURL, Username, Password);		
			
			String query = "INSERT INTO chair (ID, Type, Legs, Arms, Seat, Cushion, Price, ManuID) VALUES(?, ?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			
			myStmt.setString(1, ID);
			myStmt.setString(2, Type);
			myStmt.setString(3, Legs);
			myStmt.setString(4, Arms);
			myStmt.setString(5, Seat);
			myStmt.setString(6, Cushion);
			myStmt.setInt(7, Price);
			myStmt.setString(8, ManuID);
			
			myStmt.executeUpdate();
			//System.out.println("Rows affected: " + rowCount);
			myStmt.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void insertNewDesk(String ID, String Type, String Legs, String Top, String Drawer, int Price, String ManuID) {
		try {
			Connection dbConnect = DriverManager.getConnection(DBURL, Username, Password);		
			
			String query = "INSERT INTO desk (ID, Type, Legs, Top, Drawer, Price, ManuID) VALUES(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			
			myStmt.setString(1, ID);
			myStmt.setString(2, Type);
			myStmt.setString(3, Legs);
			myStmt.setString(4, Top);
			myStmt.setString(5, Drawer);
			myStmt.setInt(6, Price);
			myStmt.setString(7, ManuID);
			
			myStmt.executeUpdate();
			//System.out.println("Rows affected: " + rowCount);
			myStmt.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void insertNewFiling(String ID, String Type, String Rails, String Drawers, String Cabinet, int Price, String ManuID) {
		try {
			Connection dbConnect = DriverManager.getConnection(DBURL, Username, Password);	
			String query = "INSERT INTO filing (ID, Type, Rails, Drawers, Cabinet, Price, ManuID) VALUES(?, ?, ?, ?, ?, ?, ?)";
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			
			myStmt.setString(1, ID);
			myStmt.setString(2, Type);
			myStmt.setString(3, Rails);
			myStmt.setString(4, Drawers);
			myStmt.setString(5, Cabinet);
			myStmt.setInt(6, Price);
			myStmt.setString(7, ManuID);
			
			myStmt.executeUpdate();
			//System.out.println("Rows affected: " + rowCount);
			myStmt.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}	
	}
	
	public void insertNewLamp(String ID, String Type, String Base, String Bulb, int Price, String ManuID) {
		try {
			Connection dbConnect = DriverManager.getConnection(DBURL, Username, Password);

		
			
			String query = "INSERT INTO lamp (ID, Type, Base, Bulb, Price, ManuID) VALUES(?, ?, ?, ?, ?, ?)";
			PreparedStatement myStmt = dbConnect.prepareStatement(query);
			
			myStmt.setString(1, ID);
			myStmt.setString(2, Type);
			myStmt.setString(3, Base);
			myStmt.setString(4, Bulb);
			myStmt.setInt(5, Price);
			myStmt.setString(6, ManuID);
			
			myStmt.executeUpdate();
			//System.out.println("Rows affected: " + rowCount);
			myStmt.close();
			
		}catch(SQLException e) {
			e.printStackTrace();
		}	
	}	
	
}
