package Muestra;

import java.util.Date;
import java.util.Set;

import Aplicacion.Ubicacion;
import Usuarios.Usuario;
import NivelesDeVerificacion.NivelDeVerificacion;

public class Muestra {
	private VerificadorDeMuestra verificador;
	private Ubicacion ubicacion;
	private String fotografia;
	private String aliasDePrimerVerificador;
	private Date fechaDeCreacion;
	
	//Constructores
	public Muestra(Verificacion verificacion,String unaFotografia, Ubicacion unaUbicacion, Date unaFechaDeCreacion) {
		this.verificador = new VerificadorDeMuestra(verificacion);
		this.aliasDePrimerVerificador = verificacion.getAliasDeVerificador();
		this.fotografia = unaFotografia;
		this.ubicacion = unaUbicacion;
		this.fechaDeCreacion = unaFechaDeCreacion;
	}
	//Geters
	public NivelDeVerificacion getNivelDeVerificion() {
		return this.verificador.getNivelDeVerificacion();
	}
	public Ubicacion getUbicacion() {
		
		return ubicacion;
	}
	public Integer cantidadDeVerificaciones() {
		return this.verificador.getCantidadDeVerificaciones();
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
	public boolean tieneVerificacionEsteMesDe(String alias, Date fechaDeHoy){
        return this.verificador.tieneVerificacionDe(alias) && this.esDeEsteMes(fechaDeHoy);
	}
	
	public boolean esDeEsteMes(Date fechaDeHoy){
        return this.getFechaDeCreacion().getMonth() == fechaDeHoy.getMonth() && this.getFechaDeCreacion().getYear() == fechaDeHoy.getYear();
	}
	
	public void cambiarVerificacion(NivelDeVerificacion nuevoNivel) {
		this.verificador.nuevoEstado(nuevoNivel);
	}
	public void agregarVerificacion(Verificacion verificacion) {
		this.verificador.agregarVerificacion(verificacion);
		this.verificador.chequearNivelDeVerificacion(this);
	}
	public String getTipoDeMuestra() {
		return this.verificador.getTipoDeMuestra();
	}

	public Set<Usuario> getUsuarios() {
		return this.verificador.getVerificadores();
	}
	public Date getFechaDeCreacion(){
        return this.fechaDeCreacion;
	}

}