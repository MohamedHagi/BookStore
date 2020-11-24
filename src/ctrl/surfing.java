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
 * Servlet implementation class surfing
 */
@WebServlet("/surfing")
public class surfing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public surfing() {
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
		String search = request.getParameter("search");
		String select = request.getParameter("slct");
		if(search != null && select.equals("All")) {
			HashSet<Book> hs = m.retrieveAllCategBooks(search);
			try {
				if(hs.size() == 0) {
					request.setAttribute("Er", "Sorry " + search + " is currently not in stock");
				}else {
					request.setAttribute("hash", hs);
				}
				String target = "./Surf.jsp";
				request.getRequestDispatcher(target).forward(request, response);
				return;
			}catch(Exception e) {
				e.printStackTrace();
			}
		}else if(search != null && (select.equals("Fiction") || select.equals("Science") || select.equals("Engineering"))){
			HashSet<Book> hs = m.retrieveCategBooks(select, search);
			try {
				if(hs.size() == 0) {
					request.setAttribute("Er", "Sorry " + search + " is currently not in stock");
				}else {
					request.setAttribute("hash", hs);
				}
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
