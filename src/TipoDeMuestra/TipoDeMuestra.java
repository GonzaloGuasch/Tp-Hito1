package TipoDeMuestra;
import java.util.List;
import Muestra.Verificacion;
import Usuarios.Usuario;

public abstract class TipoDeMuestra {
	
	public abstract String decirTipo();
	public boolean todosVerificanron(String observacion,List<Verificacion> verificaciones) {
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
	public boolean noHayDosUsuariosDeAltoNivelQueDiscrepan(String pbservacion, List<Verificacion> verificaciones) {
		return true;
	}
	public abstract boolean hacerseCargo(List<Verificacion> verificaciones);

	
}
