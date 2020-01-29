package interfaceAdapterClass;

public class CoheteAdapter implements Transporte {
	
	private Cohete cohete;
	
	public CoheteAdapter() {
		this.cohete = new Cohete();
	}
	
	public void on() {
		cohete.plug();
	}

}
