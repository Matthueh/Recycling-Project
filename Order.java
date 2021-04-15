//import static org.junit.Assert.assertThrows;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;
/**
 * This is the class from which the main function will be called.
 *  It will take in user input and give the user output based on the results of their order.
 * @author Alexander
 *
 */
public class Order {
	
	private String category;
	private String type;
	private int amount;
	
	/**
	 * Constructor for order. 
	 * It asks the user for input regarding their order and manipulates it to ensure it works with the database class.
	 */
	Order(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Enter the category of furniture you wish to order.");
		this.setCategory(scan.next().toLowerCase());
		System.out.println("Please Enter the type of " + this.category + " you wish to order.");
		this.type = scan.next().toLowerCase();
		this.type = this.type.toUpperCase().charAt(0)+this.type.substring(1,this.type.length());
		if(this.type.equals("Swing")) {
			String temp = scan.next().toLowerCase();
			temp = temp.toUpperCase().charAt(0)+temp.substring(1,temp.length());
			this.type = this.type.concat(" ");
			this.type = this.type.concat(temp);
		}
		System.out.println("Please Enter the amount you wish to order in the form of an integer. ");
		this.setAmount(scan.nextInt());
		if(type.equals("Ergonomic")||type.equals("Executive")||type.equals("Kneeling")||type.equals("Mesh")||type.equals("Task")) {}
		else if(type.equals("Adjustable")||type.equals("Standing")||type.equals("Traditional")) {}
		else if(type.equals("Small")||type.equals("Medium")||type.equals("Large")) {}
		else if(type.equals("Desk")||type.equals("Study")||type.equals("Swing Arm")) {}
		else {
			System.out.println("Invalid type, try again.");
			scan.close();
			throw new IllegalArgumentException();
		}
		if(amount<=0) {
			System.out.println("Invalid amount, please enter an amount of 1 or greater.");
			scan.close();
			throw new IllegalArgumentException();
		}
		scan.close();
	}
	
	Order(String category, String type, int amount){
		this.category = category;
		this.type = type;
		this.amount = amount;
	}
	/**
	 * This method processes the order. Using the user inputted request values it 
	 * requests data from the database then calls the sort class to sort
	 * the data and find the cheapest combination of furniture or find if the order is impossible. 
	 * This method then calls either successfulOrder or failedOrder.
	 */
	public void processOrder(){
		Database data = new Database("jdbc:mysql://localhost/inventory","alex","hellothere");
		data.initializeConnection();
		
		if(this.category.equals("chair")) {
			 Sort sorter = new Sort();
			 sorter.powerSetChair(data.getChairs(type));
			 String[] result = sorter.sort(category,amount);
			 
			 if(result[0].equals("impossible")) {
				 this.failedOrder();
			 }
			 else {
				 this.successfulOrder(result);
			 }
		}
		else if(this.category.equals("desk")) {
			Sort sorter = new Sort();
			 sorter.powerSetDesk(data.getDesks(type));
			 String[] result = sorter.sort(category,amount);
			 if(result[0].equals("impossible")) {
				 this.failedOrder();
			 }
			 else {
				 this.successfulOrder(result);
			 }
		}
		else if(this.category.equals("filing")) {
			Sort sorter = new Sort();
			 sorter.powerSetFiling(data.getFilings(type));
			 String[] result = sorter.sort(category,amount);
			 if(result[0].equals("impossible")) {
				 this.failedOrder();
			 }
			 else {
				 this.successfulOrder(result);
			 }
		}
		else if(this.category.equals("lamp")) {
			Sort sorter = new Sort();
			 sorter.powerSetLamp(data.getLamps(type));
			 String[] result = sorter.sort(category,amount);
			 if(result[0].equals("impossible")) {
				 this.failedOrder();
			 }
			 else {
				 this.successfulOrder(result);
			 }
		}
		else {
			System.out.println("Invalid category entered, try again.");
			throw new IllegalArgumentException();
		}
		
	}
	
	/**
	 * This method is called if an order can be fulfilled. It generates an order form and deletes the ordered furniture from the database.
	 * @param result is a string array containing the ID numbers of the furniture to be ordered a long with the total price in the final index.
	 */
	public void successfulOrder(String[] result) {
		try {
			File output = new File("order form.txt");
			output.createNewFile();
			FileWriter fw = new FileWriter(output);
			PrintWriter pw = new PrintWriter(fw);	
			pw.println("Furniture Order Form");
			pw.println();
			pw.println("Faculty Name:");
			pw.println("Contact:");
			pw.println("Date:");
			pw.println();
			pw.println("Original Request: " + this.type.toLowerCase() + " " + this.category.toLowerCase() + ", " + amount);
			pw.println();
			pw.println("Items Ordered");
			for(int i = 0; i<result.length-1; i++) {
				pw.println("ID: " + result[i]);
			}
			pw.println();
			pw.println("Total Price: " + result[result.length-1]);
			pw.close();
			fw.close();
		}catch(IOException e) {
			System.out.println("Failed. The order should have been successful but the order form failed to generate.");
			System.exit(1);
		}
		
		Database data = new Database("jdbc:mysql://localhost/inventory","alex","hellothere");
		data.initializeConnection();
		
		for(int i = 0; i<result.length-1; i++) {
			if(result[i].charAt(0)=='C') {
				data.deleteChair(result[i]);
			}
			else if(result[i].charAt(0)=='D') {
				data.deleteDesk(result[i]);
			}
			else if(result[i].charAt(0)=='F') {
				data.deleteFiling(result[i]);
			}
			else if(result[i].charAt(0)=='L') {
				data.deleteLamp(result[i]);
			}
		}
		
		StringBuffer out = new StringBuffer();
		out.append("Purchase ");
		for(int i = 0; i<result.length; i++) {
			out.append(result[i]);
			if(i+1<result.length && i+2<result.length) {
				out.append(" and ");
			}
			else if(i+1<result.length) {
				out.append(" for $");
			}
			else if(i==result.length-1) {
				out.append(".");
			}
		}
		
		System.out.println(out);
	}
	
	/**
	 * This function is called if an order is unable to be fulfilled.
	 *  It finds the reccomended manufacturers and outputs them to the console.
	 */
	public void failedOrder() {
		Database data = new Database("jdbc:mysql://localhost/inventory","alex","hellothere");
		data.initializeConnection();
		ArrayList<String> finalList = new ArrayList<String>();
		
		if(category.equals("chair")) {
			ArrayList<String> IDs = data.getChairManufacturers();
			ArrayList<Manufacturer> manu = data.getManufacturers();
					
			for(int i = 0; i<manu.size(); i++) {
				Manufacturer man = manu.get(i);
				for(int j = 0; j<IDs.size(); j++) {
					if(man.getManuID().equals(IDs.get(j))) {
						finalList.add(man.getName());
					}
				}
			}	
		}
		else if(category.equals("desk")) {
			ArrayList<String> IDs = data.getDeskManufacturers();
			ArrayList<Manufacturer> manu = data.getManufacturers();
					
			for(int i = 0; i<manu.size(); i++) {
				Manufacturer man = manu.get(i);
				for(int j = 0; j<IDs.size(); j++) {
					if(man.getManuID().equals(IDs.get(j))) {
						finalList.add(man.getName());
					}
				}
			}
		}
		else if(category.equals("lamp")) {
			ArrayList<String> IDs = data.getLampManufacturers();
			ArrayList<Manufacturer> manu = data.getManufacturers();
					
			for(int i = 0; i<manu.size(); i++) {
				Manufacturer man = manu.get(i);
				for(int j = 0; j<IDs.size(); j++) {
					if(man.getManuID().equals(IDs.get(j))) {
						finalList.add(man.getName());
					}
				}
			}
		}
		else if(category.equals("filing")) {
			ArrayList<String> IDs = data.getFilingManufacturers();
			ArrayList<Manufacturer> manu = data.getManufacturers();
					
			for(int i = 0; i<manu.size(); i++) {
				Manufacturer man = manu.get(i);
				for(int j = 0; j<IDs.size(); j++) {
					if(man.getManuID().equals(IDs.get(j))) {
						finalList.add(man.getName());
					}
				}
			}
		}
		
		StringBuffer manus = new StringBuffer();

		for(int i = 0; i<finalList.size(); i++) {
		
			manus.append(finalList.get(i));
			if(i+1<finalList.size() && i+2<finalList.size()) {
				manus.append(", ");
			}
			else if(i+1<finalList.size()) {
				manus.append(", and ");
			}
			else if(i==finalList.size()-1) {
				manus.append(".");
			}
	
		}
		
		System.out.println("Order cannot be fulfilled based on current inventory. Suggest manufacturers are " + manus.toString());
	}
	
	/**
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * @param category the category to set
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

	/**
	 * @return the amount
	 */
	public int getAmount() {
		return amount;
	}

	/**
	 * @param amount the amount to set
	 */
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	/**
	 * The main is where the code is run. It will create an Order object then sort and output the result.
	 * @param args not used for this.
	 */
	public static void main(String[] args) {
		Order order = new Order();
		order.processOrder();
	}
		
}
