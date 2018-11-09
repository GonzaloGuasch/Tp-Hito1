package NivelesDeVerificacion;

import java.util.stream.Collectors;
import Muestra.Muestra;

public class Media extends NivelDeVerificacion {

	@Override
	public boolean hacerseCargo(Muestra muestra) {
		
		return this.esMuestraMedia(muestra);
	}
	private boolean esMuestraMedia(Muestra muestra) {
		return this.verificaron2Novatos(muestra) || this.verifico1Experto(muestra);
	}

	//booleans privados
	private boolean verifico1Experto(Muestra muestra) {
		return (muestra.cantidadDeVerificaciones() == 1 && this.esVerificadorMedio(muestra));
	}
	private boolean verificaron2Novatos(Muestra muestra) {
		return (muestra.cantidadDeVerificaciones() == 2 && this.hayDosNovatos(muestra));
	}
	
	private boolean hayDosNovatos(Muestra muestra) {
		
		return muestra.getUsuarios().stream().filter(usuario -> usuario.getTipoDeConocimiento() == "Novato")
				.collect(Collectors.toList()).size() == 2;
	}
	private boolean esVerificadorMedio(Muestra muestra) {
		
		return muestra.getUsuarios().stream().filter(usuario -> usuario.getTipoDeConocimiento() == "Experto")
			.collect(Collectors.toList()).size() == 1;
	}
}