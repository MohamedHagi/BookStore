package Bean;

import java.util.ArrayList;

public class Cart {
	
	private String cartID;
	ArrayList<Book> b;
	
	public Cart(String cartID) {
		this.cartID = cartID;
		this.b = new ArrayList<Book>();
	}

	public String getCartID() {
		return cartID;
	}

	public void setCartID(String cartID) {
		this.cartID = cartID;
	}

	public ArrayList<Book> getB() {
		return b;
	}

	public void setB(ArrayList<Book> b) {
		if(this.b.size() == 0) {
			for(int i  = 0; i < b.size(); i++) {
				this.b.add(b.get(i));
			}
		}else {
			for(int i = this.b.size(); i < b.size(); i++) {
				this.b.add(b.get(i));
			}
		}
	}
	
	public void add(Book b) {
		this.b.add(b);
	}
	
	public void remove(Book b) {
		if(this.b.size() == 0) {
			throw new IllegalArgumentException();
		}else {
			this.b.remove(b);
		}
	}
	
	
}
