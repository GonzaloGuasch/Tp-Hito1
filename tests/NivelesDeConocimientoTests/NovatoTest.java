package NivelesDeConocimientoTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import Aplicacion.AplicacionVinchuca;
import NivelesDeConocimiento.Experto;
import NivelesDeConocimiento.Novato;
import Usuarios.Usuario;

class NovatoTest {
	private Experto nivelExperto;
	private Novato  nivelNovato;
	@BeforeEach
	public void sdetUp() {
		nivelExperto = new Experto(nivelNovato);
		nivelNovato = new Novato(nivelExperto);
	}
	@Test
	public void testTieneTipoDeConocimientoNovato() {
		
		assertEquals("Novato", nivelNovato.getTipo());
	}
	
	@Test
	void testNivelNovatoSabeResolverEstadoDeUnUsuario() {
		//caso ideal: tiene mas de 20 muestras enviadas y mas de 10 verificadas
		Usuario usuarioMock = Mockito.mock(Usuario.class);
		
		AplicacionVinchuca aplicacionMock = Mockito.mock(AplicacionVinchuca.class);
		Mockito.when(aplicacionMock.cantidadDeMuestrasEnviadasEsteMesDe(usuarioMock)).thenReturn(21);
		Mockito.when(aplicacionMock.cantidadDeMuestrasVerificadasEsteMesDe(usuarioMock)).thenReturn(11);
		
		nivelNovato.resolverEstadoPara(usuarioMock, aplicacionMock);
		
		Mockito.verify(usuarioMock,Mockito.times(1)).setNivelDeConocimiento(nivelExperto);
	}
	@Test
	void testNivelNovatoSabeResolverEstadoDeUnUsuarioCASO2() {
		//caso 2: tiene mas de 20 muestras enviadas y menos de 10 verificadas
		Usuario usuarioMock = Mockito.mock(Usuario.class);
		
		AplicacionVinchuca aplicacionMock = Mockito.mock(AplicacionVinchuca.class);
		Mockito.when(aplicacionMock.cantidadDeMuestrasEnviadasEsteMesDe(usuarioMock)).thenReturn(21);
		Mockito.when(aplicacionMock.cantidadDeMuestrasVerificadasEsteMesDe(usuarioMock)).thenReturn(9);
		
		nivelNovato.resolverEstadoPara(usuarioMock, aplicacionMock);
		
		Mockito.verify(usuarioMock,Mockito.times(0)).setNivelDeConocimiento(nivelExperto);
	}
	@Test
	void testNivelNovatoSabeResolverEstadoDeUnUsuarioCASO3() {
		//caso 3: tiene menos de 20 muestras enviadas y mas de 10 verificadas
		Usuario usuarioMock = Mockito.mock(Usuario.class);
		
		AplicacionVinchuca aplicacionMock = Mockito.mock(AplicacionVinchuca.class);
		Mockito.when(aplicacionMock.cantidadDeMuestrasEnviadasEsteMesDe(usuarioMock)).thenReturn(19);
		Mockito.when(aplicacionMock.cantidadDeMuestrasVerificadasEsteMesDe(usuarioMock)).thenReturn(11);
		
		nivelNovato.resolverEstadoPara(usuarioMock, aplicacionMock);
		
		Mockito.verify(usuarioMock,Mockito.times(0)).setNivelDeConocimiento(nivelExperto);
	}

}
