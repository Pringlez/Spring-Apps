package ie.walsh.springapps.wiring.autoconfig.example_2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Person implements Consumer {

	public Dessert dessert;
	
	@Autowired
	public Person(Dessert dessert){
		this.dessert = dessert;
	}

	@Override
	public void eatDessert(Dessert dessert){
		System.out.println("The person is eating: " + dessert.getDessert());
	}
	
	@Qualifier("cookie")
	public void setDessert(Dessert dessert){
		System.out.println("The person's new favourite dessert is now: " + dessert.getDessert());
		this.dessert = dessert;
	}
}
