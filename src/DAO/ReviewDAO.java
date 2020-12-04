package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import Bean.Review;

public class ReviewDAO {
	
	DataSource ds;
	
	public ReviewDAO() {
		try {
			this.ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/project");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public Review getTheReview(String tittle) {
		Review result = new Review();
		try {
			Connection c = ds.getConnection();
			String sql = "select reviewid, comments, customID, bookTittle, date from review "
					+ "where bookTittle like '%"+ tittle +"%';";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				result.setRid(rs.getInt("reviewid"));
				result.setReview(rs.getString("comments"));
				result.setCustomID(rs.getInt("customID"));
				result.setBname(rs.getString("bookTittle"));
				result.setDate(rs.getDate("date"));
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
