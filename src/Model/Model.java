package Model;

import java.io.StringWriter;

import java.sql.Date;
import java.util.HashSet;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamResult;

import Bean.Book;
import Bean.Cart;
import Bean.CreditCard;
import Bean.Customers;
import Bean.ListWrapperBook;
import Bean.LoginType;
import DAO.BookDAO;
import DAO.CustProfileDAO;
import DAO.LoginDAO;

public class Model {
	
	private BookDAO bd;
	private LoginDAO ld;
	private CustProfileDAO cpd;
	public static Model ModelInstance;
	
	private Model() {
		
	}
	
	public static Model getInstance() throws ClassNotFoundException{
		if(ModelInstance == null) {
			ModelInstance = new Model();
			ModelInstance.bd = new BookDAO();
			ModelInstance.ld = new LoginDAO();
			ModelInstance.cpd = new CustProfileDAO();
		}
		return ModelInstance;
	}
	
	public HashSet<Book> retrieveBooks(){
		return bd.getBook();
	}
	
	public HashSet<Book> retrieveCategBooks(String categ, String tittle){
		return bd.getCategBook(categ, tittle);
	}
	
	public HashSet<Book> retrieveAllCategBooks(String tittle){
		return bd.getAllCategBook(tittle);
	}
	
	public boolean verifyLogin(String email, String pass) {
		boolean result = true;
		LoginType lt = ld.getLoginInfo(email, pass);
		if(lt.getEmail() == null && lt.getPassword() == null) {
			result = false;
			lt.setLocked(true);
		}else if(lt.getEmail().equals(email) && lt.getPassword().equals(pass)){
			result = true;
			lt.setLocked(false);
		}
		return result;
	}
	
	
	public Customers PrintcustInfo(String email) {
		int j = ld.custcid(email);
		Customers c = cpd.getTheprofdata(j);
		c.setCid(j);
		System.out.println(c.getCid());
		System.out.println("check if works " + c.getDateJoined() + " " + c.getFname() + " " + c.getEmail());
		return c;
	}
	
	public CreditCard PrintcustCreditCardInfo(String email) {
		int j = ld.custcid(email);
		CreditCard cc = cpd.getCreditCardInfo(j);
		return cc;
	}
	
	public boolean verifyRegisterID(String email) {
		boolean result = false;
		LoginType lt = ld.checkRegInfo(email);
		if(lt.getEmail() == null && lt.getPassword() == null) {
			result = false;
		}else if(lt.getEmail().equals(email)){
			result = true;
		}
		return result;
	}
	
	public boolean passMatch(String pass, String passr) {
		boolean result = false;
		if(pass.equals(passr)) {
			result = true;
		}
		return result;
	}
	
	public String checkForempty(String s) {
		String result = "yes";
		if(s.equals("")) {
			result = "no";
		}
		return result;
	}
	
	public boolean addCustRegistrationInfo(String email, String firstName, String lastName) {
		boolean result = false;
		long millis=System.currentTimeMillis();  
	    java.sql.Date date=new java.sql.Date(millis); 
	    int ret = ld.addToCustTable(email, firstName, lastName, date);
	    if(ret == 1) {
	    	return true;
	    }
	    return result;
	}
	
	public boolean addCustInfoInLoginTable(String email, String pass) {
		boolean result = false;
		int ret = ld.addTologinTable(email, pass);
		if(ret == 1) {
			return true;
		}
		return result;
	}
	
	/*
	 * Assigns a customer a cart upon registration 
	 * @returns true if successful 
	 * */
	public boolean addCustIntoCartTable(String email) {
		boolean result = false;
		int j = ld.custcid(email);
		int check = ld.assignCarttoCust(j);
		if(check == 1) {
			result = true;
			return result;
		}
		return result;
	}
	
	/*
	 * Adds customers address info in the address table
	 * @return true if successful
	 * */
	public boolean addCustInfoInAddTable(String street, String streetNo, String unitNo, int cid, String pcode, String city, String prov, String cont) {
		boolean result = false;
		int streetNom = Integer.parseInt(streetNo);
		int unitNom = Integer.parseInt(unitNo);
		int j = cpd.addAdd(street, streetNom, unitNom, pcode, city, prov, cont, cid);
		System.out.println(j);
		if(j == 1) {
			return true;
		}
		return result;
	}
	
	/*
	 * @param creditCard info
	 * used to add credit card details to the database
	 * @returns true if successful 
	 * */
	public boolean addCreditCardData(String cardNo, String csv, String fname, String lname, String date, int cid) {
		boolean result = false;
		Date d = Date.valueOf(date);
		int j = cpd.addCreditCard(cardNo, csv, fname, lname, d, cid);
		if(j == 1) {
			return true;
		}
		return result;
	}
	
	/*
	 * left for later
	 * */
	public String extract(String s) {
		char[] arr = s.toCharArray();
		arr[8] = '0';
		arr[9] = '1';
		return arr.toString();
	}
	
	/*
	 * Add to the cart and get the size of the list
	 * */
	public int addTocartGetSize(Book b) {
		int result = 0;
		Cart cart = new Cart();
		cart.add(b);
		result = cart.getSize();
		return result;
	}
	
	/*
	 * returns an xml string use it in the rest file
	 * */
	
	public String getXMLforRest(int bid) {
		String result = "";
		Book b = bd.getBook(bid);
		ListWrapperBook lwb = new ListWrapperBook(b.getBid(), b.getTitle(), b.getPrice(), b.getCategory());
		try {
			JAXBContext jc = JAXBContext.newInstance(lwb.getClass());
			Marshaller marsh = jc.createMarshaller();
			StringWriter sw = new StringWriter();
			marsh.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			marsh.marshal(lwb, new StreamResult(sw));
			result = sw.toString();
			System.out.println(result);
			return result;
		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}

}
