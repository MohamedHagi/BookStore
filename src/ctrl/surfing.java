package ctrl;

import java.io.IOException;
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
import Bean.Customers;
import Bean.Review;
import Bean.ShippingCountryInfo;
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
		String ID = (String) request.getSession().getAttribute("ID");
		String search = request.getParameter("search");
		String select = request.getParameter("slct");
		request.setAttribute("sess", "selected");
		request.setAttribute("val", search);
		if ((search != null && select.equals("All"))) {
			HashSet<Book> hs = m.retrieveAllCategBooks(search);
			try {
				if (hs.size() == 0) {
					request.setAttribute("Er", "Sorry " + search + " is currently not in stock");
				} else {
					request.setAttribute("hash", hs);
				}
				String target = "./Surf.jsp";
				request.getRequestDispatcher(target).forward(request, response);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if ((search != null
				&& (select.equals("Fiction") || select.equals("Science") || select.equals("Engineering")))) {
			HashSet<Book> hs = m.retrieveCategBooks(select, search);
			try {
				if (hs.size() == 0) {
					request.setAttribute("Er", "Sorry " + search + " is currently not in stock");
				} else {
					request.setAttribute("hash", hs);
				}
				String target = "./Surf.jsp";
				request.getRequestDispatcher(target).forward(request, response);
				return;
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		if(request.getParameter("details") != null) {
			String price = request.getParameter("price");
			String productID = request.getParameter("bid");
			String bookTittle = request.getParameter("tittle");
			String categ = request.getParameter("category");
			request.setAttribute("price", price);
			request.setAttribute("productID", productID);
			request.setAttribute("bookTittle", bookTittle);
			request.setAttribute("categ", categ);
			ArrayList<Review> r = m.getTheReview(bookTittle);
			if(r.size() == 0) {
				request.setAttribute("noReview", "No reviews for this product yet!");
				try {
					String path = "./Details.jsp";
					request.getRequestDispatcher(path).forward(request, response);
					return;
				}catch(Exception e) {
					e.printStackTrace();
				}
			}else {
				request.setAttribute("review", r);
				try {
					String path = "./Details.jsp";
					request.getRequestDispatcher(path).forward(request, response);
					return;
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		if(request.getParameter("addToCartFromDetails") != null) {
			String price = request.getParameter("price");
			String productID = request.getParameter("productID");
			String bookTittle = request.getParameter("bookTittle");
			String categ = request.getParameter("categ");
			if (request.getSession().getAttribute("ID") != null) {
				int cartId = m.getCartID(ID);
				System.out.println("The cart id is " + cartId);
				int j = m.insertItemIntoCart(productID, cartId, bookTittle, price, categ);
				if (j == 1) {
					ArrayList<CartItem> al = m.GetCartItems(ID);
					request.getSession().setAttribute("cartList", al);
					request.setAttribute("succ", "Item added to cart");
				} else {
					request.setAttribute("fail", "The item hasnt been added");
				}
			} else if (request.getSession().getAttribute("ID") == null) {
				CartItem ci = new CartItem();
				Cart c = (Cart) request.getSession().getAttribute("cart");
				if(c == null) {
					c = new Cart();
					c.setB(new ArrayList<CartItem>());
					request.getSession().setAttribute("cart", c);
				}
				ci.setBookTittle(bookTittle);
				ci.setPrice(Double.parseDouble(price));
				ci.setProductID(Integer.parseInt(productID));
				ci.setCategory(categ);
				boolean val = c.addanIteaminASession(ci);
				request.getSession().setAttribute("cartList", c.getList());
				if (val) {
					request.setAttribute("fail", "Item added to cart");
				} else {
					request.setAttribute("fail", "The item hasnt been added");
				}

			}
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
		
		
		
		if(request.getParameter("reviewInsert") != null) {
			String price = request.getParameter("price");
			String productID = request.getParameter("bid");
			String categ = request.getParameter("category");
			String comment = request.getParameter("textArea");
			String bookTittle = request.getParameter("hidVal");
			request.setAttribute("price", price);
			request.setAttribute("productID", productID);
			request.setAttribute("bookTittle", bookTittle);
			request.setAttribute("categ", categ);
			ArrayList<Review> r = m.getTheReview(bookTittle);
			if(r.size() == 0) {
				request.setAttribute("noReview", "No reviews for this product yet!");
			}else {
				request.setAttribute("review", r);
			}
			if(ID != null){
				boolean result = m.insertIntoReview(comment, ID, bookTittle);
				if(result) {
					request.setAttribute("success", "Review has been added");
				}else {
					request.setAttribute("success", "Sorry an error occured");
				}
				String path = "./Details.jsp";
				request.getRequestDispatcher(path).forward(request, response);
				return;
			}else {
				request.setAttribute("login", "please Login first only logged in users can write a review");
				String path = "./Details.jsp";
				request.getRequestDispatcher(path).forward(request, response);
				return;
			}
		}
		
		try {
			if (request.getParameter("addToCart") != null) {
				String price = request.getParameter("price");
				String productID = request.getParameter("bid");
				String bookTittle = request.getParameter("tittle");
				String categ = request.getParameter("category");
				if (request.getSession().getAttribute("ID") != null) {
					int cartId = m.getCartID(ID);
					System.out.println("The cart id is " + cartId);
					int j = m.insertItemIntoCart(productID, cartId, bookTittle, price, categ);
					if (j == 1) {
						ArrayList<CartItem> al = m.GetCartItems(ID);
						request.getSession().setAttribute("cartList", al);
						request.setAttribute("succ", "Item added to cart");
					} else {
						request.setAttribute("fail", "The item hasnt been added");
					}
				} else if (request.getSession().getAttribute("ID") == null) {
					CartItem ci = new CartItem();
					Cart c = (Cart) request.getSession().getAttribute("cart");
					if(c == null) {
						c = new Cart();
						c.setB(new ArrayList<CartItem>());
						request.getSession().setAttribute("cart", c);
					}
					ci.setBookTittle(bookTittle);
					ci.setPrice(Double.parseDouble(price));
					ci.setProductID(Integer.parseInt(productID));
					ci.setCategory(categ);
					boolean val = c.addanIteaminASession(ci);
					request.getSession().setAttribute("cartList", c.getList());
					if (val) {
						request.setAttribute("fail", "Item added to cart");
					} else {
						request.setAttribute("fail", "The item hasnt been added");
					}

				}
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
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
		
		if(request.getParameter("rmFromCart") != null) {
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
					ID = (String) request.getSession().getAttribute("ID");
					request.setAttribute("tot", m.GetCartTotal(ID));
					ArrayList<CartItem> al = m.GetCartItems(ID);
					request.setAttribute("cartList", al);
				} catch (NullPointerException e) {
					request.setAttribute("list", "0");
				}
		}else {
			Cart c = (Cart) request.getSession().getAttribute("cart");
			for (int i = 0; i < c.getList().size(); i++) {
				CartItem ci = c.getList().get(i);
				if (ci.getProductID() == Integer.parseInt(productID) && ci.getBookTittle().equals(tittle)
						&& ci.getPrice() == Double.parseDouble(price)) {
					c.getList().remove(i);
				}
			}
			request.setAttribute("cartList", c.getList());
		}
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
		
		
		
		
		
		if(request.getParameter("btnForCart") != null) {
			
			
			if(request.getSession().getAttribute("ID") != null){
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
				
				try {
					String target = "./CheckOut.jsp";
					request.getRequestDispatcher(target).forward(request, response);
					return;
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}else {
				try {
					String path = "./Login.jsp";
					request.getRequestDispatcher(path).forward(request, response);
					return;
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
		
		
		
		
		
		if(request.getParameter("viewCart") != null) {
			if(request.getSession().getAttribute("ID") != null){
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
				
				try {
					String target = "./CheckOut.jsp";
					request.getRequestDispatcher(target).forward(request, response);
					return;
				}catch(Exception e) {
					e.printStackTrace();
				}
				
			}else {
				try {
					String path = "./Login.jsp";
					request.getRequestDispatcher(path).forward(request, response);
					return;
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}
		
		if (request.getRequestURI().equals("/BookStore/surfing") && request.getParameter("addToCart") == null
				&& search == null) {
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


