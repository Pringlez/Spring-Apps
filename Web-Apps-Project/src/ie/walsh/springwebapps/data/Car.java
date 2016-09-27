package ie.walsh.springwebapps.data;

import java.util.Date;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Car {

	private final Long id;
	private final String make;
	private final String model;
	private final Date time;
	
	public Car(String make, String model, Date time) {
		this(null, make, model, time);
	}
	
	public Car(Long id, String make, String model, Date time) {
		this.id = null;
		this.make = make;
		this.model = model;
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

	public Date getTime() {
		return time;
	}
}
