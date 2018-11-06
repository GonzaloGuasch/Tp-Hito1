package NivelesDeVerificacion;

import java.util.ArrayList;
import java.util.List;

import Muestra.Muestra;
import Usuarios.Usuario;

public class Alta extends NivelDeVerificacion {


	@Override
	public boolean hacerseCargo(Muestra muestra) {
		return this.esMuestraAlta(muestra);
	}

	@Override
	public void cambiarEstado(Muestra muestra) {	
		
		muestra.cambiarVerificacion(new Alta());
	}
	
	public boolean esMuestraAlta(Muestra muestra) {
		
		
		return muestra.cantidadDeVerificaciones() == 3 || this.hayUsuarioConNivelAltoEn(muestra) || 
				this.hayDosUsuariosExpertos(muestra);
	}
	
	private boolean hayDosUsuariosExpertos(Muestra muestra) {
		List<Usuario> usuariosExpertos = new ArrayList<Usuario>();
		for(Usuario usuario : muestra.getUsuarios()) {
			if(usuario.getNivelDeConocimiento().valor() >= 1) {
				usuariosExpertos.add(usuario);
			}
		}
		return usuariosExpertos.size() == 2;
	}

	public boolean hayUsuarioConNivelAltoEn(Muestra muestra) {
	 boolean res = false; 
	 	for(Usuario usuario : muestra.getUsuarios()) {
		 res = res || usuario.getTipoDeConocimiento() == "Especialista";
	 	}
	return res;
	}
}
