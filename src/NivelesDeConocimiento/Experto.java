package NivelesDeConocimiento;

import Aplicacion.AplicacionVinchuca;
import Usuarios.Usuario;

public class Experto extends NivelDeConocimiento {
	
	private NivelDeConocimiento nivelDeConocimientoDeCambio;
	public Experto(NivelDeConocimiento nivelDeCambio) {
		this.rankingDeConocimiento = 1;
		this.nivelDeConocimientoDeCambio = nivelDeCambio;
	}

	@Override
	public void resolverEstadoPara(Usuario usuario, AplicacionVinchuca app) {
		
		if(app.cantidadDeMuestrasEnviadasEsteMesDe(usuario) <= 20 &&
		   app.cantidadDeMuestrasVerificadasEsteMesDe(usuario) <= 10) {
			usuario.setNivelDeConocimiento(nivelDeConocimientoDeCambio);
		}
	}
	@Override
	public String getTipo() {
		return "Experto";
	}


}
