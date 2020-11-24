package Bean;

import java.util.Date;

public class Partners {
	
	String pID;
	String fname;
	String lname;
	String email;
	Address add;
	int sharePercent;
	
	public Partners(String pID, String fname, String lname, String email, Address add, int sharePercent,
			Date dateJoined) {
		this.pID = pID;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.add = add;
		this.sharePercent = sharePercent;
	}

	public String getpID() {
		return pID;
	}

	public void setpID(String pID) {
		this.pID = pID;
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

	public int getSharePercent() {
		return sharePercent;
	}

	public void setSharePercent(int sharePercent) {
		this.sharePercent = sharePercent;
	}
	

}
