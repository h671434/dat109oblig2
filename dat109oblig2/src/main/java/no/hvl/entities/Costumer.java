package no.hvl.entities;

import java.util.Objects;

public class Costumer {

	private String firstName;
	private String lastName;
	private Address address;
	private String phone;
	
	public Costumer(String firstName, String lastName, Address address, String phone) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.address = address;
		this.phone = phone;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, firstName, lastName, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Costumer other = (Costumer) obj;
		
		return Objects.equals(address, other.address) 
				&& Objects.equals(firstName, other.firstName)
				&& Objects.equals(lastName, other.lastName) 
				&& Objects.equals(phone, other.phone);
	}

	@Override
	public String toString() {
		return "Costumer [firstName=" + firstName + ", lastName=" + lastName + ", address=" + address + ", phone="
				+ phone + "]";
	}
	
}
