package ie.walsh.springapps.wiring.autoconfig.example_2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * Example of how to address ambiguities
 * Using annotations like '@Primary' can help solve the issue
 * Other annotations like '@Qualifier' can also be used
 * @author John
 *
 */
@Component
@Qualifier("jelly")
@Primary
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
