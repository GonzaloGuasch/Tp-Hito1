package TipoDeMuestraTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TipoDeMuestra.Vinchuca;

class VinchucaTest {
	private Vinchuca tipoVinchuca;
	@BeforeEach
	public void setUp() {
		
		tipoVinchuca= new Vinchuca();
	}
	@Test
	void testUnTipoVinchucaSabeDecirSuTipo() {
		
		assertEquals("Vinchuca", tipoVinchuca.decirTipo());
	}

}
