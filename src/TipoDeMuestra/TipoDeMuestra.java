package TipoDeMuestra;
import java.util.List;
import Muestra.Verificacion;
import Usuarios.Usuario;

public abstract class TipoDeMuestra {
	
	public abstract String decirTipo();
	public boolean todosVerificaron(String observacion,List<Verificacion> verificaciones) {
	boolean res = true;
		for(Verificacion ver : verificaciones) {
			res = res && ver.getObservacionDeVerificador() == observacion;
		}
		return res;
	}
	public boolean usuarioDeMayorNivelObservo(String observacion,List<Verificacion> verificaciones) {
	 Usuario usuarioconMayorNivel = verificaciones.get(0).getVerificador();
	 Verificacion verificacionDeUsuario = verificaciones.get(0);
	   for(Verificacion ver : verificaciones) {
		if(ver.getVerificador().getNivelDeConocimiento().valor() > usuarioconMayorNivel.getNivelDeConocimiento().valor()) {
			usuarioconMayorNivel = ver.getVerificador();
			verificacionDeUsuario = ver;
		}
	   }
	return verificacionDeUsuario.getObservacionDeVerificador() == observacion;
	}
	public boolean noHayDosUsuariosDeAltoNivelQueDiscrepan(List<Verificacion> verificaciones) {
		Boolean respuesta=true;
		
		if(verificaciones.size()>=2){
	
			Verificacion verificacion1 = this.verificacionConUsuarioDeMayorConocimiento(verificaciones);
			verificaciones.remove(verificacion1);
			Verificacion verificacion2 = this.verificacionConUsuarioDeMayorConocimiento(verificaciones);
			
			respuesta = verificacion1.getObservacionDeVerificador() == verificacion2.getObservacionDeVerificador();
		}	
		return respuesta;
	}
	private Verificacion verificacionConUsuarioDeMayorConocimiento(List<Verificacion> verificaciones) {
		
		Verificacion verificacionAEntregar = verificaciones.get(0);
		for(Verificacion verificacion : verificaciones) {
			if(verificacion.getVerificador().getNivelDeConocimiento().valor() > verificacionAEntregar.getVerificador().getNivelDeConocimiento().valor()){
		
				verificacionAEntregar = verificacion;
			}
		}
		return verificacionAEntregar; 
	}
	public abstract boolean hacerseCargo(List<Verificacion> verificaciones);

	
}
