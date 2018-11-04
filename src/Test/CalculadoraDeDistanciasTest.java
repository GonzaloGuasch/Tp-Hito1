package Test;



import static org.junit.Assert.assertEquals;

import java.util.*;

import org.junit.Before;
import org.junit.jupiter.api.Test;

import Aplicacion.CalculadorDeDistancias;
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
	
	private CalculadorDeDistancias unaCalculadora;
	
	@Before
	public void setUp() {
		ubicacion1 =new Ubicacion(-34.734452, -58.239162);
		ubicacion2 =new Ubicacion(-34.735334, -58.238379);
		ubicacion3 = new Ubicacion(-34.735900, -58.239193);
		ubicacionReferencia = new Ubicacion(-34.735027, -58.240008);
		
		unaCalculadora = new CalculadorDeDistancias();
	}
	@Test
	void testUnaCalculadoraDeDistanciaSabeCalcularLasDistanciasEntre2Puntos() {

		assertEquals(121.24, unaCalculadora.distanciaEntre(ubicacion1, ubicacion2));
	}
	@Test
	void testEnUnaListaDeUbicacionesHay1UbicacionQueSeEncuentraAMenosDe20KmDeDistanciaDeUnaUbicacionDada() {
	//tiene sentido un caso en que la ubicacion de referencia ete dentro de la lista de ubicaciones?(lo mismo con las mSuestras)
		Set<Ubicacion> ubicaciones= new HashSet<Ubicacion>();
		ubicaciones.add(ubicacion1);
		ubicaciones.add(ubicacion2);
		ubicaciones.add(ubicacion3);
		
		assertEquals(1,unaCalculadora.ubicacionesAMenosDeXKilometrosDeUnaUbicacion(ubicaciones, ubicacionReferencia, 130.00).size());
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

	Muestra muestra1 = new Muestra("gonza", verificacion1);
	Muestra muestra2 = new Muestra("gonzaMolina", verificacion2);
	Muestra muestra3 = new Muestra("fran", verificacion3);
	Muestra muestraReferencia = new Muestra("diego", verificacionReferencia);
	
	Set<Muestra>muestras = new HashSet<Muestra>();
	muestras.add(muestra1);
	muestras.add(muestra2);
	muestras.add(muestra3);
	
	assertEquals(1,unaCalculadora.MuestrasAMenosDeXKilometros(muestras, muestraReferencia, 130.00).size());
	}
}
