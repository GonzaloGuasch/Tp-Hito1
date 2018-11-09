package AplicacionTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import Aplicacion.OrganizacionNoGubernamental;
import Aplicacion.Ubicacion;

class organizacionesNoGubernaenalesTestCase {
	
	private OrganizacionNoGubernamental unaOrganizacion;
	
	@BeforeEach
	public void setUp() {
		Ubicacion ubicacionMock1 = Mockito.mock(Ubicacion.class);
		Mockito.when(ubicacionMock1.getLatitud()).thenReturn(12d);
		Mockito.when(ubicacionMock1.getLongitud()).thenReturn(10d);
		
		unaOrganizacion= new OrganizacionNoGubernamental(ubicacionMock1, "unTipo", 1);
	}
	@Test
	public void testUnaOrganizacionsabeDarDecirQueTipoDeOrganizacionEs() {
		
		assertEquals("unTipo", unaOrganizacion.getTipoDeOrganizacion());
	}
	@Test
	public void testUnaOrganizacionSabeDecirCuantosTrabajadoresTiene() {
		//me dice: error positive delta expected, no tengo idea de por que
		assertEquals(new Integer(1), unaOrganizacion.getcantidadDeTrabajadores());
	}
	@Test
	public void testUnaOrganizacionSabeRetornarSuUbicacion() {
		//mismo error que el anterior
		assertEquals(new Double(10),unaOrganizacion.getUbicacion().getLongitud());
		assertEquals(new Double(12),unaOrganizacion.getUbicacion().getLatitud());
	}

}
