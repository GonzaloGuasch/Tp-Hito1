package Test;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import Aplicacion.AplicacionVinchuca;
import Muestra.Muestra;
import Muestra.Verificacion;
import Usuarios.Usuario;
import Usuarios.UsuarioComun;


class MuestraTest {
	private Usuario usuario1;
	Usuario usuario2;
	Usuario usuario3;
	
	Verificacion verificacion1;
	Verificacion verificacion2;
	Verificacion verificacion3;
	
	Muestra muestra1; 
	
	AplicacionVinchuca app;
	@BeforeEach
	void setUp() {
		usuario1 = new UsuarioComun("usuario1");
		usuario2 = new UsuarioComun("usuario2");
		usuario3 = new UsuarioComun("usuario3");
		
		verificacion1 = new Verificacion(usuario1, "vinchuca");
		verificacion2 = new Verificacion(usuario2, "vinchuca");
		verificacion3 = new Verificacion(usuario3, "vinchuca");
		
		muestra1 = new Muestra("usuario1" , verificacion1); 
		app = Mockito.mock(AplicacionVinchuca.class);
	}
	
	@Test
	void unaMuestraDeUnUsuarioNovatoTieneNivelDeVerificacionBajo() {
	  
	   assertEquals( 0 , muestra1.getNivelDeVerificion());
	   
	}
	
	@Test
	void unMuestraConDosVerificacionesDeUsuariosbajosTieneNivelMedio() {		  
		
		usuario2.verificarMuestra(verificacion2, muestra1, app);
		assertEquals( 1 , muestra1.getNivelDeVerificion());
	
	}
	
	@Test 
	void unaMuestraConTresVerificacionesDeUsuariosBajosTieneNivelAlto() {
	
		usuario2.verificarMuestra(verificacion2, muestra1, app);
		usuario3.verificarMuestra(verificacion3, muestra1, app);
		
		assertEquals( 3, muestra1.getNivelDeVerificion());
	}
	
	
}