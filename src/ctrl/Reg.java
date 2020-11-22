package ctrl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Reg
 */
@WebServlet(asyncSupported = true, urlPatterns={"/Reg", "/Reg/*", "/BookStore/Reg"})
public class Reg extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Reg() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().setAttribute("appName", this.getServletContext().getInitParameter("applicationName"));
		if(request.getParameter("btnRegister") != null) {
			request.setAttribute("cred", request.getParameter("id"));
			String path = "./Regconf.jsp";
			request.getRequestDispatcher(path).forward(request, response);
			return;
		}
		if(request.getParameter("bLogin") != null) {
			String path = "./Login.jsp";
			request.getRequestDispatcher(path).forward(request, response);
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
