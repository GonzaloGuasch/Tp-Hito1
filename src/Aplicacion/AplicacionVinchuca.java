package Aplicacion;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import Muestra.Muestra;
import Usuarios.Usuario;

public class AplicacionVinchuca {
	private Set<Muestra> muestras = new HashSet<Muestra>();
	private Set<Usuario> usuarios = new HashSet<Usuario>();
	private CalculadorDeDistancias calculadoraDistancias= new CalculadorDeDistancias();
	private Date fechaDelDia;
	
	public AplicacionVinchuca(Date fechaDelDia){
        this.fechaDelDia = fechaDelDia;
	}
	public Set<Muestra> getMuestras(){
		return this.muestras;
	}
	public Set<Usuario> getUsuarios(){
		return this.usuarios;
	}
	public Date getFecha(){
        return this.fechaDelDia;
    }
	public void agregarUsuarioALaAplicacion(Usuario usuarioNuevo) {
		this.usuarios.add(usuarioNuevo);
	}
	public void recibirMuestra(Muestra nuevaMuestra) {
		muestras.add(nuevaMuestra);
	}
	public Integer muestrasEnviadasDe(Usuario usuario) {
		
	return muestras.stream().filter( unaMuestra -> unaMuestra.esDeUsuario(usuario.getAlias()))
		.collect(Collectors.toList()).size();	
	}
	public Integer verificacionesDe(Usuario usuario) {
	
	return muestras.stream().filter( unaMuestra -> unaMuestra.tieneVerificacionDe(usuario.getAlias()))
			.collect(Collectors.toList()).size();
	}
	//el problema es que cuando subis o no de nivel es porque mandaste muestras en un mes no en general, 
	// por eso se me ocurrio que haya un mensaje que me de las del ultimo mes para saber si sube o no
	// capaz borrrar los otros mensajes que dan las muestras en general no estaria mal
	public Integer muestrasEnviadasEsteMesDe(Usuario usuario){
       return muestras.stream().filter(unaMuestra -> 
       unaMuestra.esDeUsuarioYDelMes(usuario.getAlias(), this.getFecha()))
       .collect(Collectors.toList()).size();
	}
}

