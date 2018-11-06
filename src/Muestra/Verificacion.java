package Muestra;

import Usuarios.Usuario;

import java.time.LocalDate;
import NivelesDeVerificacion.NivelDeVerificacion;

public class Verificacion {
	
		private Usuario usuarioVerificador;
		private String observacionDeUsuario;
		private LocalDate fechaDeCreacion;
		
		public Verificacion(Usuario usuario, String observacion, LocalDate fechaDeCreacion) {
			this.usuarioVerificador = usuario;
			this.observacionDeUsuario = observacion;
			this.fechaDeCreacion = fechaDeCreacion;
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
		public LocalDate getFechaDeCreacion() {
			return fechaDeCreacion;
		}
}
