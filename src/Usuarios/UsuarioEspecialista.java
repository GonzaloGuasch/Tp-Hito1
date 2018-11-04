package Usuarios;

import Aplicacion.AplicacionVinchuca;

public class UsuarioEspecialista extends Usuario {

	private String tituloEnVinchucas;
	
	public UsuarioEspecialista(String alias, String tituloDeConocimiento) {
		super(alias);
		this.tituloEnVinchucas = tituloDeConocimiento;
	}
	public String getCertificado(){
		return this.tituloEnVinchucas;
	}

	@Override
	protected void chequearEstado(Usuario usuario, AplicacionVinchuca app) {
		//No realiza ninguna accion, porque el especialista no necesita chequer su estado

	}
}
