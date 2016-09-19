package ie.walsh.springapps.wiring.autoconfig.example_2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Runner {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		ApplicationContext ctx = 
				new AnnotationConfigApplicationContext(PersonConfig.class);
		
		// Can access beans by using the 'ctx' variable
		Person person = ctx.getBean(Person.class);
		
		person.eatDessert(ctx.getBean(Cookie.class));
	}
}
