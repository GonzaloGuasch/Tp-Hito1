package AplicacionTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.*;

import Aplicacion.CalculadoraDeFechas;
import Muestra.Muestra;
import Muestra.Verificacion;

class CalculadoraDeFechasTests {
	
	private CalculadoraDeFechas unaCalculadora;
	private LocalDate localDate1;
	private LocalDate localDate2;
	
	@BeforeEach
	public void setUp() {
		localDate1 = LocalDate.of(2018, 10, 8);
		localDate2 = LocalDate.now();

		unaCalculadora = new CalculadoraDeFechas(localDate2);
	}
	@Test
	void testUnaCalculadoraDeFechasSabeDecirSiUnaMuestraEsDelUltimoMes() {
		
		Muestra muestraMock = Mockito.mock(Muestra.class);
		Mockito.when(muestraMock.getFechaDeCreacion()).thenReturn(localDate1);
	
		assertTrue(unaCalculadora.esMuestraDelUltimoMes(muestraMock));
	}
	@Test
	void testUnaCalculadoraDeFechasSabeDecirSiUnaVerificacionEsDeUltimoMes() {
		
		Verificacion verificacionMock = Mockito.mock(Verificacion.class);
		Mockito.when(verificacionMock.getFechaDeCreacion()).thenReturn(localDate1);
		
		assertTrue(unaCalculadora.esVerificacionDelUltimoMes(verificacionMock));
	}
}
