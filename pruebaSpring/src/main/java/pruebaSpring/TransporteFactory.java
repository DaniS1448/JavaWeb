package pruebaSpring;

import java.io.FileInputStream;
import java.util.Properties;

public class TransporteFactory {
	private static TransporteFactory transporteFactory;
	private Transporte transporte;

	public static TransporteFactory getTransporteFactory() {
		if (transporteFactory == null) {
			transporteFactory = new TransporteFactory();
		}
		return transporteFactory;
	}
	
	private TransporteFactory() {
		Properties p = new Properties();
		try {
			p.load(new FileInputStream("transportes.txt"));
			this.transporte = (Transporte) (Class.forName(p.getProperty("transporte")).newInstance());
		} catch (Exception e) {

		}
	}

	public Transporte getTransporte() {
		return transporte;
	}
	
	

}
