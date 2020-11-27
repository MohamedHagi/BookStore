package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import Bean.Address;
import Bean.CreditCard;
import Bean.Customers;

public class CustProfileDAO {

	DataSource ds;

	public CustProfileDAO() {
		try {
			this.ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/project");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public Customers getTheprofdata(int cid) {
		Customers c = new Customers();
		Address a = new Address();
		try {
			Connection con = ds.getConnection();
			String querry = "select fname, lname, email, streetno, djoined, street, unitno, province, country from customer, address"
					+ " where cid = " + cid + " and cid_add = " + cid + ";";
			PreparedStatement ps = con.prepareStatement(querry);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				c.setFname(rs.getString("fname"));
				c.setLname(rs.getString("lname"));
				c.setEmail(rs.getString("email"));
				c.setDateJoined(rs.getDate("djoined"));
				a.setStreet(rs.getString("street"));
				a.setUnitNo(rs.getInt("unitno"));
				a.setProvince(rs.getString("province"));
				a.setCountry(rs.getString("country"));
				c.setAdd(a);
			}
			rs.close();
			ps.close();
			con.close();
			return c;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return c;
	}
	
	public CreditCard getCreditCardInfo(int cid) {
		CreditCard cc = new CreditCard();
		try {
			Connection c = ds.getConnection();
			String querry = "select cardno, csv, fname, lname, expirydate from creditcard "
					+ "where cid_cc =" + cid + ";" ;
			PreparedStatement ps = c.prepareStatement(querry);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				cc.setCardno(rs.getString("cardno"));
				cc.setCsv(rs.getString("csv"));
				cc.setFname(rs.getString("fname"));
				cc.setLnmae(rs.getString("lname"));
				cc.setExpirydate(rs.getDate("expirydate"));
			}
			rs.close();
			ps.close();
			c.close();
			return cc;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return cc;
	}
	
	public int addAdd(String streetName, int stNo, int unitNo, String pcode, String city, String prov, String cont, int cid) {
		int result = 0;
		try {
			Connection c = ds.getConnection();
			String sql = "INSERT INTO address (street, streetno, unitno, province, country, cid_add, pcode, city) "
					+ "VALUES (?,?,?,?,?,?,?,?);";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, streetName);
			ps.setInt(2, stNo);
			ps.setInt(3, unitNo);
			ps.setString(4, prov);
			ps.setString(5, cont);
			ps.setInt(6, cid);
			ps.setString(7, pcode);
			ps.setString(8, city);
			result = ps.executeUpdate();
			ps.close();
			c.close();
			return result;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int addCreditCard(String cardno, String csv, String fname, String lname, Date expDate, int cid) {
		int result = 0;
		try {
			Connection c = ds.getConnection();
			String q = "INSERT INTO creditcard (cardno, csv, fname, lname, expirydate, cid_cc) VALUES (?,?,?,?,?,?);";
			PreparedStatement ps = c.prepareStatement(q);
			ps.setString(1, cardno);
			ps.setString(2, csv);
			ps.setString(3, fname);
			ps.setString(4, lname);
			ps.setDate(5, expDate);
			ps.setInt(6, cid);
			result = ps.executeUpdate();
			ps.close();
			c.close();
			return result;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
