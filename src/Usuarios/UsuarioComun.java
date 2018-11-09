package Usuarios;

import Aplicacion.AplicacionVinchuca;
import NivelesDeConocimiento.NivelDeConocimiento;

public class UsuarioComun extends Usuario {

	public UsuarioComun(String alias,NivelDeConocimiento nivelDeInicializacion) {
		super(alias);
		this.nivelDeConocimiento = nivelDeInicializacion;
	}
	protected void chequearEstado(Usuario usuario, AplicacionVinchuca app) {
		usuario.nivelDeConocimiento.resolverEstadoPara(this, app);
	}

}
