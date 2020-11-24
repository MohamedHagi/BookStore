package DAO;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import Bean.Visitors;

public class VisitorDAO {
	
DataSource ds;
	
	public VisitorDAO() {
		try {
			this.ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/project");
		}catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	public HashSet<Visitors> getVisitor(String pid){
		HashSet<Visitors> result = new HashSet<Visitors>();
		try {
			Connection con = ds.getConnection();
			String querry = "SELECT * FROM visitor";
			PreparedStatement ps = con.prepareStatement(querry);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("idvisitor") + rs.getString("fname"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
}
