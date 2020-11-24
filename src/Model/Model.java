package Model;

import java.util.HashSet;

import Bean.Book;
import Bean.Customers;
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
		String j = ld.custcid(email);
		Customers c = cpd.getTheprofdata(j);
		System.out.println("check if works " + c.getDateJoined() + " " + c.getFname() + " " + c.getEmail());
		return c;
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
}
