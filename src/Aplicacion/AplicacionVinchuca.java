package Aplicacion;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

import Muestra.Muestra;
import Usuarios.Usuario;

public class AplicacionVinchuca {
	private Set<Muestra> muestras = new HashSet<Muestra>();
	private Set<Usuario> usuarios = new HashSet<Usuario>();
	private CalculadoraDeDistancias calculadoraDistancias= new CalculadoraDeDistancias();
	private LocalDate fechaDelDia;
	
	public AplicacionVinchuca(LocalDate fechaDelDia){
        this.fechaDelDia = fechaDelDia;
	}
	public Set<Muestra> getMuestras(){
		return this.muestras;
	}
	public Set<Usuario> getUsuarios(){
		return this.usuarios;
	}
	public LocalDate getFecha(){
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
	public Integer muestrasEnviadasEsteMesDe(Usuario usuario){
       return muestras.stream().filter(unaMuestra -> 
       unaMuestra.esDeUsuarioYDelMes(usuario.getAlias(), this.getFecha()))
       .collect(Collectors.toList()).size();
	}
}

