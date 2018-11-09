package NivelesDeVerificacionTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import Muestra.Muestra;
import NivelesDeVerificacion.Bajo;
import Usuarios.Usuario;

class BajaTest {
	@Mock Usuario usuarioMock;
	@Mock Muestra muestraMock;
	private Bajo nivelBajo;
	
	@BeforeEach
	public void setUp() {
		
		MockitoAnnotations.initMocks(this);
		nivelBajo = new Bajo();
	}
	@Test
	void testNivelBajoDeVerificacionPuedeHacerseCargoDeUnaMuestra() {
		///caso ideal: verifico 1 persona y es novata
		Mockito.when(usuarioMock.getTipoDeConocimiento()).thenReturn("Novato");
		
		Set<Usuario> setDeUsuarios= new HashSet<Usuario>();
		setDeUsuarios.add(usuarioMock);
		
		Mockito.when(muestraMock.cantidadDeVerificaciones()).thenReturn(1);
		Mockito.when(muestraMock.getUsuarios()).thenReturn(setDeUsuarios);

		assertTrue(nivelBajo.hacerseCargo(muestraMock));
	}
	@Test
	void testNivelBajoDeVerificacionPuedeHacerseCargoDeUnaMuestraCASO2() {
		///caso 2: verifico 1 persona y no es novata
		Mockito.when(usuarioMock.getTipoDeConocimiento()).thenReturn("Especialista");
		
		Set<Usuario> setDeUsuarios= new HashSet<Usuario>();
		setDeUsuarios.add(usuarioMock);
		
		Mockito.when(muestraMock.cantidadDeVerificaciones()).thenReturn(1);
		Mockito.when(muestraMock.getUsuarios()).thenReturn(setDeUsuarios);

		assertFalse(nivelBajo.hacerseCargo(muestraMock));
	}@Test
	void testNivelBajoDeVerificacionPuedeHacerseCargoDeUnaMuestraCASO3() {
		///caso 3: verifico mas de 1 persona y hay un novato
		Mockito.when(usuarioMock.getTipoDeConocimiento()).thenReturn("Novato");
		
		Usuario usuarioMock2 =Mockito.mock(Usuario.class);
		Mockito.when(usuarioMock2.getTipoDeConocimiento()).thenReturn("Experto");

		Set<Usuario> setDeUsuarios= new HashSet<Usuario>();
		setDeUsuarios.add(usuarioMock);
		setDeUsuarios.add(usuarioMock2);

		Mockito.when(muestraMock.cantidadDeVerificaciones()).thenReturn(2);
		Mockito.when(muestraMock.getUsuarios()).thenReturn(setDeUsuarios);

		assertFalse(nivelBajo.hacerseCargo(muestraMock));
	}

}
