package ctrl;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.CreditCard;
import Bean.Customers;
import Model.Model;

/**
 * Servlet implementation class AddInfo
 */
@WebServlet("/AddInfo")
public class AddInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public AddInfo() {
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
		Model m = (Model) getServletContext().getAttribute("ModelInst");
		if (request.getParameter("ccinfo") != null) {
			String email = request.getParameter("email");
			Customers c = m.PrintcustInfo(email);
			String sNum = request.getParameter("streetNumber");
			String sName = request.getParameter("streetName");
			String unit = request.getParameter("unitNo");
			String postCode = request.getParameter("postcode");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String cont = request.getParameter("country");
			String cNum = request.getParameter("cNumber");
			String cCsv = request.getParameter("csv");
			String cFncme = request.getParameter("fname");
			String cLname = request.getParameter("lname");
			String expDate = request.getParameter("expdate");
			// boolean value = m.checkTheString(sName, sNum, postCode, city, state, cont);
			// boolean valuTwo = m.checkTheString(cNum, cCsv, cFncme, cLname, expDate);
			System.out.println(email + " " + c.getCid() + " " + sName + " " + sNum + 
					" " + unit +" " + postCode + " " + city + " " 
					+  state + " " +  cont + " " + cNum + " " + cCsv
					+ " " + cFncme + " " + cLname + " " + expDate
					);
			
			boolean ret = m.addCustInfoInAddTable(sName, sNum, unit, c.getCid(), postCode, city, state, cont);
			boolean retTwo = m.addCreditCardData(cNum, cCsv, cFncme, cLname, expDate, c.getCid());
			if (ret && retTwo) {
				Customers cTwo = m.PrintcustInfo(email);
				request.setAttribute("fname", cTwo.getFname());
				request.setAttribute("lname", cTwo.getLname());
				request.setAttribute("date", cTwo.getDateJoined());
				try {
					request.setAttribute("stNo", "Address: " + cTwo.getAdd().getUnitNo());
					request.setAttribute("stName", cTwo.getAdd().getStreet());
					request.setAttribute("prov", cTwo.getAdd().getProvince());
					request.setAttribute("cont", cTwo.getAdd().getCountry());
					CreditCard cc = m.PrintcustCreditCardInfo(email);
					request.setAttribute("cardNo", "Credit Card: " + cc.getCardno());
					request.setAttribute("csv", cc.getCsv());
					request.setAttribute("cardfName", cc.getFname());
					request.setAttribute("cardlName", cc.getLnmae());
					request.setAttribute("expdate", cc.getExpirydate());
					request.setAttribute("profileName", request.getParameter("id"));
				} catch (NullPointerException e) {
					request.setAttribute("add", "Add your address <button>Add Information</button>");
				}
				try {
					String path = "./Homeprof.jsp";
					request.getRequestDispatcher(path).forward(request, response);
					return;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		try {
			String path = "./AddAddress.jsp";
			request.getRequestDispatcher(path).forward(request, response);
			return;
		} catch (ServletException e) {
			e.printStackTrace();
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
