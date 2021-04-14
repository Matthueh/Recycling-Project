import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

@Test
public void testFileCreation() {
	Order order = new Order();
	order.setCategory("mesh");
	order.setType("chair");
	order.setAmount("1");
	String[] test = {"test1", "test2", "test3", "120"};
	order.successfulSort(test);
	File test = File("C:\\Users\\Alexander\\Documents\\UCalgary\\W2021\\Ensf409\\Project\\output.txt");
	
	
	assertTrue("File did not generate properly", File.exists());
}

@Test
public void correctOutput() {
	Order order = new Order();
	order.setCategory("mesh");
	order.setType("chair");
	order.setAmount("1");
	String[] test = {"test1", "100"};
	order.successfulSort(test);
	String testString = new String();
	BufferedReader testFile= new BufferedReader(new FileReader("C:\\Users\\Alexander\\Documents\\UCalgary\\W2021\\Ensf409\\Project\\output.txt"));
	String temp = new String();
	while((temp = testFile.readLine()) != null) {
		testString += temp;
	}
	assertTrue("Output File contents did not match expected results", testString.equals("Furniture Order Form\n\nFaculty Name:\nContact:\nData:\n\nOriginal Request: chair mesh 1\n\nItems Ordered\ntest1\n\nTotal Price: 100"));
}
