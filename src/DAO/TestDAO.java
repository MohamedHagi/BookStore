package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

public class TestDAO {

	public static void main(String[] args) {
		DataSource ds = null;
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		try {
			ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/project");
		} catch (NamingException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		};
		try {
			con = ds.getConnection();
			String querry = "SELECT * FROM bookstore_db.user";
			st = con.prepareStatement(querry);
			rs = st.executeQuery();
			while(rs.next()) {
				System.out.println(rs.getString("uname") + " " + rs.getString("uemail"));
			}
			
			rs.close();
			st.close();
			con.close();
		}catch(Exception e) {
			
		}
		
		
				

	}

}
