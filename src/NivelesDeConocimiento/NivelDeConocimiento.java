package NivelesDeConocimiento;

import Aplicacion.AplicacionVinchuca;
import Usuarios.Usuario;

public abstract class NivelDeConocimiento {
	protected Integer rankingDeConocimiento;	
	
	public abstract void resolverEstadoPara(Usuario usuario, AplicacionVinchuca app);
	
	public Integer valor() {
		return this.rankingDeConocimiento;
	}
	public abstract String getTipo();
}
