package no.hvl.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "RentalCompany", schema = "dat109_oblig2")
public class RentalCompany {

	@Id
	@Column(name = "name")
	private String name;

	@Column(name = "phone")
	private String phone;

	@OneToOne
	@JoinColumn(name = "address", referencedColumnName = "streetAddress")
	private Address companyAddress;

	@OneToMany(mappedBy = "rentalCompany")
	private List<RentalOffice> officeList;
	
	public RentalCompany(String name, String phone, Address companyAddress) {
		this.name = name;
		this.phone = phone;
		this.companyAddress = companyAddress;
	}

	public RentalCompany() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Address getCompanyAddress() {
		return companyAddress;
	}

	public void setCompanyAddress(Address companyAddress) {
		this.companyAddress = companyAddress;
	}

	@Override
	public int hashCode() {
		return Objects.hash(companyAddress, name, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		RentalCompany other = (RentalCompany) obj;
		
		return Objects.equals(companyAddress, other.companyAddress) 
				&& Objects.equals(name, other.name)
				&& Objects.equals(phone, other.phone);
	}

	@Override
	public String toString() {
		return "RentalCompany [name=" + name + ", phone=" + phone + ", companyAddress=" + companyAddress + "]";
	}
	
}
