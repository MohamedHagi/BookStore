package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import Bean.LoginType;

public class LoginDAO {
	
	DataSource ds;
	
	public LoginDAO() {
		try {
			this.ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/project");
		}catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	public LoginType getLoginInfo(String email, String pass) {
		LoginType lt = new LoginType();
		try {
			Connection con = ds.getConnection();
			String querry = "SELECT loginemail, password "
					+ "FROM login"
					+ " where loginemail='" + email +"' AND "
					+ "password='"+ pass +"';";
			PreparedStatement ps = con.prepareStatement(querry);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				lt.setEmail(rs.getNString("loginemail"));
				lt.setPassword(rs.getString("password"));
			}
			rs.close();
			ps.close();
			con.close();
			return lt;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return lt;
	}
	
	public int custcid(String email) {
		int result = 0;
		try {
			Connection con = ds.getConnection();
			String querry = "select cid from customer where email = '"+ email +"';";
			PreparedStatement ps = con.prepareStatement(querry);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				result = rs.getInt("cid");
			}
			rs.close();
			ps.close();
			con.close();
			return result;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public int assignCarttoCust(int cid) {
		int result = 0;
		long milis = System.currentTimeMillis();
		java.sql.Date d = new java.sql.Date(milis);
		try {
			Connection c = ds.getConnection();
			String sql = "INSERT INTO cart (user_ID, datecreated) VALUES (?,?);";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, cid);
			ps.setDate(2, d);
			result = ps.executeUpdate();
			ps.close();
			c.close();
			return result;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	public LoginType checkRegInfo(String email) {
		LoginType lt = new LoginType();
		try {
			Connection con = ds.getConnection();
			String querry = "SELECT loginemail "
					+ "FROM login"
					+ " where loginemail='" + email +"';";
			PreparedStatement ps = con.prepareStatement(querry);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				lt.setEmail(rs.getNString("loginemail"));
			}
			rs.close();
			ps.close();
			con.close();
			return lt;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return lt;
	}
	
	public int addTologinTable(String email, String pass) {
		int result = 0;
		try {
			Connection c = ds.getConnection();
			String querry = "INSERT INTO login (loginemail, password) VALUES (?,?);";
			PreparedStatement ps = c.prepareStatement(querry);
			ps.setString(1, email);
			ps.setString(2, pass);
			result = ps.executeUpdate();
			ps.close();
			c.close();
			return result;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return result;
	}
	
	public int addToCustTable(String email, String firstName, String lastName, Date dateJoined) {
		int result = 0;
		try {
			Connection c = ds.getConnection();
			String querry = "INSERT INTO customer (email, fname, lname, djoined) VALUES (?,?,?,?);";
			PreparedStatement ps = c.prepareStatement(querry);
			ps.setString(1, email);
			ps.setString(2, lastName);
			ps.setString(3, lastName);
			ps.setDate(4, dateJoined);
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
