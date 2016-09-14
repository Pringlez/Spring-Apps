package ie.walsh.springapps.wiring.autoconfig.example_2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
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
	
	public static void main(String[] args) {
		ApplicationContext context = 
				new AnnotationConfigApplicationContext(PersonConfig.class);
		Person person = context.getBean(Person.class);
		person.eatDessert(new Cookie());
	}
}
