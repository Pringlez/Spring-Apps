package ie.walsh.springapps.wiring.autoconfig.example_2;

import org.springframework.stereotype.Component;

@Component
public class Jelly implements Dessert {
	
	public Jelly(){
		System.out.println("I'm Jelly!");
	}
	
	public Jelly jelly(){
		return new Jelly();
	}

	@Override
	public String getDessert() {
		return "Jelly";
	}
}
