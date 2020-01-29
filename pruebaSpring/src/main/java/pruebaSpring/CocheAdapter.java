package pruebaSpring;

import org.springframework.stereotype.Component;

@Component
public class CocheAdapter implements Transporte {
	private Coche coche;
	public CocheAdapter() {
		this.coche = new Coche();
	}
	public void arrancar() {
		coche.arrancarCoche();
	}

}
