package AplicacionTest;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import Aplicacion.CalculadoraDeDistancias;
import Aplicacion.Ubicacion;
import Muestra.Muestra;

class CalculadoraDeDistanciasTest {
	
	private Ubicacion ubicacion1;
	private Ubicacion ubicacion2;
	private Ubicacion ubicacion3;
	private Ubicacion ubicacionReferencia;
	
	private CalculadoraDeDistancias unaCalculadora;
	
	@BeforeEach
	public void setUp() {
		ubicacion1 =new Ubicacion(-34.734452, -58.239162);
		ubicacion2 =new Ubicacion(-34.730967, -58.303384);
		ubicacion3 = new Ubicacion(-32.926331, -60.669527);
		ubicacionReferencia = new Ubicacion(-34.735027, -58.240008);
		
		unaCalculadora = new CalculadoraDeDistancias();
	}
	@Test
	void testUnaCalculadoraDeDistanciaSabeCalcularLasDistanciasEntre2Puntos() {

		assertEquals(2149, unaCalculadora.distanciaEntre(ubicacion1, ubicacion2));
	}
	@Test
	void testEnUnaListaDeUbicacionesHay1UbicacionQueSeEncuentraAMenosDe20KmDeDistanciaDeUnaUbicacionDada() {

		Set<Ubicacion> ubicaciones= new HashSet<Ubicacion>();
		ubicaciones.add(ubicacion1);
		ubicaciones.add(ubicacion2);
		ubicaciones.add(ubicacion3);
		
		assertEquals(1,unaCalculadora.ubicacionesAMenosDeXKilometrosDeUnaUbicacion(ubicaciones, ubicacionReferencia, 2144d).size());
	}
	@Test
	void testEnUnaListaDeUbicacionesHay1UbicacionQueSeEncuentraAMenosDe20KmDeDistanciaDeUnaUbicacionDadaCaso2() {
	//caso 2 del test anterior, la muestra de referencia esta en la lista a analizar
		Set<Ubicacion> ubicaciones= new HashSet<Ubicacion>();
		ubicaciones.add(ubicacion1);
		ubicaciones.add(ubicacion2);
		ubicaciones.add(ubicacion3);
		ubicaciones.add(ubicacionReferencia);

		assertEquals(1,unaCalculadora.ubicacionesAMenosDeXKilometrosDeUnaUbicacion(ubicaciones, ubicacionReferencia, 2144d).size());
	}
	
	@Test
	void testUnaCalculadoraDeDistanciasPuedecalcularLasMuestrasAMenosDeXKilometrosDeUnPunto() {
	
		Muestra muestraMock1= Mockito.mock(Muestra.class);
		Muestra muestraMock2= Mockito.mock(Muestra.class);
		Muestra muestraMock3= Mockito.mock(Muestra.class);
		Muestra muestraMockReferencia= Mockito.mock(Muestra.class);

		Mockito.when(muestraMock1.getUbicacion()).thenReturn(ubicacion1);
		Mockito.when(muestraMock2.getUbicacion()).thenReturn(ubicacion2);
		Mockito.when(muestraMock3.getUbicacion()).thenReturn(ubicacion3);
		Mockito.when(muestraMockReferencia.getUbicacion()).thenReturn(ubicacionReferencia);

	Set<Muestra>muestras = new HashSet<Muestra>();
	muestras.add(muestraMock1);
	muestras.add(muestraMock2);
	muestras.add(muestraMock3);
	
	assertEquals(1,unaCalculadora.MuestrasAMenosDeXKilometros(muestras, muestraMockReferencia.getUbicacion(), 2144d).size());
	}
}
