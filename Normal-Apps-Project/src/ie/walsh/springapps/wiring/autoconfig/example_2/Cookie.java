package ie.walsh.springapps.wiring.autoconfig.example_2;

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
@Qualifier("cookie")
public class Cookie implements Dessert {
	
	public Cookie(){
		System.out.println("I'm a Cookie!");
	}
	
	public Cookie cookie(){
		return new Cookie();
	}

	@Override
	public String getDessert() {
		return "Cookies";
	}
}
