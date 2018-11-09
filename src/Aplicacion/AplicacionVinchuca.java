package Aplicacion;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import Muestra.Muestra;
import Usuarios.Usuario;

public class AplicacionVinchuca {
	private Set<Muestra> muestras;
	private Set<Usuario> usuarios;
	private Set<OrganizacionNoGubernamental> organizaciones;
	private CalculadoraDeDistancias calculadoraDistancias;
	private CalculadoraDeFechas calculadoraDeFechas;
	
	//constructor
	public AplicacionVinchuca(CalculadoraDeFechas unaCalculadoraDeFechas, CalculadoraDeDistancias unacalculadoraDeDistancias){
        
		muestras = new HashSet<Muestra>();
        usuarios = new HashSet<Usuario>();
        organizaciones =new HashSet<OrganizacionNoGubernamental>();
        
        calculadoraDistancias= unacalculadoraDeDistancias;
        calculadoraDeFechas = unaCalculadoraDeFechas;
	}
	//getters
	public Set<Muestra> getMuestras(){
		return this.muestras;
	}
	public Set<Usuario> getUsuarios(){
		return this.usuarios;
	}
	public Set<OrganizacionNoGubernamental> getOrganizaciones(){
		return this.organizaciones;
	}
	public LocalDate getFecha(){
        return calculadoraDeFechas.getFechaActual();
    }
	public Set<Muestra> getMuestrasAMenosDeXKilometros(Ubicacion unaUbicacion, Double distancia) {	
		return calculadoraDistancias.MuestrasAMenosDeXKilometros(muestras, unaUbicacion, distancia);
	}
	public Integer cantidadDeMuestrasEnviadasEsteMesDe(Usuario usuario){
	       return muestras.stream().filter(unaMuestra -> unaMuestra.esDeUsuario(usuario.getAlias()) && 
	    		   calculadoraDeFechas.esMuestraDelUltimoMes(unaMuestra))
	    		   		.collect(Collectors.toList()).size();
		}
	public Integer cantidadDeMuestrasVerificadasEsteMesDe(Usuario usuario) {
		return muestras.stream().filter(unaMuestra -> unaMuestra.tieneVerificacionDe(usuario.getAlias())&&
				calculadoraDeFechas.esVerificacionDelUltimoMes(unaMuestra.getVerificacionDe(usuario)))
					.collect(Collectors.toList()).size();
	}
	
	//acciones
	public void agregarUsuarioALaAplicacion(Usuario usuarioNuevo) {
		this.usuarios.add(usuarioNuevo);
	}
	public void agregarOrganizacionALaAplicacion(OrganizacionNoGubernamental organizacionNueva) {
		this.organizaciones.add(organizacionNueva);
	}
	public void recibirMuestra(Muestra nuevaMuestra) {
		muestras.add(nuevaMuestra);
	}
}