package no.hvl.entities;

import javax.persistence.*;

import no.hvl.entities.order.Reservation;
import no.hvl.services.ReservationInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "rentalOffice")
public class RentalOffice {


	@OneToOne
	@JoinColumn(name = "address", referencedColumnName = "streetAddress")
	private Address address;

	@Id
	@Column(name = "phone")
	private String phone;

	@OneToMany(mappedBy = "rentalOffice")
	private List<Car> cars;

	@ManyToOne
	@JoinColumn(name = "rentalCompany", referencedColumnName = "name")
	private RentalCompany rentalCompany;
	
	public RentalOffice(Address address, String phone, List<Car> cars) {
		this.address = address;
		this.phone = phone;
		this.cars = cars;
	}

	public RentalOffice() {

	}

	public List<Car> getAvailableCars() {
		return cars.stream().filter(Car::isAvailable).toList();
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
	
	public List<Car> getCars() {
		return cars;
	}
	
	public void setCars(List<Car> cars) {
		this.cars = cars;
	}
	
	public boolean addCar(Car car) {
		return cars.add(car);
	}
	
	public boolean removeCar(Car car) {
		return cars.remove(car);
	}

	@Override
	public int hashCode() {
		return Objects.hash(address, phone);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		RentalOffice other = (RentalOffice) obj;
		
		return Objects.equals(address, other.address) 
				&& Objects.equals(phone, other.phone);
	}

	@Override
	public String toString() {
		return "RentalOffice [address=" + address + ", phone=" + phone + "]";
	}

}
