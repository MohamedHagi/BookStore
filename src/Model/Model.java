package Model;

import java.io.StringWriter;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.transform.stream.StreamResult;

import Bean.Admin;
import Bean.Book;
import Bean.Cart;
import Bean.CartItem;
import Bean.CreditCard;
import Bean.Customers;
import Bean.ListWrapperBook;
import Bean.LoginType;
import Bean.PurchaseOrder;
import Bean.Review;
import Bean.ShippingCountryInfo;
import Bean.Status;
import Bean.TopTen;
import DAO.AdminDAO;
import DAO.BookDAO;
import DAO.CartDAO;
import DAO.CustProfileDAO;
import DAO.LoginDAO;
import DAO.ProcessOrderDAO;
import DAO.ReviewDAO;
import DAO.ShippingDAO;

public class Model {

	private BookDAO bd;
	private LoginDAO ld;
	private CustProfileDAO cpd;
	private CartDAO cartDAO;
	private ShippingDAO sd;
	private ReviewDAO rd;
	private ProcessOrderDAO pod;
	private AdminDAO adminDAO;
	private static int failedQuerryCounter = 1;
	public static Model ModelInstance;

	private Model() {

	}

	public static Model getInstance() throws ClassNotFoundException {
		if (ModelInstance == null) {
			ModelInstance = new Model();
			ModelInstance.bd = new BookDAO();
			ModelInstance.ld = new LoginDAO();
			ModelInstance.cpd = new CustProfileDAO();
			ModelInstance.cartDAO = new CartDAO();
			ModelInstance.sd = new ShippingDAO();
			ModelInstance.rd = new ReviewDAO();
			ModelInstance.pod = new ProcessOrderDAO();
			ModelInstance.adminDAO = new AdminDAO();
		}
		return ModelInstance;
	}

	public HashSet<Book> retrieveBooks() {
		return bd.getBook();
	}

	/*
	 * get books of specific category
	 */
	public HashSet<Book> retrieveCategBooks(String categ, String tittle) {
		return bd.getCategBook(categ, tittle);
	}

	/*
	 * get books of all category
	 */
	public HashSet<Book> retrieveAllCategBooks(String tittle) {
		return bd.getAllCategBook(tittle);
	}

	public boolean verifyLogin(String email, String pass) {
		boolean result = true;
		LoginType lt = ld.getLoginInfo(email, pass);
		if (lt.getEmail() == null && lt.getPassword() == null) {
			result = false;
			lt.setLocked(true);
		} else if (lt.getEmail().equals(email) && lt.getPassword().equals(pass)) {
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
		if (lt.getEmail() == null && lt.getPassword() == null) {
			result = false;
		} else if (lt.getEmail().equals(email)) {
			result = true;
		}
		return result;
	}

	public boolean passMatch(String pass, String passr) {
		boolean result = false;
		if (pass.equals(passr)) {
			result = true;
		}
		return result;
	}

	public String checkForempty(String s) {
		String result = "yes";
		if (s.equals("")) {
			result = "no";
		}
		return result;
	}

	public boolean addCustRegistrationInfo(String email, String firstName, String lastName) {
		boolean result = false;
		long millis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(millis);
		int ret = ld.addToCustTable(email, firstName, lastName, date);
		if (ret == 1) {
			return true;
		}
		return result;
	}

	/*
	 * Add customer info into the SQL login table
	 */
	public boolean addCustInfoInLoginTable(String email, String pass) {
		boolean result = false;
		int ret = ld.addTologinTable(email, pass);
		if (ret == 1) {
			return true;
		}
		return result;
	}

	/*
	 * Assigns a customer a cart upon registration
	 * 
	 * @returns true if successful
	 */
	public boolean addCustIntoCartTable(String email) {
		boolean result = false;
		int j = ld.custcid(email);
		int check = ld.assignCarttoCust(j);
		if (check == 1) {
			result = true;
			return result;
		}
		return result;
	}

	/*
	 * get the cart ID
	 */
	public int getCartID(String email) {
		int result = cartDAO.getCustCartID(email);
		return result;
	}

	/*
	 * Add the cart from the session into customers cart
	 */
	public int AddSessCartToTheCart(Cart c, int cartID) {
		int result = 0;
		int result_one = 0;
		int result_two = 0;
		for (int i = 0; i < c.getList().size(); i++) {
			CartItem ci = c.getList().get(i);
			long mils = System.currentTimeMillis();
			java.sql.Date date = new java.sql.Date(mils);
			result_one = cartDAO.InsertIntoCartItem(ci.getProductID(), date, cartID, ci.getBookTittle(), ci.getPrice(),
					ci.getCategory());
			result_two = bd.deleteFromTable(ci.getProductID());
			if (result_one == 0 || result_two == 0) {
				break;
			}
		}
		if (result_one == 1 && result_two == 1) {
			result = 1;
		}
		return result;
	}

	/*
	 * Insert book into the cart item and also see if the quantity is enough Remove
	 * from book table
	 */
	public int insertItemIntoCart(String productID, int addcartID, String bookTittle, String bookPrice,
			String category) {
		int result = 0;
		int result_one = 0;
		int result_two = 0;
		int pID = Integer.parseInt(productID);
		double bPrice = Double.parseDouble(bookPrice);
		long mils = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(mils);
		result_one = cartDAO.InsertIntoCartItem(pID, date, addcartID, bookTittle, bPrice, category);
		result_two = bd.deleteFromTable(pID);
		if (result_one == 1 && result_two == 1) {
			result = 1;
		}
		return result;
	}

	/*
	 * Remove from the cart and into the book Table
	 */
	public int removeFromtheCart(String productID, String tittle, String addID, String price, String category) {
		int result = 0;
		int result_one = 0;
		int result_two = 0;
		int pID = Integer.parseInt(productID);
		int aID = Integer.parseInt(addID);
		Double bookPrice = Double.parseDouble(price);
		System.out.println("From model " + pID + " " + aID + " " + bookPrice + " " + tittle + category);
		result_two = bd.InsertIntoBookTable(pID, tittle, bookPrice, category);
		result_one = cpd.deleteFromCartItemTable(aID);
		if (result_one == 1 && result_two == 2) {
			result = 1;
		}
		return result;
	}

	/*
	 * Adds customers address info in the address table
	 * 
	 * @return true if successful
	 */
	public boolean addCustInfoInAddTable(String street, String streetNo, String unitNo, int cid, String pcode,
			String city, String prov, String cont) {
		boolean result = false;
		int streetNom = Integer.parseInt(streetNo);
		int unitNom = 0;
		if(unitNo.equals("")) {
			unitNom = 0;
		}else {
			unitNom = Integer.parseInt(unitNo);
		}
		int j = cpd.addAdd(street, streetNom, unitNom, pcode, city, prov, cont, cid);
		System.out.println(j);
		if (j == 1) {
			return true;
		}
		return result;
	}

	/*
	 * @param creditCard info used to add credit card details to the database
	 * 
	 * @returns true if successful
	 */
	public boolean addCreditCardData(String cardNo, String csv, String fname, String lname, String date, int cid) {
		boolean result = false;
		Date d = Date.valueOf(date);
		int j = cpd.addCreditCard(cardNo, csv, fname, lname, d, cid);
		if (j == 1) {
			return true;
		}
		return result;
	}

	/*
	 * left for later
	 */
	public String extract(String s) {
		char[] arr = s.toCharArray();
		arr[8] = '0';
		arr[9] = '1';
		return arr.toString();
	}

	/*
	 * Initialize the cart from cart class and return to the surf page for session
	 * storage
	 */
	public ArrayList<CartItem> getTheArrayListOfCart() {
		Cart c = new Cart();
		return c.getList();
	}

	/*
	 * print the cart and get the size of the list
	 */
	public ArrayList<CartItem> GetCartItems(String email) {
		int cid = ld.custcid(email);
		Cart c = new Cart();
		ArrayList<CartItem> li = cpd.getTheUsersCart(cid);
		c.setB(li);
		ArrayList<CartItem> nc = c.getList();
		return nc;
	}

	/*
	 * Get the customers cart total
	 */
	public double GetCartTotal(String email) {
		double result = 0.0;
		try {
			result = cpd.getCartTotal(email);
		} catch (NullPointerException e) {
			result = 0.0;
		}
		return result;
	}

	/*
	 * returns shipping info for a specific country
	 * 
	 */
	public ShippingCountryInfo getDilieveryPrices(String email) {
		ShippingCountryInfo sci = new ShippingCountryInfo();
		sci = sd.getTheShippingPrice(email);
		return sci;
	}

	/*
	 * Add the order total
	 */
	public Double returnCartTotal(double total, double tax, double tariff, double shipping) {
		double result = 0;
		result = total + tax + tariff + shipping;
		return result;
	}

	/*
	 * Get the review for the book
	 */
	public ArrayList<Review> getTheReview(String tittle) {
		ArrayList<Review> result = new ArrayList<Review>();
		result = rd.getTheReview(tittle);
		return result;
	}

	/*
	 * Insert into review
	 * */
	public boolean insertIntoReview(String comment, String custID, String bookTittle) {
		boolean result = false;
		long milis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(milis);
		if(comment.length() > 149) {
			return false;
		}
		int k = rd.InsertReviewIntoDB(comment, custID, bookTittle, date);
		if(k == 1) {
			return true;
		}
		return result;
	}
	
	
	/*
	 * returns an xml string use it in the rest file
	 */

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

	/*
	 * returns true if the card is not expired
	 */
	public boolean chekExpiry(Date date) {
		boolean result = true;
		long millis = System.currentTimeMillis();
		java.sql.Date todaysDate = new java.sql.Date(millis);
		if (todaysDate.after(date)) {
			result = false;
			return result;
		}
		return result;
	}

	/*
	 * hard code the failed payments
	 */
	public Status failTheThirdPayment(int num) {
		Status result = Status.PROCESSED;
		if (num % 3 == 0) {
			result = Status.DENIED;
			return result;
		}
		return result;
	}

	/*
	 * checks if purchase is valid ands the item to purchase order list
	 */
	public String PurchaseOrderQueries(String email, String cardno, ArrayList<CartItem> al) {
		String result = "";
		int cust_id = ld.custcid(email);
		long milis = System.currentTimeMillis();
		java.sql.Date date = new java.sql.Date(milis); 
		Status st = failTheThirdPayment(failedQuerryCounter);
		System.out.println(failedQuerryCounter);
		failedQuerryCounter++;
		int poid = 0;
		System.out.println(st.toString());
		if (st == Status.DENIED) {
			if (pod.InsertIntoProcessedOrder(cust_id, email, st.toString(), cardno, date) == 1) {
				result = "Sorry unable to process your Querry please call 1-800-500-200";
				return result;
			} else {
				return "Server Error Please call tech Support!";
			}
		} else {
			int ans = pod.InsertIntoProcessedOrder(cust_id, email, st.toString(), cardno, date);
			if (ans == 1) {
				poid = pod.getProcessID(email);
				System.out.println("Array list size Model line 421 " + al.size());
				for (int i = 0; i < al.size(); i++) {
					int value = pod.insertInToPOItem(al.get(i).getProductID(), al.get(i).getBookTittle(), poid,
							al.get(i).getPrice());
					System.out.println(
							al.get(i).getAddID() + " " + al.get(i).getAddCartID() + " " + al.get(i).getProductID() + " "
									+ al.get(i).getBookTittle() + " " + poid + " " + al.get(i).getPrice());
					if (value == 0) {
						result = "sorry an error occured";
						return result;
					} else {
						int val = pod.deleteFromCartItem(al.get(i).getAddID());
						if (val == 1) {
							result = "success";
						} else {
							result = "sorry an error occured";
							return result;
						}
					}
				}
			}
		}

		return result;
	}

	/*
	 * Validate the strings for credit card on checkout page
	 */
	public boolean checkTheString(String value, String valueTwo, String valueThree, String valueFour) {
		if (value.equals("") || valueTwo.equals("") || valueThree.equals("") || valueFour.equals("")) {
			return false;
		} else {
			return true;
		}
	}

	/*
	 * Validate the strings for address on the homeprof page
	 */
	public boolean checkTheString(String sName, String sNum, String postCode, String city, String state,
			String cont) {
		if (sName.equals("") || sName.equals("") || sNum.equals("") || postCode.equals("")
				|| city.equals("") || state.equals("") || cont.equals("")) {
			return false;
		} else {
			return true;
		}
	}
	
	
	/*
	 * check the strings for address form
	 * */
	public boolean checkTheString(String cNum, String cCsv, String cFncme, String cLname, String expDate) {
		if (cNum.equals("") || cCsv.equals("") || cFncme.equals("") || cLname.equals("")
				|| expDate.equals("")) {
			return false;
		} else {
			return true;
		}
	}
	
	
	/*
	 * Send data to the analytics
	 * */
	public ArrayList<TopTen> getTopTenInfo(){
		return adminDAO.getTopTen();
	}

	/*
	 * Admin Login Confirmation
	 * */
	public boolean getValidationOfAdminInput(String email, String lname) {
		boolean result = true;
		Admin a = new Admin();
		try {
			if(email.equals("") || lname.equals("")) {
				return false;
			}
			a = adminDAO.getAdmin(email, lname);
			if(a.getEmail().equals(email) && a.getLname().equals(lname)) {
				return true;
			}
		}catch(NullPointerException e) {
			return false;
		}
		return result;
	}
	
	/*
	 * prints customer querry
	 * */
	
	public PurchaseOrder getTheOrderQuerry(String poid) {
		int pid = Integer.parseInt(poid);
		PurchaseOrder po = new PurchaseOrder();
		try {
			po = pod.getTheOrderQuerry(pid);
		}catch(NullPointerException e) {
			return null;
		}
		return po;
	}
	
	/*
	 * get the books sold each month
	 * */
	public ArrayList<Book> getTheBooksSoldEachMonth(String month, String year){
		if(month.equals("") || year.equals("")) {
			return null;
		}
		int m = Integer.parseInt(month);
		int y = Integer.parseInt(year);
		ArrayList<Book> result = new ArrayList<Book>();
		try {
			result = adminDAO.getTheMonthlyBooks(m, y);
			return result;
		}catch(NullPointerException e) {
			return null;
		}
	}
	
	
}
