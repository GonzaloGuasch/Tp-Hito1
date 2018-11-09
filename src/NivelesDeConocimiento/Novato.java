package NivelesDeConocimiento;

import Aplicacion.AplicacionVinchuca;
import Usuarios.Usuario;

public class Novato extends NivelDeConocimiento {
	
	private NivelDeConocimiento nivelDeConocimientoDeCambio;
	public Novato(NivelDeConocimiento nivelDeCambio) {
		this.rankingDeConocimiento = 0;
		this.nivelDeConocimientoDeCambio = nivelDeCambio;
	}
	@Override
	public void resolverEstadoPara(Usuario usuario, AplicacionVinchuca app) {
		if(app.cantidadDeMuestrasEnviadasEsteMesDe(usuario) > 20 
		   && app.cantidadDeMuestrasVerificadasEsteMesDe(usuario) > 10) {
			usuario.setNivelDeConocimiento(nivelDeConocimientoDeCambio);
		}
		
	}
	@Override
	public String getTipo() {
		return "Novato";
	}

}
