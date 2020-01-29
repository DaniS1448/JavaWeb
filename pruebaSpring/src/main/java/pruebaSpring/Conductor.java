package pruebaSpring;

import java.io.FileInputStream;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class Conductor {

	@Autowired
	@Qualifier("avionAdapter")
	private Transporte transporte; // DEPENDENCIA

	public void conducir() {
		System.out.println("Vámonos");
		transporte.arrancar();
	}

}
