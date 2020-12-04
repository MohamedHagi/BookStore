package Bean;

public class ShippingCountryInfo {
	private int spiID;
	private String country; 
	private double taxRate; 
	private double Tariffs; 
	private String carrier;
	private double carrierFlatRate;
	
	public ShippingCountryInfo() {
		
	}
	
	public ShippingCountryInfo(int spiID, String country, double taxRate, double tariffs, String carrier, double carrierFlatRate) {
		super();
		this.spiID = spiID;
		this.country = country;
		this.taxRate = taxRate;
		Tariffs = tariffs;
		this.carrier = carrier;
		this.carrierFlatRate = carrierFlatRate;
	}

	public double getCarrierFlatRate() {
		return carrierFlatRate;
	}

	public void setCarrierFlatRate(double carrierFlatRate) {
		this.carrierFlatRate = carrierFlatRate;
	}

	public int getSpiID() {
		return spiID;
	}

	public void setSpiID(int spiID) {
		this.spiID = spiID;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public double getTaxRate() {
		return taxRate;
	}

	public void setTaxRate(double taxRate) {
		this.taxRate = taxRate;
	}

	public double getTariffs() {
		return Tariffs;
	}

	public void setTariffs(double tariffs) {
		Tariffs = tariffs;
	}

	public String getCarrier() {
		return carrier;
	}

	public void setCarrier(String carrier) {
		this.carrier = carrier;
	}
}
