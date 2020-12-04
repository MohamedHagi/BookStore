package Bean;

import java.sql.Date;

public class Recipt {
	private int rid;
	private Date date;
	private int cust_id;
	private int address;
	private String paymentMethod;
	private int itemQuant;
	private int poi_ID;
	private double orderTotal;
	private int shippingID;

	public Recipt() {

	}

	public Recipt(Date date, int cust_id, int address, String paymentMethod, int itemQuant, int poi_ID,
			double orderTotal, int shippingID) {
		this.date = date;
		this.cust_id = cust_id;
		this.address = address;
		this.paymentMethod = paymentMethod;
		this.itemQuant = itemQuant;
		this.poi_ID = poi_ID;
		this.orderTotal = orderTotal;
		this.shippingID = shippingID;
	}

	
	
	public Recipt(int rid, Date date, int cust_id, int address, String paymentMethod, int itemQuant, int poi_ID,
			double orderTotal, int shippingID) {
		this.rid = rid;
		this.date = date;
		this.cust_id = cust_id;
		this.address = address;
		this.paymentMethod = paymentMethod;
		this.itemQuant = itemQuant;
		this.poi_ID = poi_ID;
		this.orderTotal = orderTotal;
		this.shippingID = shippingID;
	}

	public int getItemQuant() {
		return itemQuant;
	}

	public void setItemQuant(int itemQuant) {
		this.itemQuant = itemQuant;
	}

	public double getOrderTotal() {
		return orderTotal;
	}

	public void setOrderTotal(double orderTotal) {
		this.orderTotal = orderTotal;
	}

	public int getShippingID() {
		return shippingID;
	}

	public void setShippingID(int shippingID) {
		this.shippingID = shippingID;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCust_id() {
		return cust_id;
	}

	public void setCust_id(int cust_id) {
		this.cust_id = cust_id;
	}

	public int getAddress() {
		return address;
	}

	public void setAddress(int address) {
		this.address = address;
	}

	public String getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public int getPoi_ID() {
		return poi_ID;
	}

	public void setPoi_ID(int poi_ID) {
		this.poi_ID = poi_ID;
	}

}
