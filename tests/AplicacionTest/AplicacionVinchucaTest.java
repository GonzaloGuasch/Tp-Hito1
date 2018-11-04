package AplicacionTest;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import Aplicacion.AplicacionVinchuca;
import Muestra.Muestra;
import Muestra.Verificacion;
import Usuarios.Usuario;
import Usuarios.UsuarioComun;


class AplicacionVinchucaTest {
	
	AplicacionVinchuca app;
	Verificacion verificacion1;
	Muestra muestra1;
	Usuario usuario1;
	
	@BeforeEach
	void setUp() { 
		app = new AplicacionVinchuca(null);
		verificacion1 = new Verificacion(usuario1, "vinchuca");
		muestra1      = new Muestra(usuario1.getAlias(), verificacion1);
		usuario1  	  = new UsuarioComun("juan");
	}
	@Test
	void unaAplicacionNoTieneNiMuestrasNiUsuario() {
		
		assertEquals(0 , app.getMuestras().size());
		assertEquals(0 , app.getUsuarios().size());
		
	}
	@Test
	void unaAplicacionAgregaUnUsuario() {
		Usuario nuevoUsuario = (Usuario) Mockito.stub(Usuario.class);
		app.agregarUsuarioALaAplicacion(nuevoUsuario);
		
		assertEquals(1 , app.getUsuarios().size());
	}
	@Test
	void unaAPlicacionRecibeUnaMuestra() {
		usuario1.enviarMuestra(muestra1, app);
		
		assertEquals(1 , app.getMuestras().size());
	}
}
