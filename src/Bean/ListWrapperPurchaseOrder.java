package Bean;

import java.sql.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="Recipt")
public class ListWrapperPurchaseOrder {
	
	int poid;
	Date date;
	String bookTittle;
	double price;
	public ListWrapperPurchaseOrder() {
		
	}
	
	
}
