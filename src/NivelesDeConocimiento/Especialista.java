package NivelesDeConocimiento;

import Aplicacion.AplicacionVinchuca;
import Usuarios.Usuario;
import NivelesDeVerificacion.Alta;

public class Especialista extends NivelDeConocimiento {
	
	public Especialista() {
		this.rankingDeConocimiento = 2;
		this.nivelDeVerificacion = new Alta();
	}
	@Override
	public void resolverEstado(Usuario usuario, AplicacionVinchuca app) {
		
	}
	@Override
	public String getTipo() {
		return "Especialista" ;
	}

}
