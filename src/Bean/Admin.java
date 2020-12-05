package Bean;


public class Admin {

	String aID;
	String fname;
	String lname;
	String email;
	Address add;
	
	public Admin() {
		
	}

	public Admin(String aID, String fname, String lname, String email, Address add) {
		this.aID = aID;
		this.fname = fname;
		this.lname = lname;
		this.email = email;
		this.add = add;
	}

	public String getaID() {
		return aID;
	}

	public void setaID(String aID) {
		this.aID = aID;
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
	

}
