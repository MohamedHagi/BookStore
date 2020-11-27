package Bean;

import java.util.ArrayList;

public class Cart {
	
	private int custID;
	ArrayList<Book> b;
	
	public Cart() {
		
	}
	
	public Cart(int custID) {
		this.custID = custID;
		this.b = new ArrayList<Book>();
	}


	public int getCustID() {
		return custID;
	}


	public void setCustID(int custID) {
		this.custID = custID;
	}


	public ArrayList<Book> getB() {
		return b;
	}


	public void setB(ArrayList<Book> b) {
		this.b = b;
	}


	public ArrayList<Book> getList() {
		return b;
	}

	public void addFromSession(ArrayList<Book> blist) {
		for(Book book: blist) {
			this.b.add(book);
		}
	}
	
	public void add(Book b) {
		this.b.add(b);
	}
	
	public int getSize() {
		return this.b.size();
	}
	
	public void remove(Book b) {
		if(this.b.size() == 0) {
			throw new IllegalArgumentException();
		}else {
			this.b.remove(b);
		}
	}
	
	
}
