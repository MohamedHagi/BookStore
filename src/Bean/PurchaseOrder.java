package Bean;

public class PurchaseOrder {
	
	private String POid;
	private String fname;
	private String lname;
	private Status st;
	
	public PurchaseOrder(String POid, String fname, String lname, Status st) {
		this.POid = POid;
		this.fname = fname;
		this.lname = lname;
		this.st = st;
	}

	public String getPOid() {
		return POid;
	}

	public void setPOid(String pOid) {
		POid = pOid;
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

	public Status getSt() {
		return st;
	}

	public void setSt(Status st) {
		this.st = st;
	}
}
