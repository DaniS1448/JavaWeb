package pruebaSpring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan
public class Main {
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		Conductor conductor=null;
		
		ApplicationContext context;
		context = new AnnotationConfigApplicationContext(Main.class);
				
		conductor = (Conductor)context.getBean("conductor");
		conductor.conducir();
	}
}
