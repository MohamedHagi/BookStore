package ctrl;

import java.io.IOException;
import java.util.HashSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Book;
import Bean.CreditCard;
import Bean.Customers;
import Model.Model;
/**
 * Servlet implementation class Profile
 */
@WebServlet(asyncSupported = true, urlPatterns={"/Profile", "/Profile/*", "/BookStore/Profile"})
public class Profile extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Profile() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    @Override
    public void init(ServletConfig config) throws ServletException{
    	super.init(config);
    	ServletContext sc = getServletContext();
    	try {
    		sc.setAttribute("ModelInst", Model.getInstance());
    	}catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Model m = (Model) getServletContext().getAttribute("ModelInst");
		if(request.getParameter("btnSignin") != null) {
			System.out.println("ID: " + request.getParameter("id") + "Pass: " + request.getParameter("pass"));
			String ID = request.getParameter("id");
			String pass = request.getParameter("pass");
			String checkID = m.checkForempty(ID);
			String checkPass = m.checkForempty(pass);
			boolean res = m.verifyLogin(ID, pass);
			if((checkID.equals("no") || checkPass.equals("no"))) {
				if(checkID.equals("no") || checkPass.equals("no")) {
					request.setAttribute("Err", "Check for Empty field(s)");
				}
				try {
					String target = "./Login.jsp";
					request.getRequestDispatcher(target).forward(request, response);
					return;
				}catch(Exception e) {
					e.printStackTrace();
				}
			}else if(!res){
					request.setAttribute("Err", "Sorry the value is not in our database");
					try {
						String target = "./Login.jsp";
						request.getRequestDispatcher(target).forward(request, response);
						return;
					}catch(Exception e) {
						e.printStackTrace();
					}
			} 
			
			if(res){
				Customers c = m.PrintcustInfo(ID);
				request.setAttribute("fname", c.getFname());
				request.setAttribute("lname", c.getLname());
				request.setAttribute("date", c.getDateJoined());
				try {
					request.setAttribute("stNo", "Address: " + c.getAdd().getUnitNo());
					request.setAttribute("stName", c.getAdd().getStreet());
					request.setAttribute("prov", c.getAdd().getProvince());
					request.setAttribute("cont", c.getAdd().getCountry());
					CreditCard cc = m.PrintcustCreditCardInfo(ID);
					request.setAttribute("cardNo", "Credit Card: " + cc.getCardno());
					request.setAttribute("csv", cc.getCsv());
					request.setAttribute("cardfName", cc.getFname());
					request.setAttribute("cardlName", cc.getLnmae());
					request.setAttribute("expdate", cc.getExpirydate());
					request.setAttribute("profileName", request.getParameter("id"));
				}catch(NullPointerException e){
					request.setAttribute("add", "Add your address <button>Add Information</button>");
				}
					
				try {
					String target = "./Homeprof.jsp";
					request.getRequestDispatcher(target).forward(request, response);
					return;
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		if(request.getParameter("btnLogout") != null) {
			try {
				String target = "./Logout.jsp";
				request.getRequestDispatcher(target).forward(request, response);
				return;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		if(request.getParameter("cartBtn") != null) {
			try {
				String target = "./CheckOut.jsp";
				request.getRequestDispatcher(target).forward(request, response);
				return;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(request.getParameter("surfBtn") != null) {
			HashSet<Book> hs = m.retrieveBooks();
			try {
				request.setAttribute("hash", hs);
				String target = "./Surf.jsp";
				request.getRequestDispatcher(target).forward(request, response);
				return;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
