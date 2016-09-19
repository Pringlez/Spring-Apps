package ie.walsh.springapps.wiring.autoconfig.example_2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class PersonConfig { 
	
	@Bean
	Dessert mockMessageService() {
		return new Dessert() {
			public String getDessert() {
				return "I'm a Dessert!";
			}
		};
	}
}
