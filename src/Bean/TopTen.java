package Bean;

public class TopTen {
	
	private String bookTittle;
	private int total;
	
	public TopTen() {
		
	}
	
	public TopTen(String bookTittle, int total) {
		this.bookTittle = bookTittle;
		this.total = total;
	}
	
	public String getBookTittle() {
		return bookTittle;
	}
	public void setBookTittle(String bookTittle) {
		this.bookTittle = bookTittle;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	
	
}
