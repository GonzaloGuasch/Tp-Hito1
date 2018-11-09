package NivelesDeConocimientoTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import Aplicacion.AplicacionVinchuca;
import NivelesDeConocimiento.Experto;
import NivelesDeConocimiento.Novato;
import Usuarios.Usuario;

class ExpertoTest {
	
	private Novato nivelNovato;
	private Experto nivelExperto;
	@BeforeEach
	public void setUp() {
		nivelNovato = new Novato(nivelExperto);
		nivelExperto= new Experto(nivelNovato);
	}
	@Test
	void testEsDeTipoExperto() {
		
		assertEquals(nivelExperto.getTipo(), "Experto");
	}
	@Test
	public void testNivelExpertoSabeResolverElEstadoDeUnUsuario() {
		//caso ideal= tiene menos de 20 muestras enviadas y meenos de 10 verificadas
		Usuario usuarioMock = Mockito.mock(Usuario.class);
		
		AplicacionVinchuca aplicacionMock = Mockito.mock(AplicacionVinchuca.class);
		Mockito.when(aplicacionMock.cantidadDeMuestrasEnviadasEsteMesDe(usuarioMock)).thenReturn(19);
		Mockito.when(aplicacionMock.cantidadDeMuestrasVerificadasEsteMesDe(usuarioMock)).thenReturn(1);
		
		nivelExperto.resolverEstadoPara(usuarioMock, aplicacionMock);
		
		Mockito.verify(usuarioMock,Mockito.times(1)).setNivelDeConocimiento(nivelNovato);
	}
	@Test
	public void testNivelExpertoSabeResolverElEstadoDeUnUsuarioCASO2() {
		//caso 2= tiene menos de 20 muestras enviadas y mas de 10 verificadas
		Usuario usuarioMock = Mockito.mock(Usuario.class);
		
		AplicacionVinchuca aplicacionMock = Mockito.mock(AplicacionVinchuca.class);
		Mockito.when(aplicacionMock.cantidadDeMuestrasEnviadasEsteMesDe(usuarioMock)).thenReturn(19);
		Mockito.when(aplicacionMock.cantidadDeMuestrasVerificadasEsteMesDe(usuarioMock)).thenReturn(11);
		
		nivelExperto.resolverEstadoPara(usuarioMock, aplicacionMock);
		
		Mockito.verify(usuarioMock,Mockito.times(0)).setNivelDeConocimiento(nivelNovato);
	}
	@Test
	public void testNivelExpertoSabeResolverElEstadoDeUnUsuarioCASO3() {
		//caso 3= tiene mas de 20 muestras enviadas y menos de 10 verificadas
		Usuario usuarioMock = Mockito.mock(Usuario.class);
		
		AplicacionVinchuca aplicacionMock = Mockito.mock(AplicacionVinchuca.class);
		Mockito.when(aplicacionMock.cantidadDeMuestrasEnviadasEsteMesDe(usuarioMock)).thenReturn(23);
		Mockito.when(aplicacionMock.cantidadDeMuestrasVerificadasEsteMesDe(usuarioMock)).thenReturn(1);
		
		nivelExperto.resolverEstadoPara(usuarioMock, aplicacionMock);
		
		Mockito.verify(usuarioMock,Mockito.times(0)).setNivelDeConocimiento(nivelNovato);
	}
}
