package TipoDeMuestra;
import java.util.List;
import Muestra.Verificacion;

public class ChinceFoliada extends TipoDeMuestra{

	@Override
	public boolean hacerseCargo(List<Verificacion> verificaciones) {

		return this.todosVerificaron("ChinceFoliada", verificaciones) || (
				   this.usuarioDeMayorNivelObservo("ChinceFoliada", verificaciones) &&
				   this.noHayDosUsuariosDeAltoNivelQueDiscrepan(verificaciones));
	}	
	@Override
	public String decirTipo() {
		return "ChinceFoliada";
	}
}
