package NivelesDeVerificacion;

import java.util.ArrayList;
import java.util.List;

import Muestra.Muestra;
import Usuarios.Usuario;

public class Media extends NivelDeVerificacion {

	@Override
	public boolean hacerseCargo(Muestra muestra) {
		
		return this.esMuestraMedia(muestra);
	}
	private boolean esMuestraMedia(Muestra muestra) {
		return muestra.cantidadDeVerificaciones() == 2 && this.hayDosNovatos(muestra);
	}

	private boolean hayDosNovatos(Muestra muestra) {
		List<Usuario> usuariosExpertos = new ArrayList<Usuario>();
		for(Usuario usuario : muestra.getUsuarios()) {
			if(usuario.esNovato()) {
				usuariosExpertos.add(usuario);
			}
		}
		return usuariosExpertos.size() == 2;
	}

	@Override
	public void cambiarEstado(Muestra muestra) {
		muestra.cambiarVerificacion(new Media());
	}
}