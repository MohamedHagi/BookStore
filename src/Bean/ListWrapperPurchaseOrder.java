package Bean;



import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Recipt")
public class ListWrapperPurchaseOrder {
	
	int cid;
	String status;
	String email;
	String card;
	
	public ListWrapperPurchaseOrder() {
		
	}
	
	
	public ListWrapperPurchaseOrder(int cid, String status, String email, String card) {
		super();
		this.cid = cid;
		this.status = status;
		this.email = email;
		this.card = card;
	}

	@XmlElement
	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
		this.cid = cid;
	}

	@XmlElement
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@XmlElement
	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@XmlElement
	public String getCard() {
		return card;
	}

	public void setCard(String card) {
		this.card = card;
	}
	
	
}
