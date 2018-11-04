package Usuarios;

import Aplicacion.AplicacionVinchuca;
import NivelesDeConocimiento.Novato;

public class UsuarioComun extends Usuario {

	public UsuarioComun(String alias) {
		super(alias);
		this.nivelDeConocimiento = new Novato();
	}
	protected void chequearEstado(Usuario usuario, AplicacionVinchuca app) {
		usuario.nivelDeConocimiento.resolverEstado(this, app);
	}

}
