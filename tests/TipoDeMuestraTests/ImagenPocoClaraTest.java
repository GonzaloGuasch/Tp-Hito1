package TipoDeMuestraTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TipoDeMuestra.ImagenPocoClara;

class ImagenPocoClaraTest {
	
	private ImagenPocoClara tipoImagenPocoClara;
	@BeforeEach
	public void setUp() {
		
		tipoImagenPocoClara = new ImagenPocoClara();
	}
	@Test
	void testunTipoDeMuestraSabeDecirSuTipo(){
		
		assertEquals("ImagenPocoClara", tipoImagenPocoClara.decirTipo());
	}
}
