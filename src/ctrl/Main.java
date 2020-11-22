package ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().setAttribute("appName", this.getServletContext().getInitParameter("applicationName"));
		String login = request.getParameter("btnLogin");
		String register = request.getParameter("btnRegister");
		String surf = request.getParameter("btnSurf");
		if(login == null && register == null && surf == null) {
			System.out.println("login " + login + ", register" + register + ", surf" + surf);
			String target = "./Main.jsp";
			request.getRequestDispatcher(target).forward(request, response);
			return;
		}
		if(login != null) {
				String target = "./Login.jsp";
				request.getRequestDispatcher(target).forward(request, response);
				return;
		}
		
		if(register != null) {
			String target = "./Register.jsp";
			request.getRequestDispatcher(target).forward(request, response);
			return;
		}
		
		if(surf != null) {
			String target = "./Surf.jsp";
			request.getRequestDispatcher(target).forward(request, response);
			return;
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
