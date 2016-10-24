package ie.walsh.springwebapps.data;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Car {

	private final Long id;
	private final String make;
	private final String model;
	private final String color;
	private final int mileage;
	private final short year;
	private final int engineSize;
	private final String fuelType;
	private final String description;
	private final int price;
	private final Date time;
	
	public Car(String make, String model, Date time) {
		this(null, make, model, time);
	}
	
	public Car(Long id, String make, String model, Date time) {
		this.id = null;
		this.make = make;
		this.model = model;
		this.color = null;
		this.mileage = 0;
		this.year = 0;
		this.engineSize = 0;
		this.fuelType = null;
		this.description = null;
		this.price = 0;
		this.time = time;
	}
	
	public Car(Long id, String make, String model, String color, int mileage, short year, int engineSize, String fuelType, String description, int price, Date time) {
		this.id = null;
		this.make = make;
		this.model = model;
		this.color = color;
		this.mileage = mileage;
		this.year = year;
		this.engineSize = engineSize;
		this.fuelType = fuelType;
		this.description = description;
		this.price = price;
		this.time = time;
	}
	
	@Override
	public boolean equals(Object that) {
		return EqualsBuilder.reflectionEquals(this, that, "id", "time");
	}
	
	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, "id", "time");
	}

	public Long getId() {
		return id;
	}

	public String getMake() {
		return make;
	}

	public String getModel() {
		return model;
	}

	public String getColor() {
		return color;
	}

	public int getMileage() {
		return mileage;
	}

	public short getYear() {
		return year;
	}

	public int getEngineSize() {
		return engineSize;
	}

	public String getFuelType() {
		return fuelType;
	}

	public String getDescription() {
		return description;
	}

	public int getPrice() {
		return price;
	}

	public Date getTime() {
		return time;
	}
}
