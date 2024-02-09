package no.hvl.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Objects;


@Entity
@Table(name = "address", schema = "dat109_oblig2")
public class Address {

	@Id
	@Column(name = "streetaddress")
	private String streetAddress;

	@Column(name = "postcode")
	private String postcode;

	@Column(name = "postalArea")
	private String postalArea;


	public Address(String streetAddress, String postcode, String postalArea) {
		this.streetAddress = streetAddress;
		this.postcode = postcode;
		this.postalArea = postalArea;
	}

	public Address() {

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
