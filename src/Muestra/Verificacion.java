package Muestra;

import Usuarios.Usuario;
import NivelesDeVerificacion.NivelDeVerificacion;

public class Verificacion {
	
		private Usuario usuarioVerificador;
		private String observacionDeUsuario;
		
		public Verificacion(Usuario usuario, String observacion) {
			this.usuarioVerificador = usuario;
			this.observacionDeUsuario = observacion;
		}
		public String getAliasDeVerificador() {
			return this.usuarioVerificador.getAlias();
		}
		public String getObservacionDeVerificador() {
			return this.observacionDeUsuario;
		}
		public NivelDeVerificacion getNivelDeVerificacionInicial() {
			return this.usuarioVerificador.getNivelDeVerificacionInicial();
		}
		public boolean noEsVerificacionDe(String alias) {
			return usuarioVerificador.getAlias() != alias;
		}
		public Usuario getVerificador() {
			return this.usuarioVerificador;
		}
}
