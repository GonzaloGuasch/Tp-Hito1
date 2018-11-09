package Aplicacion;

public class Ubicacion {
	private Double latitud;
	private Double longitud;
	//constructor
	public Ubicacion(Double latitud, Double longitud) {
		this.latitud = latitud;
		this.longitud = longitud;
	}
	//getters
	public Double getLatitud() {
		return this.latitud;
	}
	public Double getLongitud() {
		return this.longitud;
	}
	
}
