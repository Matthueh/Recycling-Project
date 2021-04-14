
public class Lamp {
	private String ID;
	private String type;
	private boolean base;
	private boolean bulb;
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
	 * setter method for base member variable
	 * 'Y' corresponds to true and 'N' to false
	 * @param base argument to set base member variable
	 */
	public void setBase(char base) {
		if(base == 'Y') {
			this.base = true;
		}
		else if(base == 'N') {
			this.base = false;
		}
	}
	/**
	 * setter method for bulb member variable
	 * 'Y' corresponds to true and 'N' to false
	 * @param bulb argument to set bulb member variable
	 */
	public void setBulb(char bulb) {
		if(bulb == 'Y') {
			this.bulb = true;
		}
		else if(bulb == 'N') {
			this.bulb = false;
		}
	}
	/**
	 * setter method for base member variable
	 * @param base argument to set base member variable
	 */
	public void setBase(boolean base) {
		this.base = base;
	}
	/**
	 * setter method for bulb member variable
	 * @param bulb argument to set bulb member variable
	 */
	public void setBulb(boolean bulb) {
		this.bulb = bulb;
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
	 * getter method for base member variable
	 * @return base of desk object
	 */
	public boolean getBase() {
		return this.base;
	}
	/**
	 * getter method for bulb member variable
	 * @return bulb of desk object
	 */
	public boolean getBulb() {
		return this.bulb;
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
	 * constructor for Lamp object
	 * @param ID 		argument ID for setter method
	 * @param type 		argument for type setter method
	 * @param base 		argument for base setter method
	 * @param bulb		argument for bulb setter method
	 * @param price		argument for price setter method
	 * @param manuID	argument for manuID setter method
	 */
	public Lamp(String ID, String type, char base, char bulb, int price, String manuID) {
		setID(ID);
		setType(type);
		setBase(base);
		setBulb(bulb);
		setPrice(price);
		setManuID(manuID);
	}
}
