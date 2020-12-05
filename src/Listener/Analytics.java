package Listener;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Book;
import Bean.PurchaseOrder;
import Bean.TopTen;
import Model.Model;

/**
 * Servlet implementation class Analytics
 */
@WebServlet("/Analytics")
public class Analytics extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Analytics() {
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
		this.getServletContext().setAttribute("appName", this.getServletContext().getInitParameter("applicationName"));
		Model m = (Model) getServletContext().getAttribute("ModelInst");
		String email = request.getParameter("email");
		String pass = request.getParameter("passwor");
		if(request.getParameter("submit") != null) {
			if(m.getValidationOfAdminInput(email, pass)) {
				String path = "./AdminArea.jsp";
				request.getRequestDispatcher(path).forward(request, response);
				return;
			}else {
				request.setAttribute("Error", "Please check entered input fields");
				String path = "./adminLogin.jsp";
				request.getRequestDispatcher(path).forward(request, response);
				return;
			}
		}
		
		if(request.getParameter("ttbtn") != null) {
			ArrayList<TopTen> hs = m.getTopTenInfo();
			request.setAttribute("still", hs);
			try {
				String path = "./analytics.jsp";
				request.getRequestDispatcher(path).forward(request, response);
				return;
			}catch(Exception e){
				e.printStackTrace();
			}
		}
		
		
		if(request.getParameter("rptbtn") != null) {
			String month = request.getParameter("month");
			String year = request.getParameter("year");
			ArrayList<Book> al = m.getTheBooksSoldEachMonth(month, year);
			if(al != null) {
				request.setAttribute("list", al);
				String path = "./AdminArea.jsp";
				request.getRequestDispatcher(path).forward(request, response);
				return;
			}else {
				request.setAttribute("mistake", "please verify input entered");
				String path = "./AdminArea.jsp";
				request.getRequestDispatcher(path).forward(request, response);
				return;
			}
		}
		
		
		
		if(request.getParameter("pobtn") != null) {
			String poid = request.getParameter("poid");
			PurchaseOrder po = m.getTheOrderQuerry(poid);
			if(po != null) {
				request.setAttribute("custEmail", po.getEmail());
				request.setAttribute("custID", po.getcID());
				request.setAttribute("custCard", po.getCard());
				request.setAttribute("custStatus", po.getStat());
			}else {
				request.setAttribute("ch", "Please check value entered");
			}
			
			try {
				String path = "./AdminArea.jsp";
				request.getRequestDispatcher(path).forward(request, response);
				return;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
			try {
				String path = "./adminLogin.jsp";
				request.getRequestDispatcher(path).forward(request, response);
				return;
			}catch(Exception e) {
				e.printStackTrace();
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
