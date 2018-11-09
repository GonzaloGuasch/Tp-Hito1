package TipoDeMuestraTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TipoDeMuestra.Indeterminada;

class Indeterminadatest {
	private Indeterminada tipoIndeterminado;
	@BeforeEach
	public void setUp() {
		tipoIndeterminado = new Indeterminada();
	}
	@Test
	void testElTipoIndeterminadoSabeDecirSuTipo() {
		
		assertEquals("Indeterminada", tipoIndeterminado.decirTipo());
	}

}
