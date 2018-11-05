package AplicacionTest;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import java.util.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Aplicacion.CalculadoraDeDistancias;
import Aplicacion.Ubicacion;
import Muestra.Muestra;
import Muestra.Verificacion;
import Usuarios.Usuario;
import Usuarios.UsuarioComun;

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
	Usuario usuario1 = new UsuarioComun("gonza");
	Usuario usuario2 = new UsuarioComun("gonzaMolina");
	Usuario usuario3 = new UsuarioComun("fran");
	Usuario usuarioReferencia = new UsuarioComun("diego");

	Verificacion verificacion1 = new Verificacion(usuario1, "una Observacion1");
	Verificacion verificacion2 = new Verificacion(usuario2, "una Observacion2");
	Verificacion verificacion3 = new Verificacion(usuario3, "una Observacion3");
	Verificacion verificacionReferencia = new Verificacion(usuarioReferencia, "una ObservacionReferencia");
	//ERROR: hasta no tener las fechas, no va a compilar
	Muestra muestra1 = new Muestra(verificacion1, "gonza",ubicacion1);
	Muestra muestra2 = new Muestra(verificacion2, "gonzaMolina", ubicacion2);
	Muestra muestra3 = new Muestra(verificacion3, "fran", ubicacion3);
	Muestra muestraReferencia = new Muestra(verificacionReferencia, "diego", ubicacionReferencia);
	
	Set<Muestra>muestras = new HashSet<Muestra>();
	muestras.add(muestra1);
	muestras.add(muestra2);
	muestras.add(muestra3);
	
	assertEquals(1,unaCalculadora.MuestrasAMenosDeXKilometros(muestras, muestraReferencia, 2144d).size());
	}
}
