package Bean;

import javax.xml.bind.annotation.XmlType;

@XmlType(propOrder = {"bid", "title", "price", "category"})
public class Book {
	private int bid;
	private String title;
	private double price;
	private String category;
	private int quantity;
	
	public Book() {
		
	}
	
	public Book(int bid, String title, double price, String category, int quantity) {
		this.bid = bid;
		this.title = title;
		this.price = price;
		this.category = category;
		this.quantity = quantity;
	}

	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
