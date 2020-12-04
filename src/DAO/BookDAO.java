package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import Bean.Book;

public class BookDAO {

	DataSource ds;

	public BookDAO() {
		try {
			this.ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/project");
		} catch (NamingException e) {
			e.printStackTrace();
		}
	}

	public HashSet<Book> getBook() {
		HashSet<Book> result = new HashSet<Book>();
		try {
			Connection con = ds.getConnection();
			String querry = "select bid, tittle, price, category, count(tittle) As quant from book group by tittle;";
			PreparedStatement ps = con.prepareStatement(querry);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book b = new Book();
				b.setBid(rs.getInt("bid"));
				b.setTitle(rs.getString("tittle"));
				b.setPrice(rs.getDouble("price"));
				b.setCategory(rs.getString("category"));
				b.setQuantity(rs.getInt("quant"));
				result.add(b);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

	public HashSet<Book> getAllCategBook(String tittle) {
		HashSet<Book> result = new HashSet<Book>();
		try {
			Connection con = ds.getConnection();
			String querry = "select bid, tittle, price, category, count(tittle) As quant from book where tittle like '%"
					+ tittle + "%' group by tittle;";
			PreparedStatement ps = con.prepareStatement(querry);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book b = new Book();
				b.setBid(rs.getInt("bid"));
				b.setTitle(rs.getString("tittle"));
				b.setPrice(rs.getDouble("price"));
				b.setCategory(rs.getString("category"));
				b.setQuantity(rs.getInt("quant"));
				result.add(b);
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

	public HashSet<Book> getCategBook(String categ, String tittle) {
		HashSet<Book> result = new HashSet<Book>();
		try {
			Connection con = ds.getConnection();
			String querry = "select bid, tittle, price, category, count(tittle) As quant from book where category='"
					+ categ + "' and tittle like '%" + tittle + "%' group by tittle;";
			PreparedStatement ps = con.prepareStatement(querry);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Book b = new Book();
				b.setBid(rs.getInt("bid"));
				b.setTitle(rs.getString("tittle"));
				b.setPrice(rs.getDouble("price"));
				b.setCategory(rs.getString("category"));
				b.setQuantity(rs.getInt("quant"));
				result.add(b);
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
	
	public Book getBook(int bid) {
		Book b = new Book();
		try {
			Connection c = ds.getConnection();
			String sql = "select bid, tittle, price, category from book where bid="+ bid +";";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				b.setBid(rs.getInt("bid"));
				b.setTitle(rs.getString("tittle"));
				b.setPrice(rs.getDouble("price"));
				b.setCategory(rs.getString("category"));
			}
			rs.close();
			ps.close();
			c.close();
			return b;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return b;
	}
	
	/*
	 * Delete from the book table after inserting into cartItem table
	 * */
	public int deleteFromTable(int bid) {
		int result = 0;
		try {
			Connection c = ds.getConnection();
			String sql = "delete from book where bid=?;";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, bid);
			result = ps.executeUpdate();
			ps.close();
			c.close();
			return result;
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
	/*
	 * Insert into book after deleting from cart item
	 * */
	public int InsertIntoBookTable(int bid, String tittle, double price, String category) {
		int result = 0;
		try {
			Connection c = ds.getConnection();
			String sql = "INSERT INTO book (bid, tittle, price, category) VALUES (?, ?, ?, ?);";
			PreparedStatement ps = c.prepareStatement(sql);
			ps.setInt(1, bid);
			ps.setString(2, tittle);
			ps.setDouble(3, price);
			ps.setString(4, category);
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
