package interfaceAdapterClass;

public class AvionAdapter implements Transporte {
	
	private Avion avion;
	
	public AvionAdapter() {
		this.avion = new Avion();
	}
	
	public void on() {
		avion.start();
	}

}
