package Bean;

import java.util.Date;

public class CreditCard {
	
	String ccId;
	Date expirydate;
	String cardno;
	String csv;
	String fname;
	String lnmae;
	
	public CreditCard(Date expirydate, String cardno, String csv, String fname, String lnmae) {
		this.expirydate = expirydate;
		this.cardno = cardno;
		this.csv = csv;
		this.fname = fname;
		this.lnmae = lnmae;
	}

	public Date getExpirydate() {
		return expirydate;
	}

	public void setExpirydate(Date expirydate) {
		this.expirydate = expirydate;
	}

	public String getCardno() {
		return cardno;
	}

	public void setCardno(String cardno) {
		this.cardno = cardno;
	}

	public String getCsv() {
		return csv;
	}

	public void setCsv(String csv) {
		this.csv = csv;
	}

	public String getFname() {
		return fname;
	}

	public void setFname(String fname) {
		this.fname = fname;
	}

	public String getLnmae() {
		return lnmae;
	}

	public void setLnmae(String lnmae) {
		this.lnmae = lnmae;
	}
}
