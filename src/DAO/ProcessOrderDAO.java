package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import Bean.PurchaseOrder;

public class ProcessOrderDAO {
	
	DataSource ds;
	
	public ProcessOrderDAO() {
		try {
			this.ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/project");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public int InsertIntoProcessedOrder(int custID, String email, String status, String cardno, Date date) {
		int result = 0; 
		try {
			Connection c = ds.getConnection();
			String sql = "INSERT INTO purchaseorder (cust_ID, email, status, card, Date) VALUES (?, ?, ?, ?, ?);";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, custID);
			ps.setString(2, email);
			ps.setString(3, status);
			ps.setString(4, cardno);
			ps.setDate(5, date);
			result = ps.executeUpdate();
			ps.close();
			c.close();
			return result;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	
	public int getProcessID(String email) {
		int result = 0;
		try {
			Connection c = ds.getConnection();
			String sql = "select poid from purchaseorder where email ='" + email + "';";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				result = rs.getInt("poid");
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
	
	
	public int insertInToPOItem(int bookID, String bookTittle, int poiID, double price) {
		int result = 0;
		try {
			Connection c = ds.getConnection();
			String sql = "Insert into poitem (book_id, book_tittle, poi_id, price) values (?, ?, ?, ?);";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, bookID);
			ps.setString(2, bookTittle);
			ps.setInt(3, poiID);
			ps.setDouble(4, price);
			result = ps.executeUpdate();
			ps.close();
			c.close();
			return result;			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int deleteFromCartItem(int addItem) {
		int result = 0;
		try {
			Connection c = ds.getConnection();
			String sql = "delete from cartitem where addID =?;";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, addItem);
			result = ps.executeUpdate();
			ps.close();
			c.close();
			return result;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public PurchaseOrder getTheOrderQuerry(int poid) {
		PurchaseOrder po = new PurchaseOrder();
		try{
			Connection c = ds.getConnection();
			String sql = "select cust_ID, email, status, card from purchaseorder where poid=" + poid + ";";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				po.setcID(rs.getInt("cust_ID"));
				po.setEmail(rs.getString("email"));
				po.setStat(rs.getString("status"));
				po.setCard(rs.getString("card"));
			}
			rs.close();
			ps.close();
			c.close();
			return po;
		
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return po;
	}
}
