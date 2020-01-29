package pruebaSpring;

public class Conductor {
	
	private Transporte transporte;
	
	public Conductor() {
		this.transporte = new CocheAdapter();
	}
	
	public void conducir() {
		System.out.println("vamos a conducir");
		this.transporte.on();
	}

}
