package ctrl;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
			if(checkID.equals("no") || checkPass.equals("no")) {
				request.setAttribute("Err", "Check for Empty field(s)");
				String target = "./Login.jsp";
				request.getRequestDispatcher(target).forward(request, response);
				return;
			}else {
				request.setAttribute("profileName", request.getParameter("id"));
				String target = "./Homeprof.jsp";
				request.getRequestDispatcher(target).forward(request, response);
				return;
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
