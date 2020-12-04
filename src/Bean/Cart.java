package Bean;

import java.util.ArrayList;

public class Cart {
	
	private int custID;
	ArrayList<CartItem> b;
	
	public Cart() {
		
	}
	
	public Cart(int custID) {
		this.custID = custID;
		this.b = new ArrayList<CartItem>();
	}


	public int getCustID() {
		return custID;
	}


	public void setCustID(int custID) {
		this.custID = custID;
	}


	public void setB(ArrayList<CartItem> b) {
		this.b = b;
	}


	public ArrayList<CartItem> getList() {
		return b;
	}
	
	public boolean addanIteaminASession(CartItem ci) {
		boolean result = false;
		int size_one = 0;
		this.b.add(ci);
		int size_two = this.b.size();
		if(size_two > size_one) {
			return true;
		}
		return result;
	}
	
	public void addFromSession(ArrayList<CartItem> cilist) {
		for(CartItem ci: cilist) {
			this.b.add(ci);
		}
	}
	
	public void add(CartItem b) {
		this.b.add(b);
	}
	
	public int getSize() {
		return this.b.size();
	}
	
	public void remove(CartItem b) {
		if(this.b.size() == 0) {
			throw new IllegalArgumentException();
		}else {
			this.b.remove(b);
		}
	}
	
	
}
