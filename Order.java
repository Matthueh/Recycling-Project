import static org.junit.Assert.assertThrows;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

public class Order {
	
	private String category;
	private String type;
	private int amount;
	
	
	Order(){
		Scanner scan = new Scanner(System.in);
		System.out.println("Please Enter the category of furniture you wish to order.");
		this.setCategory(scan.next().toLowerCase());
		System.out.println("Please Enter the type of " + this.category + " you wish to order.");
		this.type = scan.next().toLowerCase();
		this.type = this.type.toUpperCase().charAt(0)+this.type.substring(1,this.type.length());
		System.out.println("Please Enter the amount you wish to order in the form of an integer. ");
		this.setAmount(scan.nextInt());
	}
	
	public void sort(){
		Database data = new Database("jdbc:mysql://localhost/inventory","alex","hellothere");
		data.initializeConnection();
		
		if(this.category.equals("chair")) {
			 Sort sorter = new Sort();
			 sorter.powerSetChair(data.getChairs(type));
			 String[] result = sorter.sort(category,amount);
			 
			 for(int i = 0; i<result.length; i++) {
				 System.out.println("Result" + result[i]);
			 }
			 
			//String[] result = {"C0194", "C1148", "100"};
			 if(result[0].equals("impossible")) {
				 this.failedSort(result);
			 }
			 else {
				 this.successfulSort(result);
			 }
		}
		else if(this.category.equals("desk")) {
			Sort sorter = new Sort();
			 sorter.powerSetDesk(data.getDesks(type));
			 String[] result = sorter.sort(category,amount);
			 if(result[0].equals("impossible")) {
				 this.failedSort(result);
			 }
			 else {
				 this.successfulSort(result);
			 }
		}
		else if(this.category.equals("filing")) {
			Sort sorter = new Sort();
			 sorter.powerSetFiling(data.getFilings(type));
			 String[] result = sorter.sort(category,amount);
			 if(result[0].equals("impossible")) {
				 this.failedSort(result);
			 }
			 else {
				 this.successfulSort(result);
			 }
		}
		else if(this.category.equals("lamp")) {
			Sort sorter = new Sort();
			 sorter.powerSetLamp(data.getLamps(type));
			 String[] result = sorter.sort(category,amount);
			 if(result[0].equals("impossible")) {
				 this.failedSort(result);
			 }
			 else {
				 this.successfulSort(result);
			 }
		}
		else {
			System.out.println("Invalid category entered");
			System.exit(1);
		}
		
	}
	
	public void successfulSort(String[] result) {
		try {
			File output = new File("C:\\Users\\Alexander\\Documents\\UCalgary\\W2021\\Ensf409\\Project\\output.txt");
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
		}
		
		Database data = new Database("jdbc:mysql://localhost/inventory","alex","hellothere");
		data.initializeConnection();
		
	/*	for(int i = 0; i<result.length-1; i++) {
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
	*/	
		System.out.println("Success. Your order form has been generated.");
	}
	
	public void failedSort(String[] result) {
		//find the manufacturers,put in string manu;
		Database data = new Database("jdbc:mysql://localhost/inventory","alex","hellothere");
		data.initializeConnection();
		ArrayList<String> finalList = new ArrayList<String>();
		
		if(category.equals("chair")) {
			ArrayList<String> IDs = data.getChairManufacturers();
			ArrayList<Manufacturer> manu = data.getManufacturers();
			
			System.out.println(manu.size());
					
			for(int i = 0; i<manu.size(); i++) {
				Manufacturer man = manu.get(i);
				for(int j = 0; j<IDs.size(); j++) {
					if(man.getManuID()==IDs.get(j)) {
						finalList.add(man.getName());
					}
				}
			}	
		}
		else if(category.equals("desk")) {
			
		}
		else if(category.equals("lamp")) {
			
		}
		else if(category.equals("filing")) {
			
		}
		
		StringBuffer manus = new StringBuffer();
		
		System.out.println(finalList.size());
		
		for(int i = 0; i<finalList.size(); i++) {
		
			manus.append(finalList.get(i));
			//System.out.println(finalList.get(i));
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
	
	public static void main(String[] args) {
		Order order = new Order();
		System.out.println(order.getCategory() + " " + order.getType()+ " " + order.getAmount());
		order.sort();
	}
}
