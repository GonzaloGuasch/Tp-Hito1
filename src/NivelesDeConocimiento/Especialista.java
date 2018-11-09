package NivelesDeConocimiento;

import Aplicacion.AplicacionVinchuca;
import Usuarios.Usuario;

public class Especialista extends NivelDeConocimiento {
	
	public Especialista() {
		this.rankingDeConocimiento = 2;
	}
	@Override
	public void resolverEstadoPara(Usuario usuario, AplicacionVinchuca app){
		//No hace nada
	}
	@Override
	public String getTipo() {
		return "Especialista" ;
	}

}
