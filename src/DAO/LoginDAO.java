package DAO;

import java.sql.Connection;
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
	
	public String custcid(String email) {
		String result = null;
		try {
			Connection con = ds.getConnection();
			String querry = "select cid from customer where email = '"+ email +"';";
			PreparedStatement ps = con.prepareStatement(querry);
			ResultSet rs = ps.executeQuery();
			while(rs.next()){
				result = rs.getString("cid");
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
}
