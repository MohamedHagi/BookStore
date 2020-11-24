package Bean;

import java.util.Date;

public class Customers {

	String cid;
	String fname;
	String lname;
	String email;
	Address add;
	CreditCard cc;
	Date dateJoined;
	
	public Customers() {
		
	}
	
	public Customers(String cid, String fname, String lname, String email, Address add, CreditCard cc,
			Date dateJoined) {
		this.cid = cid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.add = add;
		this.cc = cc;
		this.dateJoined = dateJoined;
	}

	public String getCid() {
		return cid;
	}

	public void setCid(String cid) {
		this.cid = cid;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLname() {
		return lname;
	}

	public void setLname(String lname) {
		this.lname = lname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Address getAdd() {
		return add;
	}

	public void setAdd(Address add) {
		this.add = add;
	}

	public CreditCard getCc() {
		return cc;
	}

	public void setCc(CreditCard cc) {
		this.cc = cc;
	}

	public Date getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}
	

}
