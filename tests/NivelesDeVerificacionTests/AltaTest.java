package NivelesDeVerificacionTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import Muestra.Muestra;
import NivelesDeConocimiento.NivelDeConocimiento;
import NivelesDeVerificacion.Alta;
import Usuarios.Usuario;

class AltaTest {
	
	@Mock Muestra muestraMock;
	@Mock NivelDeConocimiento especialistaMock;
	@Mock NivelDeConocimiento expertoMock;
	@Mock Usuario usuarioMock1;
	@Mock Usuario usuarioMock2;
	@Mock Usuario usuarioMock3;
	
	private Set<Usuario> setDeUsuarios;
	private Alta nivelDeVerificacionAlto;
	@BeforeEach
	public void setUp() {
		setDeUsuarios = new HashSet<Usuario>();
		setDeUsuarios.add(usuarioMock1);
		setDeUsuarios.add(usuarioMock2);
		setDeUsuarios.add(usuarioMock3);
		
		MockitoAnnotations.initMocks(this);
		nivelDeVerificacionAlto = new Alta();
	}
	@Test
	void testNivelDeVerificacionAltoPuedeHacerseCargoDeUnaMuestra() {
		//caso ideal: verificaron 3, verifico 1 especialista y 2 expertos
		Mockito.when(especialistaMock.valor()).thenReturn(2);
		Mockito.when(expertoMock.valor()).thenReturn(1);

		Mockito.when(usuarioMock1.getTipoDeConocimiento()).thenReturn("Especialista");
		Mockito.when(usuarioMock1.getNivelDeConocimiento()).thenReturn(especialistaMock);
		
		Mockito.when(usuarioMock2.getTipoDeConocimiento()).thenReturn("Experto");
		Mockito.when(usuarioMock2.getNivelDeConocimiento()).thenReturn(expertoMock);

		Mockito.when(usuarioMock3.getTipoDeConocimiento()).thenReturn("Experto");
		Mockito.when(usuarioMock3.getNivelDeConocimiento()).thenReturn(expertoMock);

		Mockito.when(muestraMock.cantidadDeVerificaciones()).thenReturn(3);
		Mockito.when(muestraMock.getUsuarios()).thenReturn(setDeUsuarios);

		assertTrue(nivelDeVerificacionAlto.hacerseCargo(muestraMock));
	}
	@Test
	void testNivelDeVerificacionAltoPuedeHacerseCargoDeUnaMuestraCASO2() {
		//caso caso2: verificaron 3, no verifico 1 especialista y no son 2 expertos
		Mockito.when(especialistaMock.valor()).thenReturn(0);
		Mockito.when(expertoMock.valor()).thenReturn(0);

		Mockito.when(usuarioMock1.getTipoDeConocimiento()).thenReturn("Novato");
		Mockito.when(usuarioMock1.getNivelDeConocimiento()).thenReturn(especialistaMock);
		
		Mockito.when(usuarioMock2.getTipoDeConocimiento()).thenReturn("Novato");
		Mockito.when(usuarioMock2.getNivelDeConocimiento()).thenReturn(expertoMock);

		Mockito.when(usuarioMock3.getTipoDeConocimiento()).thenReturn("Novato");
		Mockito.when(usuarioMock3.getNivelDeConocimiento()).thenReturn(expertoMock);

		Mockito.when(muestraMock.cantidadDeVerificaciones()).thenReturn(3);
		Mockito.when(muestraMock.getUsuarios()).thenReturn(setDeUsuarios);

		assertTrue(nivelDeVerificacionAlto.hacerseCargo(muestraMock));
	}
	@Test
	void testNivelDeVerificacionAltoPuedeHacerseCargoDeUnaMuestraCASO3() {
		//caso caso3: no verificaron 3, no verifico 1 especialista y no son 2 expertos
		Mockito.when(especialistaMock.valor()).thenReturn(0);
		Mockito.when(expertoMock.valor()).thenReturn(0);

		Mockito.when(usuarioMock1.getTipoDeConocimiento()).thenReturn("Novato");
		Mockito.when(usuarioMock1.getNivelDeConocimiento()).thenReturn(especialistaMock);
		
		Mockito.when(usuarioMock2.getTipoDeConocimiento()).thenReturn("Novato");
		Mockito.when(usuarioMock2.getNivelDeConocimiento()).thenReturn(expertoMock);

		Mockito.when(usuarioMock3.getTipoDeConocimiento()).thenReturn("Novato");
		Mockito.when(usuarioMock3.getNivelDeConocimiento()).thenReturn(expertoMock);

		Mockito.when(muestraMock.cantidadDeVerificaciones()).thenReturn(2);
		
		Set<Usuario> setDeUsuarios2= new HashSet<Usuario>();
		setDeUsuarios.add(usuarioMock1);
		setDeUsuarios.add(usuarioMock2);
		
		Mockito.when(muestraMock.getUsuarios()).thenReturn(setDeUsuarios2);

		assertFalse(nivelDeVerificacionAlto.hacerseCargo(muestraMock));
	}

}
