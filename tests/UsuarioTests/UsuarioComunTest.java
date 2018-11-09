package UsuarioTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import Aplicacion.AplicacionVinchuca;
import Muestra.Muestra;
import NivelesDeConocimiento.Novato;
import Usuarios.Usuario;
import Usuarios.UsuarioComun;


class UsuarioComunTest {
	
	@Mock Muestra muestraMock;
	@Mock AplicacionVinchuca aplicacionMock;
	@Mock Novato novatoMock;
	
	private Usuario unUsuario;
	@BeforeEach
	void setUp() {
		
		MockitoAnnotations.initMocks(this);
		unUsuario = new UsuarioComun("alias",novatoMock);
	}
	@Test
	public void testunUsuarioSabeDarSuAlias() {
		
		assertEquals("alias", unUsuario.getAlias());
	}
	@Test
	public void testunUsuarioComunSabeDarSuNivelDeConocimiento() {
		
		Mockito.when(novatoMock.getTipo()).thenReturn("Novato");
		assertEquals("Novato",unUsuario.getNivelDeConocimiento().getTipo());
	}
	@Test
	public void testUnUsuarioComunPuedeDarSuTipoDeConocimiento() {
		Mockito.when(novatoMock.getTipo()).thenReturn("Novato");
		
		assertEquals("Novato", unUsuario.getTipoDeConocimiento());
	}
	@Test
	public void testUnUsuarioSabeEnviarUnaMuestra() {
		
		unUsuario.enviarMuestra(muestraMock, aplicacionMock);
		
		Mockito.verify(aplicacionMock,Mockito.times(1)).recibirMuestra(muestraMock);
	}
	/**@Test
	public void testUnUsuarioComunSabeVerificarUnaMuestra() {
		//caso ideal: el usuario puede verificar
		
		Verificacion verificacionMock = Mockito.mock(Verificacion.class);
		
		Mockito.when(muestraMock.esMuestraVerificablePara(unUsuario.getAlias())).thenReturn(true);
		Mockito.doCallRealMethod().when(muestraMock).agregarVerificacion(verificacionMock);
		Mockito.doCallRealMethod().when(aplicacionMock).getMuestras();
		
		unUsuario.verificarMuestra(verificacionMock, muestraMock, aplicacionMock);
		assertEquals(1,(aplicacionMock.getMuestras()).size());
	}**/
	///NECESITO USAR MENSAJE .doAnswer() para decirle a la muestra que hacer cuando tiene que agregar la veerificacion
}