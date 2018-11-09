package UsuarioTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import Usuarios.UsuarioEspecialista;

class usuarioEspecialistaTest {

	@Test
	void testUnUsuarioEspecialistaSabeDarSuTituloEnVinchucas() {
		
		UsuarioEspecialista unUsuario = new UsuarioEspecialista("fran", "biologo");
		
		assertEquals("biologo", unUsuario.getCertificado());
	}

}
