import static org.junit.Assert.*;
import org.junit.*;
import org.junit.rules.ExpectedException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.SQLSyntaxErrorException;
import java.util.*;


/**
 * These tests were based off of the database we were given.
 * 
 *
 */

public class ObjectCreationTest {
	
	//change this depending on the user.
	String DBURL = "jdbc:mysql://localhost/inventory"; 	//This can stay the same.
	String Username = "matthew";						//Change this depending on who uses it.
	String Password = "ensf409";						//Change this depending on who uses it.
	
	@Test
	/**	This method will test the getChairs method and make sure that it can accept the keyword Task and get an array list of chairs of type Task.
	 * 	If this test method does not get the value that is expected then it will not pass the J unit 4 test.
	 */
	public void testDataBaseConstructorGetChairs0TypeTask() {
		Database data = new Database(DBURL, Username, Password); 
		data.initializeConnection();
		
		//Here we are going to create an array of what expected chair Id's are going to be for the type Task
		String [] Task = {
				"C0914",
				"C1148",
				"C3405"
		};
		
		//Retrieve list of chairs of type task, convert it to an array.
		ArrayList<Chair> chair = data.getChairs("Task");
		String [] tmpArray = getArrayChairId(chair);
		
		//Checking that getChairs is actually working for type task
		assertTrue("Method getChairs(String type) doesn't handle getting type Task from the listed chairs.", Arrays.equals(Task, tmpArray));
	}
	
	@Test
	/** This method will test the getChairs method and make sure that it can accept the keyword Mesh and get an array list of chairs of type Mesh.
	 * 	If this test method does not get the value that is expected then it will not pass the J unit 4 test.
	 */
	public void testDataBaseConstructorGetChairs0TypeMesh() {
		Database data = new Database(DBURL, Username, Password); 
		data.initializeConnection();
		
		//Here we are going to create an array of what expected chair Id's are going to be for the type Task
		String [] Mesh = {
				"C0942",
				"C6748",
				"C8138",
				"C9890"
		};
		
		//Retrieve list of chairs of type task, convert it to an array.
		ArrayList<Chair> mesh = data.getChairs("Mesh");
		String [] tmpArray = getArrayChairId(mesh);
		
		//Checking that getChairs is actually working for type task
		assertTrue("Method getChairs(String type) doesn't handle getting type Mesh from the listed chairs.", Arrays.equals(Mesh, tmpArray));
	}
	
	@Test
	/**	This method will test the getChairs method and make sure that it can accept the keyword Kneeling and get an array list of chairs of type Kneeling.
	 * 	If this test method does not get the value that is expected then it will not pass the J unit 4 test.
	 */
	public void testDataBaseConstructorGetChairs0TypeKneeling() {
		Database data = new Database(DBURL, Username, Password); 
		data.initializeConnection();
		
		//Here we are going to create an array of what expected chair Id's are going to be for the type Task
		String [] Kneeling = {
				"C1320",
				"C3819"
		};
		
		//Retrieve list of chairs of type task, convert it to an array.
		ArrayList<Chair> kneeling = data.getChairs("Kneeling");
		String [] tmpArray = getArrayChairId(kneeling);
		
		//Checking that getChairs is actually working for type task
		assertTrue("Method getChairs(String type) doesn't handle getting type Kneeling from the listed chairs.", Arrays.equals(Kneeling, tmpArray));
	}
	
	@Test
	/**	This method will test the getChairs method and make sure that it can accept the keyword Executive and get an array list of chairs of type Executive.
	 * 	If this test method does not get the value that is expected then it will not pass the J unit 4 test.
	 */
	public void testDataBaseConstructorGetChairs0TypeExecutive() {
		Database data = new Database(DBURL, Username, Password); 
		data.initializeConnection();
		
		//Here we are going to create an array of what expected chair Id's are going to be for the type Task
		String [] Executive = {
				"C2483",
				"C5784",
				"C7268"
		};
		
		//Retrieve list of chairs of type task, convert it to an array.
		ArrayList<Chair> executive = data.getChairs("Executive");
		String [] tmpArray = getArrayChairId(executive);
		
		//Checking that getChairs is actually working for type task
		assertTrue("Method getChairs(String type) doesn't handle getting type Executive from the listed chairs.", Arrays.equals(Executive, tmpArray));
	}
	
	@Test
	/**	This method will test the getChairs method and make sure that it can accept the keyword Ergonomic and get an array list of chairs of type Ergonomic.
	 * 	If this test method does not get the value that is expected then it will not pass the J unit 4 test.
	 */
	public void testDataBaseConstructorGetChairs0TypeErgonomic() {
		Database data = new Database(DBURL, Username, Password); 
		data.initializeConnection();
		
		//Here we are going to create an array of what expected chair Id's are going to be for the type Task
		String [] Ergonomic = {
				"C4839",
				"C5409",
				"C5789"
		};
		
		//Retrieve list of chairs of type task, convert it to an array.
		ArrayList<Chair> ergonomic = data.getChairs("Ergonomic");
		String [] tmpArray = getArrayChairId(ergonomic);
		
		//Checking that getChairs is actually working for type task
		assertTrue("Method getChairs(String type) doesn't handle getting type Ergonomic from the listed chairs.", Arrays.equals(Ergonomic, tmpArray));
	}
	
	
	
	@Test
	/**	This method will test the getDesks method and make sure that it can accept the keyword Traditional and get an array list of desks of type Traditional.
	 * 	If this test method does not get the value that is expected then it will not pass the J unit4 test.
	 */
	public void testDataBaseConstructorGetDesks0TypeTraditional() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		//These are the expected outputs
		String [] Traditional = {
			"D0890",
			"D4231",
			"D8675",
			"D9352"
		};

		
		//Retrieve list of desks of type Traditional
		ArrayList<Desk> traditional = data.getDesks("Traditional");
		String [] tmpArray = getArrayDeskId(traditional);
		
		//Checking whether getDesks method is actually working
		assertTrue("Method getDesks(String type) doesn't handle getting type Traditional from listed desks.", Arrays.equals(Traditional, tmpArray));
		
	}
	
	@Test
	/**	This method will test the getDesks method and make sure that it can accept the keyword Adjustable and get an array list of desks of type Adjustable. 
	 * 	If this test method does not get the value that is expected then it will not pass the J unit 4 test.
	 */
	public void testDataBaseConstructorGetDesks0TypeAdjustable() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		//These are the expected outputs
		String [] Adjustable = {
				"D1030",
				"D2746",
				"D3682",
				"D4475",
				"D5437",
				"D7373"
		};
	
		//Retrieve list of desks of type Traditional
		ArrayList<Desk> adjustable = data.getDesks("Adjustable");
		String [] tmpArray = getArrayDeskId(adjustable);
		
		//Checking whether getDesks method is actually working
		assertTrue("Method getDesks(String type) doesn't handle getting type Adjustable from listed desks.", Arrays.equals(Adjustable, tmpArray));	
	}
	
	@Test
	/** This method will test the getDesks method and make sure that it can accept the keyword Adjustable and get an array list of desks of type Standing. 
	 * 	If this test method does not get the value that is expected then it will not pass the J unit 4 test.
	 */
	public void testDataBaseConstructorGetDesks0TypeStanding() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		//These are the expected outputs
		String [] Standing = {
				"D1927",
				"D2341",
				"D3820",
				"D4438",
				"D9387"
		};		
	
		//Retrieve list of desks of type Traditional
		ArrayList<Desk> standing = data.getDesks("Standing");
		String [] tmpArray = getArrayDeskId(standing);
		
		//Checking whether getDesks method is actually working
		assertTrue("Method getDesks(String type) doesn't handle getting type Standing from listed desks.", Arrays.equals(Standing, tmpArray));	
	}
	
	
	@Test
	/** This method will test the getFilings method and make sure that it can accept the keyword Small and get an array list of filings of type Small.
	 * 	If this test method does not get the value that is expected then it will not pass the J unit 4 test.
	 */
	public void testDataBaseConstructorGetFilings0TypeSmall() {
		
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
		
		ArrayList<Filing> small  = data.getFilings("Small");
		String [] tmpArray = getArrayFilingId(small);
		
		assertTrue("Method getFiling(String type) doesn't handle getting type Small.", Arrays.equals(Small, tmpArray));
	}
	
	@Test
	/** This method will test the getFilings method and make sure that it can accept the keyword Medium and get an array list of filing of type Medium.
	 * 	If this test method does not get the value that is expected then it will not pass the J unit 4 test.
	 */
	public void testDataBaseConstructorGetFilings0TypeMedium() {
		
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		//These are the expected outputs
		String [] Medium = {
				"F002",
				"F007",
				"F008",
				"F009",
				"F014"
		};
		
		ArrayList<Filing> medium  = data.getFilings("Medium");
		String [] tmpArray = getArrayFilingId(medium);
		
		assertTrue("Method getFiling(String type) doesn't handle getting type Medium.", Arrays.equals(Medium, tmpArray));
	}
	
	@Test
	/**	This method will test the getFilings method and make sure that it can accept the keyword Large and get an array list of filing of type Large.
	 * 	If this test method does not get the value that is expected then it will not pass the J unit 4 test.
	 */
	public void testDataBaseConstructorGetFilings0TypeLarge() {
		
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		//These are the expected outputs
		String [] Large = {
				"F003",
				"F010",
				"F011",
				"F012",
				"F015"
		};
		
		ArrayList<Filing> large = data.getFilings("Large");
		String [] tmpArray = getArrayFilingId(large);
		
		assertTrue("Method getFiling(String type) doesn't handle getting type Large.", Arrays.equals(Large, tmpArray));
	}
	
	@Test
	/**	This method will test the getLamps method and make sure that it can accept the keyword Desk and get an array list of Lamp of type Desk.
	 * 	If this test method does not get the value that is expected then it will not pass the J unit 4 test.
	 */
	public void testDataBaseConstructorGetLamps0TypeDesk() {
		
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

		
		ArrayList<Lamp> Lamp  = data.getLamps("Desk");
		String [] tmpArray = getArrayLampId(Lamp);
		
		assertTrue("Method getLamps(String type) doesn't handle getting type Desk.", Arrays.equals(Desk, tmpArray));
	}
	
	@Test
	/** This method will test the getLamps method and make sure that it can accept the keywords Swing Arm and get an array list of Lamp of type Swing Arm.
	 *  If this test method does not get the value that is expected then it will not pass the J unit 4 test.
	 */
	public void testDataBaseConstructorGetLamps0TypeSwingArm() {
		
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		//These are expected outputs
		String [] SwingArm = {
				"L053",
				"L096",
				"L487",
				"L879"
			};

		
		ArrayList<Lamp> swingArm  = data.getLamps("Swing Arm");
		String [] tmpArray = getArrayLampId(swingArm);
		
		assertTrue("Method getLamps(String type) doesn't handle getting type Swing Arm.", Arrays.equals(SwingArm, tmpArray));
	}
	
	@Test
	/**	This method will test the getLamps method and make sure that it can accept the keyword Study and get an array list of type Study.
	 * 	If this test method does not get the value that is expected then it will not pass the J unit 4 test.
	 */
	public void testDataBaseConstructorGetLamps0TypeStudy() {
		
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();

		String [] Study = {
				"L223",
				"L928",
				"L980",
				"L982",
			};

		
		ArrayList<Lamp> study = data.getLamps("Study");
		String [] tmpArray = getArrayLampId(study);
		
		assertTrue("Method getLamps(String type) doesn't handle getting type Study.", Arrays.equals(Study, tmpArray));
	}
	
	
	@Test
	/** This method will test the getManufacturer method which will get a array list of Manufacturers.
	 * 	If this test method does not get the value that is expected then it will not pass the J unit 4 test.
	 */
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
	/**
	 * This method will test the deleteChair method which will delete a specific chair of type Task from the database. 
	 * If the delete is successful, it will then insert the chair that we deleted. If not we will not insert the new chair.
	 * If this test method does not get the value that is expected then it will not pass the J unit 4 test.
	 * @throws SQLException when the following data that was deleted can not be inserted.
	 */
	public void testDataBaseConstructorDeleteChair0TypeTask() throws SQLException {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		data.deleteChair("C3405");

		String [] Task = {
				"C0914",
				"C1148"
		};
		
		ArrayList<Chair> chair = data.getChairs("Task");
		String [] tmpArray = getArrayChairId(chair);
		if(Arrays.equals(Task, tmpArray)) {
			insertNewChair("C3405", "Task", "Y", "Y", "N", "N", 100, "003");
		}
		else {
			assertTrue("Method deleteChair(String type) doesn't handle deleting Task", Arrays.equals(Task, tmpArray));
		}
		
	}
	
	@Test
	/**
	 * This method will test the deleteChair method which will delete a specific chair of type Mesh from the database. 
	 * If the delete is successful, it will then insert the chair that we deleted. If not we will not insert the new chair.
	 * If this test method does not get the value that is expected then it will not pass the J unit 4 test.
	 * @throws SQLException when the following data that was deleted can not be inserted.
	 */
	public void testDataBaseConstructorDeleteChair0TypeMesh() throws SQLException {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		data.deleteChair("C9890");

		String [] Mesh = {
				"C0942",
				"C6748",
				"C8138",
		};
		
		ArrayList<Chair> chair = data.getChairs("Mesh");
		String [] tmpArray = getArrayChairId(chair);
		if(Arrays.equals(Mesh, tmpArray)) {
			insertNewChair("C9890", "Mesh", "N", "Y", "N", "Y", 50, "003");
		}
		else {
			assertTrue("Method deleteChair(String type) doesn't handle deleting Mesh", Arrays.equals(Mesh, tmpArray));
		}
		
	}
	
	@Test
	/**
	 * This method will test the deleteChair method which will delete a specific chair of type Kneeling from the database. 
	 * If the delete is successful, it will then insert the chair that we deleted. If not we will not insert the new chair.
	 * If this test method does not get the value that is expected then it will not pass the J unit 4 test.
	 * @throws SQLException when the following data that was deleted can not be inserted.
	 */
	public void testDataBaseConstructorDeleteChair0TypeKneeling() throws SQLException {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		data.deleteChair("C1320");
	
		String [] Kneeling = {
				"C3819"
		};
		
		ArrayList<Chair> chair = data.getChairs("Kneeling");
		String [] tmpArray = getArrayChairId(chair);
		if(Arrays.equals(Kneeling, tmpArray)) {
			insertNewChair("C1320", "Kneeling", "Y", "N", "N", "N", 50, "002");
		}
		else {
			assertTrue("Method deleteChair(String type) doesn't handle deleting Kneeling chairs", Arrays.equals(Kneeling, tmpArray));
		}
		
	}
	
	
	@Test
	/**
	 * This method will test the deleteChair method which will delete a specific chair of type Executive from the database. 
	 * If the delete is successful, it will then insert the chair that we deleted. If not we will not insert the new chair.
	 * If this test method does not get the value that is expected then it will not pass the J unit 4 test.
	 * @throws SQLException when the following data that was deleted can not be inserted.
	 */
	public void testDataBaseConstructorDeleteChair0TypeExecutive() throws SQLException {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		data.deleteChair("C2483");
		
		String [] Executive = {
				"C5784",
				"C7268"
		};
		
		ArrayList<Chair> chair = data.getChairs("Executive");
		String [] tmpArray = getArrayChairId(chair);
		if(Arrays.equals(Executive, tmpArray)) {
			insertNewChair("C2483", "Executive", "Y", "Y", "N", "N", 175, "002");
		}
		else {
			assertTrue("Method deleteChair(String type) doesn't handle deleting Executive chairs.", Arrays.equals(Executive, tmpArray));
		}
		
	}
	
	@Test
	/**
	 * This method will test the deleteChair method which will delete a specific chair of type Ergonomic from the database. 
	 * If the delete is successful, it will then insert the chair that we deleted. If not we will not insert the new chair.
	 * If this test method does not get the value that is expected then it will not pass the J unit 4 test.
	 * @throws SQLException when the following data that was deleted can not be inserted.
	 */
	public void testDataBaseConstructorDeleteChair0TypeErgonomic() throws SQLException {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		data.deleteChair("C5409");

		String [] Ergonomic = {
				"C4839",
				"C5789"
		};
		
		ArrayList<Chair> chair = data.getChairs("Ergonomic");
		String [] tmpArray = getArrayChairId(chair);
		if(Arrays.equals(Ergonomic, tmpArray)) {
			insertNewChair("C5409", "Ergonomic", "Y", "Y", "Y", "N", 200, "003");
		}
		else {
			assertTrue("Method deleteChair(String type) doesn't handle deleting Kneeling chairs.", Arrays.equals(Ergonomic, tmpArray));
		}
		
	}
	

	@Test
	/**
	 * This method will test the deleteDesk method which will delete a specific desk of type Adjustable from the database. 
	 * If the delete is successful, it will then insert the desk that we deleted. If not we will not insert the new desk.
	 * If this test method does not get the value that is expected then it will not pass the J unit 4 test.
	 * @throws SQLException when the following data that was deleted can not be inserted.
	 */
	public void testDataBaseConstructorDeleteDesk0TypeAdjustable() throws SQLException {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		data.deleteDesk("D2746");

		String [] Adjustable = {
				"D1030",
				"D3682",
				"D4475",
				"D5437",
				"D7373"	
		};
		
		ArrayList<Desk> desk = data.getDesks("Adjustable");
		String [] tmpArray = getArrayDeskId(desk);
		if(Arrays.equals(Adjustable, tmpArray)) {
			insertNewDesk("D2746", "Adjustable", "Y", "N", "Y", 250, "004");
		}
		else {
			assertTrue("Method deleteDesk(String type) doesn't handle deleting Adjustable Desks", Arrays.equals(Adjustable, tmpArray));
		}
		
	}
	
	@Test
	/**
	 * This method will test the deleteDesk method which will delete a specific desk of type Traditional from the database. 
	 * If the delete is successful, it will then insert the desk that we deleted. If not we will not insert the new desk.
	 * If this test method does not get the value that is expected then it will not pass the J unit 4 test.
	 * @throws SQLException when the following data that was deleted can not be inserted.
	 */
	public void testDataBaseConstructorDeleteDesk0TypeTraditional() throws SQLException {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		data.deleteDesk("D8675");
		
		String [] Traditional = {
				"D0890",
				"D4231",
				"D9352"
			};
		
		ArrayList<Desk> desk = data.getDesks("Traditional");
		String [] tmpArray = getArrayDeskId(desk);
		if(Arrays.equals(Traditional, tmpArray)) {
			insertNewDesk("D8675", "Traditional", "Y", "Y", "N", 75, "001");
		}
		else {
			assertTrue("Method deleteDesk(String type) doesn't handle deleting Traditional Desks", Arrays.equals(Traditional, tmpArray));
		}
		
	}
	
	@Test
	/**
	 * This method will test the deleteDesk method which will delete a specific desk of type Standing from the database. 
	 * If the delete is successful, it will then insert the desk that we deleted. If not we will not insert the new desk.
	 * If this test method does not get the value that is expected then it will not pass the J unit 4 test.
	 * @throws SQLException when the following data that was deleted can not be inserted.
	 */
	public void testDataBaseConstructorDeleteDesk0TypeStanding() throws SQLException {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		data.deleteDesk("D4438");
		

		String [] Standing = {
				"D1927",
				"D2341",
				"D3820",
				"D9387"
		};
		
		ArrayList<Desk> desk = data.getDesks("Standing");
		String [] tmpArray = getArrayDeskId(desk);
		if(Arrays.equals(Standing, tmpArray)) {
			insertNewDesk("D4438", "Standing", "N", "Y", "Y", 150, "004");
		}
		else {
			assertTrue("Method deleteDesk(String type) doesn't handle deleting Standing desks.", Arrays.equals(Standing, tmpArray));
		}
		
	}
	
	
	@Test
	/**
	 * This method will test the deleteFiling method which will delete a specific filing of type Small from the database. 
	 * If the delete is successful, it will then insert the Filing that we deleted. If not we will not insert the new filing.
	 * If this test method does not get the value that is expected then it will not pass the J unit 4 test.
	 * @throws SQLException when the following data that was deleted can not be inserted.
	 */
	public void testDataBaseConstructorDeleteFiling0TypeSmall() throws SQLException {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		data.deleteFiling("F004");

		String [] Small = {
				"F001",
				"F005",
				"F006",
				"F013"
		};
		
		ArrayList<Filing> filing = data.getFilings("Small");
		String [] tmpArray = getArrayFilingId(filing);
		if(Arrays.equals(Small, tmpArray)) {
			insertNewFiling("F004", "Small", "N", "Y", "Y", 75, "004");
		}
		else {
			assertTrue("Method deleteFiling(String type) doesn't handle Small filing type.", Arrays.equals(Small, tmpArray));
		}
	}
	
	@Test
	/**
	 * This method will test the deleteFiling method which will delete a specific filing of type Medium from the database. 
	 * If the delete is successful, it will then insert the Filing that we deleted. If not we will not insert the new filing.
	 * If this test method does not get the value that is expected then it will not pass the J unit 4 test.
	 * @throws SQLException when the following data that was deleted can not be inserted.
	 */
	public void testDataBaseConstructorDeleteFiling0TypeMedium() throws SQLException {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		data.deleteFiling("F008");

		String [] Medium = {
				"F002",
				"F007",
				"F009",
				"F014",
		};
		
		ArrayList<Filing> filing = data.getFilings("Medium");
		String [] tmpArray = getArrayFilingId(filing);
		if(Arrays.equals(Medium, tmpArray)) {
			insertNewFiling("F008", "Medium", "Y", "N", "N", 50, "005");
		}
		else {
			assertTrue("Method deleteFiling(String type) doesn't handle deleting Medium filing type.", Arrays.equals(Medium, tmpArray));
		}
	}
	
	@Test
	/**
	 * This method will test the deleteFiling method which will delete a specific filing of type Large from the database. 
	 * If the delete is successful, it will then insert the Filing that we deleted. If not we will not insert the new filing.
	 * If this test method does not get the value that is expected then it will not pass the J unit 4 test.
	 * @throws SQLException when the following data that was deleted can not be inserted.
	 */
	public void testDataBaseConstructorDeleteFiling0TypeLarge() throws SQLException {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		data.deleteFiling("F010");
		
		String [] Large = {
			"F003",
			"F011",
			"F012",
			"F015"
		};
		
		ArrayList<Filing> filing = data.getFilings("Large");
		String [] tmpArray = getArrayFilingId(filing);
		if(Arrays.equals(Large, tmpArray)) {
			insertNewFiling("F010", "Large", "Y", "N", "Y", 225, "002");
		}
		else {
			assertTrue("Method deleteFiling(String type) doesn't handle Large filing type.", Arrays.equals(Large, tmpArray));
		}
	}
	
	@Test
	/**
	 * This method will test the deleteLamp method which will delete a specific lamp of type Desk from the database. 
	 * If the delete is successful, it will then insert the lamp that we deleted. If not we will not insert the new lamp.
	 * If this test method does not get the value that is expected then it will not pass the J unit 4 test.
	 * @throws SQLException when the following data that was deleted can not be inserted.
	 */
	public void testDataBaseConstructorDeleteLamp0TypeDesk() throws SQLException {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		data.deleteLamp("L342");
		
		String [] Desk = {
				"L013",
				"L112",
				"L132",
				"L208",
				"L564",
				"L649"
			};
		ArrayList<Lamp> lamps = data.getLamps("Desk");
		String [] tmpArray = getArrayLampId(lamps);
		if(Arrays.equals(Desk, tmpArray)) {
			insertNewLamp("L342", "Desk", "N", "Y", 2, "002");
		}
		else {
			assertTrue("Method deleteLamp(String type) doesn't handle deleting Lamp type Desk.", Arrays.equals(Desk, tmpArray));
		}
	}
	
	@Test
	/**
	 * This method will test the deleteLamp method which will delete a specific lamp of type Swing Arm from the database. 
	 * If the delete is successful, it will then insert the lamp that we deleted. If not we will not insert the new lamp.
	 * If this test method does not get the value that is expected then it will not pass the J unit 4 test.
	 * @throws SQLException when the following data that was deleted can not be inserted.
	 */
	public void testDataBaseConstructorDeleteLamp0TypeSwingArm() throws SQLException {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		data.deleteLamp("L053");
		
		String [] SwingArm = {
			"L096",
			"L487",
			"L879"
		};
		ArrayList<Lamp> lamps = data.getLamps("Swing Arm");
		String [] tmpArray = getArrayLampId(lamps);
		if(Arrays.equals(SwingArm, tmpArray)) {
			insertNewLamp("L053", "Swing Arm", "Y", "N", 27, "002");
		}
		else {
			assertTrue("Method deleteLamp(String type) doesn't handle deleting Lamp type Swing Arm.", Arrays.equals(SwingArm, tmpArray));
		}
	}
	
	
	@Test
	/**
	 * This method will test the deleteLamp method which will delete a specific lamp of type Study from the database. 
	 * If the delete is successful, it will then insert the lamp that we deleted. If not we will not insert the new lamp.
	 * If this test method does not get the value that is expected then it will not pass the J unit 4 test.
	 * @throws SQLException when the following data that was deleted can not be inserted.
	 */
	public void testDataBaseConstructorDeleteLamp0TypeStudy() throws SQLException {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		data.deleteLamp("L982");
		
		//Expected lamp outputs for executives is called.
		String [] Study = {
				"L223",
				"L928",
				"L980",
		};
		
		ArrayList<Lamp> lamps = data.getLamps("Study");
		String [] tmpArray = getArrayLampId(lamps);
		if(Arrays.equals(Study, tmpArray)) {
			insertNewLamp("L982", "Study", "Y", "N", 8, "002");
		}
		else {
			assertTrue("Method deleteLamp(String type) doesn't handle deleting Lamp type Study.", Arrays.equals(Study, tmpArray));
		}
	}
	
	@Test
	/**
	 * 	This method will test the constructor for the object of Chair. It will check whether the values 
	 * 	have been successfully placed into the constructor.
	 */
	public void testChairConstructor() {
		String ID = "C005";
		String type = "Executive";
		int price = 20;
		String manuID = "003";
		
		Chair testChair = new Chair("C005","Executive",'Y','N','N','N',20,"003");
		
		assertTrue("Constructor for chair does not handle creating the chair properly. ID is not correct.", testChair.getID().equals(ID));
		assertTrue("Constructor for chair does not handle creating the chair properly. type is not correct.", testChair.getType().equals(type));
		assertTrue("Constructor for chair does not handle creating the chair properly. legs is not correct.", testChair.getLegs() == true);
		assertTrue("Constructor for chair does not handle creating the chair properly. arms is not correct.", testChair.getArms() == false);
		assertTrue("Constructor for chair does not handle creating the chair properly. seat is not correct.", testChair.getSeat() == false);
		assertTrue("Constructor for chair does not handle creating the chair properly. cushion is not correct.", testChair.getCushion() == false);
		assertTrue("Constructor for chair does not handle creating the chair properly. price is not correct.", testChair.getPrice() == price);
		assertTrue("Constructor for chair does not handle creating the chair properly. manuID is not correct.", testChair.getManuId().equals(manuID));
	}
	
	@Test
	/**
	 * This method will test the constructor for the object of Desk. It will check whether the values
	 * have been successfully places into the constructor.
	 */
	
	public void testDeskConstructor() {
		String ID = "C0004";
		String type = "Traditional";
		int price = 20;
		String manuID = "003";
		
		Desk testDesk = new Desk("C0004", "Traditional", 'Y', 'N', 'N', 20, "003");
		
		assertTrue("Constructor for Desk does not handle creating the Desk properly. ID is not correct.", testDesk.getID().equals(ID));
		assertTrue("Constructor for Desk does not handle creating the Desk properly. type is not correct.", testDesk.getType().equals(type));
		assertTrue("Constructor for Desk does not handle creating the Desk properly. legs is not correct.", testDesk.getLegs() == true);
		assertTrue("Constructor for Desk does not handle creating the Desk properly. top is not correct.", testDesk.getTop() == false);
		assertTrue("Constructor for Desk does not handle creating the Desk properly. Drawer is not correct.", testDesk.getDrawer() == false);
		assertTrue("Constructor for Desk does not handle creating the Desk properly. Price is not correct.", testDesk.getPrice() == price);
		assertTrue("Constructor for Desk does not handle creating the Desk properly. manuID is not correct.", testDesk.getManuID().equals(manuID));
		
	}
	
	@Test
	/**
	 * This method will test the constructor for the object of Filing. It will check whether the values
	 * have been successfully placed into the constructor.
	 */
	
	public void testFilingConstructor() {
		String ID = "Hi Dylan";
		String type = "Small";
		int price = 540;
		String manuID = "005";
		
		Filing testFiling = new Filing("Hi Dylan", "Small", 'Y', 'N', 'N', 540, "005");
		assertTrue("Constructor for Filing does not handle creating the Filing properly. ID is not correct.", testFiling.getID().equals(ID));
		assertTrue("Constructor for Filing does not handle creating the Filing properly. type is not correct.", testFiling.getType().equals(type));
		assertTrue("Constructor for Filing does not handle creating the Filing properly. rails is not correct.", testFiling.getRails() == true);
		assertTrue("Constructor for Filing does not handle creating the Filing properly. drawers is not correct.", testFiling.getDrawers() == false);
		assertTrue("Constructor for Filing does not handle creating the Filing properly. cabinet is not correct.", testFiling.getCabinet() == false);
		assertTrue("Constructor for Filing does not handle creating the Filing properly. price is not correct.", testFiling.getPrice() == price);
		assertTrue("Constructor for Filing does not handle creating the Filing properly. manuID is not correct.", testFiling.getManuID().equals(manuID));
	}
	
	@Test
	/**
	 * This method will test constructor for the object of Lamp. It will check whether the values
	 * have been successfully placed into the constructor.
	 */
	public void testLampConstructor() {
		String ID = "Hi Alex";
		String type = "Study";
		int price = 69;
		String manuID = "008";
		
		Lamp testLamp = new Lamp("Hi Alex","Study",'Y','N', 69, "008");
		assertTrue("Constructor for Lamp does not handle creating the Lamp properly. ID is not correct.", testLamp.getID().equals(ID));
		assertTrue("Constructor for Lamp does not handle creating the Lamp properly. type is not correct.", testLamp.getType().equals(type));
		assertTrue("Constructor for Lamp does not handle creating the Lamp properly. base is not correct.", testLamp.getBase() == true);
		assertTrue("Constructor for Lamp does not handle creating the Lamp properly. bulb is not correct.", testLamp.getBulb() == false);
		assertTrue("Constructor for Lamp does not handle creating the Lamp properly. price is not correct.", testLamp.getPrice() == price);
		assertTrue("Constructor for Lamp does not handle creating the Lamp properly. manuID is not correct.", testLamp.getManuID() == manuID);
	}
	
	@Test
	/**
	 * This method will test constructor for the object of Manufacturer. It will check whether the values
	 * have been successfully placed into the constructor.
	 */
	public void testManufacturerConstructor() {
		String manuID = "12394";
		String name = "BigStuffClub";
		String phone = "4200 4200 4200";
		String province = "Nunavut";
		
		Manufacturer manu = new Manufacturer("12394", "BigStuffClub", "4200 4200 4200", "Nunavut");
		assertTrue("Constructor for Manufacturer does not handle creating the Manufacturer properly. ID is not correct.", manu.getManuID().equals(manuID));
		assertTrue("Constructor for Manufacturer does not handle creating the Manufacturer properly. name is not correct.", manu.getName().equals(name));
		assertTrue("Constructor for Manufacturer does not handle creating the Manufacturer properly. phone is not correct.", manu.getPhone().equals(phone));
		assertTrue("Constructor for Manufacturer does not handle creating the Manufacturer properly. Nunavut is not correct.", manu.getProvince().equals(province));
	}
	

	@Test
	/**
	 * 	This method will test sort method on the chair type task and must give the cheapest output combination.
	 */
	public void testSortChairTypeTask() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		//Expected output
		String [] Task ={
			"C0914",
			"C3405",
			"150"
		};
		
		ArrayList<Chair> chair = data.getChairs("Task");

		Sort sort = new Sort();
		sort.powerSetChair(chair);
		
		assertTrue("This has not preformed sort correctly for type Task from chair.", Arrays.equals(Task, sort.sort("chair", 1)));	
	}
	
	@Test
	/**
	 * 	This method will test sort method on the chair type task and must give the cheapest output combination for multiple chairs.
	 */
	public void testSortChairTypeTaskMulti() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		//Expected output
		String [] Task ={
			"impossible"
		};
		
		ArrayList<Chair> chair = data.getChairs("Task");

		Sort sort = new Sort();
		sort.powerSetChair(chair);
		
		assertTrue("This has not preformed sort correctly for type Task from chair for multi.", Arrays.equals(Task, sort.sort("chair", 2)));	
	}
	
	@Rule public ExpectedException exceptionRule = ExpectedException.none();
	@Test
	/**
	 * This method will handle exception handling for order chair type task.
	 */
	public void testSortChairTypeTaskException() {
		Order order = new Order("chair", "Task", 0);
		exceptionRule.expect(IllegalArgumentException.class);
	}
	
	
	
	@Test
	/**
	 * This method will test sort method on the chair type Mesh and must give the cheapest output combination.
	 */
	public void testSortChairTypeMesh() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		//Expected output
		String [] Mesh ={
			"C0942",
			"C9890",
			"150"
		};
		
		ArrayList<Chair> chair = data.getChairs("Mesh");

		Sort sort = new Sort();
		sort.powerSetChair(chair);
		
		assertTrue("This has not preformed sort correctly for type Mesh from chair.", Arrays.equals(Mesh, sort.sort("chair", 1)));	
	}
	
	@Test
	/**
	 * This method will handle exception handling for sort chair type mesh.
	 */
	public void testSortChairTypeMeshException() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		ArrayList<Chair> chair = data.getChairs("Mesh");
		Sort sort = new Sort();
		sort.powerSetChair(chair);
		exceptionRule.expect(IllegalArgumentException.class);
		sort.sort("chair", 0);
		
	}
	
	@Test
	/**
	 * This method will test sort method on the chair type Mesh and must give the cheapest output combination for multiple chairs.
	 */
	public void testSortChairTypeMeshMulti() {
		Order order = new Order("chair", "Mesh", 0);
		exceptionRule.expect(IllegalArgumentException.class);	
	}
	
	
	@Test
	/**
	 * This method will test sort method on the chair type Kneeling and must give the cheapest output combination.
	 */
	public void testSortChairTypeKneeling() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		//Expected output
		String [] Kneeling ={
			"impossible"
		};
		
		ArrayList<Chair> chair = data.getChairs("Kneeling");

		Sort sort = new Sort();
		sort.powerSetChair(chair);
		
		assertTrue("This has not preformed sort correctly for type Kneeling from chair.", Arrays.equals(Kneeling, sort.sort("chair", 1)));	
	}
	@Test
	/**
	 * This method will test sort method on the chair type Kneeling and must give the cheapest output combination for multiple chairs.
	 */
	public void testSortChairTypeKneelingMulti() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		//Expected output
		String [] Kneeling ={
			"impossible"
		};
		
		ArrayList<Chair> chair = data.getChairs("Kneeling");

		Sort sort = new Sort();
		sort.powerSetChair(chair);
		
		assertTrue("This has not preformed sort correctly for type Kneeling from chair.", Arrays.equals(Kneeling, sort.sort("chair", 3)));	
	}
	@Test
	/**
	 * 	This method will handle exception for sort chair type kneeling.
	 */
	public void testSortChairTypeKneelingException() {
		Order order = new Order("chair", "Kneeling", 0);
		exceptionRule.expect(IllegalArgumentException.class);
	}
	
	@Test
	/**
	 * This method will test sort method on the chair type Executive and must give the cheapest output combination.
	 */
	public void testSortChairTypeExecutive() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		//Expected output
		String [] Executive ={
			"C2483",
			"C5784",
			"C7268",
			"400"
		};
		
		ArrayList<Chair> chair = data.getChairs("Executive");

		Sort sort = new Sort();
		sort.powerSetChair(chair);
		
		assertTrue("This has not preformed sort correctly for type Executive from chair.", Arrays.equals(Executive, sort.sort("chair", 1)));	
	}
	
	@Test
	/**
	 * This method will test sort method on the chair type Executive and must give the cheapest output combination for multiple chairs.
	 */
	public void testSortChairTypeExecutiveMulti() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		//Expected output
		String [] Executive ={
				"impossible"
		};
		
		ArrayList<Chair> chair = data.getChairs("Executive");

		Sort sort = new Sort();
		sort.powerSetChair(chair);
		
		assertTrue("This has not preformed sort correctly for type Executive from chair.", Arrays.equals(Executive, sort.sort("chair", 2)));	
	}
	@Test
	/**
	 * This method will test whether the sort method will throw an illegal argument exception when chair with type executive is passed.
	 */
	public void testSortChairTypeExecutiveException() {
		Order order = new Order("chair", "Executive", 0);
		exceptionRule.expect(IllegalArgumentException.class);
	}
	@Test
	/**
	 * This method will test sort method on the chair type Ergonomic and must give the cheapest output combination.
	 */
	public void testSortChairTypeErgonomic() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		//Expected output
		String [] Ergonomic ={
			"C4839",
			"C5409",
			"250"
		};
		
		ArrayList<Chair> chair = data.getChairs("Ergonomic");

		Sort sort = new Sort();
		sort.powerSetChair(chair);
		
		assertTrue("This has not preformed sort correctly for type Ergonomic from chair.", Arrays.equals(Ergonomic, sort.sort("chair", 1)));
	}
	
	@Test
	/**
	 * This method will test sort method on the chair type Ergonomic and must give the cheapest output combination of multiple chairs.
	 */
	public void testSortChairTypeErgonomicMulti() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		//Expected output
		String [] Ergonomic ={
				"impossible"
		};
		
		ArrayList<Chair> chair = data.getChairs("Ergonomic");

		Sort sort = new Sort();
		sort.powerSetChair(chair);
		
		assertTrue("This has not preformed sort correctly for type Ergonomic from chair.", Arrays.equals(Ergonomic, sort.sort("chair", 3)));
	}
	
	@Test
	/**
	 * This method will test whether the sort method will throw and Illegal argument exception when chair type ergonomic is passed.
	 */
	public void testSortChairTypeErgonomicException() {
		Order order = new Order("chair", "Ergonomic", 0);
		exceptionRule.expect(IllegalArgumentException.class);
	}
	
	@Test
	/**
	 * This method will test sort method on the desk type Traditional and must give the cheapest output combination.
	 */
	public void testSortDeskTypeTraditional() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		//Expected output
		String [] Traditional = {
			"D0890",
			"D8675",
			"100"
		};
		ArrayList<Desk> desk = data.getDesks("Traditional");
		
		Sort sort = new Sort();
		sort.powerSetDesk(desk);
		
		assertTrue("This has not preformed sort correctly for type Traditional from desk.", Arrays.equals(Traditional, sort.sort("desk", 1)));
		
	}
	
	@Test
	/**
	 * This method will test sort method on the desk type Traditional and must give the cheapest output combination for multiple desks.
	 */
	public void testSortDeskTypeTraditionalMulti() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		//Expected output
		String [] Traditional = {
				"D4231",
				"D8675",
				"D9352",
				"200"
		};
		ArrayList<Desk> desk = data.getDesks("Traditional");
		
		Sort sort = new Sort();
		sort.powerSetDesk(desk);
		
		assertTrue("This has not preformed sort correctly for type Traditional from desk.", Arrays.equals(Traditional, sort.sort("desk", 2)));
		
	}
	
	@Test
	/**
	 * This method will test the sort methods illegal argument exception for desk type traditional.
	 */
	public void testSortDeskTypeTraditionalException() {
		Order order = new Order("desk", "Traditional", 0);
		exceptionRule.expect(IllegalArgumentException.class);
	}
	
	@Test
	/**
	 * This method will test sort method on the desk type Adjustable and must give the cheapest output combination.
	 */
	public void testSortDeskTypeAdjustable() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		//Expected output
		String [] Adjustable = {
			"D1030",
			"D3682",
			"D5437",
			"250"
		};
		ArrayList<Desk> desk = data.getDesks("Adjustable");
		
		Sort sort = new Sort();
		sort.powerSetDesk(desk);
		
		assertTrue("This has not preformed sort correctly for type Adjustable from desk.", Arrays.equals(Adjustable, sort.sort("desk", 1)));
		
	}
	
	@Test
	/**
	 * This method will test sort method on the desk type Adjustable and must give the cheapest output combination for multiple desks.
	 */
	public void testSortDeskTypeAdjustableMulti() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		//Expected output
		String [] Adjustable = {
			"D1030",
			"D2746",
			"D3682",
			"D4475",
			"D5437",
			"D7373",
			"1050"
		};
		ArrayList<Desk> desk = data.getDesks("Adjustable");
		
		Sort sort = new Sort();
		sort.powerSetDesk(desk);
		
		assertTrue("This has not preformed sort correctly for type Adjustable from desk.", Arrays.equals(Adjustable, sort.sort("desk", 3)));
		
	}
	
	@Test
	/**
	 *  This method will test desk illegal argument exception type adjustable.
	 */
	public void testSortDeskTypeAdjustableException() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		ArrayList<Desk> desk = data.getDesks("Adjustable");
		Sort sort = new Sort();
		sort.powerSetDesk(desk);
		exceptionRule.expect(IllegalArgumentException.class);
		sort.sort("desk", 0);
		
	}
	
	@Test
	/**
	 * This method will test sort method on the desk type Standing and must give the cheapest output combination.
	 */
	public void testSortDeskTypeStanding() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		String [] Standing = {
			"D1927",
			"D2341",
			"300"
		};
		ArrayList<Desk> desk = data.getDesks("Standing");
		Sort sort = new Sort();

		sort.powerSetDesk(desk);
		
		assertTrue("This has not preformed sort correctly for type Standing from desk.", Arrays.equals(Standing, sort.sort("desk", 1)));
	}
	
	@Test
	/**
	 * This method will test sort method on the desk type Standing and must give the cheapest output combination.
	 */
	public void testSortDeskTypeStandingMulti() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		String [] Standing = {
			"impossible"
		};
		ArrayList<Desk> desk = data.getDesks("Standing");
		Sort sort = new Sort();

		sort.powerSetDesk(desk);
		
		assertTrue("This has not preformed sort correctly for type Standing from desk.", Arrays.equals(Standing, sort.sort("desk", 3)));
	}
	
	@Test
	/**
	 * This will test desk type standing for illegal argument exception in sort.
	 */
	public void testSortDeskTypeStandingException() {
		Order order = new Order("desk", "Standing", 0);
		exceptionRule.expect(IllegalArgumentException.class);
		
	}
	
	@Test
	/**
	 * This method will test sort method on the filing type Small and must give the cheapest output combination.
	 */
	public void testSortFilingTypeSmall() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		String [] Small = {
			"F001",
			"F013",
			"100"
		};
		ArrayList<Filing> filing = data.getFilings("Small");
		
		Sort sort = new Sort();
		sort.powerSetFiling(filing);
		
		assertTrue("This has not preformed sort correctly for type Small from filing.", Arrays.equals(Small, sort.sort("filing", 1)));		
	}
	
	@Test
	/**
	 * This method will test sort method on the filing type Small and must give the cheapest output combination for multiple filings.
	 */
	public void testSortFilingTypeSmallMulti() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		String [] Small = {
			"F001",
			"F004",
			"F005",
			"F006",
			"F013",
			"300"
		};
		ArrayList<Filing> filing = data.getFilings("Small");
		
		Sort sort = new Sort();
		sort.powerSetFiling(filing);
		
		assertTrue("This has not preformed sort correctly for type Small from filing.", Arrays.equals(Small, sort.sort("filing", 3)));		
	}
	
	@Test
	/**
	 *  This will test illegal argument exception for filing type small for sort.
	 */
	public void testSortFilingTypeSmallException() {
		Order order = new Order("filing", "Small", 0);
		exceptionRule.expect(IllegalArgumentException.class);
	}
	
	@Test
	/**
	 * This method will test sort method on the filing type Medium and must give the cheapest output combination.
	 */
	public void testSortFilingTypeMedium() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		String [] Medium = {
			"F007",
			"F008",
			"200"
		};
		ArrayList<Filing> filing = data.getFilings("Medium");
		
		Sort sort = new Sort();
		sort.powerSetFiling(filing);
		
		
		assertTrue("This has not preformed sort correctly for type Medium from filing.", Arrays.equals(Medium, sort.sort("filing", 1)));		
	}
	
	@Test
	/**
	 * This method will test sort method on the filing type Medium and must give the cheapest output combination for multiple filings.
	 */
	public void testSortFilingTypeMediumMulti() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		String [] Medium = {
			"F007",
			"F008",
			"F014",
			"400"
		};
		ArrayList<Filing> filing = data.getFilings("Medium");
		
		Sort sort = new Sort();
		sort.powerSetFiling(filing);
		
		
		assertTrue("This has not preformed sort correctly for type Medium from filing.", Arrays.equals(Medium, sort.sort("filing", 2)));		
	}
	
	@Test
	/**
	 * This will test illegal argument exception for filing type Medium in sort.
	 */
	public void testSortFilingTypeMediumException() {
		Order order = new Order("filing", "Medium", 0);
		exceptionRule.expect(IllegalArgumentException.class);
	}
	@Test
	/**
	 * This method will test sort method on the filing type Large and must give the cheapest output combination.
	 */
	public void testSortFilingTypeLarge() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		String [] Large = {
			"F010",
			"F012",
			"300"
		};
		ArrayList<Filing> filing = data.getFilings("Large");
		
		Sort sort = new Sort();
		sort.powerSetFiling(filing);
		
		assertTrue("This has not preformed sort correctly for type Large from filing.", Arrays.equals(Large, sort.sort("filing", 1)));		
	}
	
	@Test
	/**
	 * This method will test sort method on the filing type Large and must give the cheapest output combination for multiple filings.
	 */
	public void testSortFilingTypeLargeMulti() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		String [] Large = {
			"impossible"
		};
		ArrayList<Filing> filing = data.getFilings("Large");
		
		Sort sort = new Sort();
		sort.powerSetFiling(filing);
		
		assertTrue("This has not preformed sort correctly for type Large from filing.", Arrays.equals(Large, sort.sort("filing", 3)));		
	}
	
	@Test
	/**
	 * This method will test sort method on filing type large and throw an illegal argument exception.
	 */
	public void testSortFilingTypeLargeException() {
		Order order = new Order("filing", "Large", 0);
		exceptionRule.expect(IllegalArgumentException.class);
	}
	
	@Test
	/**
	 * This method will test sort method on Lamp type desk and must give the cheapest output combination.
	 */
	public void testSortLampTypeDesk() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		String [] Desk = {
			"L013",
			"L208",
			"20"
		};
		ArrayList<Lamp> lamps = data.getLamps("Desk");
		
		Sort sort = new Sort();
		sort.powerSetLamp(lamps);
		assertTrue("This has not preformed sort correctly for type Desk.", Arrays.equals(Desk, sort.sort("lamp", 1)));
	}
	@Test
	/**
	 * This method will test sort method on Lamp type desk and must give the cheapest output combination for multiple lamps.
	 */
	public void testSortLampTypeDeskMulti() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		String [] Desk = {
			"L013",
			"L112",
			"L208",
			"L342",
			"40"
		};
		ArrayList<Lamp> lamps = data.getLamps("Desk");
		
		Sort sort = new Sort();
		sort.powerSetLamp(lamps);
		assertTrue("This has not preformed sort correctly for type Desk.", Arrays.equals(Desk, sort.sort("lamp", 2)));
	}
	
	@Test
	/**
	 * This method will test exception handling for Lamp type desk for illegal argument exception handling.
	 */
	public void testSortLampTypeDeskException() {
		Order order = new Order("lamp", "Desk", 0);
		exceptionRule.expect(IllegalArgumentException.class);
	}
	
	@Test
	/**
	 * This method will test sort method on Lamp type Swing Arm and must give the cheapest output combination.
	 */
	public void testSortLampTypeSwingArm() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		String [] Desk = {
			"L053",
			"L096",
			"30"
		};
		ArrayList<Lamp> lamps = data.getLamps("Swing Arm");
		
		Sort sort = new Sort();
		sort.powerSetLamp(lamps);
		assertTrue("This has not preformed sort correctly for type Desk.", Arrays.equals(Desk, sort.sort("lamp", 1)));
	}
	
	@Test
	/**
	 * This method will test sort method on Lamp type Swing Arm and must give the cheapest output combination for multiple lamps.
	 */
	public void testSortLampTypeSwingArmMulti() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		String [] Desk = {
			"impossible"
		};
		ArrayList<Lamp> lamps = data.getLamps("Swing Arm");
		
		Sort sort = new Sort();
		sort.powerSetLamp(lamps);
		assertTrue("This has not preformed sort correctly for type Desk.", Arrays.equals(Desk, sort.sort("lamp", 3)));
	}
	@Test
	/**
	 * This method will test exception handling for Lamp type swing arm for illegal argument exception handling.
	 */
	public void testSortLampTypeSwingArmException() {
		Order order = new Order("filing", "Swing Arm", 0);
		exceptionRule.expect(IllegalArgumentException.class);
	}
	
	
	@Test
	/**
	 * This method will test sort method on Lamp type Study and must give the cheapest output combination.
	 */
	public void testSortLampTypeStudy() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		String [] Study = {
			"L928",
			"10"
		};
		ArrayList<Lamp> lamps = data.getLamps("Study");
		
		Sort sort = new Sort();
		sort.powerSetLamp(lamps);
		assertTrue("This has not preformed sort correctly for type Study.", Arrays.equals(Study, sort.sort("lamp", 1)));
	}
	@Test
	/**
	 * This method will test exception handling for Lamp type Study for illegal argument exception handling.
	 */
	public void testSortLampTypeStudyException() {
		Order order = new Order("filing", "Study", 0);
		exceptionRule.expect(IllegalArgumentException.class);
	}
	
	@Test
	/**
	 * This method will test sort method on Lamp type Study and must give the cheapest output combination for multiple lamps.
	 */
	public void testSortLampTypeStudyMulti() {
		Database data = new Database(DBURL, Username, Password);
		data.initializeConnection();
		
		String [] Study = {
				"L223",
				"L928",
				"L982",
				"20"
		};
		ArrayList<Lamp> lamps = data.getLamps("Study");
		
		Sort sort = new Sort();
		sort.powerSetLamp(lamps);
		assertTrue("This has not preformed sort correctly for type Study.", Arrays.equals(Study, sort.sort("lamp", 2)));
	}
	

	
	
	//These are helper methods
	
	/**
	 * This is a helper function that will take the arrayList of type chair get its corresponding ID
	 * and turn it into a string array.
	 * @param data will take in the chair array list and convert it to a string array.
	 * @return String array that was the originally the chair array list.
	 */
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
	
	/**
	 * This is a helper function that will take the arrayList of type desk get its corresponding ID 
	 * and turn it into a string array.
	 * @param data will take in the desk array list and convert it to a string array.
	 * @return String array that was the originally the desk array list.
	 */
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
	/**
	 * This is a helper function that will take the arrayList of type Filing get its corresponding ID 
	 * and turn it into a string array.
	 * @param data will take in the filing array list and convert it to a string array.
	 * @return String array that was the originally the filing array list.
	 */
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
	/**
	 * This is a helper function that will take the arrayList of type Lamp get its corresponding ID 
	 * and turn it into a string array.
	 * @param data will take in the Lamp array list and convert it to a string array.
	 * @return String array that was the originally the Lamp array list.
	 */
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
	
	/**
	 * This is a helper function that will take the arrayList of type Manufacturer get its corresponding ID 
	 * and turn it into a string array.
	 * @param data will take in the manufacturer array list and convert it to a string array.
	 * @return String array that was the originally the manufacturer array list.
	 */
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
	
	/**
	 * This is a helper function that will insert the chair we deleted when testing the delete method above.
	 * @param ID will be inserted into the ID column.
	 * @param Type will be inserted into the type column.
	 * @param Legs will be inserted into the legs column.
	 * @param Arms will be inserted into the arms column.
	 * @param Seat will be inserted into the seat column.
	 * @param Cushion will be inserted into the cushion column.
	 * @param Price will be inserted into the price column.
	 * @param ManuID will be inserted into the Manufacturer's ID column.
	 */
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
	/**
	 * This is a helper function that will insert the desk we deleted when testing the delete method above.
	 * @param ID will be inserted into the ID column.
	 * @param Type will be inserted into the type column.
	 * @param Legs will be inserted into the leg column.
	 * @param Top will be inserted into the top column.
	 * @param Drawer will be inserted into the drawer column.
	 * @param Price will be inserted into the price column.
	 * @param ManuID will be inserted into the manufacturers ID column.
	 */
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
	/**
	 * This is a helper function that will insert the desk we deleted when testing the delete method above.
	 * @param ID will be inserted into the ID column.
	 * @param Type will be inserted into the type column.
	 * @param Rails will be inserted into the leg column.
	 * @param Drawers will be inserted into the drawers column.
	 * @param Cabinet will be inserted into the cabinet column.
	 * @param Price will be inserted into the price column.
	 * @param ManuID will be inserted into the manufacturers ID column.
	 */
	
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
	/**
	 * This is a helper function that will insert the desk we deleted when testing the delete method above.
	 * @param ID will be inserted into the ID column.
	 * @param Type will be inserted into the type column.
	 * @param Base will be inserted into the base column.
	 * @param Bulb will be inserted into the bulb column.
	 * @param Price will be inserted into the price column.
	 * @param ManuID will be inserted into the manufacturers ID column.
	 */
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