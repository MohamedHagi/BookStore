package Bean;

import java.util.Date;

public class Customers {

	int cid;
	String fname;
	String lname;
	String email;
	Address add;
	CreditCard cc;
	Date dateJoined;
	boolean lock;
	
	public Customers() {
		
	}
	
	public Customers(int cid, String fname, String lname, String email, Address add, CreditCard cc,
			Date dateJoined, boolean lock) {
		this.cid = cid;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.add = add;
		this.cc = cc;
		this.dateJoined = dateJoined;
		this.lock = lock;
	}

	public boolean isLock() {
		return lock;
	}

	public void setLock(boolean lock) {
		this.lock = lock;
	}

	public int getCid() {
		return cid;
	}

	public void setCid(int cid) {
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
