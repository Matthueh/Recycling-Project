
public class Filing {
	
	private String ID;
	private String type;
	private boolean rails;
	private boolean drawers;
	private boolean cabinet;
	private int price;
	private String manuID;
	
	/**
	 * Constructor for Filing
	 * @param ID to be set to ID	
	 * @param type to be set to type
	 * @param rails to be converted from char to boolean then set to rails
	 * @param drawers to be converted from char to boolean then set to drawers
	 * @param cabinet to be converted from char to boolean then set to cabinet
	 * @param price to be set to price
	 * @param manuID to be set to manuID
	 */
	Filing(String ID, String type, char rails, char drawers, char cabinet, int price, String manuID){
		this.setID(ID);
		this.setType(type);
		this.setPrice(price);
		this.setManuID(manuID);
		
		if(rails=='Y') {
			this.setRails(true);
		}
		else {
			this.setRails(false);
		}
		
		if(drawers=='Y') {
			this.setDrawers(true);
		}
		else {
			this.setDrawers(false);
		}
		
		if(cabinet=='Y') {
			this.setCabinet(true);
		}
		else {
			this.setCabinet(false);
		}
		
	}


	/**
	 * @return the iD
	 */
	public String getID() {
		return ID;
	}


	/**
	 * @param iD the iD to set
	 */
	public void setID(String iD) {
		ID = iD;
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
	 * @return the rails
	 */
	public boolean getRails() {
		return rails;
	}


	/**
	 * @param rails the rails to set
	 */
	public void setRails(boolean rails) {
		this.rails = rails;
	}


	/**
	 * @return the drawers
	 */
	public boolean getDrawers() {
		return drawers;
	}


	/**
	 * @param drawers the drawers to set
	 */
	public void setDrawers(boolean drawers) {
		this.drawers = drawers;
	}


	/**
	 * @return the cabinet
	 */
	public boolean getCabinet() {
		return cabinet;
	}


	/**
	 * @param cabinet the cabinet to set
	 */
	public void setCabinet(boolean cabinet) {
		this.cabinet = cabinet;
	}


	/**
	 * @return the price
	 */
	public int getPrice() {
		return price;
	}


	/**
	 * @param price the price to set
	 */
	public void setPrice(int price) {
		this.price = price;
	}


	/**
	 * @return the manuID
	 */
	public String getManuID() {
		return manuID;
	}


	/**
	 * @param manuID the manuID to set
	 */
	public void setManuID(String manuID) {
		this.manuID = manuID;
	}
}
