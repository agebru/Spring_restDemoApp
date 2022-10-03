package com.demo.model;

import javax.persistence.Embeddable;

@Embeddable
public class Address {
	private Integer zipCode;
	private String street;
	private String city;
	
	public Address() {}

	
	public Address(Integer zipCode, String street, String city) {
		super();
		this.zipCode = zipCode;
		this.street = street;
		this.city = city;
	}


	public Integer getZipCode() {
		return zipCode;
	}


	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}


	public String getStreet() {
		return street;
	}


	public void setStreet(String street) {
		this.street = street;
	}


	public String getCity() {
		return city;
	}


	public void setCity(String city) {
		this.city = city;
	}


	@Override
	public String toString() {
		return "Address [zipCode=" + zipCode + ", street=" + street + ", city=" + city + "]";
	}
	

}
