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
				b.setBid(rs.getString("bid"));
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
				b.setBid(rs.getString("bid"));
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
				b.setBid(rs.getString("bid"));
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
}
