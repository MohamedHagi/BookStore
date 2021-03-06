package Bean;

public class Visitors {

	String vID;
	String fname;
	String lname;
	String email;
	Address add;
	CreditCard cc;
	
	public Visitors(String vID, String fname, String lname, String email, Address add, CreditCard cc) {
		this.vID = vID;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.add = add;
		this.cc = cc;
	}

	public String getvID() {
		return vID;
	}

	public void setvID(String vID) {
		this.vID = vID;
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
	

}
