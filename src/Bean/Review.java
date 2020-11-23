package Bean;

public class Review {
	
	private int rid;
	private String bid;
	private String review;
	private String bname;
	
	public Review(int rid, String bid, String review, String bname) {
		this.rid = rid;
		this.bid = bid;
		this.review = review;
		this.bname = bname;
	}

	public int getRid() {
		return rid;
	}

	public void setRid(int rid) {
		this.rid = rid;
	}

	public String getBid() {
		return bid;
	}

	public void setBid(String bid) {
		this.bid = bid;
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
	
}
