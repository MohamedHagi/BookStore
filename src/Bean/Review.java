package Bean;

import java.sql.Date;

public class Review {
	
	private int rid;
	private String review;
	private String bname;
	private Date date;
	private int customID;
	
	public Review() {
		
	}
	
	public Review(int rid, String review, String bname, Date date, int customID) {
		super();
		this.rid = rid;
		this.review = review;
		this.bname = bname;
		this.date = date;
		this.customID = customID;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getReview() {
		return review;
	}

	public void setReview(String review) {
		this.review = review;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getCustomID() {
		return customID;
	}

	public void setCustomID(int customID) {
		this.customID = customID;
	}
	
}
