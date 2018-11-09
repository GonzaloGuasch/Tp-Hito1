package MuestraTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;
import org.mockito.Mockito;

import Aplicacion.Ubicacion;
import Muestra.Muestra;
import Muestra.Verificacion;
import Muestra.VerificadorDeMuestra;
import NivelesDeVerificacion.Alta;
import Usuarios.Usuario;



class MuestraTest {
	
	@Mock Verificacion verificacionMock;
	@Mock VerificadorDeMuestra verificadorMock;
	@Mock Usuario usuarioMock;
	private Ubicacion unaUbicacion;
	private Muestra unaMuestra;
	
	@BeforeEach
	void setUp() {
		MockitoAnnotations.initMocks(this);
		unaUbicacion = new Ubicacion(10d, 20d);
		
		unaMuestra = new Muestra(verificacionMock, "foto", unaUbicacion, verificadorMock);
	}
	@Test
	public void testUnaMuestraSabeDecirSuNivelDeVerificacion() {
		Alta nivelalto= new Alta();
		
		Mockito.when(verificadorMock.getNivelDeVerificacion(unaMuestra)).thenReturn(nivelalto);
		
		assertEquals(nivelalto,unaMuestra.getNivelDeVerificion());
	}
	@Test
	public void testUnaMuestraSabeDarSuUbicacion() {
		
		assertEquals(new Double(10),unaMuestra.getUbicacion().getLatitud());
		assertEquals(new Double(20),unaMuestra.getUbicacion().getLongitud());
	}
	@Test
	public void testUnaMuestraSabeDarSuFotografia() {
		
		assertEquals("foto", unaMuestra.getFotografia());
	}
	@Test 
	public void testUnaMuestraSabeDecirSuCantidadDeVerificaciones() {
		
		Mockito.when(verificadorMock.getCantidadDeVerificaciones()).thenReturn(1);
		assertEquals(new Integer(1),unaMuestra.cantidadDeVerificaciones());
	}
	@Test
	public void testUnaMuestraPuedeRetornarLaVerificacionDeUnUsuario() {
				
		Mockito.when(verificadorMock.getVerificacionDe(usuarioMock)).thenReturn(verificacionMock);
		
		assertEquals(verificacionMock,unaMuestra.getVerificacionDe(usuarioMock));
	}
	@Test
	public void testUnaMuestraPuedeDarSuTipoDeMuestra() {
		
		Mockito.when(verificadorMock.getTipoDeMuestra()).thenReturn("Indeterminada");
		
		assertEquals("Indeterminada", unaMuestra.getTipoDeMuestra());
	}
	
	@Test
	public void testUnaMuestraPuedeDarLsUsuariosQueVeifiacron() {
		
		Set<Usuario> usuariosVerificadores = new HashSet<Usuario>();
		usuariosVerificadores.add(usuarioMock);
		
		Mockito.when(verificadorMock.getUsuariosVerificadores()).thenReturn(usuariosVerificadores);
		
		assertEquals(1,unaMuestra.getUsuarios().size());
	}
	@Test
	public void testunaMuestraSabeDecirSiEsVerificableParaUnUsuario() {
		
		Mockito.when(usuarioMock.getAlias()).thenReturn("alias");
		Mockito.when(verificadorMock.puedeVerificar(usuarioMock.getAlias())).thenReturn(true);
		
		assertTrue(unaMuestra.esMuestraVerificablePara(usuarioMock.getAlias()));
	}
	@Test
	public void testUnaMuestraPuedeDecirSiTieneLaVerificacionDe() {
		
		Mockito.when(usuarioMock.getAlias()).thenReturn("alias");
		Mockito.when(verificadorMock.tieneVerificacionDe(usuarioMock.getAlias())).thenReturn(true);
		
		assertTrue(unaMuestra.tieneVerificacionDe(usuarioMock.getAlias()));
	}
	@Test
	public void testUnaMuestraPuedeAgregarUnaVerificacion() {
		
		Verificacion verificacionMock2 = Mockito.mock(Verificacion.class);
		
		Mockito.doCallRealMethod().when(verificadorMock).agregarVerificacion(verificacionMock2);
		
		Mockito.when(verificadorMock.getCantidadDeVerificaciones()).thenReturn(2);
		
		assertEquals(new Integer(2),unaMuestra.cantidadDeVerificaciones());
		//como hago paa agregar el times(int)?
		//Mockito.verify(verificadorMock).agregarVerificacion(verificacionMock2);
	}
}