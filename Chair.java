
public class Chair {
	private String ID;
	
	private String type;
	
	private boolean legs;
	private boolean arms;
	private boolean seat;
	private boolean cushion;
	private int price;
	private String manuId;
	
	/**
	 * This is a constructor that will be used to set the object chair that was pulled from the data base.
	 * @param ID will be used for setter method to set ID class argument.
	 * @param type will be used for setter method to set type class argument.
	 * @param legs will be used for setter method to set legs class argument.
	 * @param arms will be used for setter method to set arms class argument.
	 * @param seat will be used for setter method to set seat class argument. 
	 * @param cushion will be used for setter method to set cushion argument.
	 * @param price will be used for setter method to set price argument.
	 * @param manuId will be used for setter method to set manuId argument. 
	 */
	public Chair(String ID, String type, char legs, char arms, char seat, char cushion, 
													int price, String manuId) {
		setID(ID);
		setType(type);
		setLegs(legs);
		setArms(arms);
		setSeat(seat);
		setCushion(cushion);
		setPrice(price);
		setManuId(manuId);
	}
	

	/**
	 * This is a setter method that will be used to set Id.
	 * @param ID will be the argument that places Id into class argument.
	 */
	public void setID(String ID) {
		this.ID = ID;
	}
	
	/**
	 * This is a setter method that will be used to set type.
	 * @param type will be the argument that places Id into class argument.
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	/**
	 * This is a setter method that will be used to set legs to a boolean value.
	 * @param legs will be the argument that we will check in order to place an argument 
	 * into class argument legs.
	 * 
	 */
	public void setLegs(char legs) {
		//This will check the char for leg in the database.
		//It will then put a boolean in legs whether it exists.
		if(legs == 'Y') {  
			this.legs = true;
		}
		else {
			this.legs = false;
		}
	}
	/**
	 * This is a setter method that will be used to set arms to a boolean value. 
	 * @param arms will be the argument that we will check in order to place an argument
	 * into class argument arms.
	 */
	
	public void setArms(char arms) {
		//This will check the char for arms in the database.
		//It will then put a boolean in arms whether it exists or not.
		if(arms == 'Y') {
			this.arms = true;
		}
		else {
			this.legs = false;
		}
	}
	
	/**
	 * This is a setter method that will be used to set seat to a boolean value.
	 * @param seat will be the argument that we will check in order to place an argument
	 * into class argument seat.
	 */
	public void setSeat(char seat) {
		//This will check the char for seat in the database.
		//It will then put a boolean in seat whether it exits or not.
		if(seat == 'Y') {
			this.seat = true;
		}
		else {
			this.seat = false;
		}
	}
	
	/**
	 * This is a setter method that will be used to set cushion to a boolean value.
	 * @param cushion will be the argument that we will check in order to place an argument
	 * into class argument cushion.
	 */
	public void setCushion(char cushion) {
		//This will check the char for cushion in the database.
		//It will then put a boolean in cushion whether it exists or not.
		if(cushion == 'Y') {
			this.cushion = true;
		}
		else {
			this.cushion = false;
		}	
	}
	
	/**
	 * This is a setter method that will be used to set price.
	 * @param price will be the argument that we will place an argument
	 * into class argument price.
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	
	/**
	 * This is a setter method that will be used to set manuId.
	 * @param manuId will be the argument that we will place an argument
	 * into class argument manuId
	 */
	public void setManuId(String manuId) {
		this.manuId = manuId;
	}
	
	/**
	 * This is a getter function for ID.
	 * @return Id of the chair we want.
	 */
	public String getId() {
		return this.ID;
	}
	/**
	 * This is a getter function for type.
	 * @return Type of chair it is.
	 */
	public String getType() {
		return this.type;
	}
	/**
	 * This is a getter function for legs.
	 * @return A boolean on if it has legs or not.
	 */
	public boolean getLegs() {
		return this.legs;
	}
	/**
	 * This is a getter function for arms.
	 * @return A boolean on if it has arms or not.
	 */
	public boolean getArms() {
		return this.arms;
	}
	/**
	 * This is a getter function for seat.
	 * @return A boolean on if it has a seat or not.
	 */
	public boolean getSeat() {
		return this.seat;
	}
	/**
	 * This is a getter function for cushion.
	 * @return A boolean on if it has a cushion or not.
	 */
	public boolean getCushion() {
		return this.cushion;
	}
	/**
	 * This is getter function for price.
	 * @return An integer of the price of the chair.
	 */
	public int getPrice() {
		return this.price;
	}
	/**
	 * This is a getter function for manuId.
	 * @return An Id for which manufacture it came from.
	 */
	public String getManuId() {
		return this.manuId;
	}
}
