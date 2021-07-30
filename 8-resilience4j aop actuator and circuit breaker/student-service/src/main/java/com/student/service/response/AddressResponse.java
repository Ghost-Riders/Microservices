package com.student.service.response;

public class AddressResponse {

	private long AddressId;
	private String street;
	private String city;

	public AddressResponse() {
	}

	public long getAddressId() {
		return AddressId;
	}

	public void setAddressId(long addressId) {
		AddressId = addressId;
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
		return "AddressResponse [AddressId=" + AddressId + ", street=" + street + ", city=" + city + "]";
	}

}
