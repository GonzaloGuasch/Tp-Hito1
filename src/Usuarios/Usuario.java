package Usuarios;

import Aplicacion.AplicacionVinchuca;
import Muestra.Muestra;
import Muestra.Verificacion;
import NivelesDeVerificacion.NivelDeVerificacion;
import NivelesDeConocimiento.NivelDeConocimiento;

public abstract class Usuario {
	private String identificacion;
	protected NivelDeConocimiento nivelDeConocimiento;
	
	//Constructor
	public Usuario(String alias) {
		this.identificacion = alias;
	}
	//Cantidad de Muestras enviadas y verificadas en una app
	public Integer cantidadDeMuestrasEnviadas(AplicacionVinchuca app) {
		return app.muestrasEnviadasDe(this);
	}
	public Integer cantidadDeMuestrasVerificadas(AplicacionVinchuca app) {
		return  app.verificacionesDe(this);
	}
	public Integer cantidadDeMuestrasEnviadasEsteMesEn(AplicacionVinchuca app) {
        return app.muestrasEnviadasEsteMesDe(this);
    }
	
	//get alias del usuario y nivel de verificacion
	public String getAlias() {
		return this.identificacion;
	}
	public NivelDeVerificacion getNivelDeVerificacion() {
		return nivelDeConocimiento.getNivelDeVerificacion();
	}
	
	//Acciones del usuario
	
	//Envio de muestra
	public void enviarMuestra(Muestra nuevaMuestra, AplicacionVinchuca app) {
		this.enviarMuestraAlaAplicacion(nuevaMuestra, app);
		this.chequearEstado(this, app);
	}
	
	private void enviarMuestraAlaAplicacion(Muestra nuevaMuestra, AplicacionVinchuca app) {
		app.recibirMuestra(nuevaMuestra);
		
	}
	//es abstract poque el especialista lo re-define vacio, "templateMethod"
	protected abstract void chequearEstado(Usuario usuario, AplicacionVinchuca app);
	
	//Verificacion de muestra
		
	public void verificarMuestra(Verificacion verificacion, Muestra nuevaMuestra, AplicacionVinchuca app){
		if(nuevaMuestra.esMuestraVerificablePara(this.getAlias(), verificacion)){
			nuevaMuestra.agregarVerificacion(verificacion); 
			this.enviarMuestra(nuevaMuestra, app);
		}
		this.chequearEstado(this, app);
	}
	
	public void setNivelDeConocimiento(NivelDeConocimiento nuevoNivel) {
		this.nivelDeConocimiento = nuevoNivel;
	}
	public NivelDeConocimiento getNivelDeConocimiento() {
		// TODO Auto-generated method stub
		return null;
	}
	public String getTipoDeConocimiento() {
		return nivelDeConocimiento.getTipo();
	}

}
