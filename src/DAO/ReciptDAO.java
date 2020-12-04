package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


public class ReciptDAO {

	DataSource ds;

	public ReciptDAO() {
		try {
			this.ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/project");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public int insertIntoRecipt(Date date, int custid, int add, String payment, int itemquant, int poiID, double orderTot, int shippingID) {
		int result = 0;
		try {
			Connection c = ds.getConnection();
			String sql = "INSERT INTO recipt "
					+ "(date, cust_id, address, paymentMethod, ItemQuant, poi_ID, OrderTotal, shipingID) " 
					+ "VALUES "
					+ "(?, ?, ?, ?, ?, ?, ?, ?);";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setDate(1, date);
			ps.setInt(2, custid);
			ps.setInt(3, add);
			ps.setString(4, payment);
			ps.setInt(5, itemquant);
			ps.setInt(6, poiID);
			ps.setDouble(7, orderTot);
			ps.setInt(8, shippingID);
			result = ps.executeUpdate();
			ps.close();
			c.close();
			return result;
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return result;
	}
	
	public int getRid(int custID) {
		int result = 0;
		try {
			Connection c = ds.getConnection();
			String sql = "select rid from recipt where cust_id =" + custID + ";";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				result = rs.getInt("rid");
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
	
	public int getTheAid(int cid) {
		int result = 0;
		try {
			Connection c = ds.getConnection();
			String sql = "select aid from address where cid_add ="+ cid +";";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				result = rs.getInt("aid");
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
