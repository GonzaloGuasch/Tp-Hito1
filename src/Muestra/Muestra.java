package Muestra;

import java.time.LocalDate;
import java.util.Set;

import Aplicacion.Ubicacion;
import Usuarios.Usuario;
import NivelesDeVerificacion.NivelDeVerificacion;

public class Muestra {
	private VerificadorDeMuestra verificador;
	private Ubicacion ubicacion;
	private String fotografia;
	private String aliasDePrimerVerificador;
	private LocalDate fechaDeCreacion;
	
	//Constructor
	public Muestra(Verificacion verificacion,String unaFotografia, Ubicacion unaUbicacion,VerificadorDeMuestra unVerificador) {
		this.verificador = unVerificador;
		verificador.agregarVerificacion(verificacion);
		
		this.aliasDePrimerVerificador = verificacion.getAliasDeVerificador();
		this.fechaDeCreacion = verificacion.getFechaDeCreacion();
		
		this.fotografia = unaFotografia;
		this.ubicacion = unaUbicacion;
	}
	//Geters
	public NivelDeVerificacion getNivelDeVerificion() {
		return this.verificador.getNivelDeVerificacion(this);
	}
	public Ubicacion getUbicacion() {
		return ubicacion;
	}
	public String getFotografia() {
		return this.fotografia;
	}
	public Integer cantidadDeVerificaciones() {
		return this.verificador.getCantidadDeVerificaciones();
	}
	public Verificacion getVerificacionDe(Usuario unUsuario) {
		return verificador.getVerificacionDe(unUsuario);
	}
	public String getTipoDeMuestra() {
		return this.verificador.getTipoDeMuestra();
	}
	public Set<Usuario> getUsuarios() {
		return this.verificador.getUsuariosVerificadores();
	}
	public LocalDate getFechaDeCreacion(){
        return this.fechaDeCreacion;
	}
	//Booleans 
	public boolean esDeUsuario(String alias) {
		return this.aliasDePrimerVerificador == alias;
	}
	public boolean esMuestraVerificablePara(String alias) {
		return this.verificador.puedeVerificar(alias);
	}
	public Boolean tieneVerificacionDe(String alias) {
		return this.verificador.tieneVerificacionDe(alias);
	}
	public void agregarVerificacion(Verificacion verificacion) {
		this.verificador.agregarVerificacion(verificacion);
	}
}