package no.hvl.dat109.oblig2;

import java.util.Objects;

public class Car {

	private String registrationNr;
	private String brand;
	private String model;
	private String color;
	private RentalGroup group;
	private boolean available;
	
	public Car(String registrationNr, String brand, String model, String color, RentalGroup group, boolean available) {
		this.registrationNr = registrationNr;
		this.brand = brand;
		this.model = model;
		this.color = color;
		this.group = group;
		this.available = available;
	}

	public String getRegistrationNr() {
		return registrationNr;
	}

	public void setRegistrationNr(String registrationNr) {
		this.registrationNr = registrationNr;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public RentalGroup getGroup() {
		return group;
	}

	public void setGroup(RentalGroup group) {
		this.group = group;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public int hashCode() {
		return Objects.hash(available, brand, color, group, model, registrationNr);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		
		Car other = (Car) obj;
		
		return available == other.available 
				&& Objects.equals(brand, other.brand)
				&& Objects.equals(color, other.color)
				&& group == other.group 
				&& Objects.equals(model, other.model)
				&& Objects.equals(registrationNr, other.registrationNr);
	}

	@Override
	public String toString() {
		return "Car [registrationNr=" + registrationNr + ", brand=" + brand + ", model=" + model + ", color=" + color
				+ ", group=" + group + ", available=" + available + "]";
	}
	
}
