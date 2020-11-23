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
 * Servlet implementation class Reg
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Reg", "/Reg/*", "/BookStore/Reg" })
public class Reg extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public Reg() {
		super();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		ServletContext sc = getServletContext();
		try {
			sc.setAttribute("ModelInst", Model.getInstance());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		this.getServletContext().setAttribute("appName", this.getServletContext().getInitParameter("applicationName"));
		Model m = (Model) getServletContext().getAttribute("ModelInst");
		if (request.getParameter("btnRegister") != null) {
			request.setAttribute("cred", request.getParameter("id"));
			String id = request.getParameter("id");
			String firstName = request.getParameter("fname");
			String lastName = request.getParameter("lname");
			String pass = request.getParameter("pass");
			String passr = request.getParameter("passr");
			String checkId = m.checkForempty(id);
			String checkfirstName = m.checkForempty(firstName);
			String checklastName = m.checkForempty(lastName);
			String checkpass = m.checkForempty(pass);
			String checkpassr = m.checkForempty(passr);

			if (checkId.equals("no") || checkfirstName.equals("no") || checklastName.equals("no")
					|| checkpass.equals("no") || checkpassr.equals("no")) {
				request.setAttribute("Err", "Check for Empty field(s)");
				String path = "./Register.jsp";
				try {
					request.getRequestDispatcher(path).forward(request, response);
					return;
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				String path = "./Regconf.jsp";
				try {
					request.getRequestDispatcher(path).forward(request, response);
					return;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		if (request.getParameter("bLogin") != null) {
			String path = "./Login.jsp";
			request.getRequestDispatcher(path).forward(request, response);
			return;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
