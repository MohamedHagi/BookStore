package Bean;

import java.sql.Date;

public class CartItem {
	
	int addID;
	int productID;
	Date date;
	int addCartID;
	String bookTittle;
	double price;
	String category;
	
	public CartItem() {
		
	}
	
	public CartItem(int addID, int productID, Date date, int addCartID, String bookTittle, double price, String category) {
		this.addID = addID;
		this.productID = productID;
		this.date = date;
		this.addCartID = addCartID;
		this.bookTittle = bookTittle;
		this.price = price;
		this.category = category;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAddID() {
		return addID;
	}

	public void setAddID(int addID) {
		this.addID = addID;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getAddCartID() {
		return addCartID;
	}

	public void setAddCartID(int addCartID) {
		this.addCartID = addCartID;
	}

	public String getBookTittle() {
		return bookTittle;
	}

	public void setBookTittle(String bookTittle) {
		this.bookTittle = bookTittle;
	}
	
}
