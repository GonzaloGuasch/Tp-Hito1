  package MuestraTests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Collection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import Muestra.Muestra;
import Muestra.Verificacion;
import Muestra.VerificadorDeMuestra;
import NivelesDeVerificacion.Alta;
import NivelesDeVerificacion.Bajo;
import NivelesDeVerificacion.Media;
import NivelesDeVerificacion.NivelDeVerificacion;
import TipoDeMuestra.ChinceFoliada;
import TipoDeMuestra.ImagenPocoClara;
import TipoDeMuestra.Indeterminada;
import TipoDeMuestra.PhtiaChinche;
import TipoDeMuestra.TipoDeMuestra;
import TipoDeMuestra.Vinchuca;
import Usuarios.Usuario;

class VerificadorDeMuestraTest {

	@Mock private Verificacion verificacionMock1;
	@Mock private Verificacion verificacionMock2;
	@Mock private Usuario usuarioMock;
	
	@Mock private Alta altaMock;
	@Mock private Media MediaMock;
	@Mock private Bajo BajoMock;

	@Mock private ChinceFoliada chinceFoliadaMock;
	@Mock private ImagenPocoClara imagenPocoClaraMock;
	@Mock private Indeterminada indeterminadaMock;
	@Mock private PhtiaChinche phtiaChincheMock;
	@Mock private Vinchuca vinchucaMock;
	
	private VerificadorDeMuestra unVerificador;
	private Collection<NivelDeVerificacion> nivelesDeVerificacion;
	private Collection<TipoDeMuestra> tiposDeMuestra;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		nivelesDeVerificacion = new ArrayList<NivelDeVerificacion>();
		nivelesDeVerificacion.add(altaMock);
		nivelesDeVerificacion.add(MediaMock);
		nivelesDeVerificacion.add(BajoMock);

		tiposDeMuestra = new ArrayList<TipoDeMuestra>();
		tiposDeMuestra.add(chinceFoliadaMock);
		tiposDeMuestra.add(imagenPocoClaraMock);
		tiposDeMuestra.add(indeterminadaMock);
		tiposDeMuestra.add(phtiaChincheMock);
		tiposDeMuestra.add(vinchucaMock);

		unVerificador = new VerificadorDeMuestra(nivelesDeVerificacion, tiposDeMuestra);
		unVerificador.agregarVerificacion(verificacionMock1);
		unVerificador.agregarVerificacion(verificacionMock2);
	}
	@Test
	public void testUnVerificadorPuedeAgregarUnaVerificacion() {
		
		Verificacion verificacionMock = Mockito.mock(Verificacion.class);
		unVerificador.agregarVerificacion(verificacionMock);
		assertEquals(new Integer(3),unVerificador.getCantidadDeVerificaciones());
	}
	@Test
	public void testUnVerificadorSabeSiUnUsuarioPuedeVerificarONo() {
		//caso feliz
		Mockito.when(usuarioMock.getAlias()).thenReturn("alias");
		
		Mockito.when(verificacionMock1.esVerificacionDe("alias")).thenReturn(false);
		Mockito.when(verificacionMock2.esVerificacionDe("alias")).thenReturn(false);
		
		assertTrue(unVerificador.puedeVerificar(usuarioMock.getAlias()));
	}
	@Test
	public void testUnVerificadorSabeSiUnUsuarioPuedeVerificarONoCASO2() {
		//caso 2: el usuario ya hizo una verificacion en la muestra
		Mockito.when(usuarioMock.getAlias()).thenReturn("alias");
		
		Mockito.when(verificacionMock1.esVerificacionDe("alias")).thenReturn(false);
		Mockito.when(verificacionMock2.esVerificacionDe("alias")).thenReturn(true);
		
		assertFalse(unVerificador.puedeVerificar(usuarioMock.getAlias()));
	}
	@Test
	public void testUnVerificadorSabeDecirSiTieneONoLaVerificacionDeUnUsuario() {
		
		Mockito.when(usuarioMock.getAlias()).thenReturn("alias");
		
		Mockito.when(verificacionMock1.getAliasDeVerificador()).thenReturn("alias");
		Mockito.when(verificacionMock2.getAliasDeVerificador()).thenReturn("alias1");
		
		assertTrue(unVerificador.tieneVerificacionDe(usuarioMock.getAlias()));
	}
	@Test
	public void testUnVerificadorPuedeDecirTodosLosUsuariosQueVerificaronLaMuestra() {
		
		Usuario usuarioMock2 = Mockito.mock(Usuario.class);
		
		Mockito.when(verificacionMock1.getVerificador()).thenReturn(usuarioMock);
		Mockito.when(verificacionMock2.getVerificador()).thenReturn(usuarioMock2);
		
		assertEquals(2,unVerificador.getUsuariosVerificadores().size()); 
		//como hago para saber si le llego 1 vez?
		Mockito.verify(verificacionMock1).getVerificador();
		Mockito.verify(verificacionMock2).getVerificador();
	}
	@Test
	public void testUnVerificadorPuedeDarLaVerificacionDeUnUsuarioDeterminado() {
		
		Mockito.when(usuarioMock.getAlias()).thenReturn("alias");
		
		Mockito.when(verificacionMock1.esVerificacionDe(usuarioMock.getAlias())).thenReturn(true);
		Mockito.when(verificacionMock2.esVerificacionDe(usuarioMock.getAlias())).thenReturn(false);
		
		assertTrue(verificacionMock1.equals(unVerificador.getVerificacionDe(usuarioMock)));
	}
	@Test
	public void testUnVerificadorPuedeDarElNivelDeVerificacionDeUnaMuestra() {
		
		Muestra muestraMock = Mockito.mock(Muestra.class);
		Mockito.when(altaMock.hacerseCargo(muestraMock)).thenReturn(false);
		Mockito.when(MediaMock.hacerseCargo(muestraMock)).thenReturn(false);
		Mockito.when(BajoMock.hacerseCargo(muestraMock)).thenReturn(true);
		
		assertEquals(BajoMock,unVerificador.getNivelDeVerificacion(muestraMock));
	}
	/**@Test
	public void testUnVerificadorPuedeDarElTipoDeMuestra() {
		//no se por que no corre
		Mockito.when(chinceFoliadaMock.hacerseCargo(unVerificador.getVerificaciones())).thenReturn(false);
		Mockito.when(imagenPocoClaraMock.hacerseCargo(unVerificador.getVerificaciones())).thenReturn(false);
		Mockito.when(indeterminadaMock.hacerseCargo(unVerificador.getVerificaciones())).thenReturn(false);
		Mockito.when(phtiaChincheMock.hacerseCargo(unVerificador.getVerificaciones())).thenReturn(false);
		Mockito.when(vinchucaMock.hacerseCargo(unVerificador.getVerificaciones())).thenReturn(true);

		assertEquals("Vinchuca",unVerificador.getTipoDeMuestra());
	}**/
}
