package pruebaSpring;

import org.springframework.stereotype.Component;

@Component
public class AvionAdapter implements Transporte {
	private Avion avion;
	public AvionAdapter() {
		this.avion= new Avion();
	}
	public void arrancar() {
		avion.arrancarAvion();
	}

}
