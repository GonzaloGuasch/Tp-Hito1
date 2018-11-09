package MuestraTests;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import Muestra.Verificacion;
import Usuarios.Usuario;


class VerificacionTest {
	
	@Mock Usuario usuarioMock;
	private Verificacion unaVerificacion;
	private LocalDate fechaDeHoy;
	@BeforeEach
	void setUp() {	
		MockitoAnnotations.initMocks(this);
		
		fechaDeHoy = LocalDate.now();
		unaVerificacion = new Verificacion(usuarioMock, "unString", fechaDeHoy);
	}
	@Test
	public void testunaVerificacionPuedeDarElAliasDeSuVerificador() {
		
		Mockito.when(usuarioMock.getAlias()).thenReturn("miAlias");
		
		assertEquals("miAlias", unaVerificacion.getAliasDeVerificador());
	}
	@Test
	public void testUnaVerificacionPuedeDarLaObservacionDelVerificador() {
		
		assertEquals("unString",unaVerificacion.getObservacionDeVerificador());
	}
	@Test
	public void testUnaVerificacionSabeDecirSiEsDeUnUsuario() {
		
		Mockito.when(usuarioMock.getAlias()).thenReturn("miAlias");
		
		assertTrue(unaVerificacion.esVerificacionDe("miAlias"));
	}
	@Test
	public void testUnaVerificacionPuedeRetornarSuUsuario() {
		
		assertEquals(usuarioMock,unaVerificacion.getVerificador());
	}
	@Test
	public void testunaVerificacionPuedeDarSuFechaDeCreacion() {
		
		assertEquals(fechaDeHoy,unaVerificacion.getFechaDeCreacion());
	}
}
