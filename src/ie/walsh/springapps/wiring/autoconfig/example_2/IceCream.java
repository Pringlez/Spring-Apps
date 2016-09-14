package ie.walsh.springapps.wiring.autoconfig.example_2;

import org.springframework.stereotype.Component;

@Component
public class IceCream implements Dessert {
	
	public IceCream(){
		System.out.println("I'm Ice-Cream!");
	}
	
	public IceCream iceCream(){
		return new IceCream();
	}

	@Override
	public String getDessert() {
		return "Ice-Cream";
	}
}
