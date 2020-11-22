package Bean;

import java.util.Date;

public class Users {
	
	private String uID;
	private Date dateJoined;
	
	public Users(String uID, Date dateJoined) {
		this.uID = uID;
		this.dateJoined = dateJoined;
	}

	public String getuID() {
		return uID;
	}

	public void setuID(String uID) {
		this.uID = uID;
	}

	public Date getDateJoined() {
		return dateJoined;
	}

	public void setDateJoined(Date dateJoined) {
		this.dateJoined = dateJoined;
	}
	
}
