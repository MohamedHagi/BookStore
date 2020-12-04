package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

import Bean.ShippingCountryInfo;

public class ShippingDAO {
	
	DataSource ds;
	
	public ShippingDAO() {
		try {
			this.ds = (DataSource) (new InitialContext()).lookup("java:/comp/env/jdbc/project");
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public ShippingCountryInfo getTheShippingPrice(String email) {
		ShippingCountryInfo sci = new ShippingCountryInfo();
		try {
			Connection c = ds.getConnection();
			String sql = "select spiID, Country, TaxRate, carrier, carrierFlatRate from countryshippingprice "
					+ "where Country in " +
					"(select country from address where cid_add in "
					+ "(select cid from customer where email='" + email + "'))";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				sci.setSpiID(rs.getInt("spiID"));
				sci.setCountry(rs.getString("Country"));
				sci.setTaxRate(rs.getDouble("TaxRate"));
				sci.setCarrier(rs.getString("carrier"));
				sci.setCarrierFlatRate(rs.getDouble("carrierFlatRate"));
			}
			rs.close();
			ps.close();
			c.close();
			return sci;
					
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return sci;
	}
	
	
	public int getTheShippingID(String email) {
		int result = 0;
		try {
			Connection c = ds.getConnection();
			String sql = "select spiID from countryshippingprice "
					+ "where Country in " +
					"(select country from address where cid_add in "
					+ "(select cid from customer where email='" + email + "'))";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				result = rs.getInt("spiID");
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
	
	public int getTheShippingQuant(int cid) {
		int result = 0;
		try {
			Connection c = ds.getConnection();
			String sql = "select count(*) as countsum from cartitem "
					+ "where addcartID in (select cartID from cart where user_ID =" + cid +") "
					+ "group by addcartID "
					+ ";";
			PreparedStatement ps = c.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				result = rs.getInt("countsum");
			}
			rs.close();
			ps.close();
			c.close();
			return result;
		}catch(SQLException e){
			
		}
		return result;
	}
}
