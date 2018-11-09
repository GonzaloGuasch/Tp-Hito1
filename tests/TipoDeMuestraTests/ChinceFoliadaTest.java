package TipoDeMuestraTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import Muestra.Verificacion;
import NivelesDeConocimiento.NivelDeConocimiento;
import TipoDeMuestra.ChinceFoliada;
import Usuarios.Usuario;

class ChinceFoliadaTest {
	@Mock NivelDeConocimiento nivelDeConocimientoMock1;
	@Mock NivelDeConocimiento nivelDeConocimientoMock2;
	@Mock NivelDeConocimiento nivelDeConocimientoMock3;

	@Mock Verificacion verificacionMock1;
	@Mock Verificacion verificacionMock2;
	@Mock Verificacion verificacionMock3;

	@Mock Usuario usuarioMock1;
	@Mock Usuario usuarioMock2;
	@Mock Usuario usuarioMock3;

	private ChinceFoliada tipoChinceFoliada;
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		tipoChinceFoliada = new ChinceFoliada();
	}
	@Test
	void testUnaChinceFoliadaSabeDecirSuTipo() {
		
		assertEquals("ChinceFoliada", tipoChinceFoliada.decirTipo());
	}
	@Test
	void testUnaChinceFoliadaPuedeHacerceCargoDeUnGrupoDeVerificaciones() {
		//caso ideal: los 3 verificaron que es chince
		Mockito.when(nivelDeConocimientoMock1.valor()).thenReturn(0);
		Mockito.when(nivelDeConocimientoMock2.valor()).thenReturn(1);
		Mockito.when(nivelDeConocimientoMock3.valor()).thenReturn(2);

		Mockito.when(usuarioMock1.getNivelDeConocimiento()).thenReturn(nivelDeConocimientoMock1);
		Mockito.when(usuarioMock1.getNivelDeConocimiento()).thenReturn(nivelDeConocimientoMock2);
		Mockito.when(usuarioMock1.getNivelDeConocimiento()).thenReturn(nivelDeConocimientoMock3);

		Mockito.when(verificacionMock1.getObservacionDeVerificador()).thenReturn("ChinceFoliada");
		Mockito.when(verificacionMock2.getObservacionDeVerificador()).thenReturn("ChinceFoliada");
		Mockito.when(verificacionMock3.getObservacionDeVerificador()).thenReturn("ChinceFoliada");

		Mockito.when(verificacionMock1.getVerificador()).thenReturn(usuarioMock1);
		Mockito.when(verificacionMock2.getVerificador()).thenReturn(usuarioMock2);
		Mockito.when(verificacionMock3.getVerificador()).thenReturn(usuarioMock3);
		
		ArrayList<Verificacion> verificaciones = new ArrayList<Verificacion>();
		verificaciones.add(verificacionMock1);
		verificaciones.add(verificacionMock2);
		verificaciones.add(verificacionMock3);

		assertTrue(tipoChinceFoliada.hacerseCargo(verificaciones));
	}
}
