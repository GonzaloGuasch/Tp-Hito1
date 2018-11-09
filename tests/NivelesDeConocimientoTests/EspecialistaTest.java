package NivelesDeConocimientoTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import NivelesDeConocimiento.Especialista;

class EspecialistaTest {
	
	private Especialista nivelEspecialista;
	
	@BeforeEach
	public void setUp() {
		nivelEspecialista = new Especialista();
	}
	@Test
	public void testTieneRankingDeConocimiento2() {
		
		assertEquals("Especialista", nivelEspecialista.getTipo());
	}
}
