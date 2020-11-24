package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import Bean.Address;
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

	public Customers getTheprofdata(String cid) {
		Customers c = new Customers();
		Address a = new Address();
		try {
			Connection con = ds.getConnection();
			String querry = "select fname, lname, email, djoined, street, unitno, province, country from customer, address"
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

}
