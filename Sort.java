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
	/**
	 * generates all combinations of the chair list and 
	 * stores the combinations in the local variable powerSetChairs
	 * @param list a full copy of the chair database
	 */
	public void powerSetChair(ArrayList<Chair> list) {
		int length = 2;
		for(int i = 1; i < list.size(); i++) {
			 length *= 2;
		}
		powerSetChairs = new Chair[length][list.size()];
		for(int i = 0; i < length; i++) {
			for(int index = 0; index < list.size(); index++) {
				if((i & (1 << index)) > 0) {
					powerSetChairs[i][index] = list.get(index);
				}
			}
		}
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
	/**
	 * Finds the cheapest combination of the specified furniture for a requested order.
	 * First finds all combinations of items that can complete an order then finds the cheapest from
	 * that list.
	 * @param furniture	type of furniture requested
	 * @param parts		number of items of furniture requested
	 */
	public String[] sort(String furniture, int parts) {
		if(furniture.equals("Chair")) {
			int buildableLength = 0;
			int index = 0;
			for(int row = 0; row < powerSetChairs.length; row++) {
				if(buildCheckChair(row, parts)) {
					buildableLength++;
				}
			}
			if(buildableLength == 0) {
				String[] error = {"impossible"};
				return error;
			}
			buildableChair = new Chair[buildableLength][];
			index = 0;
			for(int row = 0; row < powerSetChairs.length; row++) {
				if(buildCheckChair(row, parts)) {
					buildableChair[index] = new Chair[powerSetChairs[row].length];
					for(int column = 0; column < buildableChair[index].length; column++) {
						buildableChair[index][column] = powerSetChairs[row][column];
					}
				}
			}
			for(index = 0; index < buildableChair[index].length; index++) {
				checkPriceChair(index);
			}
			String[] chairIDs = new String[finalChairs.length + 1];
			for(int i = 0; i < finalChairs.length - 1; i++) {
				chairIDs[i] = finalChairs[i].getID();
			}
			chairIDs[chairIDs.length - 1] = Integer.toString(getOrderPriceChair(finalChairs));
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
			buildableDesk = new Desk[buildableLength][];
			index = 0;
			for(int row = 0; row < powerSetDesks.length; row++) {
				if(buildCheckDesk(row, parts)) {
					buildableDesk[index] = new Desk[powerSetDesks[row].length];
					for(int column = 0; column < buildableDesk[index].length; column++) {
						buildableDesk[index][column] = powerSetDesks[row][column];
					}
				}
			}
			for(index = 0; index < buildableDesk[index].length; index++) {
				checkPriceDesk(index);
			}
			String[] deskIDs = new String[finalDesks.length];
			for(int i = 0; i < finalDesks.length; i++) {
				deskIDs[i] = finalDesks[i].getID();
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
			buildableLamp = new Lamp[buildableLength][];
			index = 0;
			for(int row = 0; row < powerSetLamps.length; row++) {
				if(buildCheckLamp(row, parts)) {
					buildableLamp[index] = new Lamp[powerSetLamps[row].length];
					for(int column = 0; column < buildableLamp[index].length; column++) {
						buildableLamp[index][column] = powerSetLamps[row][column];
					}
				}
			}
			for(index = 0; index < buildableLamp[index].length; index++) {
				checkPriceLamp(index);
			}
			String[] lampIDs = new String[finalLamps.length];
			for(int i = 0; i < finalLamps.length; i++) {
				lampIDs[i] = finalLamps[i].getID();
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
			buildableFiling = new Filing[buildableLength][];
			index = 0;
			for(int row = 0; row < powerSetFilings.length; row++) {
				if(buildCheckFiling(row, parts)) {
					buildableFiling[index] = new Filing[powerSetFilings[row].length];
					for(int column = 0; column < buildableFiling[index].length; column++) {
						buildableFiling[index][column] = powerSetFilings[row][column];
					}
				}
			}
			for(index = 0; index < buildableFiling[index].length; index++) {
				checkPriceFiling(index);
			}
			String[] filingIDs = new String[finalFilings.length];
			for(int i = 0; i < finalFilings.length; i++) {
				filingIDs[i] = finalFilings[i].getID();
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
		if(legs + arms + cushion + seat >= parts * 4) {
			return true;
		}
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
		for(int i = 0; i < powerSetDesks[row].length; i++) {
			if(powerSetDesks[row][i].getLegs()) {
				legs++;
			}
			if(powerSetDesks[row][i].getTop()) {
				top++;
			}
		}
		if(legs + top >= parts * 2) {
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
			if(powerSetLamps[row][i].getBase()) {
				base++;
			}
			if(powerSetLamps[row][i].getBulb()) {
				bulb++;
			}
		}
		if(base + bulb >= parts * 2) {
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
		if(rails + drawers + cabinet >= parts * 3) {
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
			finalChairs = buildableChair[index];
			return;
		}
		
		if(getOrderPriceChair(finalChairs) > getOrderPriceChair(buildableChair[index])) {
			for(int column = 0; column < buildableChair[index].length; column++) {
				finalChairs[column] = buildableChair[index][column];
			}
		}
	}
	/**
	 * compares the prices of the current lowest costing combinations of cabinets 
	 * with the current combination at index of the buildableFiling member variable.
	 * If the combination from buildableFiling is lower than the last lowest combination then
	 * the combination from buildableFiling replaces the last combination.
	 * @param index row index of the buildableFiling member variable
	 */
	public void checkPriceFiling(int index) {
		if(finalFilings == null) {
			finalFilings = buildableFiling[index];
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
			finalDesks = buildableDesk[index];
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
			finalLamps = buildableLamp[index];
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
			price += order[index].getPrice();
		}
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
			price += order[index].getPrice();
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
			price += order[index].getPrice();
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
			price += order[index].getPrice();
		}
		return price;
	}
	
	
	
	//Some getter methods
	
	public Chair [][] getPowerSetChairs() {
		return this.powerSetChairs;
	}
	
	public Chair [][] getBuildableChairs(){
		return this.buildableChair;
	}
	
	public Chair [] getFinalChairs() {
		return this.finalChairs;
	}
	
	
	
	
	public Desk[][] getPowerSetDesks() {
		return this.powerSetDesks;
	}
	
	public Desk [][] getBuildableDesks(){
		return this.buildableDesk;
	}
	
	public Desk [] getFinalDesks() {
		return this.finalDesks;
	}
	
	
	
	public Filing[][] getPowerSetFiling(){
		return this.powerSetFilings;
	}
	
	public Filing [][] getBuildableFilings(){ 
		return this.buildableFiling;
	}
	
	public Filing [] getFinalFiling() {
		return this.finalFilings;
	}
	
	
	
	public Lamp[][] getPowerSetLamp(){
		return this.powerSetLamps;
	}
	public Lamp[][] getBuildableLamps(){
		return this.buildableLamp;
	}
	public Lamp [] getFinalLamps() {
		return this.finalLamps;
	}
	
	
}





