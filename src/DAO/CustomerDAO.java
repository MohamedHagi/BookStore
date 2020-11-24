package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import Bean.Customers;

public class CustomerDAO {
	
	DataSource ds;
	
	public CustomerDAO() {
		try {
			this.ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/project");
		}catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	public HashSet<Customers> getCustomer(String email){
		HashSet<Customers> result = new HashSet<Customers>();
		try {
			Connection con = ds.getConnection();
			String querry = "SELECT * FROM customer";
			PreparedStatement ps = con.prepareStatement(querry);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("cid") + rs.getString("fname"));
			}
			rs.close();
			ps.close();
			con.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
