package edu.osu.cse5234.model;

public class ShippingInfo {

	private String name;
	
	private String addressLine1;
	
	private String addressLine2;
	
	private String city;
	
	private String state;
	
	private String zip;

	public ShippingInfo() {
		
	}
	
	public String getName() {
		return name;
	}

	public void setName(String newName) {
		this.name = newName;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String newNddressLine1) {
		this.addressLine1 = newNddressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String newAddressLine2) {
		this.addressLine2 = newAddressLine2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String newCity) {
		this.city = newCity;
	}

	public String getState() {
		return state;
	}

	public void setState(String newState) {
		this.state = newState;
	}

	public String getZip() {
		return zip;
	}

	public void setZip(String newZip) {
		this.zip = newZip;
	}

}
