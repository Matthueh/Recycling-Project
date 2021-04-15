import java.util.ArrayList;
/**
 * 
 * @author dylan
 *
 */
public class Sort {
	//holds all possible combinations of chairs
	private Chair[][] powerSetChairs;
	//holds all combinations of chairs that allow for a complete order
	private Chair[][] buildableChair;
	//holds the cheapest combination of chairs for the order
	private Chair[] finalChairs = null;
	//holds all possible combinations of filling cabinets
	private Filing[][] powerSetFilings;
	//holds all combinations of filing cabinets that allow for a complete order
	private Filing[][] buildableFiling;
	//holds the cheapest combination of filing cabinets for the order
	private Filing[] finalFilings = null;
	//holds all possible combinations of desks
	private Desk[][] powerSetDesks;
	//holds all combinations of desks that allow for a complete order
	private Desk[][] buildableDesk;
	//holds the cheapest combination of desks for the order
	private Desk[] finalDesks = null;
	//holds all possible combinations of lamps
	private Lamp[][] powerSetLamps;
	//holds all combinations of lamps that allow for a complete order
	private Lamp[][] buildableLamp;
	//holds the cheapest combination of chairs for the order
	private Lamp[] finalLamps = null;
	//the four powerset functions are used to generate all combinations of the desired furniture type
	//these must be called before using the main sort function
	//each function must be used with its respective object type
	/**
	 * generates all combinations of the chair list and 
	 * stores the combinations in the local variable powerSetChairs
	 * @param list a full copy of the chair database
	 */
	public void powerSetChair(ArrayList<Chair> list) {
		int length = 2;
		for(int i = 1; i < list.size(); i++) {
			 length *= 2;
		}//finds the number of possible combinations
		powerSetChairs = new Chair[length][list.size()];
		for(int i = 0; i < length; i++) {
			for(int index = 0; index < list.size(); index++) {
				if((i & (1 << index)) > 0) {
					powerSetChairs[i][index] = list.get(index);
				}
			}
		}//uses bit maps to create each combination from the set of funiture items
	}
	/**
	 * generates all combinations of the desk list and 
	 * stores the combinations in the local variable powerSetDesks
	 * @param list a full copy of the desk database
	 */
	public void powerSetDesk(ArrayList<Desk> list) {
		int length = 2;
		for(int i = 1; i < list.size(); i++) {
			 length *= 2;
		}
		powerSetDesks = new Desk[length][list.size()];
		for(int i = 0; i < length; i++) {
			for(int index = 0; index < list.size(); index++) {
				if((i & (1 << index)) > 0) {
					powerSetDesks[i][index] = list.get(index);
				}
			}
		}
	}
	/**
	 * generates all combinations of the filing cabinet list and 
	 * stores the combinations in the local variable powerSetFilings
	 * @param list a full copy of the filing cabinet database
	 */
	public void powerSetFiling(ArrayList<Filing> list) {
		int length = 2;
		for(int i = 1; i < list.size(); i++) {
			 length *= 2;
		}
		powerSetFilings = new Filing[length][list.size()];
		for(int i = 0; i < length; i++) {
			for(int index = 0; index < list.size(); index++) {
				if((i & (1 << index)) > 0) {
					powerSetFilings[i][index] = list.get(index);
				}
			}
		}
	}
	/**
	 * generates all combinations of the lamp list and 
	 * stores the combinations in the local variable powerSetLamps
	 * @param list a full copy of the lamp database
	 */
	public void powerSetLamp(ArrayList<Lamp> list) {
		int length = 2;
		for(int i = 1; i < list.size(); i++) {
			 length *= 2;
		}
		powerSetLamps = new Lamp[length][list.size()];
		for(int i = 0; i < length; i++) {
			for(int index = 0; index < list.size(); index++) {
				if((i & (1 << index)) > 0) {
					powerSetLamps[i][index] = list.get(index);
				}
			}
		}
	}
	//sort must be called after powerset to find the cheapest combination of items for a complete order
	/**
	 * Finds the cheapest combination of the specified furniture for a requested order.
	 * First finds all combinations of items that can complete an order then finds the cheapest from
	 * that list.
	 * @param furniture	type of furniture requested
	 * @param parts		number of items of furniture requested
	 */
	public String[] sort(String furniture, int parts) {
		if(furniture.equals("chair")) {//these if statements determine which set of functions to use
			int buildableLength = 0;
			int index = 0;
			for(int row = 0; row < powerSetChairs.length; row++) {
				if(buildCheckChair(row, parts)) {
					buildableLength++;
				}
			}//checks for the amount of sets that will fulfill the order
			if(buildableLength == 0) {
				String[] error = {"impossible"};
				return error;
			}//if there are no usable sets then the function returns an error
			buildableChair = new Chair[buildableLength][powerSetChairs[0].length];
			index = 0;
			for(int row = 0; row < powerSetChairs.length; row++) {
				if(buildCheckChair(row, parts)) {
					for(int column = 0; column < buildableChair[index].length; column++) {
						buildableChair[index][column] = powerSetChairs[row][column];
					}
					index++;
				}
			}//checks for each set that can complete an order
			for(index = 0; index < buildableChair.length; index++) {
				checkPriceChair(index);
			}//finds the cheapest set for the order
			int counter = 0;
			for(int i = 0; i < finalChairs.length; i++) {
				if(finalChairs[i] != null) {
					counter++;
				}
			}//gets the length of the array to return
			String[] chairIDs = new String[counter + 1];
			counter = 0;
			for(int i = 0; i < finalChairs.length; i++) {
				if(finalChairs[i] != null) {
					chairIDs[counter] = finalChairs[i].getId();
					counter++;
				}
			}//adds the ids to the array to be returned
			chairIDs[chairIDs.length - 1] = Integer.toString(getOrderPriceChair(finalChairs));//adds the total price to the last element of the array
			return chairIDs;
		}
		if(furniture.equals("desk")) {
			int buildableLength = 0;
			int index = 0;
			for(int row = 0; row < powerSetDesks.length; row++) {
				if(buildCheckDesk(row, parts)) {
					buildableLength++;
				}
			}
			if(buildableLength == 0) {
				String[] error = {"impossible"};
				return error;
			}
			buildableDesk = new Desk[buildableLength][powerSetDesks[0].length];
			index = 0;
			for(int row = 0; row < powerSetDesks.length; row++) {
				if(buildCheckDesk(row, parts)) {
					for(int column = 0; column < buildableDesk[index].length; column++) {
						buildableDesk[index][column] = powerSetDesks[row][column];
					}
					index++;
				}
			}
			for(index = 0; index < buildableDesk.length; index++) {
				checkPriceDesk(index);
			}
			int counter = 0;
			for(int i = 0; i < finalDesks.length; i++) {
				if(finalDesks[i] != null) {
					counter++;
				}
			}
			String[] deskIDs = new String[counter + 1];
			counter = 0;
			for(int i = 0; i < finalDesks.length; i++) {
				if(finalDesks[i] != null) {
					deskIDs[counter] = finalDesks[i].getID();
					counter++;
				}
			}
			deskIDs[deskIDs.length - 1] = Integer.toString(getOrderPriceDesk(finalDesks));
			return deskIDs;
		}
		if(furniture.equals("lamp")) {
			int buildableLength = 0;
			int index = 0;
			for(int row = 0; row < powerSetLamps.length; row++) {
				if(buildCheckLamp(row, parts)) {
					buildableLength++;
				}
			}
			if(buildableLength == 0) {
				String[] error = {"impossible"};
				return error;
			}
			buildableLamp = new Lamp[buildableLength][powerSetLamps[0].length];
			index = 0;
			for(int row = 0; row < powerSetLamps.length; row++) {
				if(buildCheckLamp(row, parts)) {
					for(int column = 0; column < buildableLamp[index].length; column++) {
						buildableLamp[index][column] = powerSetLamps[row][column];
					}
					index++;
				}
			}
			for(index = 0; index < buildableLamp.length; index++) {
				checkPriceLamp(index);
			}
			int counter = 0;
			for(int i = 0; i < finalLamps.length; i++) {
				if(finalLamps[i] != null) {
					counter++;
				}
			}
			String[] lampIDs = new String[counter + 1];
			counter = 0;
			for(int i = 0; i < finalLamps.length; i++) {
				if(finalLamps[i] != null) {
					lampIDs[counter] = finalLamps[i].getID();
					counter++;
				}
			}
			lampIDs[lampIDs.length - 1] = Integer.toString(getOrderPriceLamp(finalLamps));
			return lampIDs;
		}
		if(furniture.equals("filing")) {
			int buildableLength = 0;
			int index = 0;
			for(int row = 0; row < powerSetFilings.length; row++) {
				if(buildCheckFiling(row, parts)) {
					buildableLength++;
				}
			}
			if(buildableLength == 0) {
				String[] error = {"impossible"};
				return error;
			}
			buildableFiling = new Filing[buildableLength][powerSetFilings[0].length];
			index = 0;
			for(int row = 0; row < powerSetFilings.length; row++) {
				if(buildCheckFiling(row, parts)) {
					for(int column = 0; column < buildableFiling[index].length; column++) {
						buildableFiling[index][column] = powerSetFilings[row][column];
					}
					index++;
				}
			}
			for(index = 0; index < buildableFiling.length; index++) {
				checkPriceFiling(index);
			}
			int counter = 0;
			for(int i = 0; i < finalFilings.length; i++) {
				if(finalFilings[i] != null) {
					counter++;
				}
			}
			String[] filingIDs = new String[counter + 1];
			counter = 0;
			for(int i = 0; i < finalFilings.length; i++) {
				if(finalFilings[i] != null) {
					filingIDs[counter] = finalFilings[i].getID();
					counter++;
				}
			}
			filingIDs[filingIDs.length - 1] = Integer.toString(getOrderPriceFiling(finalFilings));
			return filingIDs;
		}
		String[] error = {"error"};
		return error;
	}
	/**
	 * Generates a list of all combinations of chairs that can be used to
	 * complete an order
	 * @param row	row index of the power set of chairs
	 * @param parts number of furniture that must be built
	 * @return		returns true if a combination of chairs will be able to complete an order
	 */
	public boolean buildCheckChair(int row, int parts) {
		int legs = 0;
		int arms = 0;
		int cushion = 0;
		int seat = 0;
		for(int i = 0; i < powerSetChairs[row].length; i++) {
			if(powerSetChairs[row][i] != null) {
				if(powerSetChairs[row][i].getLegs()) {
					legs++;
				}
				if(powerSetChairs[row][i].getArms()) {
					arms++;
				}
				if(powerSetChairs[row][i].getCushion()) {
					cushion++;
				}
				if(powerSetChairs[row][i].getSeat()) {
					seat++;
				}
			}
		}//checks what usable parts each item of furniture contains
		if(legs >= parts && arms >= parts && cushion >= parts && seat >= parts) {
			return true;
		}//checks if the order can be fulfilled from the set of items
		else {
			return false;
		}
	}
	/**
	 * Generates a list of all combinations of desks that can be used to
	 * complete an order
	 * @param row	row index of the power set of desks
	 * @param parts number of furniture that must be built
	 * @return		returns true if a combination of desks will be able to complete an order
	 */
	public boolean buildCheckDesk(int row, int parts) {
		int legs = 0;
		int top = 0;
		int drawer = 0;
		for(int i = 0; i < powerSetDesks[row].length; i++) {
			if(powerSetDesks[row][i] != null) {
				if(powerSetDesks[row][i].getLegs()) {
					legs++;
				}
				if(powerSetDesks[row][i].getTop()) {
					top++;
				}
				if(powerSetDesks[row][i].getDrawer()) {
					drawer++;
				}
			}
		}
		if(legs >= parts && top >= parts && drawer >= parts) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Generates a list of all combinations of lamps that can be used to
	 * complete an order
	 * @param row	row index of the power set of lamps
	 * @param parts number of furniture that must be built
	 * @return		returns true if a combination of lamps will be able to complete an order
	 */
	public boolean buildCheckLamp(int row, int parts) {
		int base = 0;
		int bulb = 0;
		for(int i = 0; i < powerSetLamps[row].length; i++) {
			if(powerSetLamps[row][i] != null) {
				if(powerSetLamps[row][i].getBase()) {
					base++;
				}
				if(powerSetLamps[row][i].getBulb()) {
					bulb++;
				}
			}
		}
		if(base >= parts && bulb >= parts) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * Generates a list of all combinations of filing cabinets that can be used to
	 * complete an order
	 * @param row	row index of the power set of filing cabinets
	 * @param parts number of furniture that must be built
	 * @return		returns true if a combination of filing cabinets will be able to complete an order
	 */
	public boolean buildCheckFiling(int row, int parts) {
		int rails = 0;
		int drawers = 0;
		int cabinet = 0;
		for(int i = 0; i < powerSetFilings[row].length; i++) {
			if(powerSetFilings[row][i] != null) {
				if(powerSetFilings[row][i].getRails()) {
					rails++;
				}
				if(powerSetFilings[row][i].getDrawers()) {
					drawers++;
				}
				if(powerSetFilings[row][i].getCabinet()) {
					cabinet++;
				}
			}
		}
		if(rails >= parts && drawers >= parts && cabinet >= parts) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * compares the prices of the current lowest costing combinations of chairs 
	 * with the current combination at index of the buildableChair member variable.
	 * If the combination from buildableChair is lower than the last lowest combination then
	 * the combination from buildableChair replaces the last combination.
	 * @param index row index of the buildableChair member variable
	 */
	public void checkPriceChair(int index) {
		if(finalChairs == null) {
			finalChairs = new Chair[buildableChair[index].length];
			for(int i = 0; i < buildableChair[index].length; i++) {
				finalChairs[i] = buildableChair[index][i];
			}
			return;
		}
		//if finalChairs does not have a current lowest cost set, then the first element of buildableChair is put into finalChairs
		if(getOrderPriceChair(finalChairs) > getOrderPriceChair(buildableChair[index])) {
			for(int column = 0; column < buildableChair[index].length; column++) {
				finalChairs[column] = buildableChair[index][column];
			}
		}
	}//checks whether the price of the given set is lower than the previous lowest set of items
	/**
	 * compares the prices of the current lowest costing combinations of cabinets 
	 * with the current combination at index of the buildableFiling member variable.
	 * If the combination from buildableFiling is lower than the last lowest combination then
	 * the combination from buildableFiling replaces the last combination.
	 * @param index row index of the buildableFiling member variable
	 */
	public void checkPriceFiling(int index) {
		if(finalFilings == null) {
			finalFilings = new Filing[buildableFiling[index].length];
			for(int i = 0; i < buildableFiling[index].length; i++) {
				finalFilings[i] = buildableFiling[index][i];
			}
			return;
		}
		
		if(getOrderPriceFiling(finalFilings) > getOrderPriceFiling(buildableFiling[index])) {
			for(int column = 0; column < buildableFiling[index].length; column++) {
				finalFilings[column] = buildableFiling[index][column];
			}
		}
	}
	/**
	 * compares the prices of the current lowest costing combinations of desks 
	 * with the current combination at index of the buildableDesk member variable.
	 * If the combination from buildableDesk is lower than the last lowest combination then
	 * the combination from buildableDesk replaces the last combination.
	 * @param index row index of the buildableDesk member variable
	 */
	public void checkPriceDesk(int index) {
		if(finalDesks == null) {
			finalDesks = new Desk[buildableDesk[index].length];
			for(int i = 0; i < buildableDesk[index].length; i++) {
				finalDesks[i] = buildableDesk[index][i];
			}
			return;
		}
		
		if(getOrderPriceDesk(finalDesks) > getOrderPriceDesk(buildableDesk[index])) {
			for(int column = 0; column < buildableDesk[index].length; column++) {
				finalDesks[column] = buildableDesk[index][column];
			}
		}
	}
	/**
	 * compares the prices of the current lowest costing combinations of lamps 
	 * with the current combination at index of the buildableLamp member variable.
	 * If the combination from buildableLamp is lower than the last lowest combination then
	 * the combination from buildableLamp replaces the last combination.
	 * @param index row index of the buildableLamp member variable
	 */
	public void checkPriceLamp(int index) {
		if(finalLamps == null) {
			finalLamps = new Lamp[buildableLamp[index].length];
			for(int i = 0; i < buildableLamp[index].length; i++) {
				finalLamps[i] = buildableLamp[index][i];
			}
			return;
		}
		
		if(getOrderPriceLamp(finalLamps) > getOrderPriceLamp(buildableLamp[index])) {
			for(int column = 0; column < buildableLamp[index].length; column++) {
				finalLamps[column] = buildableLamp[index][column];
			}
		}
	}
	/**
	 * Finds the price of the combination of chairs
	 * @param 	order	an array of Chair objects to be scanned for price
	 * @return	the price of combination of chairs
	 */
	public int getOrderPriceChair(Chair[] order) {
		int price = 0;
		for(int index = 0; index < order.length; index++) {
			if(order[index] != null) {
				price += order[index].getPrice();
			}
		}//finds the total price of the set of items
		return price;
	}
	/**
	 * Finds the price of the combination of cabinets
	 * @param 	order	an array of Filing Cabinet objects to be scanned for price
	 * @return	the price of combination of cabinets
	 */
	public int getOrderPriceFiling(Filing[] order) {
		int price = 0;
		for(int index = 0; index < order.length; index++) {
			if(order[index] != null) {
				price += order[index].getPrice();
			}
		}
		return price;
	}
	/**
	 * Finds the price of the combination of desks
	 * @param 	order	an array of Desk objects to be scanned for price
	 * @return	the price of combination of desks
	 */
	public int getOrderPriceDesk(Desk[] order) {
		int price = 0;
		for(int index = 0; index < order.length; index++) {
			if(order[index] != null) {
				price += order[index].getPrice();
			}
		}
		return price;
	}
	/**
	 * Finds the price of the combination of lamps
	 * @param 	order	an array of Lamp objects to be scanned for price
	 * @return	the price of combination of lamps
	 */
	public int getOrderPriceLamp(Lamp[] order) {
		int price = 0;
		for(int index = 0; index < order.length; index++) {
			if(order[index] != null) {
				price += order[index].getPrice();
			}
		}
		return price;
	}
  
  
  
  
  //getter methods
  
	/**
	 * getter for powerSetChairs
	 * @return	member variable powerSetChairs
	 */
  	public Chair [][] getPowerSetChairs() {
		return this.powerSetChairs;
	}
  	/**
	 * getter for buildableChairs
	 * @return	member variable buildableChairs
	 */
	public Chair [][] getBuildableChairs(){
		return this.buildableChair;
	}
	/**
	 * getter for finalChairs
	 * @return	member variable finalChairs
	 */
	public Chair [] getFinalChairs() {
		return this.finalChairs;
	}
	
	
	
	/**
	 * getter for powerSetDesks
	 * @return	member variable powerSetDesks
	 */
	public Desk[][] getPowerSetDesks() {
		return this.powerSetDesks;
	}
	/**
	 * getter for buildableDesks
	 * @return	member variable buildableDesks
	 */
	public Desk [][] getBuildableDesks(){
		return this.buildableDesk;
	}
	/**
	 * getter for finalDesks
	 * @return	member variable finalDesks
	 */
	public Desk [] getFinalDesks() {
		return this.finalDesks;
	}
	
	
	/**
	 * getter for powerSetFilings
	 * @return	member variable powerSetFilings
	 */
	public Filing[][] getPowerSetFiling(){
		return this.powerSetFilings;
	}
	/**
	 * getter for buildableFilings
	 * @return	member variable buildableFilings
	 */
	public Filing [][] getBuildableFilings(){ 
		return this.buildableFiling;
	}
	/**
	 * getter for finalFilings
	 * @return	member variable finalFilings
	 */
	public Filing [] getFinalFiling() {
		return this.finalFilings;
	}
	
	
	/**
	 * getter for powerSetLamps
	 * @return	member variable powerSetLamps
	 */
	public Lamp[][] getPowerSetLamp(){
		return this.powerSetLamps;
	}
	/**
	 * getter for buildableLamps
	 * @return	member variable buildableLamps
	 */
	public Lamp[][] getBuildableLamps(){
		return this.buildableLamp;
	}
	/**
	 * getter for finalLamps
	 * @return	member variable finalLamps
	 */
	public Lamp [] getFinalLamps() {
		return this.finalLamps;
	}
  
}
