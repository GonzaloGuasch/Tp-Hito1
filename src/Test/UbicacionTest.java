package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Aplicacion.Ubicacion;


class UbicacionTest {
	
	Ubicacion ubicacion; 
	
	@BeforeEach
	void setUp() {
		ubicacion = new Ubicacion(10d , 10d);
	}
	
	@Test
	void unaUbicacionTieneLatitudYLongitud() {
		
		
		assertEquals(new Double(10) , ubicacion.getLatitud());
		assertEquals(new Double(10) , ubicacion.getLongitud());
	}

}
