package NivelesDeVerificacion;

import Muestra.Muestra;
import Usuarios.Usuario;

public class Bajo extends NivelDeVerificacion {

	@Override
	public boolean hacerseCargo(Muestra muestra) {
	  return this.esMuestraBaja(muestra);
	}

	private boolean esMuestraBaja(Muestra muestra) {
		return muestra.cantidadDeVerificaciones() == 1 && this.esVerificadorBajo(muestra);
	}
	//booleanos privados
	private boolean esVerificadorBajo(Muestra muestra) {
	boolean res = false;
	    for(Usuario u : muestra.getUsuarios()) {
	    	res = u.getTipoDeConocimiento() == "Novato";
	    }
		return res;
	}
}