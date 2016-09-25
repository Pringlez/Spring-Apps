package ie.walsh.springwebapps.data;

import java.util.Date;

public class ExampleData {

	private final Long id;
	private final String message;
	private final Date time;
	private Double latitude;
	private Double longitude;
	
	public ExampleData(String message, Date time) {
		this(null, message, time, null, null);
	}
	
	public ExampleData(Long id, String message, Date time, Double longitude, Double latitude) {
		this.id = null;
		this.message = message;
		this.time = time;
		this.longitude = longitude;
		this.latitude = latitude;
	}
	
	@Override
	public boolean equals(Object that) {
		//return EqualsBuilder.reflectionEquals(this, that, "id", "time");
		return true;
	}
	
	@Override
	public int hashCode() {
		//return HashCodeBuilder.reflectionHashCode(this, "id", "time");
		return 0;
	}

	public Long getId() {
		return id;
	}

	public String getMessage() {
		return message;
	}

	public Date getTime() {
		return time;
	}

	public Double getLatitude() {
		return latitude;
	}

	public Double getLongitude() {
		return longitude;
	}
}
