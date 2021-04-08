
public class Lamp {
	private String ID;
	private String type;
	private boolean base;
	private boolean bulb;
	private int price;
	private String manuID;
	public void setID(String ID) {
		this.ID = ID;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setBase(char base) {
		if(base == 'Y') {
			this.base = true;
		}
		else if(base == 'N') {
			this.base = false;
		}
	}
	public void setBulb(char bulb) {
		if(bulb == 'Y') {
			this.bulb = true;
		}
		else if(bulb == 'N') {
			this.bulb = false;
		}
	}
	public void setBase(boolean base) {
		this.base = base;
	}
	public void setBulb(boolean bulb) {
		this.bulb = bulb;
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
	public boolean getBase() {
		return this.base;
	}
	public boolean getBulb() {
		return this.bulb;
	}
	public int getPrice() {
		return this.price;
	}
	public String getManuID() {
		return this.manuID;
	}
	public Lamp(String ID, String type, char base, char bulb, int price, String manuID) {
		setID(ID);
		setType(type);
		setBase(base);
		setBulb(bulb);
		setPrice(price);
		setManuID(manuID);
	}
}
