package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class CartDAO {
	
	DataSource ds;
	public CartDAO() {
		try {
			this.ds = (DataSource) new InitialContext().lookup("java:/comp/env/jdbc/project");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int InsertIntoCartItem(int productID, Date createDate, int addcartID, String bookTittle, double bookPrice, String category) {
		int result = 0;
		try {
			Connection con = ds.getConnection();
			String sql = "INSERT INTO cartitem (productID, createdate, addcartID, bookTittle, bookprice, category) VALUES (?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setInt(1, productID);
			ps.setDate(2, createDate);
			ps.setInt(3, addcartID);
			ps.setString(4, bookTittle);
			ps.setDouble(5, bookPrice);
			ps.setString(6, category);
			result = ps.executeUpdate();
			ps.close();
			con.close();
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
	}
	
	public int getCustCartID(String email) {
		int result = 0;
		try {
			Connection c = ds.getConnection();
			String sql = "select cartID from cart " 
					+ "where user_ID in " 
					+ "(select cid from customer where email='" + email + "');";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				result = rs.getInt("cartID");
			}
			rs.close();
			ps.close();
			c.close();
			return result;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
}
