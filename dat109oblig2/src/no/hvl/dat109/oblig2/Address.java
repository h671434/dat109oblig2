package no.hvl.dat109.oblig2;

import java.util.Objects;

public class Address {

	private String streetAddress;
	private String postcode;
	private String postalArea;
	
	public Address(String streetAddress, String postcode, String postalArea) {
		this.streetAddress = streetAddress;
		this.postcode = postcode;
		this.postalArea = postalArea;
	}

	public String getStreetAddress() {
		return streetAddress;
	}
	
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	public String getPostcode() {
		return postcode;
	}
	
	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}
	
	public String getPostalArea() {
		return postalArea;
	}
	
	public void setPostalArea(String postalArea) {
		this.postalArea = postalArea;
	}

	@Override
	public int hashCode() {
		return Objects.hash(postalArea, postcode, streetAddress);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Address other = (Address) obj;
		
		return Objects.equals(postalArea, other.postalArea)
				&& Objects.equals(postcode, other.postcode)
				&& Objects.equals(streetAddress, other.streetAddress);
	}

	@Override
	public String toString() {
		return "Address [streetAddress=" + streetAddress + ", postcode=" + postcode + ", postalArea=" + postalArea
				+ "]";
	}	
	
}
