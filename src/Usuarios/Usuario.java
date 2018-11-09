package Usuarios;

import Aplicacion.AplicacionVinchuca;
import Muestra.Muestra;
import Muestra.Verificacion;
import NivelesDeConocimiento.NivelDeConocimiento;

public abstract class Usuario {
	private String identificacion;
	protected NivelDeConocimiento nivelDeConocimiento;
	
	//Constructor
	public Usuario(String alias) {
		this.identificacion = alias;
	}
	//getters
	public String getAlias() {
		return this.identificacion;
	}
	public NivelDeConocimiento getNivelDeConocimiento() {
		return nivelDeConocimiento;
	}
	public String getTipoDeConocimiento() {
		return nivelDeConocimiento.getTipo();
	}
	//Acciones del usuario
	
	//Envio de muestra
	public void enviarMuestra(Muestra nuevaMuestra, AplicacionVinchuca app) {
		app.recibirMuestra(nuevaMuestra);
		this.chequearEstado(this, app);
	}
	//es abstract porque el especialista lo re-define vacio, "templateMethod"
	protected abstract void chequearEstado(Usuario usuario, AplicacionVinchuca app);
	
	//Verificacion de muestra
		
	public void verificarMuestra(Verificacion verificacion, Muestra nuevaMuestra, AplicacionVinchuca app){
		if(nuevaMuestra.esMuestraVerificablePara(this.getAlias())){
			nuevaMuestra.agregarVerificacion(verificacion); 
			this.enviarMuestra(nuevaMuestra, app);
		}
		this.chequearEstado(this, app);
	}
	
	public void setNivelDeConocimiento(NivelDeConocimiento nuevoNivel) {
		this.nivelDeConocimiento = nuevoNivel;
	} 
}
