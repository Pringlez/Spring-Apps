package ie.walsh.springapps.wiring.javaconfig.example_2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

/**
 * Example of how to address ambiguities
 * Using annotations like '@Primary' can help solve the issue
 * Other annotations like '@Qualifier' can also be used
 * @author John
 *
 */
@Component
@Qualifier("ice-cream")
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
