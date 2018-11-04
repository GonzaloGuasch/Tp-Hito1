package NivelesDeConocimiento;

import Aplicacion.AplicacionVinchuca;
import Usuarios.Usuario;
import NivelesDeVerificacion.Bajo;

public class Novato extends NivelDeConocimiento {

	public Novato() {
		this.rankingDeConocimiento = 0;
		this.nivelDeVerificacion = new Bajo();
	}
	@Override
	public void resolverEstado(Usuario usuario, AplicacionVinchuca app) {
		if(usuario.cantidadDeMuestrasEnviadasEsteMesEn(app) >= 20 
		   && usuario.cantidadDeMuestrasVerificadas(app) >= 10) {
			usuario.setNivelDeConocimiento(new Experto());
		}
		
	}
	@Override
	public String getTipo() {
		return "Novato";
	}

}
