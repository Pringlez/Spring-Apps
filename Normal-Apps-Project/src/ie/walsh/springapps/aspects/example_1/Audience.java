package ie.walsh.springapps.aspects.example_1;

import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

@Aspect
public class Audience {

	@Pointcut("execution(** ie.walsh.springapps.aspects.example_1.Performance.perform())")
	public void performance(){}
	
	@Before("performance()")
	public void silenceCellPhones(){
		System.out.println("Silencing Phones!");
	}
	
	@Before("performance()")
	public void takeSeats(){
		System.out.println("Taking Seats!");
	}
	
	@AfterReturning("performace()")
	public void applause(){
		System.out.println("CLAPING!");
	}
	
	@AfterThrowing("performance()")
	public void demandRefund(){
		System.out.println("Demanding a refund!");
	}
}
