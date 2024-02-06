package no.hvl.dat109.oblig2;

import java.util.List;
import java.util.Objects;

public class RentalOffice {

	private Address address;
	private String phone;
	private List<Car> cars;
	
	public RentalOffice(Address address, String phone, List<Car> cars) {
		this.address = address;
		this.phone = phone;
		this.cars = cars;
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
