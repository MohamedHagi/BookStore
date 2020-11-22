package Bean;

public class PurchaseOrder {
	
	private String POid;
	private String fname;
	private String lname;
	private String st;
	
	public PurchaseOrder(String POid, String fname, String lname, String st) {
		this.POid = POid;
		this.fname = fname;
		this.lname = lname;
		Status[] s = Status.values();
		for(int i = 0; i < s.length; i++) {
			if(s[i].toString().equals(st)) {
				this.st = st;
				break;
			}else {
				System.out.println("Wrong enum value");
				throw new IllegalArgumentException();
			}
		}
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

	public String getSt() {
		return st;
	}

	public void setSt(String st) {
		Status[] s = Status.values();
		for(int i = 0; i < s.length; i++) {
			if(s[i].toString().equals(st)) {
				this.st = st;
				break;
			}else {
				System.out.println("Wrong enum value");
				throw new IllegalArgumentException();
			}
		}
	}
}
