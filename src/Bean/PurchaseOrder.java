package Bean;

import java.sql.Date;

public class PurchaseOrder {
	
	private int poId;
	private int cID;
	private int shipID;
	private int cartID;
	private String email;
	private Status st;
	private String stat;
	private String card;
	private Date date;
	
	public PurchaseOrder() {
		
	}
	
	public PurchaseOrder(int poId, Date date, String card, String stat, int cID, String email, int shipID, Status st, int cartID) {
		this.poId = poId;
		this.cID = cID;
		this.email = email;
		this.shipID = shipID;
		this.st = st;
		this.cartID = cartID;
		this.stat = stat;
		this.card = card;
		this.date = date;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}

	public String getStat() {
		return stat;
	}

	public void setStat(String stat) {
		this.stat = stat;
	}

	public int getCartID() {
		return cartID;
	}

	public void setCartID(int cartID) {
		this.cartID = cartID;
	}

	public int getPoId() {
		return poId;
	}

	public void setPoId(int poId) {
		this.poId = poId;
	}

	public int getcID() {
		return cID;
	}

	public void setcID(int cID) {
		this.cID = cID;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getShipID() {
		return shipID;
	}

	public void setShipID(int cartID) {
		this.shipID = cartID;
	}

	public Status getSt() {
		return st;
	}

	public void setSt(Status st) {
		this.st = st;
	}
	
	
}
