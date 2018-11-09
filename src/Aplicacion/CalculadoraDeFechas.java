package Aplicacion;

import java.time.LocalDate;

import Muestra.Muestra;
import Muestra.Verificacion;

public class CalculadoraDeFechas {

	private LocalDate fechaDeHoy;
	//constructor
	public CalculadoraDeFechas(LocalDate fechaDelDia) {		
		this.fechaDeHoy = fechaDelDia;
	}
	//getters
	public LocalDate getFechaActual() {
		return fechaDeHoy;
	}
	//booleanos
	public boolean esMuestraDelUltimoMes(Muestra unaMuestra) {

		return unaMuestra.getFechaDeCreacion().getMonthValue() == (fechaDeHoy.getMonthValue()-1) && 
				unaMuestra.getFechaDeCreacion().getYear() == fechaDeHoy.getYear();
	}
	public boolean esVerificacionDelUltimoMes(Verificacion unaVerificacion) {
		
		return unaVerificacion.getFechaDeCreacion().getMonthValue() == (fechaDeHoy.getMonthValue()-1) && 
				unaVerificacion.getFechaDeCreacion().getYear() == fechaDeHoy.getYear();
	}
}
