package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

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
	
	public ArrayList<Review> getTheReview(String tittle) {
		ArrayList<Review> result = new ArrayList<Review>();
		try {
			Connection c = ds.getConnection();
			String sql = "select reviewid, comments, email, bookTittle, date from review "
					+ "where bookTittle like '%"+ tittle +"%';";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Review r = new Review();
				r.setRid(rs.getInt("reviewid"));
				r.setReview(rs.getString("comments"));
				r.setCustomID(rs.getString("email"));
				r.setBname(rs.getString("bookTittle"));
				r.setDate(rs.getDate("date"));
				result.add(r);
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
	
	
	public int InsertReviewIntoDB(String comment, String custID, String bookTittle, Date date) {
		int result = 0;
		try {
			Connection c = ds.getConnection();
			String sql = "INSERT INTO review (comments, bookTittle, date, email) VALUES (?, ?, ?, ?);";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setString(1, comment);
			ps.setString(2, bookTittle);
			ps.setDate(3, date);
			ps.setString(4, custID);
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
