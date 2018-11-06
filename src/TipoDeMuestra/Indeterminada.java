package TipoDeMuestra;

import java.util.ArrayList;
import java.util.List;
import Muestra.Verificacion;

public class Indeterminada extends TipoDeMuestra {

	@Override
	public boolean hacerseCargo(List<Verificacion> verificaciones) {
		return this.observacionesDiferentes(verificaciones) == 3 || !this.noHayDosUsuariosDeAltoNivelQueDiscrepan(verificaciones); 	}

	private int observacionesDiferentes(List<Verificacion> verificaciones) {
		ArrayList<String> observacionesDiferentes = new ArrayList<String>();
		for(Verificacion ver : verificaciones) {
			observacionesDiferentes.add(ver.getObservacionDeVerificador());
		}
		return observacionesDiferentes.size();
	}

	@Override
	public String decirTipo() {
		return "Indeterminada";
	}
}
