package ie.walsh.springapps.wiring.javaconfig.example_2;

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
		person.setDessert(ctx.getBean(IceCream.class));
		person.setDessert(ctx.getBean(Jelly.class));
		person.setDessert(ctx.getBean(Cookie.class));
	}
}
