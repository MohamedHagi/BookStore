package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashSet;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import Bean.Partners;

public class PartnersDAO {
	
	DataSource ds;
	
	public PartnersDAO() {
		try {
			this.ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/project");
		}catch(NamingException e) {
			e.printStackTrace();
		}
	}
	
	public HashSet<Partners> getPartner(String pid){
		HashSet<Partners> result = new HashSet<Partners>();
		try {
			Connection con = ds.getConnection();
			String querry = "SELECT * FROM partner";
			PreparedStatement ps = con.prepareStatement(querry);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("idpartner") + rs.getString("fname"));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return result;
	}
	
}
