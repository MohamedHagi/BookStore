package Bean;

public class PurchaseOrder {
	
	private int poId;
	private int cID;
	private int reciptID;
	private int shipID;
	private int cartID;
	private String email;
	private Status st;
	
	public PurchaseOrder() {
		
	}
	
	public PurchaseOrder(int poId, int cID, String email, int reciptID, int shipID, Status st, int cartID) {
		this.poId = poId;
		this.cID = cID;
		this.email = email;
		this.reciptID = reciptID;
		this.shipID = shipID;
		this.st = st;
		this.cartID = cartID;
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

	public int getReciptID() {
		return reciptID;
	}

	public void setReciptID(int reciptID) {
		this.reciptID = reciptID;
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
