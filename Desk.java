public class Desk {
	private String ID;
	private String type;
	private boolean legs;
	private boolean top;
	private boolean drawer;
	private int price;
	private String manuID;
	
	public void setID(String ID) {
		this.ID = ID;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setLegs(char legs) {
		if(legs == 'Y') {
			this.legs = true;
		}
		else if(legs == 'N') {
			this.legs = false;
		}
	}
	public void setTop(char top) {
		if(top == 'Y') {
			this.top = true;
		}
		else if(top == 'N') {
			this.top = false;
		}
	}
	public void setDrawer(char drawer) {
		if(drawer == 'Y') {
			this.drawer = true;
		}
		if(drawer == 'N') {
			this.drawer = false;
		}
	}
	public void setLegs(boolean legs) {
		this.legs = legs;
	}
	public void setTop(boolean top) {
		this.top = top;
	}
	public void setDrawer(boolean drawer) {
		this.drawer = drawer;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setManuID(String manuID) {
		this.manuID = manuID;
	}
	public String getID() {
		return this.ID;
	}
	public String getType() {
		return this.type;
	}
	public boolean getLegs() {
		return this.legs;
	}
	public boolean getTop() {
		return this.top;
	}
	public boolean getDrawer() {
		return this.drawer;
	}
	public int getPrice() {
		return this.price;
	}
	public String getManuID() {
		return this.manuID;
	}
	public Desk(String ID, String type, char legs, char top, char drawer, int price, String manuID) {
		setID(ID);
		setType(type);
		setLegs(legs);
		setTop(top);
		setDrawer(drawer);
		setPrice(price);
		setManuID(manuID);
	}	
}