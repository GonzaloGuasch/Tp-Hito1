package NivelesDeConocimiento;

import Aplicacion.AplicacionVinchuca;
import Usuarios.Usuario;
import NivelesDeVerificacion.NivelDeVerificacion;

public abstract class NivelDeConocimiento {
	protected Integer rankingDeConocimiento;
	protected NivelDeVerificacion nivelDeVerificacion;
	
	
	public Integer getRanking() {
		return this.rankingDeConocimiento;
	}
	public NivelDeVerificacion getNivelDeVerificacion() {
		return this.nivelDeVerificacion;
	}
	public abstract void resolverEstado(Usuario usuario, AplicacionVinchuca app);
	
	public int valor() {
		return this.rankingDeConocimiento;
	}
	public abstract String getTipo();
}
