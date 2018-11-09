package AplicacionTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import Aplicacion.AplicacionVinchuca;
import Aplicacion.CalculadoraDeDistancias;
import Aplicacion.CalculadoraDeFechas;
import Aplicacion.OrganizacionNoGubernamental;
import Aplicacion.Ubicacion;
import Muestra.Muestra;
import Muestra.Verificacion;
import Usuarios.Usuario;


class AplicacionVinchucaTest {
	@Mock private Muestra muestraMock;
	@Mock private CalculadoraDeDistancias calculadoraDeDistanciasMock;
	@Mock private CalculadoraDeFechas calculadoraDeFechasMock;
	@Mock private Usuario usuarioMock;
	@Mock private Verificacion verificacionMock;
	private AplicacionVinchuca unaAplicacion;
	Set<Muestra> coleccionCon1Muestra;
	
	@BeforeEach
	public void setUp() {
		MockitoAnnotations.initMocks(this);
		
		unaAplicacion = new AplicacionVinchuca(calculadoraDeFechasMock,calculadoraDeDistanciasMock);
		
		coleccionCon1Muestra = new HashSet<Muestra>();
		coleccionCon1Muestra.add(muestraMock);
	}
	@Test
	public void testUnaAplicacionSeCreaConListasVaciasDeUsuariosMuestrasYOrgNoGubernamentalesYConLaFechaDeHoy() {
		
	assertEquals(unaAplicacion.getMuestras().size(),0);
	assertEquals(unaAplicacion.getUsuarios().size(),0);	
	assertEquals(unaAplicacion.getOrganizaciones().size(),0);
	
	Mockito.when(calculadoraDeFechasMock.getFechaActual()).thenReturn(LocalDate.now());
	assertEquals(LocalDate.now(),unaAplicacion.getFecha());
	}
	@Test
	public void testUnaAplicacionPuedeRecibirMuestras() {
		
		unaAplicacion.recibirMuestra(muestraMock);
		assertEquals(1,unaAplicacion.getMuestras().size());
	}
	@Test
	public void testunaAplicacionPuedeAgregarOrganizaciones() {
		
		OrganizacionNoGubernamental orgaMock = Mockito.mock(OrganizacionNoGubernamental.class);
		unaAplicacion.agregarOrganizacionALaAplicacion(orgaMock);
		assertEquals(1,unaAplicacion.getOrganizaciones().size());
	}
	@Test
	public void testunaAplicacionPuedeAgregarUnUsuario() {
		
		unaAplicacion.agregarUsuarioALaAplicacion(usuarioMock);
		assertEquals(1, unaAplicacion.getUsuarios().size());
	}
	@Test
	public void testunaAplicacionPuedeDecirLasMuestrasAMenosDeXKilometrosDeUnaUbicacion() {
		
		Ubicacion ubicacionMock = Mockito.mock(Ubicacion.class);
		
		Mockito.when(calculadoraDeDistanciasMock.MuestrasAMenosDeXKilometros(unaAplicacion.getMuestras(), ubicacionMock, 20d))
			.thenReturn(coleccionCon1Muestra);
		
		assertEquals(1,unaAplicacion.getMuestrasAMenosDeXKilometros(ubicacionMock, 20d).size());
	}
	@Test
	public void testunaAplicacionSabeDecirLaCantidadDeMuestrasEnviadasEsteMesDeUnUsuario() {
		//caso ideal: es una muestra del ultimo mes y la muestra es del usuario
		Mockito.when(usuarioMock.getAlias()).thenReturn("alias");
		Mockito.when(calculadoraDeFechasMock.esMuestraDelUltimoMes(muestraMock)).thenReturn(true);
		Mockito.when(muestraMock.esDeUsuario(usuarioMock.getAlias())).thenReturn(true);
		
		unaAplicacion.recibirMuestra(muestraMock);
		assertEquals(new Integer(1),unaAplicacion.cantidadDeMuestrasEnviadasEsteMesDe(usuarioMock));
	}
	@Test
	public void testunaAplicacionSabeDecirLaCantidadDeMuestrasEnviadasEsteMesDeUnUsuarioCASO2() {
		//caso 2: la muestra es del ultimo Mes y no es del usuario
		Mockito.when(usuarioMock.getAlias()).thenReturn("alias");
		Mockito.when(calculadoraDeFechasMock.esMuestraDelUltimoMes(muestraMock)).thenReturn(true);
		Mockito.when(muestraMock.esDeUsuario(usuarioMock.getAlias())).thenReturn(false);
		
		unaAplicacion.recibirMuestra(muestraMock);
		assertEquals(new Integer(0),unaAplicacion.cantidadDeMuestrasEnviadasEsteMesDe(usuarioMock));
	}
	@Test
	public void testunaAplicacionSabeDecirLaCantidadDeMuestrasEnviadasEsteMesDeUnUsuarioCASO3() {
		//caso 3: la muestra no es del ultimo mes y es del usuario
		Mockito.when(usuarioMock.getAlias()).thenReturn("alias");
		Mockito.when(calculadoraDeFechasMock.esMuestraDelUltimoMes(muestraMock)).thenReturn(false);
		Mockito.when(muestraMock.esDeUsuario(usuarioMock.getAlias())).thenReturn(true);
		
		unaAplicacion.recibirMuestra(muestraMock);
		assertEquals(new Integer(0),unaAplicacion.cantidadDeMuestrasEnviadasEsteMesDe(usuarioMock));
	}
	@Test
	public void testUnaAplicacionSabeDecirLaCantidadDeMuestrasVerificadasEsteMes() {
		//caso ideal: la muestra esta verificada por el usuario y la verificacion es de este mes
		Mockito.when(usuarioMock.getAlias()).thenReturn("alias");
		
		Mockito.when(muestraMock.getVerificacionDe(usuarioMock)).thenReturn(verificacionMock);
		Mockito.when(muestraMock.tieneVerificacionDe(usuarioMock.getAlias())).thenReturn(true);
		Mockito.when(calculadoraDeFechasMock.esVerificacionDelUltimoMes(muestraMock.getVerificacionDe(usuarioMock))).thenReturn(true);
		
		unaAplicacion.recibirMuestra(muestraMock);
		assertEquals(new Integer(1),unaAplicacion.cantidadDeMuestrasVerificadasEsteMesDe(usuarioMock));
	}
	@Test
	public void testUnaAplicacionSabeDecirLaCantidadDeMuestrasVerificadasEsteMesCASO2() {
		//caso 2: la muestra no esta verificada por el usuario y la verificacion es de este mes
		Mockito.when(usuarioMock.getAlias()).thenReturn("alias");
		
		Mockito.when(muestraMock.getVerificacionDe(usuarioMock)).thenReturn(verificacionMock);
		Mockito.when(muestraMock.tieneVerificacionDe(usuarioMock.getAlias())).thenReturn(false);
		Mockito.when(calculadoraDeFechasMock.esVerificacionDelUltimoMes(muestraMock.getVerificacionDe(usuarioMock))).thenReturn(true);
		
		unaAplicacion.recibirMuestra(muestraMock);
		assertEquals(new Integer(0),unaAplicacion.cantidadDeMuestrasVerificadasEsteMesDe(usuarioMock));
	}
	@Test
	public void testUnaAplicacionSabeDecirLaCantidadDeMuestrasVerificadasEsteMesCASO3() {
		//caso 3: la muestra esta verificada por el usuario y la verificacion no es de este mes
		Mockito.when(usuarioMock.getAlias()).thenReturn("alias");
		
		Mockito.when(muestraMock.getVerificacionDe(usuarioMock)).thenReturn(verificacionMock);
		Mockito.when(muestraMock.tieneVerificacionDe(usuarioMock.getAlias())).thenReturn(true);
		Mockito.when(calculadoraDeFechasMock.esVerificacionDelUltimoMes(muestraMock.getVerificacionDe(usuarioMock))).thenReturn(false);
		
		unaAplicacion.recibirMuestra(muestraMock);
		assertEquals(new Integer(0),unaAplicacion.cantidadDeMuestrasVerificadasEsteMesDe(usuarioMock));
	}
}
