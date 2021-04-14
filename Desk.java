
public class Desk {
	private String ID;
	private String type;
	private boolean legs;
	private boolean top;
	private int price;
	private String manuID;
	/**
	 * setter method for ID member variable
	 * @param ID argument to set ID member variable to
	 */
	public void setID(String ID) {
		this.ID = ID;
	}
	/**
	 * setter method for type member variable
	 * @param type argument to set type member variable to
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * setter method for legs member variable
	 * 'Y' corresponds to true and 'N' to false
	 * @param legs argument to set legs member variable to
	 */
	public void setLegs(char legs) {
		if(legs == 'Y') {
			this.legs = true;
		}
		else if(legs == 'N') {
			this.legs = false;
		}
	}
	/**
	 * setter method for top member variable
	 * 'Y' corresponds to true and 'N' to false
	 * @param top argument to set top member variable
	 */
	public void setTop(char top) {
		if(top == 'Y') {
			this.top = true;
		}
		else if(top == 'N') {
			this.top = false;
		}
	}
	/**
	 * setter method for legs member variable
	 * @param legs argument to set legs member variable
	 */
	public void setLegs(boolean legs) {
		this.legs = legs;
	}
	/**
	 * setter method for top member variable
	 * @param top argument to set top variable
	 */
	public void setTop(boolean top) {
		this.top = top;
	}
	/**
	 * setter method for price member variable
	 * @param price argument to set price member variable
	 */
	public void setPrice(int price) {
		this.price = price;
	}
	/**
	 * setter method for manuID member variable
	 * @param manuID argument to set manuID member variable
	 */
	public void setManuID(String manuID) {
		this.manuID = manuID;
	}
	/**
	 * getter method for ID member variable
	 * @return ID of desk object
	 */
	public String getID() {
		return this.ID;
	}
	/**
	 * getter method for type member variable
	 * @return type of desk object
	 */
	public String getType() {
		return this.type;
	}
	/**
	 * getter method for legs member variable
	 * @return legs of desk object
	 */
	public boolean getLegs() {
		return this.legs;
	}
	/**
	 * getter method for top member variable
	 * @return top of desk object
	 */
	public boolean getTop() {
		return this.top;
	}
	/**
	 * getter method for price member variable
	 * @return price of desk object
	 */
	public int getPrice() {
		return this.price;
	}
	/**
	 * getter method for manuID member variable
	 * @return manuID of desk object
	 */
	public String getManuID() {
		return this.manuID;
	}
	/**
	 * constructor for Desk object
	 * @param ID 		argument ID for setter method
	 * @param type 		argument for type setter method
	 * @param legs 		argument for legs setter method
	 * @param top		argument for top setter method
	 * @param price		argument for price setter method
	 * @param manuID	argument for manuID setter method
	 */
	public Desk(String ID, String type, char legs, char top, int price, String manuID) {
		setID(ID);
		setType(type);
		setLegs(legs);
		setTop(top);
		setPrice(price);
		setManuID(manuID);
	}	
}
