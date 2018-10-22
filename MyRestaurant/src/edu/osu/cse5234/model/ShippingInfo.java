package edu.osu.cse5234.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="SHIPPING_INFO")
public class ShippingInfo {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="ID")
	private int id;

	@Column(name="NAME")
	private String name;
	
	@Column(name="ADDRESS1")
	private String addressLine1;
	
	@Column(name="ADDRESS2")
	private String addressLine2;
	
	@Column(name="CITY")
	private String city;
	
	@Column(name="STATE")
	private String state;
	
	@Column(name="COUNTRY")
	private String country;

	@Column(name="ZIP")
	private String zip;

	public ShippingInfo() {
		
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
	
	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

}
