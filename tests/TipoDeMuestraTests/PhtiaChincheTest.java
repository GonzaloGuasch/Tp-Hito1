package TipoDeMuestraTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import TipoDeMuestra.PhtiaChinche;

class PhtiaChincheTest {
	private PhtiaChinche tipoPhtiaChinche;
	@BeforeEach
	void setUp(){
		tipoPhtiaChinche = new PhtiaChinche();
	}
	@Test
	void testElTipoPhtiaChincheSabeDecirSuTipo() {
		
		assertEquals("PhtiaChince", tipoPhtiaChinche.decirTipo());
	}

}
