package Muestra;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import TipoDeMuestra.ChinceFoliada;
import TipoDeMuestra.ImagenPocoClara;
import TipoDeMuestra.Indeterminada;
import TipoDeMuestra.PhtiaChinche;
import TipoDeMuestra.TipoDeMuestra;
import TipoDeMuestra.Vinchuca;
import Usuarios.Usuario;
import NivelesDeVerificacion.NivelDeVerificacion;
import NivelesDeVerificacion.Alta;
import NivelesDeVerificacion.Media;
import NivelesDeVerificacion.Bajo;

public class VerificadorDeMuestra {
	
	private NivelDeVerificacion nivelDeVerificacionDeMuestra;
	private List<Verificacion> verificaciones = new ArrayList<Verificacion>();
	private Collection<NivelDeVerificacion> estadosPosibles = new ArrayList<NivelDeVerificacion>();
	private Collection<TipoDeMuestra> tiposPosibles = new ArrayList<TipoDeMuestra>();
	
	//Constructor
	public VerificadorDeMuestra(Verificacion nuevaVerificacion){
		this.nivelDeVerificacionDeMuestra = nuevaVerificacion.getNivelDeVerificacion();
		this.verificaciones.add(nuevaVerificacion);
		
		NivelDeVerificacion alta   = new Alta();
		NivelDeVerificacion media = new Media ();
		NivelDeVerificacion bajo   = new Bajo();
		
		this.estadosPosibles.add(alta);
		this.estadosPosibles.add(media);
		this.estadosPosibles.add(bajo);
		
		TipoDeMuestra vinchuca 			= new Vinchuca();
		TipoDeMuestra Pchinche 			= new PhtiaChinche();
		TipoDeMuestra chince 			= new ChinceFoliada();
		TipoDeMuestra imagenPocoClara 	= new ImagenPocoClara();
		TipoDeMuestra indeterminada 	= new Indeterminada();
		
		this.tiposPosibles.add(vinchuca);
		this.tiposPosibles.add(chince);
		this.tiposPosibles.add(imagenPocoClara);
		this.tiposPosibles.add(indeterminada);
		this.tiposPosibles.add(Pchinche);
	}
	//Getters
	public NivelDeVerificacion getNivelDeVerificacion() {
		return this.nivelDeVerificacionDeMuestra;
	}
	//Acciones
	public void nuevoEstado(NivelDeVerificacion nuevoNivel) {
		this.nivelDeVerificacionDeMuestra = nuevoNivel;
	}
	
	
	//Booleanos
	
	public boolean puedeVerificar(String usuario, Verificacion nuevaVerificacion) {
		boolean res = false;
		for(Verificacion v :verificaciones) {
			res = res || v.noEsVerificacionDe(usuario);
		}
		return res;
	}
	public Boolean tieneVerificacionDe(String alias) {
		return verificaciones.stream().filter(verificacion -> verificacion.getAliasDeVerificador() == alias)
				.collect(Collectors.toList()).size() > 0;
	}
	public void chequearNivelDeVerificacion(Muestra muestra) {
			
	estadosPosibles.stream().filter(unEstadoPosible -> unEstadoPosible.hacerseCargo(muestra))
	.findFirst().get().cambiarEstado(muestra);
		
	}
	public Integer getCantidadDeVerificaciones() {
		return this.verificaciones.size();
	}
	public void agregarVerificacion(Verificacion verificacion) {
		this.verificaciones.add(verificacion);
	}
	public Set<Usuario> getVerificadores() {
		Set<Usuario> verificadores = new HashSet<Usuario>();
		for(Verificacion v : verificaciones) {
			verificadores.add(v.getVerificador());
		}
		return verificadores;
	}
	public String getTipoDeMuestra() {
	 
		return tiposPosibles.stream().filter(unTipoDeMuestra -> unTipoDeMuestra.hacerseCargo(this.verificaciones))
		.findFirst().get().decirTipo();
	}
	
}

