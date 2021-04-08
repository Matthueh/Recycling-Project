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
	//We are going to first test whether if the values from the data base have been successfully been loaded up.
	public void testDataBaseConstructorGetChairs0Type() {
		Database data = new Database(DBURL, Username, Password); // We will have to get database from Alex.
		
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
		String[] tmpArray = getArrayId(chair);
		
		//Checking that getChairs is actually working for type task
		assertTrue("Method getChairs(String type) doesn't handle getting type Task from the listed chairs.", Arrays.equals(Task, tmpArray));
		
		//Reassigning list of chairs of type mesh, convert it to an array.
		chair = data.getChairs("Mesh");
		tmpArray = getArrayId(chair);
		
		//Checking that getChairs is actually working for type mesh. 
		assertTrue("Method getChairs(String type) doesn't handle getting type Mesh from the listed chairs.", Arrays.equals(Mesh,  tmpArray));
		
		//Reassigning list of chairs of type Kneeling, convert it to an array.
		chair = data.getChairs("Kneeling");
		tmpArray = getArrayId(chair);
		
		//Checking that getChairs is actually working for type Kneeling.
		assertTrue("Method getChairs(String type) doesn't handle getting type Kneeling from the listed chairs.", Arrays.equals(Kneeling, tmpArray));
		
		//Retrieve list of chairs of type Executive 
		chair = data.getChairs("Executive");
		tmpArray = getArrayId(chair);
		
		//Checking that getChairs is actually working for type Executive.
		assertTrue("Method getChairs(String type) doesn't handle getting type Executive from the listed chairs.", Arrays.equals(Executive, tmpArray));
		
		//Retrieve list of chairs of type Ergonomic.
		chair = data.getChairs("Ergonomic");
		tmpArray = getArrayId(chair);
		
		//Checking that getChairs is actually working for type Executive.
		assertTrue("Method get Chairs(string type) doesn't handle getting type Ergonomic from the listed chairs.", Arrays.equals(Ergonomic, tmpArray));	
	}
	
	@Test
	public void testDataBaseConstructorGetDesks0Type() {
		//Database data = new Database(DBURL, Username, Password);
	}
	
	
	//Got to fix this
	public String[] getArrayId(ArrayList<Chair> data) {
		ArrayList<String> tmp = new ArrayList<String>();
		if(data != null && data.isEmpty() == false) {
			for(int i = 0; i < data.size() ; i++ ) {
				tmp.add(data.get(i).getId());
			}
		}
		String [] tmpArray = tmp.toArray(new String[tmp.size()]);
		return tmpArray;
	}
	
}
