package Bean;

public class Address {
	
	private String aid;
	private String street;
	private int streetNo;
	private int unitNo;
	private String province;
	private String country;
	private String phoneNo;
	
	public Address() {
		
	}
	
	public Address(String aid, String street, int streetNo, int unitNo, String province, String country,
			String phoneNo) {
		this.aid = aid;
		this.street = street;
		this.streetNo = streetNo;
		this.unitNo = unitNo;
		this.province = province;
		this.country = country;
		this.phoneNo = phoneNo;
	}

	public String getAid() {
		return aid;
	}

	public void setAid(String aid) {
		this.aid = aid;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getStreetNo() {
		return streetNo;
	}

	public void setStreetNo(int streetNo) {
		this.streetNo = streetNo;
	}

	public int getUnitNo() {
		return unitNo;
	}

	public void setUnitNo(int unitNo) {
		this.unitNo = unitNo;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
}
