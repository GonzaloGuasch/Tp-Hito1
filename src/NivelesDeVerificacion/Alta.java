package NivelesDeVerificacion;

import java.util.stream.Collectors;

import Muestra.Muestra;
import Usuarios.Usuario;

public class Alta extends NivelDeVerificacion {

	//booleanos
	@Override
	public boolean hacerseCargo(Muestra muestra) {
		return this.esMuestraAlta(muestra);
	}
	private boolean esMuestraAlta(Muestra muestra) {
		
		return muestra.cantidadDeVerificaciones() == 3 || this.esVerificadorEspecialista(muestra) || this.verificaronDosUsuariosExpertos(muestra);
	 }
	//booleanos privados
	private boolean verificaronDosUsuariosExpertos(Muestra muestra) {
		
		return muestra.getUsuarios().stream().filter(usuario -> usuario.getTipoDeConocimiento() == "Experto")
			.collect(Collectors.toList()).size() ==2;
	}
	private boolean esVerificadorEspecialista(Muestra muestra) {
		
		boolean res = false; 
		for(Usuario usuario : muestra.getUsuarios()) {
			res = res || usuario.getTipoDeConocimiento() == "Especialista";
		}
		return res;
	}
}
