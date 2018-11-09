package Muestra;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import TipoDeMuestra.TipoDeMuestra;
import Usuarios.Usuario;
import NivelesDeVerificacion.NivelDeVerificacion;

public class VerificadorDeMuestra {
	
	private ArrayList<Verificacion> verificaciones;
	private Collection<NivelDeVerificacion> estadosPosibles;
	private Collection<TipoDeMuestra> tiposPosibles;
	
	//Constructor
	public VerificadorDeMuestra(Collection<NivelDeVerificacion>nivelesDeVerificacionPosible,
				Collection<TipoDeMuestra>tiposPosibles){
		this.verificaciones = new ArrayList<Verificacion>();
		
		this.tiposPosibles = tiposPosibles;
		this.estadosPosibles = nivelesDeVerificacionPosible;
	}
	//Getters
	public String getTipoDeMuestra() {		 
		return tiposPosibles.stream().filter(unTipoDeMuestra -> unTipoDeMuestra.hacerseCargo(this.verificaciones))
		.findFirst().get().decirTipo();
	}
	public NivelDeVerificacion getNivelDeVerificacion(Muestra unaMuestra) {
		
		return estadosPosibles.stream().filter(unEstadoPosible -> unEstadoPosible.hacerseCargo(unaMuestra))
		.findFirst().get();	
	}
	public Verificacion getVerificacionDe(Usuario unUsuario) {
		
		return verificaciones.stream().filter(verificacion->verificacion.esVerificacionDe(unUsuario.getAlias()))
				.collect(Collectors.toList()).get(0);
	}
	public Set<Usuario> getUsuariosVerificadores() {
		Set<Usuario> verificadores = new HashSet<Usuario>();
		for(Verificacion v : verificaciones) {
			verificadores.add(v.getVerificador());
		}
		return verificadores;
	}
	public Integer getCantidadDeVerificaciones() {
		return this.verificaciones.size();
	}
	//este getter lo hice solo para poder testear el msj gettipodemuestra(), (para mockear los tipos necesitaba las verificaciones)
	public ArrayList<Verificacion> getVerificaciones(){
		return verificaciones;
	}
	//Acciones
	public void agregarVerificacion(Verificacion verificacion) {
		this.verificaciones.add(verificacion);
	}
	//Booleanos
	
	public boolean puedeVerificar(String usuario) {
		
		return verificaciones.stream().filter(verificacion -> verificacion.esVerificacionDe(usuario))
				.collect(Collectors.toList()).size() == 0;
	}
	
	public Boolean tieneVerificacionDe(String alias) {
		return verificaciones.stream().filter(verificacion -> verificacion.getAliasDeVerificador() == alias)
				.collect(Collectors.toList()).size() > 0;
	}
	
}

