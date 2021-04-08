import static org.junit.Assert.*;
import org.junit.*;
import java.io.*;
import java.util.*;
import org.junit.contrib.java.lang.system.ExpectedSystemExit;

public class ObjectCreationTest {
	
	//change this depending on the user.
	String DBURL = ""; 
	String Username = "";
	String Password = "";
	
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
	
	public void testDataBaseConstructorGetFilings0Type() {
		
		Database data = new DataBase(DBURL, Username, Password);
		data.initilizeConnection();
		
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
		
		assertTrue("Method getFilings(String type) doesn't handle getting type Small.", Arrays.equals(Small, tmpArray));
		
		filing = data.getFiling("Medium");
		tmpArray = getArrayFilingId(filing);
		
		assertTrue("Method getFilings(String type) doesn't handle getting type Medium", Arrays.equals(Medium, tmpArray));
		
		filing = data.getFiling("Large");
		tmpArray = getArrayFilingId(filing);
		
		assertTrue("Method getFilings(String type) doesn't handlge getting type Large", Arrays.equals(Large, tmpArray));
		
	}
	
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
		
		ArrayList<Lamp> Lamp  = data.getFilings("Desk");
		String [] tmpArray = getArrayLampId(Lamp);
		
		assertTrue("Method getFilings(String type) doesn't handle getting type Small.", Arrays.equals(Desk, tmpArray));
		
		Lamp = data.getFiling("SwingArm");
		tmpArray = getArrayLampId(Lamp);
		
		assertTrue("Method getFilings(String type) doesn't handle getting type Medium", Arrays.equals(SwingArm, tmpArray));
		
		Lamp = data.getFiling("Study");
		tmpArray = getArrayLampId(Lamp);
		
		assertTrue("Method getFilings(String type) doesn't handlge getting type Large", Arrays.equals(Study, tmpArray));
		
		
		
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
	
}
