package ie.walsh.springwebapps.data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class CarForm {

	@NotNull
	@Size(min=1, max=140)
	private String make;
	
	@NotNull
	@Size(min=1, max=140)
	private String model;

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
}
