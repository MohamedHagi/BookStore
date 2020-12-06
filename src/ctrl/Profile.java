package ctrl;

import java.io.IOException;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashSet;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.Book;
import Bean.Cart;
import Bean.CartItem;
import Bean.CreditCard;
import Bean.Customers;
import Bean.ShippingCountryInfo;
import Model.Model;

/**
 * Servlet implementation class Profile
 */
@WebServlet(asyncSupported = true, urlPatterns = { "/Profile", "/Profile/*", "/BookStore/Profile" })
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
		if (request.getParameter("btnSignin") != null) {
			String ID = request.getParameter("id");
			request.getSession().setAttribute("ID", ID);
			String pass = request.getParameter("pass");
			request.getSession().setAttribute("pass", pass);
			String checkID = m.checkForempty(ID);
			String checkPass = m.checkForempty(pass);
			boolean res = m.verifyLogin(ID, pass);
			if ((checkID.equals("no") || checkPass.equals("no"))) {
				if (checkID.equals("no") || checkPass.equals("no")) {
					request.setAttribute("Err", "Check for Empty field(s)");
				}
				try {
					String target = "./Login.jsp";
					request.getRequestDispatcher(target).forward(request, response);
					return;
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else if (!res) {
				request.setAttribute("Err", "Sorry the value is not in our database");
				try {
					String target = "./Login.jsp";
					request.getRequestDispatcher(target).forward(request, response);
					return;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}

			if (res) {
				Customers c = m.PrintcustInfo(ID);
				c.setLock(false);
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
				} catch (NullPointerException e) {
					request.setAttribute("add", "Add your address <button>Add Information</button>");
				}
				try {
					if (request.getSession().getAttribute("cart") != null) {
						Cart car = (Cart) request.getSession().getAttribute("cart");
						int cartID = m.getCartID(ID);
						int result = m.AddSessCartToTheCart(car, cartID);
						System.out.println(result);
						ArrayList<CartItem> al = m.GetCartItems(ID);
						request.setAttribute("tot", m.GetCartTotal(ID));
						request.setAttribute("size", al.size());
						request.setAttribute("la", al);

					} else {
						ArrayList<CartItem> al = m.GetCartItems(ID);
						request.setAttribute("tot", m.GetCartTotal(ID));
						request.setAttribute("size", al.size());
						request.setAttribute("la", al);
					}
				} catch (NullPointerException e) {
					request.setAttribute("list", "0");
				}

				try {
					String target = "./Homeprof.jsp";
					request.getRequestDispatcher(target).forward(request, response);
					return;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		if (request.getParameter("viewProfile") != null) {
			if (request.getSession().getAttribute("ID") != null) {
				String ID = (String) request.getSession().getAttribute("ID");
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
				} catch (NullPointerException e) {
					request.setAttribute("add", "Add your address <button>Add Information</button>");
				}
				try {
					ArrayList<CartItem> al = m.GetCartItems(ID);
					request.setAttribute("tot", m.GetCartTotal(ID));
					request.setAttribute("size", al.size());
					request.setAttribute("la", al);
				} catch (NullPointerException e) {
					request.setAttribute("list", "0");
				}

				try {
					String target = "./Homeprof.jsp";
					request.getRequestDispatcher(target).forward(request, response);
					return;
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				try {
					String target = "./Login.jsp";
					request.getRequestDispatcher(target).forward(request, response);
					return;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		if (request.getParameter("rmBtn") != null) {
			String productID = request.getParameter("productID");
			String tittle = request.getParameter("tittle");
			String addID = request.getParameter("addID");
			String price = request.getParameter("price");
			String category = request.getParameter("category");
			if (request.getSession().getAttribute("ID") != null) {
				try {
					int result = m.removeFromtheCart(productID, tittle, addID, price, category);
					if (result == 0) {
						request.setAttribute("removed", "The item has been successfully removed");
					} else {
						request.setAttribute("removed", "The item has not been removed");
					}
				} catch (Exception e) {
					e.printStackTrace();
				}
				try {
					String ID = (String) request.getSession().getAttribute("ID");
					request.setAttribute("tot", m.GetCartTotal(ID));
					ArrayList<CartItem> al = m.GetCartItems(ID);
					request.setAttribute("size", al.size());
					request.setAttribute("la", al);
				} catch (NullPointerException e) {
					request.setAttribute("list", "0");
				}
				try {
					String target = "./CheckOut.jsp";
					request.getRequestDispatcher(target).forward(request, response);
					return;
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				Cart c = (Cart) request.getSession().getAttribute("cart");
				for (int i = 0; i < c.getList().size(); i++) {
					CartItem ci = c.getList().get(i);
					if (ci.getProductID() == Integer.parseInt(productID) && ci.getBookTittle().equals(tittle)
							&& ci.getPrice() == Double.parseDouble(price)) {
						c.getList().remove(i);
					}
				}
				request.setAttribute("la", c.getList());
				try {
					String target = "./CheckOut.jsp";
					request.getRequestDispatcher(target).forward(request, response);
					return;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		if (request.getParameter("btnLogout") != null) {
			System.out.println(request.getParameter("btnLogout"));
			System.out.println("Logout " + request.getRequestURI());
			try {
				// test this
				request.getSession().invalidate();
				String target = "./Logout.jsp";
				request.getRequestDispatcher(target).forward(request, response);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if (request.getParameter("cartBtn") != null) {
			try {
				String ID = (String) request.getSession().getAttribute("ID");
				Customers c = m.PrintcustInfo(ID);
				int count = 0;
				if(c.getAdd() == null) {
					request.setAttribute("count", count);
					request.setAttribute("add", " <a href=\"/BookStore/AddAddress.jsp\">Add Address</a>");
				}
				ArrayList<CartItem> al = m.GetCartItems(ID);
				request.setAttribute("size", al.size());
				request.setAttribute("la", al);
				if (al.size() > 0) {
					ShippingCountryInfo sci = new ShippingCountryInfo();
					sci = m.getDilieveryPrices(ID);
					double total = m.GetCartTotal(ID);
					request.setAttribute("tax", sci.getTaxRate());
					request.setAttribute("tar", sci.getTariffs());
					request.setAttribute("tot", total);
					request.setAttribute("shipping", sci.getCarrierFlatRate());
					request.setAttribute("orderTot",
							 m.returnCartTotal(total, sci.getTaxRate(), sci.getTariffs(), sci.getCarrierFlatRate()));
					if(c.getAdd() != null) {
						count = 1;
						request.setAttribute("count", count);
						request.setAttribute("conf", "Confirm Address: ");
						request.setAttribute("stNum", "Street Number: " + c.getAdd().getStreetNo());
						request.setAttribute("unitNo", "Unit Number: " + c.getAdd().getUnitNo());
						request.setAttribute("stName", "Street Name: " + c.getAdd().getStreet());
						request.setAttribute("pcode", "Postal Code: " + c.getAdd().getPcode());
						request.setAttribute("city", "City: "  + c.getAdd().getCity());
						request.setAttribute("state", "State: " + c.getAdd().getProvince());
						request.setAttribute("cont", "Country: " + c.getAdd().getCountry());
					}
					
				}else {
					request.setAttribute("noItem", "There no items in your cart At this time");
				}
			} catch (NullPointerException e) {
				request.setAttribute("list", "0");
			}
			try {
				String target = "./CheckOut.jsp";
				request.getRequestDispatcher(target).forward(request, response);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if(request.getParameter("updateAdd") != null) {
			String ID = (String) request.getSession().getAttribute("ID");
			Customers c = m.PrintcustInfo(ID);
			String sNum = request.getParameter("streetNumber");
			String sName = request.getParameter("streetName");
			String unit = request.getParameter("unitNo");
			String postCode = request.getParameter("postcode");
			String city = request.getParameter("city");
			String state = request.getParameter("state");
			String cont = request.getParameter("country");
			boolean check = m.checkForempty(sNum, unit, sName, city, postCode, cont, state, ID);
			if(!check) {
				request.setAttribute("emp", "check for empty fields");
			}
			boolean res = m.updateAddress(sNum, unit, sName, city, postCode, cont, state, ID);
			if(!res) {
				request.setAttribute("notDone", "Address Not updated");
				int count = 0;
				ArrayList<CartItem> al = m.GetCartItems(ID);
				request.setAttribute("size", al.size());
				request.setAttribute("la", al);
				if (al.size() > 0) {
					ShippingCountryInfo sci = new ShippingCountryInfo();
					sci = m.getDilieveryPrices(ID);
					double total = m.GetCartTotal(ID);
					request.setAttribute("tax", sci.getTaxRate());
					request.setAttribute("tar", sci.getTariffs());
					request.setAttribute("tot", total);
					request.setAttribute("shipping", sci.getCarrierFlatRate());
					request.setAttribute("orderTot",
							 m.returnCartTotal(total, sci.getTaxRate(), sci.getTariffs(), sci.getCarrierFlatRate()));
					if(c.getAdd() != null) {
						count = 1;
						request.setAttribute("count", count);
						request.setAttribute("conf", "Confirm Address: ");
						request.setAttribute("stNum", "Street Number: " + c.getAdd().getStreetNo());
						request.setAttribute("unitNo", "Unit Number: " + c.getAdd().getUnitNo());
						request.setAttribute("stName", "Street Name: " + c.getAdd().getStreet());
						request.setAttribute("pcode", "Postal Code: " + c.getAdd().getPcode());
						request.setAttribute("city", "City: "  + c.getAdd().getCity());
						request.setAttribute("state", "State: " + c.getAdd().getProvince());
						request.setAttribute("cont", "Country: " + c.getAdd().getCountry());
					}
					
				}else {
					request.setAttribute("noItem", "There no items in your cart At this time");
				}
				
				
				try {
					String target = "./CheckOut.jsp";
					request.getRequestDispatcher(target).forward(request, response);
					return;
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			int count = 0;
			ArrayList<CartItem> al = m.GetCartItems(ID);
			request.setAttribute("size", al.size());
			request.setAttribute("la", al);
			if (al.size() > 0) {
				ShippingCountryInfo sci = new ShippingCountryInfo();
				sci = m.getDilieveryPrices(ID);
				double total = m.GetCartTotal(ID);
				request.setAttribute("tax", sci.getTaxRate());
				request.setAttribute("tar", sci.getTariffs());
				request.setAttribute("tot", total);
				request.setAttribute("shipping", sci.getCarrierFlatRate());
				request.setAttribute("orderTot",
						 m.returnCartTotal(total, sci.getTaxRate(), sci.getTariffs(), sci.getCarrierFlatRate()));
				if(c.getAdd() != null) {
					count = 1;
					request.setAttribute("count", count);
					request.setAttribute("conf", "Confirm Address: ");
					request.setAttribute("stNum", "Street Number: " + c.getAdd().getStreetNo());
					request.setAttribute("unitNo", "Unit Number: " + c.getAdd().getUnitNo());
					request.setAttribute("stName", "Street Name: " + c.getAdd().getStreet());
					request.setAttribute("pcode", "Postal Code: " + c.getAdd().getPcode());
					request.setAttribute("city", "City: "  + c.getAdd().getCity());
					request.setAttribute("state", "State: " + c.getAdd().getProvince());
					request.setAttribute("cont", "Country: " + c.getAdd().getCountry());
				}
				
			}else {
				request.setAttribute("noItem", "There no items in your cart At this time");
			}
			
			try {
				String target = "./CheckOut.jsp";
				request.getRequestDispatcher(target).forward(request, response);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		
		
		if (request.getParameter("payBtn") != null) {
			if (request.getParameter("check").equals("on")) {
				System.out.println("gets here");
				String ID = (String) request.getSession().getAttribute("ID");
				CreditCard cc = m.PrintcustCreditCardInfo(ID);
				boolean answer = m.chekExpiry(cc.getExpirydate());		
				
				System.out.println("checks the expiry date " + answer);
				ArrayList<CartItem> al = m.GetCartItems(ID);
				if (answer && al.size() > 0) {
					String confirmation = m.PurchaseOrderQueries(ID, cc.getCardno(), al);
					if (confirmation.equals("success")) {
						Customers c = m.PrintcustInfo(ID);
						request.setAttribute("stNo", "Shipped to this Address: " + c.getAdd().getUnitNo());
						request.setAttribute("stName", c.getAdd().getStreet());
						request.setAttribute("prov", c.getAdd().getProvince());
						request.setAttribute("cont", c.getAdd().getCountry());
						request.setAttribute("conf", confirmation + "fully Ordered your confirmation number is "
								+ request.getRequestedSessionId());
					} else {
						request.setAttribute("conf", confirmation);
					}
				} else {
					request.setAttribute("failiure", "An error Occured while processing your payment");
				}

				try {
					String path = "./orderConf.jsp";
					request.getRequestDispatcher(path).forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		
		if (request.getParameter("payNow") != null) {
			String ID = (String) request.getSession().getAttribute("ID");
			String num = request.getParameter("Inp");
			String cvv = request.getParameter("cvv");
			String name = request.getParameter("name");
			String exp = request.getParameter("expdate");
			Date d = Date.valueOf(exp);
			boolean var = m.chekExpiry(d);
			boolean checkForEmpty = m.checkTheString(num, cvv, name, exp);
			if (var && checkForEmpty) {
				ArrayList<CartItem> al = m.GetCartItems(ID);
				if (var && al.size() > 0) {
					String confirmation = m.PurchaseOrderQueries(ID, num, al);
					if (confirmation.equals("success")) {
						Customers c = m.PrintcustInfo(ID);
						request.setAttribute("stNo", "Shipped to this Address: " + c.getAdd().getUnitNo());
						request.setAttribute("stName", c.getAdd().getStreet());
						request.setAttribute("prov", c.getAdd().getProvince());
						request.setAttribute("cont", c.getAdd().getCountry());
						request.setAttribute("conf", confirmation + "fully Ordered your confirmation number is "
								+ request.getRequestedSessionId());
					} else {
						request.setAttribute("conf", confirmation);
					}
				} else {
					request.setAttribute("failiure", "An error Occured while processing your payment");
				}

				try {
					String path = "./orderConf.jsp";
					request.getRequestDispatcher(path).forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			} else {
				request.setAttribute("Error", "Check for empty field");
				try {
					ArrayList<CartItem> al = m.GetCartItems(ID);
					request.setAttribute("size", al.size());
					request.setAttribute("la", al);
					if (al.size() > 0) {
						ShippingCountryInfo sci = new ShippingCountryInfo();
						sci = m.getDilieveryPrices(ID);
						double total = m.GetCartTotal(ID);
						request.setAttribute("tax", sci.getTaxRate());
						request.setAttribute("tar", sci.getTariffs());
						request.setAttribute("tot", total);
						request.setAttribute("shipping", sci.getCarrierFlatRate());
						request.setAttribute("orderTot",
								m.returnCartTotal(total, sci.getTaxRate(), sci.getTariffs(), sci.getCarrierFlatRate()));
					}
				} catch (NullPointerException e) {
					request.setAttribute("list", "0");
				}
				try {
					String path = "./CheckOut.jsp";
					request.getRequestDispatcher(path).forward(request, response);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}

		if (request.getParameter("surfBtn") != null) {
			HashSet<Book> hs = m.retrieveBooks();
			try {
				request.setAttribute("hash", hs);
				String target = "./Surf.jsp";
				request.getRequestDispatcher(target).forward(request, response);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
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
