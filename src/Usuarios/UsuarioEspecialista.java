package Usuarios;

import Aplicacion.AplicacionVinchuca;

public class UsuarioEspecialista extends Usuario {

	private String tituloEnVinchucas;
	
	public UsuarioEspecialista(String alias, String tituloDeConocimiento) {
		super(alias);
		this.tituloEnVinchucas = tituloDeConocimiento;
	}
	//getters
	public String getCertificado(){
		return this.tituloEnVinchucas;
	}
	//acciones
	@Override
	protected void chequearEstado(Usuario usuario, AplicacionVinchuca app) {
		//No realiza ninguna accion, porque el especialista no necesita chequear su estado

	}
}
