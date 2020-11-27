package Bean;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name="Book")
public class ListWrapperBook {
	
	private int bid;
	private String tittle; 
	private double price;
	private String category;
	
	public ListWrapperBook() {
		
	}

	public ListWrapperBook(int bid, String tittle, double price, String category) {
		super();
		this.bid = bid;
		this.tittle = tittle;
		this.price = price;
		this.category = category;
	}

	@XmlElement
	public int getBid() {
		return bid;
	}

	public void setBid(int bid) {
		this.bid = bid;
	}

	@XmlElement
	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	@XmlElement
	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	@XmlElement
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}
	
}
