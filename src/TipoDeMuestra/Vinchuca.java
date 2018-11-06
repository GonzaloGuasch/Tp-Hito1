package TipoDeMuestra;
import java.util.List;
import Muestra.Verificacion;

public class Vinchuca extends TipoDeMuestra {

	@Override
	public boolean hacerseCargo(List<Verificacion> verificaciones) {
		
		return this.todosVerificaron("Vinchuca", verificaciones) || (
				   this.usuarioDeMayorNivelObservo("Vinchuca", verificaciones) &&
				   this.noHayDosUsuariosDeAltoNivelQueDiscrepan(verificaciones));
	}

	@Override
	public String decirTipo() {
		return "Vinchuca";
	}

	


}
