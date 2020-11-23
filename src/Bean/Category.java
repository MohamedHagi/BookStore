package Bean;

public class Category {
	
	private Book b;
	private String c;
	
	public Category(Book b, String c) {
		this.b = b;
		if(c.equals("Science") || c.equals("Engineering") || c.equals("Fiction")) {
			this.c = c;
		}
	}

	public Book getB() {
		return b;
	}

	public void setB(Book b) {
		this.b = b;
	}

	public String getC() {
		return c;
	}

	public void setC(String c) {
		if(c.equals("Science") || c.equals("Engineering") || c.equals("Fiction")) {
			this.c = c;
		}
	}
}
