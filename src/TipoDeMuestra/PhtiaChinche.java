package TipoDeMuestra;

import java.util.List;

import Muestra.Verificacion;

public class PhtiaChinche extends TipoDeMuestra {
	
	@Override
	public boolean hacerseCargo(List<Verificacion> verificaciones) {
		
		return this.todosVerificanron("PhtiaChinche", verificaciones) || (
			   this.usuarioDeMayorNivelObservo("PhtiaChinche", verificaciones) &&
			   this.noHayDosUsuariosDeAltoNivelQueDiscrepan("PhtiaChinche" , verificaciones));
	}

	@Override
	public String decirTipo() {
		return "PhtiaChince";
	}

	
}
