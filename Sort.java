import java.util.ArrayList;

public class Sort {
	private Chair[][] powerSetChairs;
	private Chair[][] buildableChair;
	private Chair[] finalChairs = null;
	private Filing[][] powerSetFilings;
	private Filing[][] buildableFiling;
	private Filing[] finalFilings = null;
	private Desk[][] powerSetDesks;
	private Desk[][] buildableDesk;
	private Desk[] finalDesks = null;
	private Lamp[][] powerSetLamps;
	private Lamp[][] buildableLamp;
	private Lamp[] finalLamps = null;
	public void powerSetChair(ArrayList<Chair> list) {
		int length = 2;
		for(int i = 1; i < list.size(); i++) {
			 length *= 2;
		}
		powerSetChairs = new Chair[length][];
		for(int i = 0; i < length; i++) {
			for(int index = 0; index < list.size(); index++) {
				if((i & (1 << index)) > 0) {
					powerSetChairs[i][index] = list.get(index);
				}
			}
		}
	}
	public void powerSetDesk(ArrayList<Desk> list) {
		int length = 2;
		for(int i = 1; i < list.size(); i++) {
			 length *= 2;
		}
		powerSetDesks = new Desk[length][];
		for(int i = 0; i < length; i++) {
			for(int index = 0; index < list.size(); index++) {
				if((i & (1 << index)) > 0) {
					powerSetDesks[i][index] = list.get(index);
				}
			}
		}
	}
	public void powerSetFiling(ArrayList<Filing> list) {
		int length = 2;
		for(int i = 1; i < list.size(); i++) {
			 length *= 2;
		}
		powerSetFilings = new Filing[length][];
		for(int i = 0; i < length; i++) {
			for(int index = 0; index < list.size(); index++) {
				if((i & (1 << index)) > 0) {
					powerSetFilings[i][index] = list.get(index);
				}
			}
		}
	}
	public void powerSetLamp(ArrayList<Lamp> list) {
		int length = 2;
		for(int i = 1; i < list.size(); i++) {
			 length *= 2;
		}
		powerSetLamps = new Lamp[length][];
		for(int i = 0; i < length; i++) {
			for(int index = 0; index < list.size(); index++) {
				if((i & (1 << index)) > 0) {
					powerSetLamps[i][index] = list.get(index);
				}
			}
		}
	}
	public void sort(String furniture, int parts) {
		if(furniture.equals("Chair")) {
			int buildableLength = 0;
			int index = 0;
			for(int row = 0; row < powerSetChairs.length; row++) {
				if(buildCheckChair(row, index, parts)) {
					buildableLength++;
				}
			}
			buildableChair = new Chair[buildableLength][];
			index = 0;
			for(int row = 0; row < powerSetChairs.length; row++) {
				if(buildCheckChair(row, index, parts)) {
					buildableChair[index] = new Chair[powerSetChairs[row].length];
					for(int column = 0; column < buildableChair[index].length; column++) {
						buildableChair[index][column] = powerSetChairs[row][column];
					}
				}
			}
			for(index = 0; index < buildableChair[index].length; index++) {
				checkPriceChair(index);
			}
		}
		if(furniture.equals("Desk")) {
			int buildableLength = 0;
			int index = 0;
			for(int row = 0; row < powerSetDesks.length; row++) {
				if(buildCheckDesk(row, index, parts)) {
					buildableLength++;
				}
			}
			buildableDesk = new Desk[buildableLength][];
			index = 0;
			for(int row = 0; row < powerSetDesks.length; row++) {
				if(buildCheckDesk(row, index, parts)) {
					buildableDesk[index] = new Desk[powerSetDesks[row].length];
					for(int column = 0; column < buildableDesk[index].length; column++) {
						buildableDesk[index][column] = powerSetDesks[row][column];
					}
				}
			}
			for(index = 0; index < buildableDesk[index].length; index++) {
				checkPriceDesk(index);
			}
		}
		if(furniture.equals("Lamp")) {
			int buildableLength = 0;
			int index = 0;
			for(int row = 0; row < powerSetLamps.length; row++) {
				if(buildCheckLamp(row, index, parts)) {
					buildableLength++;
				}
			}
			buildableLamp = new Lamp[buildableLength][];
			index = 0;
			for(int row = 0; row < powerSetLamps.length; row++) {
				if(buildCheckLamp(row, index, parts)) {
					buildableLamp[index] = new Lamp[powerSetLamps[row].length];
					for(int column = 0; column < buildableLamp[index].length; column++) {
						buildableLamp[index][column] = powerSetLamps[row][column];
					}
				}
			}
			for(index = 0; index < buildableLamp[index].length; index++) {
				checkPriceLamp(index);
			}
		}
		if(furniture.equals("Filing")) {
			int buildableLength = 0;
			int index = 0;
			for(int row = 0; row < powerSetFilings.length; row++) {
				if(buildCheckFiling(row, index, parts)) {
					buildableLength++;
				}
			}
			buildableFiling = new Filing[buildableLength][];
			index = 0;
			for(int row = 0; row < powerSetFilings.length; row++) {
				if(buildCheckFiling(row, index, parts)) {
					buildableFiling[index] = new Filing[powerSetFilings[row].length];
					for(int column = 0; column < buildableFiling[index].length; column++) {
						buildableFiling[index][column] = powerSetFilings[row][column];
					}
				}
			}
			for(index = 0; index < buildableFiling[index].length; index++) {
				checkPriceFiling(index);
			}
		}
	}
	public boolean buildCheckChair(int row, int index, int parts) {
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
	public boolean buildCheckDesk(int row, int index, int parts) {
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
	public boolean buildCheckLamp(int row, int index, int parts) {
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
	public boolean buildCheckFiling(int row, int index, int parts) {
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
	public int getOrderPriceChair(Chair[] order) {
		int price = 0;
		for(int index = 0; index < order.length; index++) {
			price += order[index].getPrice();
		}
		return price;
	}
	public int getOrderPriceFiling(Filing[] order) {
		int price = 0;
		for(int index = 0; index < order.length; index++) {
			price += order[index].getPrice();
		}
		return price;
	}
	public int getOrderPriceDesk(Desk[] order) {
		int price = 0;
		for(int index = 0; index < order.length; index++) {
			price += order[index].getPrice();
		}
		return price;
	}
	public int getOrderPriceLamp(Lamp[] order) {
		int price = 0;
		for(int index = 0; index < order.length; index++) {
			price += order[index].getPrice();
		}
		return price;
	}
}
