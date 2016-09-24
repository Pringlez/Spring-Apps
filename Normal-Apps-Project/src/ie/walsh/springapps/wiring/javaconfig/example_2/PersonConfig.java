package ie.walsh.springapps.wiring.javaconfig.example_2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class PersonConfig { 
	
	@Bean
	public Dessert getIceCream(){
		return new IceCream();
	}
	
	@Bean
	@Primary
	public Dessert getCookie(){
		return new Cookie();
	}
	
	@Bean
	public Dessert getJelly(){
		return new Jelly();
	}
	
	@Bean
	public Person setPersonalDessert(Dessert dessert) {
		return new Person(dessert);
	}
}
