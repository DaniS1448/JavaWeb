package pruebaSpring;

import org.springframework.stereotype.Component;

@Component
public class CoheteAdapter implements Transporte {
	private Cohete cohete;
	public CoheteAdapter() {
		this.cohete= new Cohete();
	}
	public void arrancar() {
		cohete.arrancarCohete();
	}

}
