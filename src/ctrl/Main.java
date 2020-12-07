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
import Model.Model;

/**
 * Servlet implementation class Main
 */
@WebServlet(asyncSupported = true, urlPatterns = {"/Main", "/Main/*", "/Main/Login", "/Main/Register", "/Main/Surf"})
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Main() {
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
		this.getServletContext().setAttribute("appName", this.getServletContext().getInitParameter("applicationName"));
		Model m = (Model) getServletContext().getAttribute("ModelInst");
		String login = request.getParameter("btnLogin");
		String register = request.getParameter("btnRegister");
		String surf = request.getParameter("btnSurf");
		String admin = request.getParameter("btnAdmin");
		if(login == null && register == null && surf == null) {
			System.out.println("login " + login + ", register" + register + ", surf" + surf);
			String target = "./Main.jsp";
			request.getRequestDispatcher(target).forward(request, response);
			return;
		}
		if(login != null) {
				try {
					String target = "./Login.jsp";
					request.getRequestDispatcher(target).forward(request, response);
					return;
				}catch(Exception e) {
					e.printStackTrace();
				}
				
		}
		
		if(register != null) {
			try {
				String target = "./Register.jsp";
				request.getRequestDispatcher(target).forward(request, response);
				return;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		if(admin != null) {
			try {
				String target = "./adminLogin.jsp";
				request.getRequestDispatcher(target).forward(request, response);
				return;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		if(surf != null) {
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
