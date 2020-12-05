package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import Bean.Admin;
import Bean.Book;
import Bean.TopTen;

public class AdminDAO {

	DataSource ds;

	public AdminDAO() {
		try {
			this.ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/project");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public Admin getAdmin(String email, String lname) {
		Admin a = new Admin();
		try {
			Connection con = ds.getConnection();
			String querry = "SELECT email, lname FROM admin where email='"+ email +"' "
					+ "and "
					+ "lname ='"+ lname + "'";
			PreparedStatement ps = con.prepareStatement(querry);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				a.setEmail(rs.getString("email"));
				a.setLname(rs.getString("lname"));
			}
			rs.close();
			ps.close();
			con.close();
			return a;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return a;
	}
	
	public ArrayList<TopTen> getTopTen() {
		ArrayList<TopTen> result = new ArrayList<TopTen>();
		try {
			Connection c = ds.getConnection();
			String sql = "select book_tittle, count(*) "
					+ "as total "
					+ "from poitem "
					+ "group by book_tittle "
					+ "order by total desc "
					+ "limit 10 "
					+ ";";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				TopTen t = new TopTen();
				t.setBookTittle(rs.getString("book_tittle"));
				t.setTotal(rs.getInt("total"));
				result.add(t);
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
	
	public ArrayList<Book> getTheMonthlyBooks(int month, int year){
		ArrayList<Book> result = new ArrayList<Book>();
		try {
			Connection c = ds.getConnection();
			String sql = "select book_id, book_tittle, price from poitem where poi_id in "
					+ "(select poid from purchaseorder "
					+ "where month(Date) ="+ month +" and year(Date) ="+ year +" and status = 'PROCESSED');";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Book b = new Book();
				b.setBid(rs.getInt("book_id"));
				b.setTitle(rs.getString("book_tittle"));
				b.setPrice(rs.getDouble("price"));
				result.add(b);
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
