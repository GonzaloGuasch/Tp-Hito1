package TipoDeMuestra;
import java.util.List;
import Muestra.Verificacion;

public class ChinceFoliada extends TipoDeMuestra{

	@Override
	public boolean hacerseCargo(List<Verificacion> verificaciones) {

		return this.todosVerificanron("ChinceFoliada", verificaciones) || (
				   this.usuarioDeMayorNivelObservo("ChinceFoliada", verificaciones) &&
				   this.noHayDosUsuariosDeAltoNivelQueDiscrepan("ChinceFoliada" , verificaciones));
	}
	
	@Override
	public String decirTipo() {
		return "ChinceFoliada";
	}

}
