package pruebaSpring;

public class CocheAdapter implements Transporte {
	
	private Coche coche;
	
	public CocheAdapter() {
		this.coche = new Coche();
	}
	
	public void on() {
		coche.arrancar();
	}

}
