package main.java.walsh.springwebapps.data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * This class allows car data to be submitted to the database
 * @author John
 *
 */
public class CarForm {

	@NotNull
	@Size(min=1, max=256)
	private String make;
	
	@NotNull
	@Size(min=1, max=256)
	private String model;
	
	@NotNull
	@Size(min=1, max=256)
	private String color;
	
	@NotNull
	@Size(min=1, max=2147483647)
	private int mileage;
	
	@NotNull
	@Size(min=1, max=32767)
	private short year;
	
	@NotNull
	@Size(min=1, max=8388607)
	private int engineSize;
	
	@NotNull
	@Size(min=1, max=256)
	private String fuelType;
	
	@NotNull
	@Size(min=1, max=65535)
	private String description;
	
	@NotNull
	@Size(min=1, max=2147483647)
	private int price;

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
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

	public int getMileage() {
		return mileage;
	}

	public void setMileage(int mileage) {
		this.mileage = mileage;
	}

	public short getYear() {
		return year;
	}

	public void setYear(short year) {
		this.year = year;
	}

	public int getEngineSize() {
		return engineSize;
	}

	public void setEngineSize(int engineSize) {
		this.engineSize = engineSize;
	}

	public String getFuelType() {
		return fuelType;
	}

	public void setFuelType(String fuelType) {
		this.fuelType = fuelType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}
}
