package Aplicacion;

public class Ubicacion {
	private Double latitud;
	private Double longitud;
	
	public Ubicacion(Double latitud, Double longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
	}
	public Double getLatitud() {
		return this.latitud;
	}
	public Double getLongitud() {
		return this.longitud;
	}
	
}
