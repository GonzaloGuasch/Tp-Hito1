package NivelesDeVerificacionTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import Muestra.Muestra;
import NivelesDeVerificacion.Media;
import Usuarios.Usuario;

class MediaTest {
	@Mock Usuario usuarioMock;
	@Mock Muestra muestraMock;
	private Media nivelMedio;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		nivelMedio = new Media();
	}

	@Test
	void testNivelMedioPuedeHacerseCargoDeUnaMuestra() {
		//caso limite: no verifico 2 novatos y no verifico 1 experto
		Mockito.when(usuarioMock.getTipoDeConocimiento()).thenReturn("Novato");
		
		Set<Usuario> setDeUsuarios= new HashSet<Usuario>();
		setDeUsuarios.add(usuarioMock);
		
		Mockito.when(muestraMock.cantidadDeVerificaciones()).thenReturn(1);
		Mockito.when(muestraMock.getUsuarios()).thenReturn(setDeUsuarios);

		
		assertFalse(nivelMedio.hacerseCargo(muestraMock));
	}
	@Test
	void testNivelMedioPuedeHacerseCargoDeUnaMuestraCASO2() {
		//caso 2: no verifico 2 novatos y verifico 1 experto
		Mockito.when(usuarioMock.getTipoDeConocimiento()).thenReturn("Experto");
		
		Set<Usuario> setDeUsuarios= new HashSet<Usuario>();
		setDeUsuarios.add(usuarioMock);
		
		Mockito.when(muestraMock.cantidadDeVerificaciones()).thenReturn(1);
		Mockito.when(muestraMock.getUsuarios()).thenReturn(setDeUsuarios);

		
		assertTrue(nivelMedio.hacerseCargo(muestraMock));
	}
	@Test
	void testNivelMedioPuedeHacerseCargoDeUnaMuestraCASO3() {
		//caso 3:  verifico 2 novatos y no verifico 1 experto
		Usuario usuarioMock2 = Mockito.mock(Usuario.class);
		
		Mockito.when(usuarioMock2.getTipoDeConocimiento()).thenReturn("Novato");
		Mockito.when(usuarioMock.getTipoDeConocimiento()).thenReturn("Novato");
		
		Set<Usuario> setDeUsuarios= new HashSet<Usuario>();
		setDeUsuarios.add(usuarioMock);
		setDeUsuarios.add(usuarioMock2);

		Mockito.when(muestraMock.cantidadDeVerificaciones()).thenReturn(2);
		Mockito.when(muestraMock.getUsuarios()).thenReturn(setDeUsuarios);

		assertTrue(nivelMedio.hacerseCargo(muestraMock));
	}

}
